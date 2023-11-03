package com.baidu.android.pushservice.k;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.p.f;
import com.baidu.android.pushservice.util.Utility;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class b {
    public static volatile b d;
    public Context a;
    public ArrayList<e> b = new ArrayList<>();
    public HashMap<String, f> c = new HashMap<>();

    public b(Context context) {
        this.a = context.getApplicationContext();
        String h = com.baidu.android.pushservice.m.d.h(context);
        if (TextUtils.isEmpty(h)) {
            return;
        }
        try {
            ArrayList<e> e = e(Utility.b(h));
            if (e != null) {
                this.b.addAll(e);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (d == null) {
                d = new b(context);
            }
            bVar = d;
        }
        return bVar;
    }

    public String a(e eVar, boolean z) {
        return a(eVar, z, this.b);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000c A[Catch: all -> 0x0045, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x0006, B:7:0x000c, B:9:0x001c, B:11:0x0026, B:13:0x002b, B:17:0x0033, B:18:0x0036), top: B:24:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String a(e eVar, boolean z, ArrayList<e> arrayList) {
        String c;
        boolean z2 = false;
        Iterator<e> it = arrayList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.b.equals(eVar.b) || next.a.equals(eVar.a)) {
                arrayList.remove(next);
                if (z) {
                    arrayList.add(eVar);
                }
                z2 = true;
                if (!z2 && z) {
                    arrayList.add(eVar);
                }
                c = Utility.c(a(arrayList));
                com.baidu.android.pushservice.m.d.g(this.a, c);
            }
            while (it.hasNext()) {
            }
        }
        if (!z2) {
            arrayList.add(eVar);
        }
        c = Utility.c(a(arrayList));
        com.baidu.android.pushservice.m.d.g(this.a, c);
        return c;
    }

    public String a(String str) {
        return this.c.get(str) != null ? this.c.get(str).b() : "";
    }

    public final String a(List<e> list) {
        if (list != null && list.size() != 0) {
            StringBuffer stringBuffer = null;
            try {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int i = 0; i < list.size(); i++) {
                    try {
                        e eVar = list.get(i);
                        if (eVar != null) {
                            stringBuffer2.append(eVar.b);
                            stringBuffer2.append(",");
                            stringBuffer2.append(eVar.a);
                            stringBuffer2.append(",");
                            stringBuffer2.append(eVar.d);
                            stringBuffer2.append(",");
                            stringBuffer2.append(eVar.c);
                            if (i != list.size() - 1) {
                                stringBuffer2.append(ParamableElem.DIVIDE_PARAM);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                stringBuffer = stringBuffer2;
            } catch (Exception unused2) {
            }
            if (stringBuffer != null) {
                return stringBuffer.toString();
            }
        }
        return "";
    }

    public void a(String str, f fVar) {
        this.c.put(str, fVar);
    }

    public boolean a(String str, String str2) {
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.c.containsKey(str) && str2.equals(this.c.get(str).a());
    }

    public e b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<e> it = this.b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (!TextUtils.isEmpty(next.a) && next.a.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public synchronized void b(Context context) {
        String h = com.baidu.android.pushservice.m.d.h(context);
        ArrayList<e> e = TextUtils.isEmpty(h) ? null : e(Utility.b(h));
        if (d != null && e != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = e.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().b);
            }
            int i = 0;
            while (i < d.b.size()) {
                if (arrayList.contains(d.b.get(i).b)) {
                    d.b.remove(i);
                    i--;
                }
                i++;
            }
            d.b.addAll(e);
        }
    }

    public synchronized void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ArrayList<e> e = e(Utility.b(str2));
        String str3 = "";
        if (d != null && e != null) {
            try {
                if (str.equals("r_v2")) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<e> it = e.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().b);
                    }
                    int i = 0;
                    while (i < d.b.size()) {
                        if (arrayList.contains(d.b.get(i).b)) {
                            d.b.remove(i);
                            i--;
                        }
                        i++;
                    }
                    d.b.addAll(e);
                    str3 = a(d.b);
                }
                com.baidu.android.pushservice.m.d.g(this.a, Utility.c(str3));
            } catch (Exception unused) {
            }
        }
    }

    public e c(String str) {
        if (this.b == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<e> it = this.b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (str.equals(next.b)) {
                return next;
            }
        }
        return null;
    }

    public void d(String str) {
        this.c.remove(str);
    }

    public ArrayList<e> e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<e> arrayList = new ArrayList<>();
        try {
            for (String str2 : str.trim().split(ParamableElem.DIVIDE_PARAM)) {
                String[] split = str2.trim().split(",");
                if (split.length >= 3) {
                    e eVar = new e();
                    eVar.b = split[0].trim();
                    eVar.a = split[1].trim();
                    eVar.d = split[2].trim();
                    if (split.length > 3) {
                        eVar.c = Integer.parseInt(split[split.length - 1].trim());
                    }
                    arrayList.add(eVar);
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
