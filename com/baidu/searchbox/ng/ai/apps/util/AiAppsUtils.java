package com.baidu.searchbox.ng.ai.apps.util;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.ar.util.IoUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.OpenAppAction;
import com.baidu.searchbox.ng.ai.apps.view.container.IAiAppsNAViewRoot;
import com.baidu.webkit.sdk.WebView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AiAppsUtils {
    private static final boolean DEBUG = false;
    private static final String HTML_SUFFIX = ".html";
    private static final String TAG = "AiAppsUtils";
    private static Handler sHandler = new Handler(Looper.getMainLooper());

    public static String getHtmlPagePath(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        return str + str2 + HTML_SUFFIX;
    }

    public static String buildPageUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        String str4 = str + str2 + HTML_SUFFIX;
        if (TextUtils.isEmpty(str3)) {
            return AiAppsUrlUtils.toFileUriString(str4);
        }
        Uri fileUri = AiAppsUrlUtils.toFileUri(str4);
        if (fileUri == null) {
            return AiAppsUrlUtils.toFileUriString(str4);
        }
        return fileUri.buildUpon().query(str3).build().toString();
    }

    public static boolean checkPageParams(AiAppsConfigData aiAppsConfigData, AiAppsPageParam aiAppsPageParam, boolean z) {
        boolean z2 = true;
        if (aiAppsConfigData == null) {
            return false;
        }
        if (z) {
            return aiAppsConfigData.isInPageUrl(aiAppsPageParam.mPage) || aiAppsConfigData.isInTabUrl(aiAppsPageParam.mPage);
        }
        if (!aiAppsConfigData.isInPageUrl(aiAppsPageParam.mPage) || aiAppsConfigData.isInTabUrl(aiAppsPageParam.mPage)) {
            z2 = false;
        }
        return z2;
    }

    public static boolean checkTabParams(AiAppsConfigData aiAppsConfigData, AiAppsPageParam aiAppsPageParam) {
        return aiAppsConfigData != null && aiAppsConfigData.hasTabItemInfo() && aiAppsConfigData.isInTabUrl(aiAppsPageParam.mPage);
    }

    public static Class<?> getAiAppsComponentClazz(Class<?> cls, int i) {
        if (i != 0) {
            try {
                return Class.forName(cls.getName() + i);
            } catch (ClassNotFoundException e) {
                return cls;
            }
        }
        return cls;
    }

    public static JSONObject convertBundleToString(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Set<String> keySet = bundle.keySet();
        if (keySet.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (String str : keySet) {
                try {
                    jSONObject.put(str, JSONObject.wrap(bundle.get(str)));
                } catch (JSONException e) {
                }
            }
            return jSONObject;
        }
        return null;
    }

    public static void runOnUiThreadAtOnce(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            sHandler.postAtFrontOfQueue(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0L);
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            sHandler.postDelayed(runnable, j);
        } else {
            runnable.run();
        }
    }

    public static void postOnUi(Runnable runnable) {
        postOnUi(runnable, 0L);
    }

    public static void postOnUi(Runnable runnable, long j) {
        sHandler.postDelayed(runnable, j);
    }

    public static String generateOpenAppScheme(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder("baiduboxapp://v26/swan/openApp?upgrade=0");
        try {
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jSONObject.put("open", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            jSONObject.put(OpenAppAction.PARAMS_DOWNLOAD_KEY, str2);
            sb.append("&params=");
            sb.append(URLEncoder.encode(jSONObject.toString(), IoUtils.UTF_8));
        } catch (UnsupportedEncodingException e) {
        } catch (JSONException e2) {
        }
        return sb.toString();
    }

    public static String getStackTrace() {
        return getStackTrace(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @Nullable
    public static String getStackTrace(int i) {
        int i2 = 0;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (i2 >= i) {
                break;
            }
            if (stackTraceElement != null) {
                sb.append(stackTraceElement.toString()).append("\n");
                i2++;
            }
        }
        return sb.toString();
    }

    @RequiresApi(api = 23)
    public static boolean isLocationPermissionGranted() {
        return !AiAppAPIUtils.hasMarshMallow() || AppRuntime.getAppContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static Uri getUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || str.startsWith("file://")) {
            return Uri.parse(str);
        }
        if (str.startsWith("/")) {
            return Uri.fromFile(new File(str));
        }
        return null;
    }

    public static WebView getBdWebViewBySlaveId(String str) {
        NgWebView webView;
        AiAppsWebViewManager webViewManager = AiAppsController.getInstance().getWebViewManager(str);
        if (webViewManager == null || (webView = webViewManager.getWebView()) == null) {
            return null;
        }
        return webView.getCurrentWebView();
    }

    public static IAiAppsNAViewRoot getCurrentNAViewRoot(String str) {
        AiAppsWebViewManager webViewManager = AiAppsController.getInstance().getWebViewManager(str);
        if (webViewManager instanceof AiAppsSlaveManager) {
            return ((AiAppsSlaveManager) webViewManager).getNARootViewManager();
        }
        return null;
    }

    public static void onPreloadNextEnv() {
        AiAppsActivity activity = AiAppsController.getInstance().getActivity();
        activity.preloadNextAiAppsProcess();
        AiAppsSlavePool.preloadSlaveManager(activity, 600L);
    }

    public static String getTopWebViewId() {
        AiAppsFragment topAiAppsFragment = AiAppsController.getInstance().getTopAiAppsFragment();
        if (topAiAppsFragment != null) {
            return topAiAppsFragment.getSlaveWebViewId();
        }
        return null;
    }

    @Nullable
    public static String encodeChinese(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    stringBuffer.append(charAt);
                }
            }
            return stringBuffer.toString();
        }
        return str;
    }

    public static String getSign(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures.length <= 0) {
                return "";
            }
            return packageInfo.signatures[0].toCharsString();
        } catch (Exception e) {
            return "";
        }
    }

    public static String getSignByPermission(Context context, String str) {
        String str2 = "";
        try {
            str2 = context.getPackageManager().getPermissionInfo(str, 128).packageName;
        } catch (Exception e) {
        }
        return TextUtils.isEmpty(str2) ? str2 : getSign(context, str2);
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static String getPackageVersion(Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str);
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    public static String getPackageSourcePath(Context context) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            return applicationInfo.sourceDir;
        }
        return null;
    }

    public static String getVersionName() {
        try {
            Application appContext = AiAppsRuntime.getAppContext();
            return appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}
