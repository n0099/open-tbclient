package com.baidu.android.pushservice.a;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.pushservice.i.i;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.internal.GlobalConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public final class b {
    private static volatile b b;
    private Context c;
    public ArrayList<f> a = new ArrayList<>();
    private HashMap<String, com.baidu.android.pushservice.d.g> d = new HashMap<>();

    private b(Context context) {
        int i;
        this.c = context.getApplicationContext();
        String e = com.baidu.android.pushservice.c.c.e(context);
        if (TextUtils.isEmpty(e) && l.C(this.c)) {
            e = m.a(this.c, this.c.getPackageName() + ".push_sync", "r_v2");
        }
        if (!TextUtils.isEmpty(e)) {
            try {
                ArrayList<f> e2 = e(a(e));
                if (e2 != null) {
                    this.a.addAll(e2);
                }
            } catch (Exception e3) {
            }
        }
        if (com.baidu.android.pushservice.a.a(this.c.getPackageName()) || com.baidu.android.pushservice.b.d.k(this.c)) {
            return;
        }
        int b2 = i.b(this.c, "com.baidu.push.sync.vn", -1);
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e4) {
            i = 0;
        }
        if (b2 < i) {
            a();
            i.a(this.c, "com.baidu.push.sync.vn", i);
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
            return (TextUtils.isEmpty(str) || (a = com.baidu.android.pushservice.j.b.a(str.getBytes())) == null || a.length <= 0) ? "" : new String(BaiduAppSSOJni.decryptAES(a, a.length, 0));
        } catch (Exception e) {
            return "";
        } catch (UnsatisfiedLinkError e2) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(List<f> list) {
        StringBuffer stringBuffer;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer2 = null;
        try {
            stringBuffer = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                try {
                    f fVar = list.get(i);
                    if (fVar != null) {
                        stringBuffer.append(fVar.c);
                        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        stringBuffer.append(fVar.a);
                        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        stringBuffer.append(fVar.f);
                        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        if (fVar.g) {
                            stringBuffer.append("true");
                        } else {
                            stringBuffer.append("false");
                        }
                        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        stringBuffer.append(fVar.e);
                        if (i != list.size() - 1) {
                            stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                        }
                    }
                } catch (Exception e) {
                    stringBuffer2 = stringBuffer;
                    stringBuffer = stringBuffer2;
                    if (stringBuffer == null) {
                    }
                }
            }
        } catch (Exception e2) {
        }
        return stringBuffer == null ? stringBuffer.toString() : "";
    }

    private void a() {
        a("r_v2", this.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00fa A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:9:0x003b, B:11:0x0047, B:13:0x0053, B:14:0x008e, B:16:0x0094, B:26:0x00d0, B:28:0x00d6, B:30:0x00e0, B:31:0x00e4, B:33:0x00ea, B:34:0x00f4, B:36:0x00fa, B:38:0x010a, B:40:0x0114, B:42:0x011d, B:47:0x0131, B:49:0x0137, B:50:0x0143, B:52:0x0149, B:54:0x0159, B:56:0x0162, B:18:0x009a, B:20:0x00a4, B:22:0x00b3, B:24:0x00c2, B:25:0x00c8), top: B:68:0x003b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, ArrayList<f> arrayList) {
        String str2;
        String str3;
        String f;
        String str4;
        boolean z;
        ArrayList<f> e;
        boolean z2;
        Context v;
        String str5 = this.c.getPackageName() + ".push_sync";
        for (ResolveInfo resolveInfo : l.D(this.c) ? l.p(this.c) : l.o(this.c)) {
            try {
                String str6 = resolveInfo.activityInfo.packageName;
                if (!l.C(this.c) || (v = l.v(this.c, resolveInfo.activityInfo.packageName)) == null) {
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = m.a(v, resolveInfo.activityInfo.packageName + ".push_sync", str);
                    str2 = m.a(v, resolveInfo.activityInfo.packageName + ".self_push_sync", "bindinfo");
                }
                if ((TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) && l.m(this.c, str6) > 50) {
                    if (!TextUtils.equals(this.c.getPackageName(), GlobalConstants.SEARCHBOX_PACKAGE_NAME) && !TextUtils.equals(this.c.getPackageName(), BdSailorPlatform.LITE_PACKAGE_NAME)) {
                        str3 = com.baidu.android.pushservice.c.d.e(this.c, str6);
                    }
                    f = com.baidu.android.pushservice.c.d.f(this.c, str6);
                    str4 = str3;
                } else {
                    f = str2;
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
                if (!TextUtils.isEmpty(f)) {
                    f h = h(a(f));
                    Iterator<f> it3 = arrayList.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z = false;
                            break;
                        }
                        f next3 = it3.next();
                        if (TextUtils.equals(h.c, next3.c)) {
                            arrayList.remove(next3);
                            arrayList.add(h);
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        arrayList.add(h);
                    }
                }
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.m.a(this.c, e2);
            }
        }
        if (arrayList.size() > 0) {
            String b2 = b(a(arrayList));
            com.baidu.android.pushservice.c.c.b(this.c, b2);
            if (l.C(this.c)) {
                m.a(this.c, str5, str, b2);
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
                String[] split = str2.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
            return arrayList;
        }
    }

    private static f h(String str) {
        f fVar = new f();
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length >= 3 && !TextUtils.isEmpty(split[0])) {
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
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String a(f fVar, boolean z) {
        return a(fVar, z, this.a, "r_v2");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b A[Catch: all -> 0x006c, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x0006, B:7:0x000c, B:9:0x001c, B:11:0x0026, B:13:0x002b, B:17:0x0033, B:18:0x0036, B:20:0x004b), top: B:27:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x0006, B:7:0x000c, B:9:0x001c, B:11:0x0026, B:13:0x002b, B:17:0x0033, B:18:0x0036, B:20:0x004b), top: B:27:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String a(f fVar, boolean z, ArrayList<f> arrayList, String str) {
        boolean z2;
        String b2;
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
                b2 = b(a(arrayList));
                com.baidu.android.pushservice.c.c.b(this.c, b2);
                if (l.C(this.c)) {
                    m.a(this.c, this.c.getPackageName() + ".push_sync", str, b2);
                }
            }
            while (it.hasNext()) {
            }
        }
        z2 = false;
        if (!z2) {
            arrayList.add(fVar);
        }
        b2 = b(a(arrayList));
        com.baidu.android.pushservice.c.c.b(this.c, b2);
        if (l.C(this.c)) {
        }
        return b2;
    }

    public void a(String str, com.baidu.android.pushservice.d.g gVar) {
        this.d.put(str, gVar);
    }

    public synchronized void a(String str, String str2) {
        int i;
        if (!TextUtils.isEmpty(str2)) {
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
                    com.baidu.android.pushservice.c.c.b(this.c, b2);
                    if (l.C(this.c)) {
                        m.a(this.c, this.c.getPackageName() + ".push_sync", str, b2);
                    }
                } catch (Exception e2) {
                }
            }
        }
    }

    public String b(String str) {
        try {
            return com.baidu.android.pushservice.j.b.a(BaiduAppSSOJni.encryptAES(str, 0), "utf-8");
        } catch (Exception e) {
            return "";
        } catch (UnsatisfiedLinkError e2) {
            return "";
        }
    }

    public synchronized void b(Context context) {
        ArrayList<f> arrayList;
        int i;
        String e = com.baidu.android.pushservice.c.c.e(context);
        if (TextUtils.isEmpty(e)) {
            l.b("ClientManager*BBind* selfbindinfo is null", context);
            if (l.C(this.c)) {
                e = m.a(this.c, this.c.getPackageName() + ".push_sync", "r_v2");
            }
        }
        if (TextUtils.isEmpty(e)) {
            arrayList = null;
        } else {
            String a = a(e);
            l.b("ClientManager*BBind* clients=" + a, context);
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
            l.b("ClientManager*BBind* sInstance.mClientsV2.size=" + b.a.size(), context);
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
                if (str.equals(next.c)) {
                    return next;
                }
            }
        }
        return null;
    }

    public f d(String str) {
        String str2;
        List<ResolveInfo> p;
        ArrayList<f> e;
        Context v;
        if (!TextUtils.isEmpty(str)) {
            Iterator<f> it = this.a.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (!TextUtils.isEmpty(next.a) && next.a.equals(str)) {
                    return next;
                }
            }
            l.b("ClientManager*BBind* isRegisteredClientByAppid return not by mClientsV2!", this.c);
            try {
                p = l.D(this.c) ? l.p(this.c) : l.o(this.c);
            } catch (Exception e2) {
                str2 = null;
            }
            if (p != null && !p.isEmpty()) {
                String str3 = null;
                for (ResolveInfo resolveInfo : p) {
                    try {
                        if (l.C(this.c) && (v = l.v(this.c, resolveInfo.activityInfo.packageName)) != null) {
                            str3 = m.a(v, resolveInfo.activityInfo.packageName + ".push_sync", "r_v2");
                        }
                        if (TextUtils.isEmpty(str3)) {
                            str3 = com.baidu.android.pushservice.c.d.e(this.c, resolveInfo.activityInfo.packageName);
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
                    } catch (Exception e3) {
                        str2 = str3;
                    }
                }
                str2 = str3;
                l.b("ClientManager*BBind* isRegisteredClientByAppid return null!" + str2, this.c);
                return null;
            }
            l.b("ClientManager*BBind* getFriendPackages is null!", this.c);
        }
        str2 = null;
        l.b("ClientManager*BBind* isRegisteredClientByAppid return null!" + str2, this.c);
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
