package com.baidu.searchbox.schemedispatch.monitor;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.ad.util.InterceptCallback;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatistic;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidStatisticUtils;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.nx;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes4.dex */
public class OpenAppUtils {
    public static final Boolean DEBUG = Boolean.valueOf(AppConfig.isDebug());
    public static final String OPEN_APP_SOURCE = "plugin";
    public static final String TAG = "OpenAppUtils";

    public static boolean checkMinVersion(String str, int i) {
        if (Integer.parseInt(str) <= i) {
            return true;
        }
        return false;
    }

    public static void openApp(Context context, String str, String str2, String str3, InterceptCallback interceptCallback, SchemeStatisticField schemeStatisticField, boolean z, boolean z2) {
        openApp(context, str, str2, str3, interceptCallback, schemeStatisticField, z, z2, new InvokeStatistic().setPage("package"));
    }

    public static void openApp(Context context, String str, String str2, String str3, final InterceptCallback interceptCallback, SchemeStatisticField schemeStatisticField, boolean z, boolean z2, final InvokeStatistic invokeStatistic) {
        boolean z3;
        final WeakReference weakReference = new WeakReference(context);
        String str4 = null;
        try {
            final Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            SchemeCheckInfo schemeCheckInfo = OpenAppManager.getadCheckSchemeInGlobalWhiteList(str, "", schemeStatisticField, false);
            if (schemeCheckInfo == null) {
                schemeCheckInfo = OpenAppManager.getAdCheckSchemeInFeedWhiteList(str, "", schemeStatisticField);
            }
            if (schemeCheckInfo == null) {
                schemeCheckInfo = OpenAppManager.checkSchemeInDeepLinkWhiteList(str, schemeStatisticField);
            }
            SchemeCheckInfo checkTypeClose = OpenAppBaseCheck.checkTypeClose(schemeCheckInfo, str);
            if (checkTypeClose != null) {
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                z3 = false;
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    str4 = queryIntentActivities.get(i).activityInfo.packageName;
                    int i2 = context.getPackageManager().getPackageInfo(str4, 0).versionCode;
                    if (!TextUtils.isEmpty(str2)) {
                        boolean checkMinVersion = checkMinVersion(str2, i2);
                        if (checkMinVersion && TextUtils.equals(str4, str3)) {
                            intent.setPackage(str4);
                            z3 = true;
                            break;
                        } else if (checkMinVersion) {
                            intent.setPackage(str4);
                            z3 = true;
                        }
                    } else {
                        if (TextUtils.equals(str4, str3)) {
                            intent.setPackage(str4);
                            z3 = true;
                            break;
                        }
                        z3 = true;
                    }
                }
                invokeStatistic.addSchemeHeader(checkTypeClose.getScheme(), true).addScheme(str);
                if (!z3) {
                    invokeStatistic.setSource(InvokeStatisticKt.SCHEME_INVOKE_SOURCE_NOT_INSTALL);
                }
            } else {
                invokeStatistic.addSchemeHeader(str).addScheme(str).setSource(InvokeStatisticKt.SCHEME_INVOKE_SOURCE_NOT_WHITELIST);
                z3 = false;
            }
            invokeStatistic.addExtPackage(str3);
            SchemeForbidStatisticUtils.ubcWhetherInstallApk(context, str4, str);
            if (z3) {
                nx.b().g(checkTypeClose, str3, false, new InterceptCallback() { // from class: com.baidu.searchbox.schemedispatch.monitor.OpenAppUtils.1
                    @Override // com.baidu.searchbox.feed.ad.util.InterceptCallback
                    public void onResult(boolean z4) {
                        Context context2;
                        if (z4 && (context2 = (Context) weakReference.get()) != null) {
                            if (ActivityUtils.startActivitySafely(context2, intent)) {
                                invokeStatistic.invokeSuc();
                            } else {
                                invokeStatistic.invokeFail();
                            }
                        }
                        InterceptCallback interceptCallback2 = interceptCallback;
                        if (interceptCallback2 != null) {
                            interceptCallback2.onResult(z4);
                        }
                    }
                }, z2, invokeStatistic);
                return;
            }
            if (interceptCallback != null) {
                interceptCallback.onResult(false);
            }
            invokeStatistic.invokeFail();
        } catch (Exception unused) {
            if (interceptCallback != null) {
                interceptCallback.onResult(false);
            }
        }
    }

    public static boolean openApp(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
            return false;
        }
        if (DEBUG.booleanValue()) {
            Log.i(TAG, "ris.size():" + queryIntentActivities.size());
        }
        intent.setPackage(queryIntentActivities.get(0).activityInfo.packageName);
        ActivityUtils.startActivitySafely(context, intent);
        return true;
    }

    public static boolean openApp(Context context, String str, boolean z) {
        ResolveInfo next;
        boolean z2 = false;
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0 && (next = queryIntentActivities.iterator().next()) != null) {
                String str2 = next.activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setComponent(new ComponentName(str, str2));
                intent2.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                try {
                    context.startActivity(intent2);
                    z2 = true;
                } catch (ActivityNotFoundException unused) {
                }
            }
            if (!z2 && z) {
                UniversalToast.makeText(context, context.getResources().getText(R.string.app_can_not_open_toast).toString()).showToast();
            }
        }
        return z2;
    }
}
