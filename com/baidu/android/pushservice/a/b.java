package com.baidu.android.pushservice.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.d.f;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f2680b;

    /* renamed from: c  reason: collision with root package name */
    public Context f2682c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<e> f2681a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, f> f2683d = new HashMap<>();

    public b(Context context) {
        this.f2682c = context.getApplicationContext();
        String d2 = com.baidu.android.pushservice.c.c.d(context);
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        try {
            ArrayList<e> c2 = c(m.b(d2));
            if (c2 != null) {
                this.f2681a.addAll(c2);
            }
        } catch (Throwable th) {
            new b.c(this.f2682c).a(Log.getStackTraceString(th)).a();
        }
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f2680b == null) {
                f2680b = new b(context);
            }
            bVar = f2680b;
        }
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(List<e> list) {
        StringBuffer stringBuffer;
        if (list != null && list.size() != 0) {
            StringBuffer stringBuffer2 = null;
            try {
                stringBuffer = new StringBuffer();
                for (int i = 0; i < list.size(); i++) {
                    try {
                        e eVar = list.get(i);
                        if (eVar != null) {
                            stringBuffer.append(eVar.f2678b);
                            stringBuffer.append(",");
                            stringBuffer.append(eVar.f2677a);
                            stringBuffer.append(",");
                            stringBuffer.append(eVar.f2689d);
                            stringBuffer.append(",");
                            stringBuffer.append(eVar.f2679c);
                            if (i != list.size() - 1) {
                                stringBuffer.append(";");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        stringBuffer2 = stringBuffer;
                        new b.c(this.f2682c).a(Log.getStackTraceString(e)).a();
                        stringBuffer = stringBuffer2;
                        if (stringBuffer != null) {
                        }
                        return "";
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (stringBuffer != null) {
                return stringBuffer.toString();
            }
        }
        return "";
    }

    public e a(String str) {
        if (this.f2681a == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<e> it = this.f2681a.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (str.equals(next.f2678b)) {
                return next;
            }
        }
        return null;
    }

    public String a(e eVar, boolean z) {
        return a(eVar, z, this.f2681a);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000c A[Catch: all -> 0x0045, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x0006, B:7:0x000c, B:9:0x001c, B:11:0x0026, B:13:0x002b, B:17:0x0033, B:18:0x0036), top: B:26:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String a(e eVar, boolean z, ArrayList<e> arrayList) {
        String c2;
        boolean z2 = false;
        Iterator<e> it = arrayList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f2678b.equals(eVar.f2678b) || next.f2677a.equals(eVar.f2677a)) {
                arrayList.remove(next);
                if (z) {
                    arrayList.add(eVar);
                }
                z2 = true;
                if (!z2 && z) {
                    arrayList.add(eVar);
                }
                c2 = m.c(a(arrayList));
                com.baidu.android.pushservice.c.c.b(this.f2682c, c2);
            }
            while (it.hasNext()) {
            }
        }
        if (!z2) {
            arrayList.add(eVar);
        }
        c2 = m.c(a(arrayList));
        com.baidu.android.pushservice.c.c.b(this.f2682c, c2);
        return c2;
    }

    public void a(String str, f fVar) {
        this.f2683d.put(str, fVar);
    }

    public synchronized void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ArrayList<e> c2 = c(m.b(str2));
        String str3 = "";
        if (f2680b != null && c2 != null) {
            try {
                if (str.equals("r_v2")) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<e> it = c2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().f2678b);
                    }
                    int i = 0;
                    while (i < f2680b.f2681a.size()) {
                        if (arrayList.contains(f2680b.f2681a.get(i).f2678b)) {
                            f2680b.f2681a.remove(i);
                            i--;
                        }
                        i++;
                    }
                    f2680b.f2681a.addAll(c2);
                    str3 = a(f2680b.f2681a);
                }
                com.baidu.android.pushservice.c.c.b(this.f2682c, m.c(str3));
            } catch (Exception e2) {
                new b.c(this.f2682c).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public e b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator<e> it = this.f2681a.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (!TextUtils.isEmpty(next.f2677a) && next.f2677a.equals(str)) {
                    return next;
                }
            }
        }
        m.a("ClientManager*BBind* isRegisteredClientByAppid return null!", this.f2682c);
        return null;
    }

    public synchronized void b(Context context) {
        ArrayList<e> arrayList = null;
        String d2 = com.baidu.android.pushservice.c.c.d(context);
        if (!TextUtils.isEmpty(d2)) {
            String b2 = m.b(d2);
            m.a("ClientManager*BBind* clients=" + b2, context);
            arrayList = c(b2);
        }
        if (f2680b != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().f2678b);
            }
            int i = 0;
            while (i < f2680b.f2681a.size()) {
                if (arrayList2.contains(f2680b.f2681a.get(i).f2678b)) {
                    f2680b.f2681a.remove(i);
                    i--;
                }
                i++;
            }
            f2680b.f2681a.addAll(arrayList);
            m.a("ClientManager*BBind* sInstance.mClientsV2.size=" + f2680b.f2681a.size(), context);
        }
    }

    public boolean b(String str, String str2) {
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.f2683d.containsKey(str) && str2.equals(this.f2683d.get(str).a());
    }

    public ArrayList<e> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<e> arrayList = new ArrayList<>();
        try {
            for (String str2 : str.trim().split(";")) {
                String[] split = str2.trim().split(",");
                if (split.length >= 3) {
                    e eVar = new e();
                    eVar.f2678b = split[0].trim();
                    eVar.f2677a = split[1].trim();
                    eVar.f2689d = split[2].trim();
                    if (split.length > 3) {
                        eVar.f2679c = Integer.parseInt(split[split.length - 1].trim());
                    }
                    arrayList.add(eVar);
                }
            }
        } catch (Exception e2) {
            new b.c(this.f2682c).a(Log.getStackTraceString(e2)).a();
        }
        return arrayList;
    }

    public String d(String str) {
        return this.f2683d.get(str) != null ? this.f2683d.get(str).b() : "";
    }

    public void e(String str) {
        this.f2683d.remove(str);
    }
}
