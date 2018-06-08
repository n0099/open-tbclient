package com.baidu.android.pushservice.b;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.pushservice.h.o;
import com.baidu.android.pushservice.j.j;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.n;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.ar.util.IoUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public final class b {
    private static volatile b b;
    private Context c;
    public ArrayList<f> a = new ArrayList<>();
    private HashMap<String, com.baidu.android.pushservice.e.g> d = new HashMap<>();

    private b(Context context) {
        int i;
        this.c = context.getApplicationContext();
        String e = com.baidu.android.pushservice.d.c.e(context);
        if (TextUtils.isEmpty(e) && m.E(this.c)) {
            e = n.a(this.c, this.c.getPackageName() + ".push_sync", "r_v2");
        }
        if (!TextUtils.isEmpty(e)) {
            try {
                ArrayList<f> e2 = e(a(e));
                if (e2 != null) {
                    Iterator<f> it = e2.iterator();
                    while (it.hasNext()) {
                        this.a.add(it.next());
                    }
                }
            } catch (Exception e3) {
            }
        }
        int b2 = j.b(this.c, "com.baidu.push.sync.vn", -1);
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e4) {
            i = 0;
        }
        if (b2 < i) {
            a();
            j.a(this.c, "com.baidu.push.sync.vn", i);
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
            return (TextUtils.isEmpty(str) || (a = com.baidu.android.pushservice.k.b.a(str.getBytes())) == null || a.length <= 0) ? "" : new String(BaiduAppSSOJni.decryptAES(a, a.length, 0));
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

    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc A[Catch: Exception -> 0x0103, TryCatch #0 {Exception -> 0x0103, blocks: (B:9:0x003b, B:11:0x0047, B:13:0x0053, B:14:0x008e, B:16:0x0094, B:21:0x00b2, B:23:0x00b8, B:25:0x00c2, B:26:0x00c6, B:28:0x00cc, B:29:0x00d6, B:31:0x00dc, B:33:0x00ec, B:35:0x00f6, B:37:0x00ff, B:42:0x0113, B:44:0x0119, B:45:0x0125, B:47:0x012b, B:49:0x013b, B:51:0x0144, B:18:0x009a, B:20:0x00a4), top: B:63:0x003b }] */
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
        for (ResolveInfo resolveInfo : m.F(this.c) ? m.o(this.c) : m.n(this.c)) {
            try {
                String str6 = resolveInfo.activityInfo.packageName;
                if (!m.E(this.c) || (v = m.v(this.c, resolveInfo.activityInfo.packageName)) == null) {
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = n.a(v, resolveInfo.activityInfo.packageName + ".push_sync", str);
                    str2 = n.a(v, resolveInfo.activityInfo.packageName + ".self_push_sync", "bindinfo");
                }
                if ((TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) && m.m(this.c, str6) > 50) {
                    String e2 = com.baidu.android.pushservice.d.d.e(this.c, str6);
                    f = com.baidu.android.pushservice.d.d.f(this.c, str6);
                    str4 = e2;
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
            } catch (Exception e3) {
                o.a(this.c, e3);
            }
        }
        if (arrayList.size() > 0) {
            String b2 = b(a(arrayList));
            com.baidu.android.pushservice.d.c.c(this.c, b2);
            if (m.E(this.c)) {
                n.a(this.c, str5, str, b2);
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
        }
        return null;
    }

    public f a(int i, boolean z) {
        Iterator<f> it = this.a.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next.d >= i && (!z || next.g)) {
                if (m.c(this.c, next.c())) {
                    return next;
                }
            }
        }
        return null;
    }

    public String a(f fVar, boolean z) {
        return a(fVar, z, this.a, "r_v2");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x0006, B:7:0x000c, B:9:0x001c, B:11:0x0026, B:13:0x002b, B:17:0x0033, B:18:0x0036, B:20:0x004b, B:21:0x006a), top: B:27:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x0006, B:7:0x000c, B:9:0x001c, B:11:0x0026, B:13:0x002b, B:17:0x0033, B:18:0x0036, B:20:0x004b, B:21:0x006a), top: B:27:0x0002 }] */
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
                    b2 = b(a(arrayList));
                    com.baidu.android.pushservice.d.c.c(this.c, b2);
                    if (m.E(this.c)) {
                        n.a(this.c, this.c.getPackageName() + ".push_sync", str, b2);
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
            com.baidu.android.pushservice.d.c.c(this.c, b2);
            if (m.E(this.c)) {
            }
        }
        return b2;
    }

    public void a(String str, com.baidu.android.pushservice.e.g gVar) {
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
                    com.baidu.android.pushservice.d.c.c(this.c, b2);
                    if (m.E(this.c)) {
                        n.a(this.c, this.c.getPackageName() + ".push_sync", str, b2);
                    }
                } catch (Exception e2) {
                }
            }
        }
    }

    public String b(String str) {
        try {
            return com.baidu.android.pushservice.k.b.a(BaiduAppSSOJni.encryptAES(str, 0), IoUtils.UTF_8);
        } catch (Exception e) {
            return "";
        } catch (UnsatisfiedLinkError e2) {
            return "";
        }
    }

    public synchronized void b(Context context) {
        ArrayList<f> arrayList;
        int i;
        String e = com.baidu.android.pushservice.d.c.e(context);
        if (TextUtils.isEmpty(e)) {
            m.b("ClientManager*BBind* selfbindinfo is null", context);
            if (m.E(this.c)) {
                e = n.a(this.c, this.c.getPackageName() + ".push_sync", "r_v2");
            }
        }
        if (TextUtils.isEmpty(e)) {
            arrayList = null;
        } else {
            String a = a(e);
            m.b("ClientManager*BBind* clients=" + a, context);
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
            m.b("ClientManager*BBind* sInstance.mClientsV2.size=" + b.a.size(), context);
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
        List<ResolveInfo> o;
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
            m.b("ClientManager*BBind* isRegisteredClientByAppid return not by mClientsV2!", this.c);
            try {
                o = m.F(this.c) ? m.o(this.c) : m.n(this.c);
            } catch (Exception e2) {
                str2 = null;
            }
            if (o != null && !o.isEmpty()) {
                String str3 = null;
                for (ResolveInfo resolveInfo : o) {
                    try {
                        if (m.E(this.c) && (v = m.v(this.c, resolveInfo.activityInfo.packageName)) != null) {
                            str3 = n.a(v, resolveInfo.activityInfo.packageName + ".push_sync", "r_v2");
                        }
                        if (TextUtils.isEmpty(str3)) {
                            str3 = com.baidu.android.pushservice.d.d.e(this.c, resolveInfo.activityInfo.packageName);
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
                m.b("ClientManager*BBind* isRegisteredClientByAppid return null!" + str2, this.c);
                return null;
            }
            m.b("ClientManager*BBind* getFriendPackages is null!", this.c);
        }
        str2 = null;
        m.b("ClientManager*BBind* isRegisteredClientByAppid return null!" + str2, this.c);
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
