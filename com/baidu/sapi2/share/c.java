package com.baidu.sapi2.share;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c {
    static final int a = 87;

    c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Intent> a(Context context) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        Map<String, Integer> orderAuthorizedPackages = SapiContext.getInstance(context).getOrderAuthorizedPackages();
        if (context == null) {
            return arrayList;
        }
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent("baidu.intent.action.account.SHARE_SERVICE"), 32);
            if (queryIntentServices != null) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    if (serviceInfo != null) {
                        Intent intent = new Intent("baidu.intent.action.account.SHARE_SERVICE");
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        if (Build.VERSION.SDK_INT > 11) {
                            intent.addFlags(32);
                        }
                        if (TextUtils.isEmpty(serviceInfo.permission) || context.checkCallingOrSelfPermission(serviceInfo.permission) == 0) {
                            if (a(context, intent.getComponent().getPackageName()) && !context.getPackageName().equals(intent.getComponent().getPackageName())) {
                                int i = Integer.MAX_VALUE;
                                for (String str : orderAuthorizedPackages.keySet()) {
                                    i = intent.getComponent().getPackageName().matches(str) ? orderAuthorizedPackages.get(str).intValue() : i;
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
        String c = c(context);
        String packageSign = SapiUtils.getPackageSign(context, c);
        Map<String, String> authorizedPackages = SapiContext.getInstance(context).getAuthorizedPackages();
        if (!TextUtils.isEmpty(c) && !TextUtils.isEmpty(packageSign)) {
            for (String str : authorizedPackages.keySet()) {
                if (c.matches(str) && packageSign.equals(authorizedPackages.get(str))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean a(Context context, String str) {
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
                    HashMap hashMap = new HashMap();
                    hashMap.put("app", sapiAccount.app);
                    StatService.onEvent("silent_login_share", hashMap);
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
}
