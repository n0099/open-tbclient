package com.baidu.android.pushservice.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.pushservice.d.f;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f1175b;
    private Context c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<e> f1176a = new ArrayList<>();
    private HashMap<String, f> d = new HashMap<>();

    private b(Context context) {
        this.c = context.getApplicationContext();
        String d = com.baidu.android.pushservice.c.c.d(context);
        if (TextUtils.isEmpty(d)) {
            return;
        }
        try {
            ArrayList<e> c = c(m.b(d));
            if (c != null) {
                this.f1176a.addAll(c);
            }
        } catch (Throwable th) {
            new b.c(this.c).a(Log.getStackTraceString(th)).a();
        }
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f1175b == null) {
                f1175b = new b(context);
            }
            bVar = f1175b;
        }
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(List<e> list) {
        StringBuffer stringBuffer;
        if (list == null || list.size() == 0) {
            return "";
        }
        try {
            stringBuffer = new StringBuffer();
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    e eVar = list.get(i2);
                    if (eVar != null) {
                        stringBuffer.append(eVar.f1174b);
                        stringBuffer.append(",");
                        stringBuffer.append(eVar.f1173a);
                        stringBuffer.append(",");
                        stringBuffer.append(eVar.d);
                        stringBuffer.append(",");
                        stringBuffer.append(eVar.c);
                        if (i2 != list.size() - 1) {
                            stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                        }
                    }
                    i = i2 + 1;
                } catch (Exception e) {
                    e = e;
                    new b.c(this.c).a(Log.getStackTraceString(e)).a();
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

    public e a(String str) {
        if (this.f1176a != null && !TextUtils.isEmpty(str)) {
            Iterator<e> it = this.f1176a.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (str.equals(next.f1174b)) {
                    return next;
                }
            }
        }
        return null;
    }

    public String a(e eVar, boolean z) {
        return a(eVar, z, this.f1176a);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000c A[Catch: all -> 0x0045, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x0006, B:7:0x000c, B:9:0x001c, B:11:0x0026, B:13:0x002b, B:17:0x0033, B:18:0x0036), top: B:25:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String a(e eVar, boolean z, ArrayList<e> arrayList) {
        boolean z2;
        String c;
        Iterator<e> it = arrayList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f1174b.equals(eVar.f1174b) || next.f1173a.equals(eVar.f1173a)) {
                arrayList.remove(next);
                if (z) {
                    arrayList.add(eVar);
                }
                z2 = true;
                if (!z2 && z) {
                    arrayList.add(eVar);
                }
                c = m.c(a(arrayList));
                com.baidu.android.pushservice.c.c.b(this.c, c);
            }
            while (it.hasNext()) {
            }
        }
        z2 = false;
        if (!z2) {
            arrayList.add(eVar);
        }
        c = m.c(a(arrayList));
        com.baidu.android.pushservice.c.c.b(this.c, c);
        return c;
    }

    public void a(String str, f fVar) {
        this.d.put(str, fVar);
    }

    public synchronized void a(String str, String str2) {
        int i;
        if (!TextUtils.isEmpty(str2)) {
            ArrayList<e> c = c(m.b(str2));
            String str3 = "";
            if (f1175b != null && c != null) {
                try {
                    if (str.equals("r_v2")) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<e> it = c.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().f1174b);
                        }
                        int i2 = 0;
                        while (i2 < f1175b.f1176a.size()) {
                            if (arrayList.contains(f1175b.f1176a.get(i2).f1174b)) {
                                f1175b.f1176a.remove(i2);
                                i = i2 - 1;
                            } else {
                                i = i2;
                            }
                            i2 = i + 1;
                        }
                        f1175b.f1176a.addAll(c);
                        str3 = a(f1175b.f1176a);
                    }
                    com.baidu.android.pushservice.c.c.b(this.c, m.c(str3));
                } catch (Exception e) {
                    new b.c(this.c).a(Log.getStackTraceString(e)).a();
                }
            }
        }
    }

    public e b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator<e> it = this.f1176a.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (!TextUtils.isEmpty(next.f1173a) && next.f1173a.equals(str)) {
                    return next;
                }
            }
        }
        m.a("ClientManager*BBind* isRegisteredClientByAppid return null!", this.c);
        return null;
    }

    public synchronized void b(Context context) {
        ArrayList<e> arrayList;
        int i;
        String d = com.baidu.android.pushservice.c.c.d(context);
        if (TextUtils.isEmpty(d)) {
            arrayList = null;
        } else {
            String b2 = m.b(d);
            m.a("ClientManager*BBind* clients=" + b2, context);
            arrayList = c(b2);
        }
        if (f1175b != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().f1174b);
            }
            int i2 = 0;
            while (i2 < f1175b.f1176a.size()) {
                if (arrayList2.contains(f1175b.f1176a.get(i2).f1174b)) {
                    f1175b.f1176a.remove(i2);
                    i = i2 - 1;
                } else {
                    i = i2;
                }
                i2 = i + 1;
            }
            f1175b.f1176a.addAll(arrayList);
            m.a("ClientManager*BBind* sInstance.mClientsV2.size=" + f1175b.f1176a.size(), context);
        }
    }

    public boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.d.containsKey(str) && str2.equals(this.d.get(str).a());
    }

    public ArrayList<e> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<e> arrayList = new ArrayList<>();
        try {
            for (String str2 : str.trim().split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
                String[] split = str2.trim().split(",");
                if (split.length >= 3) {
                    e eVar = new e();
                    eVar.f1174b = split[0].trim();
                    eVar.f1173a = split[1].trim();
                    eVar.d = split[2].trim();
                    if (split.length > 3) {
                        eVar.c = Integer.parseInt(split[split.length - 1].trim());
                    }
                    arrayList.add(eVar);
                }
            }
            return arrayList;
        } catch (Exception e) {
            new b.c(this.c).a(Log.getStackTraceString(e)).a();
            return arrayList;
        }
    }

    public String d(String str) {
        return this.d.get(str) != null ? this.d.get(str).b() : "";
    }

    public void e(String str) {
        this.d.remove(str);
    }
}
