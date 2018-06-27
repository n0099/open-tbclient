package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    static final int a = 87;
    private static final String b = "share_account";
    private static final String c = "share_fail_reason";

    public static List<Intent> a(Context context) {
        return a(context, context.getPackageManager().queryIntentActivities(new Intent("baidu.intent.action.account.SHARE_ACTIVITY"), 32), "baidu.intent.action.account.SHARE_ACTIVITY");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Intent> a(Context context, boolean z) {
        List<Intent> a2 = a(context, context.getPackageManager().queryIntentServices(new Intent("baidu.intent.action.account.SHARE_SERVICE"), 32), "baidu.intent.action.account.SHARE_SERVICE");
        if (!z && a.a().c(context)) {
            List<Intent> a3 = a(context);
            if (a3.size() > 0) {
                Iterator<Intent> it = a2.iterator();
                while (it.hasNext()) {
                    Intent next = it.next();
                    Iterator<Intent> it2 = a3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        } else if (next.getComponent().getPackageName().equals(it2.next().getComponent().getPackageName())) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
            return a2;
        }
        return a2;
    }

    static List<Intent> a(Context context, List<ResolveInfo> list, String str) {
        String str2;
        ComponentInfo componentInfo;
        ArrayList arrayList = new ArrayList();
        if (context == null || list == null || list.size() == 0) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        Map<String, Integer> orderAuthorizedPackages = SapiContext.getInstance(context).getOrderAuthorizedPackages();
        try {
            for (ResolveInfo resolveInfo : list) {
                if ("baidu.intent.action.account.SHARE_SERVICE".equals(str)) {
                    str2 = resolveInfo.serviceInfo.permission;
                    componentInfo = resolveInfo.serviceInfo;
                } else {
                    str2 = resolveInfo.activityInfo.permission;
                    componentInfo = resolveInfo.activityInfo;
                }
                if (componentInfo != null) {
                    Intent intent = new Intent(str);
                    intent.setClassName(componentInfo.packageName, componentInfo.name);
                    if (Build.VERSION.SDK_INT > 11) {
                        intent.addFlags(32);
                    }
                    if (TextUtils.isEmpty(str2) || context.checkCallingOrSelfPermission(str2) == 0) {
                        if (a(context, intent.getComponent().getPackageName()) && !context.getPackageName().equals(intent.getComponent().getPackageName())) {
                            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                            for (String str3 : orderAuthorizedPackages.keySet()) {
                                i = intent.getComponent().getPackageName().matches(str3) ? orderAuthorizedPackages.get(str3).intValue() : i;
                            }
                            hashMap.put(intent, Integer.valueOf(i));
                        }
                    }
                }
            }
            ArrayList<Map.Entry> arrayList2 = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList2, new Comparator<Map.Entry<Intent, Integer>>() { // from class: com.baidu.sapi2.share.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(Map.Entry<Intent, Integer> entry, Map.Entry<Intent, Integer> entry2) {
                    return entry.getValue().compareTo(entry2.getValue());
                }
            });
            for (Map.Entry entry : arrayList2) {
                arrayList.add(entry.getKey());
            }
        } catch (Throwable th) {
            Log.e(th);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return a(context, c(context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, String> authorizedPackages = SapiContext.getInstance(context).getAuthorizedPackages();
        String packageSign = SapiUtils.getPackageSign(context, str);
        if (!TextUtils.isEmpty(packageSign)) {
            for (String str2 : authorizedPackages.keySet()) {
                if (str.matches(str2) && packageSign.equals(authorizedPackages.get(str2))) {
                    return true;
                }
            }
        }
        return false;
    }

    static String c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if (packagesForUid.length <= 0) {
                return "";
            }
            return packagesForUid[0];
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(Context context, LoginShareStrategy loginShareStrategy, ShareModel shareModel, int i, String str, boolean z) {
        synchronized (c.class) {
            if (z) {
                SapiAccountManager.getInstance().getAccountService().setIqiyiAccessToken(str);
            } else if (context != null && loginShareStrategy != null && shareModel != null) {
                shareModel.b(context);
                final SapiContext sapiContext = SapiContext.getInstance(context);
                if (loginShareStrategy == LoginShareStrategy.SILENT && !sapiContext.isLoginStatusChanged() && sapiContext.getCurrentAccount() == null && shareModel.a().size() > 0 && SapiUtils.isValidAccount(shareModel.a().get(0))) {
                    SapiAccount sapiAccount = shareModel.a().get(0);
                    sapiContext.setCurrentAccount(sapiAccount);
                    SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
                    sapiContext.addLoginAccount(sapiAccount);
                    new ShareStorage().a(false);
                    sapiContext.removeShareAccount(sapiAccount);
                    if (SapiAccountManager.getSilentShareListener() != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.share.c.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiAccountManager.getSilentShareListener() != null && SapiContext.this.getCurrentAccount() != null) {
                                    SapiAccountManager.getSilentShareListener().onSilentShare();
                                }
                            }
                        });
                    }
                    for (SapiAccount sapiAccount2 : shareModel.a()) {
                        if (a(context, sapiAccount2)) {
                            sapiContext.addShareAccount(sapiAccount2);
                        }
                    }
                } else {
                    for (SapiAccount sapiAccount3 : shareModel.a()) {
                        if (a(context, sapiAccount3)) {
                            sapiContext.addShareAccount(sapiAccount3);
                        }
                        if (i >= 87) {
                            b(context, sapiAccount3);
                        }
                    }
                }
            }
        }
    }

    static boolean a(Context context, SapiAccount sapiAccount) {
        if (context == null) {
            return false;
        }
        SapiContext sapiContext = SapiContext.getInstance(context);
        if (SapiUtils.isValidAccount(sapiAccount)) {
            return (sapiContext.getCurrentAccount() == null || !sapiContext.getCurrentAccount().uid.equals(sapiAccount.uid)) && !sapiContext.getLoginAccounts().contains(sapiAccount);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, ShareModel shareModel) {
        if (context != null && shareModel != null) {
            shareModel.b(context);
            SapiContext sapiContext = SapiContext.getInstance(context);
            if (shareModel.a().size() > 0) {
                SapiAccount sapiAccount = shareModel.a().get(0);
                if (sapiContext.getCurrentAccount() == null || !sapiContext.getCurrentAccount().uid.equals(sapiAccount.uid)) {
                    sapiContext.removeShareAccount(sapiAccount);
                }
            }
        }
    }

    static void b(Context context, SapiAccount sapiAccount) {
        if (context != null && SapiUtils.isValidAccount(sapiAccount)) {
            SapiContext sapiContext = SapiContext.getInstance(context);
            SapiAccount currentAccount = sapiContext.getCurrentAccount();
            if (currentAccount != null && sapiAccount.uid.equals(currentAccount.uid)) {
                ShareAccountAccessor.getAccessor().updateSession(currentAccount, sapiAccount);
                sapiContext.setCurrentAccount(currentAccount);
                SapiAccountManager.getInstance().preFetchStoken(currentAccount, false);
            }
            for (SapiAccount sapiAccount2 : sapiContext.getLoginAccounts()) {
                if (sapiAccount.uid.equals(sapiAccount2.uid)) {
                    ShareAccountAccessor.getAccessor().updateSession(sapiAccount2, sapiAccount);
                    sapiContext.addLoginAccount(sapiAccount2);
                    new ShareStorage().a(false);
                }
            }
            for (SapiAccount sapiAccount3 : sapiContext.getShareAccounts()) {
                if (sapiAccount.uid.equals(sapiAccount3.uid)) {
                    ShareAccountAccessor.getAccessor().updateSession(sapiAccount3, sapiAccount);
                    sapiContext.addShareAccount(sapiAccount3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(b.b(context, str));
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    SapiContext.getInstance(context).addReloginCredentials(next, SapiAccount.ReloginCredentials.fromJSONObject(jSONObject.optJSONObject(next)));
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, LoginShareStrategy loginShareStrategy, ShareModel shareModel) {
        if (context != null && loginShareStrategy != null && shareModel != null) {
            if (TextUtils.isEmpty(shareModel.c())) {
                shareModel.a(context.getPackageName());
            }
            shareModel.a(loginShareStrategy);
            shareModel.a(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<ShareStorage.StorageModel> d(Context context) {
        return ShareStorage.StorageModel.a(SapiContext.getInstance(context).getShareStorage());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.share.c.3
            @Override // java.lang.Runnable
            public void run() {
                Context context = SapiAccountManager.getInstance().getConfignation().context;
                if (SapiUtils.isOnline(context)) {
                    ArrayList arrayList = new ArrayList();
                    List<Intent> a2 = c.a(context);
                    if (a2.size() == 0) {
                        SapiContext.getInstance(context).setShareStorage(null);
                        return;
                    }
                    ShareStorage shareStorage = new ShareStorage();
                    HashSet hashSet = new HashSet();
                    for (SapiAccount sapiAccount : SapiAccountManager.getInstance().getLoginAccounts()) {
                        hashSet.add(sapiAccount.displayname);
                    }
                    int size = a2.size();
                    int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                    int i = size;
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    for (Intent intent : a2) {
                        ShareStorage.StorageModel a3 = shareStorage.a(intent.getComponent().getPackageName());
                        if (a3 == null || a3.d == ordinal) {
                            if (a3 == null) {
                                i4++;
                            } else {
                                if (a3.c == 0) {
                                    i3++;
                                } else if (a3.c == 1) {
                                    i2++;
                                }
                                if (a3.b == 0 && !hashSet.contains(a3.displayname)) {
                                    arrayList.add(a3);
                                    hashSet.add(a3.displayname);
                                }
                            }
                            i4 = i4;
                            i3 = i3;
                            i2 = i2;
                        } else {
                            i--;
                        }
                    }
                    SapiContext.getInstance(context).setShareStorage(ShareStorage.StorageModel.toJSONArray(arrayList));
                    HashMap hashMap = new HashMap();
                    hashMap.put("cuid", SapiUtils.getClientId(context));
                    hashMap.put("device", Build.MODEL);
                    hashMap.put("read_failure_count", i4 + "");
                    hashMap.put("read_sp_count", i3 + "");
                    hashMap.put("read_sd_count", i2 + "");
                    hashMap.put("app_count", i + "");
                    hashMap.put("share_count", arrayList.size() + "");
                    hashMap.put(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE);
                    StatService.onEvent("share_read", hashMap, false);
                }
            }
        }));
    }

    public static void a(Activity activity, String str, String str2) {
        if (activity == null) {
            throw new IllegalArgumentException("loginActivity can't be null");
        }
        if (!TextUtils.isEmpty(str)) {
            ComponentName componentName = new ComponentName(str, "com.baidu.sapi2.activity.ShareActivity");
            Intent intent = new Intent();
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.setComponent(componentName);
            activity.startActivityForResult(intent, 20001);
        } else {
            Toast.makeText(activity, "登录失败", 0).show();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cuid", SapiUtils.getClientId(activity));
        hashMap.put("device", Build.MODEL);
        StatService.onEvent("share_account_click", hashMap, false);
    }

    public static void a(ShareCallPacking.ShareLoginCallBack shareLoginCallBack, int i, int i2, Intent intent, ShareCallPacking shareCallPacking) {
        int i3;
        String str;
        String str2;
        String str3;
        if (i == 20001) {
            if (shareLoginCallBack == null) {
                throw new IllegalArgumentException("and shareLoginCallBack can't be null");
            }
            Context context = SapiAccountManager.getInstance().getConfignation().context;
            if (i2 == -1) {
                SapiAccount sapiAccount = (SapiAccount) intent.getParcelableExtra("share_account");
                if (sapiAccount != null) {
                    String str4 = sapiAccount.uid;
                    SapiContext sapiContext = SapiContext.getInstance(context);
                    sapiContext.setCurrentAccount(sapiAccount);
                    SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
                    sapiContext.addLoginAccount(sapiAccount);
                    shareCallPacking.markLoginState(false);
                    sapiContext.removeShareAccount(sapiAccount);
                    String stringExtra = intent.getStringExtra("FACE_LOGIN_UID");
                    if (!TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(SapiContext.getInstance(context).getFaceLoginUid())) {
                        new FaceLoginService().syncFaceLoginUID(context, stringExtra);
                    }
                    String stringExtra2 = intent.getStringExtra("FACE_LOGIN_MODEL");
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        SapiContext.getInstance(context).setFaceLoginModel(stringExtra2);
                        new FaceLoginService().syncShareFaceLoginModel(stringExtra2);
                    }
                    shareLoginCallBack.onSuccess();
                    str3 = str4;
                    str2 = "";
                    i3 = 0;
                    HashMap hashMap = new HashMap();
                    hashMap.put("device", Build.MODEL);
                    hashMap.put("share_result", i3 + "");
                    hashMap.put("fail_reason", str2);
                    hashMap.put("uid", str3);
                    StatService.onEvent("share_account_result", hashMap, false);
                }
                i3 = 1;
                str = SapiResult.ERROR_MSG_V2_SHARE_ACCOUNT_FAIL;
                Toast.makeText(context, SapiResult.ERROR_MSG_V2_SHARE_ACCOUNT_FAIL, 0).show();
                shareLoginCallBack.onFailed(SapiResult.ERROR_CODE_V2_SHARE_ACCOUNT_FAIL, SapiResult.ERROR_MSG_V2_SHARE_ACCOUNT_FAIL);
            } else {
                i3 = 2;
                if (intent != null) {
                    str = intent.getStringExtra("share_fail_reason");
                    Toast.makeText(context, str, 0).show();
                } else {
                    str = "result data is null";
                }
                shareLoginCallBack.onFailed(SapiResult.ERROR_CODE_V2_SHARE_ACCOUNT_FAIL, SapiResult.ERROR_MSG_V2_SHARE_ACCOUNT_FAIL);
            }
            str2 = str;
            str3 = "";
            HashMap hashMap2 = new HashMap();
            hashMap2.put("device", Build.MODEL);
            hashMap2.put("share_result", i3 + "");
            hashMap2.put("fail_reason", str2);
            hashMap2.put("uid", str3);
            StatService.onEvent("share_account_result", hashMap2, false);
        }
    }
}
