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
import com.baidu.sapi2.utils.L;
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
public final class d {
    static final int a = 87;

    d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Intent> a(Context context) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        Map<String, Integer> p = com.baidu.sapi2.c.a(context).p();
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
                                for (String str : p.keySet()) {
                                    i = intent.getComponent().getPackageName().matches(str) ? p.get(str).intValue() : i;
                                }
                                hashMap.put(intent, Integer.valueOf(i));
                            }
                        }
                    }
                }
                ArrayList<Map.Entry> arrayList2 = new ArrayList(hashMap.entrySet());
                Collections.sort(arrayList2, new Comparator<Map.Entry<Intent, Integer>>() { // from class: com.baidu.sapi2.share.d.1
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
            L.e(th);
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
        Map<String, String> l = com.baidu.sapi2.c.a(context).l();
        if (!TextUtils.isEmpty(c) && !TextUtils.isEmpty(packageSign)) {
            for (String str : l.keySet()) {
                if (c.matches(str) && packageSign.equals(l.get(str))) {
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
        Map<String, String> l = com.baidu.sapi2.c.a(context).l();
        String packageSign = SapiUtils.getPackageSign(context, str);
        if (!TextUtils.isEmpty(packageSign)) {
            for (String str2 : l.keySet()) {
                if (str.matches(str2) && packageSign.equals(l.get(str2))) {
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
            L.e(th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(Context context, LoginShareStrategy loginShareStrategy, ShareModel shareModel, int i) {
        synchronized (d.class) {
            if (context != null && loginShareStrategy != null && shareModel != null) {
                shareModel.b(context);
                final com.baidu.sapi2.c a2 = com.baidu.sapi2.c.a(context);
                if (loginShareStrategy == LoginShareStrategy.SILENT && !a2.i() && a2.d() == null && shareModel.a().size() > 0 && SapiUtils.isValidAccount(shareModel.a().get(0))) {
                    SapiAccount sapiAccount = shareModel.a().get(0);
                    a2.a(sapiAccount);
                    a2.c(sapiAccount);
                    a2.d(sapiAccount);
                    if (SapiAccountManager.getSilentShareListener() != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.share.d.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiAccountManager.getSilentShareListener() != null && com.baidu.sapi2.c.this.d() != null) {
                                    SapiAccountManager.getSilentShareListener().onSilentShare();
                                }
                            }
                        });
                    }
                    for (SapiAccount sapiAccount2 : shareModel.a()) {
                        if (a(context, sapiAccount2)) {
                            a2.b(sapiAccount2);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(SapiUtils.QR_LOGIN_LP_APP, sapiAccount.app);
                    StatService.a("silent_login_share", hashMap);
                } else {
                    for (SapiAccount sapiAccount3 : shareModel.a()) {
                        if (a(context, sapiAccount3)) {
                            a2.b(sapiAccount3);
                        }
                        if (i >= a) {
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
        com.baidu.sapi2.c a2 = com.baidu.sapi2.c.a(context);
        if (SapiUtils.isValidAccount(sapiAccount)) {
            return (a2.d() == null || !a2.d().uid.equals(sapiAccount.uid)) && !a2.g().contains(sapiAccount);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, ShareModel shareModel) {
        if (context != null && shareModel != null) {
            shareModel.b(context);
            com.baidu.sapi2.c a2 = com.baidu.sapi2.c.a(context);
            if (shareModel.a().size() > 0) {
                SapiAccount sapiAccount = shareModel.a().get(0);
                if (a2.d() == null || !a2.d().uid.equals(sapiAccount.uid)) {
                    a2.d(sapiAccount);
                }
            }
        }
    }

    static void b(Context context, SapiAccount sapiAccount) {
        if (context != null && SapiUtils.isValidAccount(sapiAccount)) {
            com.baidu.sapi2.c a2 = com.baidu.sapi2.c.a(context);
            SapiAccount d = a2.d();
            if (d != null && sapiAccount.uid.equals(d.uid)) {
                b.a().a(d, sapiAccount);
                a2.a(d);
            }
            for (SapiAccount sapiAccount2 : a2.g()) {
                if (sapiAccount.uid.equals(sapiAccount2.uid)) {
                    b.a().a(sapiAccount2, sapiAccount);
                    a2.c(sapiAccount2);
                }
            }
            for (SapiAccount sapiAccount3 : a2.f()) {
                if (sapiAccount.uid.equals(sapiAccount3.uid)) {
                    b.a().a(sapiAccount3, sapiAccount);
                    a2.b(sapiAccount3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(c.b(context, str));
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    com.baidu.sapi2.c.a(context).a(next, SapiAccount.ReloginCredentials.fromJSONObject(jSONObject.optJSONObject(next)));
                }
            } catch (Throwable th) {
                L.e(th);
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
