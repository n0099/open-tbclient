package com.baidu.android.pushservice.b;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.pushservice.f.p;
import com.baidu.android.pushservice.h.m;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.h.r;
import com.baidu.android.pushservice.h.u;
import com.baidu.android.pushservice.h.v;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class b {
    private static volatile b b;
    private Context c;
    public ArrayList<f> a = new ArrayList<>();
    private HashMap<String, com.baidu.android.pushservice.c.g> d = new HashMap<>();

    private b(Context context) {
        int i;
        this.c = context.getApplicationContext();
        String g = q.g(context);
        if (TextUtils.isEmpty(g) && u.D(this.c)) {
            g = v.a(this.c, this.c.getPackageName() + ".push_sync", "r_v2");
        }
        if (TextUtils.isEmpty(g)) {
            com.baidu.android.pushservice.e.a.d("ClientManager", "ClientManager init strAppsV2 empty.");
        } else {
            try {
                String a = a(g);
                com.baidu.android.pushservice.e.a.b("ClientManager", "ClientManager init strAppsV2 : " + a);
                ArrayList<f> e = e(a);
                if (e != null) {
                    Iterator<f> it = e.iterator();
                    while (it.hasNext()) {
                        this.a.add(it.next());
                    }
                }
            } catch (Exception e2) {
                com.baidu.android.pushservice.e.a.a("ClientManager", e2);
            }
        }
        int b2 = m.b(this.c, "com.baidu.push.sync.vn", -1);
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e3) {
            com.baidu.android.pushservice.e.a.c("ClientManager", "Clientmanager not found " + context.getPackageName());
            i = 0;
        }
        if (b2 < i) {
            a();
            m.a(this.c, "com.baidu.push.sync.vn", i);
        }
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b(context);
            }
            bVar = b;
        }
        return bVar;
    }

    public static String a(String str) {
        byte[] a;
        try {
            return (TextUtils.isEmpty(str) || (a = com.baidu.android.pushservice.i.b.a(str.getBytes())) == null || a.length <= 0) ? "" : new String(BaiduAppSSOJni.decryptAES(a, a.length, 0));
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a("ClientManager", e);
            return "";
        } catch (UnsatisfiedLinkError e2) {
            com.baidu.android.pushservice.e.a.a("ClientManager", e2);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(List<f> list) {
        StringBuffer stringBuffer;
        if (list == null || list.size() == 0) {
            return "";
        }
        try {
            stringBuffer = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                try {
                    f fVar = list.get(i);
                    if (fVar != null) {
                        stringBuffer.append(fVar.c);
                        stringBuffer.append(",");
                        stringBuffer.append(fVar.a);
                        stringBuffer.append(",");
                        stringBuffer.append(fVar.f);
                        stringBuffer.append(",");
                        if (fVar.g) {
                            stringBuffer.append("true");
                        } else {
                            stringBuffer.append("false");
                        }
                        stringBuffer.append(",");
                        stringBuffer.append(fVar.e);
                        if (i != list.size() - 1) {
                            stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    com.baidu.android.pushservice.e.a.a("ClientManager", e);
                    if (stringBuffer == null) {
                    }
                }
            }
        } catch (Exception e2) {
            e = e2;
            stringBuffer = null;
        }
        return stringBuffer == null ? stringBuffer.toString() : "";
    }

    private void a() {
        a("r_v2", this.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d8 A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:9:0x003a, B:11:0x0046, B:13:0x0052, B:14:0x008a, B:16:0x0090, B:21:0x00ae, B:23:0x00b4, B:25:0x00be, B:26:0x00c2, B:28:0x00c8, B:29:0x00d2, B:31:0x00d8, B:33:0x00e8, B:35:0x00f2, B:37:0x00fb, B:42:0x012b, B:44:0x0131, B:45:0x013d, B:47:0x0143, B:49:0x0153, B:51:0x015c, B:18:0x0096, B:20:0x00a0), top: B:63:0x003a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, ArrayList<f> arrayList) {
        String str2;
        String str3;
        String h;
        String str4;
        boolean z;
        ArrayList<f> e;
        boolean z2;
        Context t;
        String str5 = this.c.getPackageName() + ".push_sync";
        for (ResolveInfo resolveInfo : u.E(this.c) ? u.n(this.c) : u.m(this.c)) {
            try {
                String str6 = resolveInfo.activityInfo.packageName;
                if (!u.D(this.c) || (t = u.t(this.c, resolveInfo.activityInfo.packageName)) == null) {
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = v.a(t, resolveInfo.activityInfo.packageName + ".push_sync", str);
                    str2 = v.a(t, resolveInfo.activityInfo.packageName + ".self_push_sync", "bindinfo");
                }
                if ((TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) && u.l(this.c, str6) > 50) {
                    String g = r.g(this.c, str6);
                    h = r.h(this.c, str6);
                    str4 = g;
                } else {
                    h = str2;
                    str4 = str3;
                }
                if (!TextUtils.isEmpty(str4) && (e = e(a(str4))) != null) {
                    Iterator<f> it = e.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        Iterator<f> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            f next2 = it2.next();
                            if (TextUtils.equals(next.c, next2.c) || TextUtils.equals(next.a, next2.a)) {
                                arrayList.remove(next2);
                                arrayList.add(next);
                                z2 = true;
                                break;
                            }
                            while (it2.hasNext()) {
                            }
                        }
                        z2 = false;
                        if (!z2) {
                            arrayList.add(next);
                        }
                    }
                }
                if (!TextUtils.isEmpty(h)) {
                    f h2 = h(a(h));
                    Iterator<f> it3 = arrayList.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z = false;
                            break;
                        }
                        f next3 = it3.next();
                        if (TextUtils.equals(h2.c, next3.c)) {
                            arrayList.remove(next3);
                            arrayList.add(h2);
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        arrayList.add(h2);
                    }
                }
            } catch (Exception e2) {
                com.baidu.android.pushservice.e.a.e("ClientManager", "syncRegisterDataImpl Exception: " + e2.getMessage());
                p.a(this.c, e2);
            }
        }
        if (arrayList.size() > 0) {
            String b2 = b(a(arrayList));
            q.e(this.c, b2);
            if (u.D(this.c)) {
                v.a(this.c, str5, str, b2);
            }
        }
    }

    public static ArrayList<f> e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<f> arrayList = new ArrayList<>();
        try {
            for (String str2 : str.trim().split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
                String[] split = str2.trim().split(",");
                if (split.length >= 3) {
                    f fVar = new f();
                    fVar.c = split[0].trim();
                    fVar.a = split[1].trim();
                    fVar.f = split[2].trim();
                    if (split.length > 3) {
                        fVar.g = split[3].trim().equals("true");
                        if (split.length > 4) {
                            fVar.e = Integer.parseInt(split[4].trim());
                        }
                    }
                    arrayList.add(fVar);
                }
            }
            return arrayList;
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a("ClientManager", e);
            return arrayList;
        }
    }

    private f h(String str) {
        String[] split;
        f fVar = new f();
        try {
            if (!TextUtils.isEmpty(str) && (split = str.trim().split(",")) != null && split.length >= 3 && !TextUtils.isEmpty(split[0])) {
                fVar.c = split[0].trim();
                fVar.a = split[1].trim();
                fVar.f = split[2].trim();
                if (split.length > 3) {
                    fVar.g = split[3].trim().equals("true");
                    if (split.length > 4) {
                        fVar.e = Integer.parseInt(split[4].trim());
                        return fVar;
                    }
                    return fVar;
                }
                return fVar;
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a("ClientManager", e);
        }
        return null;
    }

    public f a(int i, boolean z) {
        Iterator<f> it = this.a.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next.d >= i && (!z || next.g)) {
                if (u.c(this.c, next.c())) {
                    return next;
                }
            }
        }
        return null;
    }

    public String a(f fVar, boolean z) {
        com.baidu.android.pushservice.e.a.c("ClientManager", "syncV2 addOrRemove:" + z + ", " + fVar);
        com.baidu.android.pushservice.e.a.c("ClientManager", "client.packageName=" + fVar.c + " client.appId=" + fVar.a + " client.userId=" + fVar.f);
        return a(fVar, z, this.a, "r_v2");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0063 A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x0006, B:7:0x000c, B:9:0x001c, B:11:0x0026, B:13:0x002b, B:17:0x0033, B:18:0x0036, B:20:0x0063, B:21:0x0081), top: B:27:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x0006, B:7:0x000c, B:9:0x001c, B:11:0x0026, B:13:0x002b, B:17:0x0033, B:18:0x0036, B:20:0x0063, B:21:0x0081), top: B:27:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(f fVar, boolean z, ArrayList<f> arrayList, String str) {
        boolean z2;
        String b2;
        synchronized (arrayList) {
            Iterator<f> it = arrayList.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next.c.equals(fVar.c) || next.a.equals(fVar.a)) {
                    arrayList.remove(next);
                    if (z) {
                        arrayList.add(fVar);
                    }
                    z2 = true;
                    if (!z2 && z) {
                        arrayList.add(fVar);
                    }
                    String a = a(arrayList);
                    com.baidu.android.pushservice.e.a.b("ClientManager", "sync  strApps: " + a);
                    b2 = b(a);
                    q.e(this.c, b2);
                    if (u.D(this.c)) {
                        v.a(this.c, this.c.getPackageName() + ".push_sync", str, b2);
                    }
                }
                while (it.hasNext()) {
                }
            }
            z2 = false;
            if (!z2) {
                arrayList.add(fVar);
            }
            String a2 = a(arrayList);
            com.baidu.android.pushservice.e.a.b("ClientManager", "sync  strApps: " + a2);
            b2 = b(a2);
            q.e(this.c, b2);
            if (u.D(this.c)) {
            }
        }
        return b2;
    }

    public void a(String str, com.baidu.android.pushservice.c.g gVar) {
        this.d.put(str, gVar);
    }

    public synchronized void a(String str, String str2) {
        int i;
        if (TextUtils.isEmpty(str2)) {
            com.baidu.android.pushservice.e.a.c("ClientManager", "ClientManager init strApps empty.");
        } else {
            ArrayList<f> e = e(a(str2));
            String str3 = "";
            if (b != null && e != null) {
                try {
                    if (str.equals("r_v2")) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<f> it = e.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().c);
                        }
                        int i2 = 0;
                        while (i2 < b.a.size()) {
                            if (arrayList.contains(b.a.get(i2).c)) {
                                b.a.remove(i2);
                                i = i2 - 1;
                            } else {
                                i = i2;
                            }
                            i2 = i + 1;
                        }
                        b.a.addAll(e);
                        str3 = a(b.a);
                    }
                    String b2 = b(str3);
                    q.e(this.c, b2);
                    if (u.D(this.c)) {
                        v.a(this.c, this.c.getPackageName() + ".push_sync", str, b2);
                    }
                } catch (Exception e2) {
                    com.baidu.android.pushservice.e.a.a("ClientManager", e2);
                }
            }
        }
    }

    public String b(String str) {
        try {
            return com.baidu.android.pushservice.i.b.a(BaiduAppSSOJni.encryptAES(str, 0), "utf-8");
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.e("ClientManager", "encrypted init strApps exception.");
            return "";
        } catch (UnsatisfiedLinkError e2) {
            com.baidu.android.pushservice.e.a.a("ClientManager", e2);
            return "";
        }
    }

    public synchronized void b(Context context) {
        ArrayList<f> arrayList;
        int i;
        String g = q.g(context);
        if (TextUtils.isEmpty(g)) {
            com.baidu.android.pushservice.e.a.c("ClientManager", "*BBind* selfbindinfo is null");
            u.b("ClientManager*BBind* selfbindinfo is null", context);
            if (u.D(this.c)) {
                g = v.a(this.c, this.c.getPackageName() + ".push_sync", "r_v2");
            }
        }
        if (TextUtils.isEmpty(g)) {
            arrayList = null;
        } else {
            String a = a(g);
            u.b("ClientManager*BBind* clients=" + a, context);
            arrayList = e(a);
        }
        if (b != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<f> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().c);
            }
            int i2 = 0;
            while (i2 < b.a.size()) {
                if (arrayList2.contains(b.a.get(i2).c)) {
                    b.a.remove(i2);
                    i = i2 - 1;
                } else {
                    i = i2;
                }
                i2 = i + 1;
            }
            b.a.addAll(arrayList);
            u.b("ClientManager*BBind* sInstance.mClientsV2.size=" + b.a.size(), context);
        }
    }

    public boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.d.containsKey(str) && str2.equals(this.d.get(str).a());
    }

    public f c(String str) {
        if (this.a != null && !TextUtils.isEmpty(str)) {
            Iterator<f> it = this.a.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next.c.equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public f d(String str) {
        String str2;
        Exception exc;
        List<ResolveInfo> n;
        ArrayList<f> e;
        Context t;
        if (!TextUtils.isEmpty(str)) {
            Iterator<f> it = this.a.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (!TextUtils.isEmpty(next.a) && next.a.equals(str)) {
                    return next;
                }
            }
            u.b("ClientManager*BBind* isRegisteredClientByAppid return not by mClientsV2!", this.c);
            try {
                n = u.E(this.c) ? u.n(this.c) : u.m(this.c);
            } catch (Exception e2) {
                exc = e2;
                str2 = null;
            }
            if (n != null && !n.isEmpty()) {
                String str3 = null;
                for (ResolveInfo resolveInfo : n) {
                    try {
                        if (u.D(this.c) && (t = u.t(this.c, resolveInfo.activityInfo.packageName)) != null) {
                            try {
                                str3 = v.a(t, resolveInfo.activityInfo.packageName + ".push_sync", "r_v2");
                            } catch (Exception e3) {
                                com.baidu.android.pushservice.e.a.a("ClientManager", e3);
                            }
                        }
                        if (TextUtils.isEmpty(str3)) {
                            str3 = r.g(this.c, resolveInfo.activityInfo.packageName);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            String a = a(str3);
                            if (a.contains(str) && (e = e(a)) != null && !e.isEmpty()) {
                                Iterator<f> it2 = e.iterator();
                                while (it2.hasNext()) {
                                    f next2 = it2.next();
                                    if (!TextUtils.isEmpty(next2.a) && next2.a.equals(str)) {
                                        this.a.add(next2);
                                        return next2;
                                    }
                                }
                                continue;
                            }
                        }
                    } catch (Exception e4) {
                        str2 = str3;
                        exc = e4;
                        com.baidu.android.pushservice.e.a.a("ClientManager", exc);
                        u.b("ClientManager*BBind* isRegisteredClientByAppid return null!" + str2, this.c);
                        return null;
                    }
                }
                str2 = str3;
                u.b("ClientManager*BBind* isRegisteredClientByAppid return null!" + str2, this.c);
                return null;
            }
            u.b("ClientManager*BBind* getFriendPackages is null!", this.c);
        }
        str2 = null;
        u.b("ClientManager*BBind* isRegisteredClientByAppid return null!" + str2, this.c);
        return null;
    }

    public String f(String str) {
        return this.d.get(str) != null ? this.d.get(str).b() : "";
    }

    public void g(String str) {
        if (this.d.containsKey(str)) {
            this.d.remove(str);
        }
    }
}
