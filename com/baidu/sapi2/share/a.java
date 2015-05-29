package com.baidu.sapi2.share;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
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
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.tbadk.game.GameInfoData;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a {
    static final String a = "SHARE_SERVICE";
    static final String b = "SHARE_RECEIVER";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(Intent intent);

        void a(Intent intent, Intent intent2);
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, b bVar, boolean z) {
        if (context != null && bVar != null) {
            for (Map.Entry<String, Map<String, Intent>> entry : a(context, z).entrySet()) {
                if (entry.getValue() != null) {
                    Intent intent = entry.getValue().get(a);
                    Intent intent2 = entry.getValue().get(b);
                    if (intent != null) {
                        if (a(context, intent.getComponent().getPackageName())) {
                            bVar.a(intent, intent2);
                        } else if (intent2 != null) {
                            bVar.a(intent2);
                        }
                    } else if (intent2 != null) {
                        bVar.a(intent2);
                    }
                }
            }
        }
    }

    static Map<String, Map<String, Intent>> a(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        List<Intent> a2 = a(context);
        List<Intent> b2 = b(context);
        for (Intent intent : a2) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(a, intent);
            hashMap.put(intent.getComponent().getPackageName(), hashMap2);
        }
        for (Intent intent2 : b2) {
            if (hashMap.containsKey(intent2.getComponent().getPackageName())) {
                ((Map) hashMap.get(intent2.getComponent().getPackageName())).put(b, intent2);
            } else {
                HashMap hashMap3 = new HashMap();
                hashMap3.put(b, intent2);
                hashMap.put(intent2.getComponent().getPackageName(), hashMap3);
            }
        }
        if (!z) {
            hashMap.remove(context.getPackageName());
        }
        return hashMap;
    }

    static List<Intent> a(Context context) {
        ArrayList arrayList = new ArrayList();
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
                            arrayList.add(intent);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            L.e(th);
        }
        return arrayList;
    }

    static List<Intent> b(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        try {
            for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent("baidu.intent.action.SHARE_V6"), 32)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    Intent intent = new Intent("baidu.intent.action.SHARE_V6");
                    intent.setClassName(activityInfo.packageName, activityInfo.name);
                    if (Build.VERSION.SDK_INT > 11) {
                        intent.addFlags(32);
                    }
                    if (!TextUtils.isEmpty(activityInfo.permission) && context.checkCallingOrSelfPermission(activityInfo.permission) == 0) {
                        arrayList.add(intent);
                    }
                }
            }
        } catch (Throwable th) {
            L.e(th);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        String d = d(context);
        String b2 = b(context, d);
        Map<String, String> l = com.baidu.sapi2.d.a(context).l();
        if (!TextUtils.isEmpty(d) && !TextUtils.isEmpty(b2)) {
            for (String str : l.keySet()) {
                if (d.matches(str) && b2.equals(l.get(str))) {
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
        Map<String, String> l = com.baidu.sapi2.d.a(context).l();
        String b2 = b(context, str);
        if (!TextUtils.isEmpty(b2)) {
            for (String str2 : l.keySet()) {
                if (str.matches(str2) && b2.equals(l.get(str2))) {
                    return true;
                }
            }
        }
        return false;
    }

    static String d(Context context) {
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

    static String b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures.length <= 0) {
                return "";
            }
            return a(packageInfo.signatures[0].toByteArray());
        } catch (Throwable th) {
            L.e(th);
            return "";
        }
    }

    static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return b(messageDigest.digest());
        } catch (Throwable th) {
            L.e(th);
            return "";
        }
    }

    static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return sb.toString();
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append(GameInfoData.NOT_FROM_DETAIL);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(Context context, LoginShareStrategy loginShareStrategy, ShareModel shareModel) {
        synchronized (a.class) {
            if (context != null && loginShareStrategy != null && shareModel != null) {
                shareModel.b(context);
                com.baidu.sapi2.d a2 = com.baidu.sapi2.d.a(context);
                if (loginShareStrategy == LoginShareStrategy.SILENT && !a2.h() && a2.d() == null && shareModel.a().size() > 0 && SapiUtils.isValidAccount(shareModel.a().get(0))) {
                    SapiAccount sapiAccount = shareModel.a().get(0);
                    a2.a(sapiAccount);
                    a2.c(sapiAccount);
                    a2.d(sapiAccount);
                    if (SapiAccountManager.getSilentShareListener() != null) {
                        new Handler(Looper.getMainLooper()).post(new RunnableC0008a(a2));
                    }
                    for (SapiAccount sapiAccount2 : shareModel.a()) {
                        if (a(context, sapiAccount2)) {
                            a2.b(sapiAccount2);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(SapiUtils.QR_LOGIN_LP_APP, sapiAccount.app);
                    com.baidu.sapi2.utils.a.a("silent_login_share", hashMap);
                } else {
                    for (SapiAccount sapiAccount3 : shareModel.a()) {
                        if (a(context, sapiAccount3)) {
                            a2.b(sapiAccount3);
                        }
                        b(context, sapiAccount3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.share.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class RunnableC0008a implements Runnable {
        final /* synthetic */ com.baidu.sapi2.d a;

        RunnableC0008a(com.baidu.sapi2.d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SapiAccountManager.getSilentShareListener() != null && this.a.d() != null) {
                SapiAccountManager.getSilentShareListener().onSilentShare();
            }
        }
    }

    static boolean a(Context context, SapiAccount sapiAccount) {
        if (context == null) {
            return false;
        }
        com.baidu.sapi2.d a2 = com.baidu.sapi2.d.a(context);
        if (SapiUtils.isValidAccount(sapiAccount)) {
            return (a2.d() == null || !a2.d().uid.equals(sapiAccount.uid)) && !a2.f().contains(sapiAccount);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, ShareModel shareModel) {
        if (context != null && shareModel != null) {
            shareModel.b(context);
            com.baidu.sapi2.d a2 = com.baidu.sapi2.d.a(context);
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
            com.baidu.sapi2.d a2 = com.baidu.sapi2.d.a(context);
            SapiAccount d = a2.d();
            if (d != null && sapiAccount.uid.equals(d.uid)) {
                d.bduss = sapiAccount.bduss;
                a2.a(d);
            }
            for (SapiAccount sapiAccount2 : a2.f()) {
                if (sapiAccount.uid.equals(sapiAccount2.uid)) {
                    sapiAccount2.bduss = sapiAccount.bduss;
                    a2.c(sapiAccount2);
                }
            }
            for (SapiAccount sapiAccount3 : a2.e()) {
                if (sapiAccount.uid.equals(sapiAccount3.uid)) {
                    sapiAccount3.bduss = sapiAccount.bduss;
                    a2.b(sapiAccount3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(e.b(context, str));
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    com.baidu.sapi2.d.a(context).a(next, SapiAccount.ReloginCredentials.fromJSONObject(jSONObject.optJSONObject(next)));
                }
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, LoginShareStrategy loginShareStrategy, ShareModel shareModel) {
        if (context != null && loginShareStrategy != null && shareModel != null) {
            if (TextUtils.isEmpty(shareModel.c())) {
                shareModel.a(context.getPackageName());
            }
            shareModel.a(loginShareStrategy);
            shareModel.a(context);
        }
    }
}
