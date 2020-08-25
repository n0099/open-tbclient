package com.baidu.ar.statistic;

import android.content.Context;
import android.util.Pair;
import com.baidu.ar.statistic.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes11.dex */
class b implements k.a {
    private d vB;
    private String vC;
    private String vD;
    private String[][] vE;
    private Map<String, String> vF;
    private k vI;
    private WeakReference<Context> vz;
    private Map<String, a> vA = new HashMap();
    private long vG = 0;
    private long vH = 0;

    public b(Context context, d dVar, String[][] strArr, Map<String, String> map, k kVar) {
        this.vz = new WeakReference<>(context);
        this.vB = dVar;
        this.vE = strArr;
        this.vF = map == null ? new HashMap<>() : map;
        this.vI = kVar;
        this.vI.a(this);
    }

    private void A(long j) {
        if (j < this.vG) {
            j = this.vG;
        }
        this.vH = j;
    }

    private Pair<Long, Long> a(long j, long j2) {
        long j3;
        long j4;
        if (this.vG <= 0 || j > this.vG) {
            j3 = j2 - j;
            j4 = 0;
        } else if (this.vH <= 0 || j2 < this.vH) {
            j3 = this.vG - j;
            j4 = j2 - this.vG;
        } else {
            j3 = (this.vH - j2) + (this.vG - j);
            j4 = this.vH - this.vG;
        }
        if (j3 < 0) {
            j3 = 0;
        }
        return new Pair<>(Long.valueOf(j3), Long.valueOf(j4 >= 0 ? j4 : 0L));
    }

    private ArrayList<String> aE(String str) {
        String[][] strArr;
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.vE != null && this.vE.length > 0) {
            for (String[] strArr2 : this.vE) {
                if (strArr2 != null && strArr2.length >= 2 && str.equals(strArr2[0])) {
                    for (int i = 1; i < strArr2.length; i++) {
                        arrayList.add(strArr2[i]);
                    }
                }
            }
        }
        return arrayList;
    }

    private String aF(String str) {
        Object[][] objArr;
        if (this.vE != null && this.vE.length > 0) {
            for (Object[] objArr2 : this.vE) {
                if (objArr2 != null && objArr2.length >= 2) {
                    for (int i = 1; i < objArr2.length; i++) {
                        if (str.equals(objArr2[i])) {
                            return objArr2[0];
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    private void b(a... aVarArr) {
        synchronized (this.vB) {
            this.vB.gl();
            for (a aVar : aVarArr) {
                this.vB.k(aVar);
            }
            this.vB.notifyAll();
        }
    }

    private void d(a aVar) {
        f(aVar);
        if (aVar.aB("event_label") || !this.vF.containsKey(aVar.gf())) {
            return;
        }
        aVar.c("event_label", this.vF.get(aVar.gf()));
    }

    private void f(a aVar) {
        aVar.c("request_id", this.vD);
    }

    private String gj() {
        if (this.vC == null) {
            Context context = this.vz.get();
            if (context == null) {
                return "";
            }
            UUID gz = new com.baidu.ar.g.g(context).gz();
            this.vC = gz == null ? "" : gz.toString();
        }
        return this.vC;
    }

    private void z(long j) {
        this.vG = j;
    }

    public void B(long j) {
        z(j);
        synchronized (this.vB) {
            this.vB.flush();
        }
        gk();
    }

    public void C(long j) {
        A(j);
    }

    @Override // com.baidu.ar.statistic.k.a
    public void O(int i) {
        if (i > 0) {
            synchronized (this.vB) {
                this.vB.notifyAll();
            }
        }
    }

    public void c(a aVar) {
        d(aVar);
        b(aVar);
    }

    public void e(a aVar) {
        d(aVar);
        synchronized (this.vB) {
            this.vB.gl();
            String gf = aVar.gf();
            long longValue = ((Number) aVar.az("_db_period")).longValue();
            ArrayList arrayList = new ArrayList();
            int size = this.vB.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.vB.get(i);
                if (gf.equals(aVar2.gf()) && longValue == aVar2.aA("_db_period") && aVar.getTimestamp() - aVar2.getTimestamp() < longValue) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            if (!arrayList.isEmpty()) {
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    int intValue = ((Integer) arrayList.get(size2)).intValue();
                    this.vB.remove(intValue);
                    a.a(this.vB.get(intValue));
                }
            }
            this.vB.k(aVar);
            this.vB.notifyAll();
        }
    }

    public void g(a aVar) {
        String gf = aVar.gf();
        a aVar2 = this.vA.get(gf);
        boolean equals = "1".equals(aVar.az("__stt"));
        if (aVar2 == null) {
            if (equals) {
                this.vA.put(gf, aVar);
                a clone = aVar.clone();
                clone.ax(gf);
                clone.aC("__stt");
                clone.aC("__falseev");
                c(clone);
            }
        } else if (equals) {
        } else {
            String ay = aVar.ay("__falseev");
            if (ay != null && !ay.isEmpty()) {
                a clone2 = aVar.clone();
                clone2.ax(ay);
                clone2.aC("__stt");
                clone2.aC("__falseev");
                c(clone2);
            }
            this.vA.remove(gf);
            a.a(aVar2);
        }
    }

    public void gk() {
        this.vI.gp();
    }

    public void h(a aVar) {
        String gf = aVar.gf();
        ArrayList<String> aE = aE(gf);
        if (aE.isEmpty()) {
            return;
        }
        c(aVar.clone());
        Iterator<String> it = aE.iterator();
        while (it.hasNext()) {
            this.vA.put(gf + ":" + it.next(), aVar);
        }
    }

    public void h(List<String> list) {
        this.vI.j(list);
    }

    public void i(a aVar) {
        String str;
        a aVar2;
        String gf = aVar.gf();
        String aF = aF(gf);
        if (aF == null || aF.isEmpty() || (aVar2 = this.vA.get((aF + ":" + gf))) == null) {
            return;
        }
        Pair<Long, Long> a = a(aVar2.getTimestamp(), aVar.getTimestamp());
        aVar.c("st", String.valueOf(aVar2.getTimestamp()));
        aVar.c("duration", String.valueOf(((Long) a.first).longValue()));
        aVar.c("_pausedt", String.valueOf(((Long) a.second).longValue()));
        c(aVar);
        this.vA.remove(str);
        a.a(aVar2);
    }

    public void init() {
        if (this.vz.get() == null) {
            return;
        }
        this.vD = com.baidu.ar.g.l.aQ(gj() + String.valueOf(System.currentTimeMillis()));
    }

    public void j(a aVar) {
        boolean n;
        f(aVar);
        synchronized (this.vI) {
            n = this.vI.n(aVar);
        }
        if (n) {
            return;
        }
        a.a(aVar);
    }
}
