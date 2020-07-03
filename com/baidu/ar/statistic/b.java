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
/* loaded from: classes3.dex */
class b implements k.a {
    private WeakReference<Context> uW;
    private d uY;
    private String uZ;
    private String va;
    private String[][] vb;
    private Map<String, String> vc;
    private k vf;
    private Map<String, a> uX = new HashMap();
    private long vd = 0;
    private long ve = 0;

    public b(Context context, d dVar, String[][] strArr, Map<String, String> map, k kVar) {
        this.uW = new WeakReference<>(context);
        this.uY = dVar;
        this.vb = strArr;
        this.vc = map == null ? new HashMap<>() : map;
        this.vf = kVar;
        this.vf.a(this);
    }

    private void A(long j) {
        if (j < this.vd) {
            j = this.vd;
        }
        this.ve = j;
    }

    private Pair<Long, Long> a(long j, long j2) {
        long j3;
        long j4;
        if (this.vd <= 0 || j > this.vd) {
            j3 = j2 - j;
            j4 = 0;
        } else if (this.ve <= 0 || j2 < this.ve) {
            j3 = this.vd - j;
            j4 = j2 - this.vd;
        } else {
            j3 = (this.ve - j2) + (this.vd - j);
            j4 = this.ve - this.vd;
        }
        if (j3 < 0) {
            j3 = 0;
        }
        return new Pair<>(Long.valueOf(j3), Long.valueOf(j4 >= 0 ? j4 : 0L));
    }

    private ArrayList<String> aA(String str) {
        String[][] strArr;
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.vb != null && this.vb.length > 0) {
            for (String[] strArr2 : this.vb) {
                if (strArr2 != null && strArr2.length >= 2 && str.equals(strArr2[0])) {
                    for (int i = 1; i < strArr2.length; i++) {
                        arrayList.add(strArr2[i]);
                    }
                }
            }
        }
        return arrayList;
    }

    private String aB(String str) {
        Object[][] objArr;
        if (this.vb != null && this.vb.length > 0) {
            for (Object[] objArr2 : this.vb) {
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
        synchronized (this.uY) {
            this.uY.eX();
            for (a aVar : aVarArr) {
                this.uY.k(aVar);
            }
            this.uY.notifyAll();
        }
    }

    private void d(a aVar) {
        f(aVar);
        if (aVar.ax("event_label") || !this.vc.containsKey(aVar.eR())) {
            return;
        }
        aVar.c("event_label", this.vc.get(aVar.eR()));
    }

    private String eV() {
        if (this.uZ == null) {
            Context context = this.uW.get();
            if (context == null) {
                return "";
            }
            UUID fl = new com.baidu.ar.f.e(context).fl();
            this.uZ = fl == null ? "" : fl.toString();
        }
        return this.uZ;
    }

    private void f(a aVar) {
        aVar.c("request_id", this.va);
    }

    private void z(long j) {
        this.vd = j;
    }

    public void B(long j) {
        z(j);
        synchronized (this.uY) {
            this.uY.flush();
        }
        eW();
    }

    public void C(long j) {
        A(j);
    }

    @Override // com.baidu.ar.statistic.k.a
    public void M(int i) {
        if (i > 0) {
            synchronized (this.uY) {
                this.uY.notifyAll();
            }
        }
    }

    public void aV() {
        if (this.uW.get() == null) {
            return;
        }
        this.va = com.baidu.ar.f.j.aM(eV() + String.valueOf(System.currentTimeMillis()));
    }

    public void c(a aVar) {
        d(aVar);
        b(aVar);
    }

    public void e(a aVar) {
        d(aVar);
        synchronized (this.uY) {
            this.uY.eX();
            String eR = aVar.eR();
            long longValue = ((Number) aVar.av("_db_period")).longValue();
            ArrayList arrayList = new ArrayList();
            int size = this.uY.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.uY.get(i);
                if (eR.equals(aVar2.eR()) && longValue == aVar2.aw("_db_period") && aVar.getTimestamp() - aVar2.getTimestamp() < longValue) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            if (!arrayList.isEmpty()) {
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    int intValue = ((Integer) arrayList.get(size2)).intValue();
                    this.uY.remove(intValue);
                    a.a(this.uY.get(intValue));
                }
            }
            this.uY.k(aVar);
            this.uY.notifyAll();
        }
    }

    public void eW() {
        this.vf.fb();
    }

    public void g(a aVar) {
        String eR = aVar.eR();
        a aVar2 = this.uX.get(eR);
        boolean equals = "1".equals(aVar.av("__stt"));
        if (aVar2 == null) {
            if (equals) {
                this.uX.put(eR, aVar);
                a clone = aVar.clone();
                clone.at(eR);
                clone.ay("__stt");
                clone.ay("__falseev");
                c(clone);
            }
        } else if (equals) {
        } else {
            String au = aVar.au("__falseev");
            if (au != null && !au.isEmpty()) {
                a clone2 = aVar.clone();
                clone2.at(au);
                clone2.ay("__stt");
                clone2.ay("__falseev");
                c(clone2);
            }
            this.uX.remove(eR);
            a.a(aVar2);
        }
    }

    public void g(List<String> list) {
        this.vf.i(list);
    }

    public void h(a aVar) {
        String eR = aVar.eR();
        ArrayList<String> aA = aA(eR);
        if (aA.isEmpty()) {
            return;
        }
        c(aVar.clone());
        Iterator<String> it = aA.iterator();
        while (it.hasNext()) {
            this.uX.put(eR + ":" + it.next(), aVar);
        }
    }

    public void i(a aVar) {
        String str;
        a aVar2;
        String eR = aVar.eR();
        String aB = aB(eR);
        if (aB == null || aB.isEmpty() || (aVar2 = this.uX.get((aB + ":" + eR))) == null) {
            return;
        }
        Pair<Long, Long> a = a(aVar2.getTimestamp(), aVar.getTimestamp());
        aVar.c("st", String.valueOf(aVar2.getTimestamp()));
        aVar.c("duration", String.valueOf(((Long) a.first).longValue()));
        aVar.c("_pausedt", String.valueOf(((Long) a.second).longValue()));
        c(aVar);
        this.uX.remove(str);
        a.a(aVar2);
    }

    public void j(a aVar) {
        boolean n;
        f(aVar);
        synchronized (this.vf) {
            n = this.vf.n(aVar);
        }
        if (n) {
            return;
        }
        a.a(aVar);
    }
}
