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
    private String uA;
    private String[][] uB;
    private Map<String, String> uC;
    private k uF;
    private WeakReference<Context> uw;
    private d uy;
    private String uz;
    private Map<String, a> ux = new HashMap();
    private long uD = 0;
    private long uE = 0;

    public b(Context context, d dVar, String[][] strArr, Map<String, String> map, k kVar) {
        this.uw = new WeakReference<>(context);
        this.uy = dVar;
        this.uB = strArr;
        this.uC = map == null ? new HashMap<>() : map;
        this.uF = kVar;
        this.uF.a(this);
    }

    private void A(long j) {
        if (j < this.uD) {
            j = this.uD;
        }
        this.uE = j;
    }

    private Pair<Long, Long> a(long j, long j2) {
        long j3;
        long j4;
        if (this.uD <= 0 || j > this.uD) {
            j3 = j2 - j;
            j4 = 0;
        } else if (this.uE <= 0 || j2 < this.uE) {
            j3 = this.uD - j;
            j4 = j2 - this.uD;
        } else {
            j3 = (this.uE - j2) + (this.uD - j);
            j4 = this.uE - this.uD;
        }
        if (j3 < 0) {
            j3 = 0;
        }
        return new Pair<>(Long.valueOf(j3), Long.valueOf(j4 >= 0 ? j4 : 0L));
    }

    private String aA(String str) {
        Object[][] objArr;
        if (this.uB != null && this.uB.length > 0) {
            for (Object[] objArr2 : this.uB) {
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

    private ArrayList<String> az(String str) {
        String[][] strArr;
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.uB != null && this.uB.length > 0) {
            for (String[] strArr2 : this.uB) {
                if (strArr2 != null && strArr2.length >= 2 && str.equals(strArr2[0])) {
                    for (int i = 1; i < strArr2.length; i++) {
                        arrayList.add(strArr2[i]);
                    }
                }
            }
        }
        return arrayList;
    }

    private void b(a... aVarArr) {
        synchronized (this.uy) {
            this.uy.eH();
            for (a aVar : aVarArr) {
                this.uy.k(aVar);
            }
            this.uy.notifyAll();
        }
    }

    private void d(a aVar) {
        f(aVar);
        if (aVar.aw("event_label") || !this.uC.containsKey(aVar.eB())) {
            return;
        }
        aVar.c("event_label", this.uC.get(aVar.eB()));
    }

    private String eF() {
        if (this.uz == null) {
            Context context = this.uw.get();
            if (context == null) {
                return "";
            }
            UUID eV = new com.baidu.ar.f.e(context).eV();
            this.uz = eV == null ? "" : eV.toString();
        }
        return this.uz;
    }

    private void f(a aVar) {
        aVar.c("request_id", this.uA);
    }

    private void z(long j) {
        this.uD = j;
    }

    public void B(long j) {
        z(j);
        synchronized (this.uy) {
            this.uy.flush();
        }
        eG();
    }

    public void C(long j) {
        A(j);
    }

    @Override // com.baidu.ar.statistic.k.a
    public void G(int i) {
        if (i > 0) {
            synchronized (this.uy) {
                this.uy.notifyAll();
            }
        }
    }

    public void aH() {
        if (this.uw.get() == null) {
            return;
        }
        this.uA = com.baidu.ar.f.j.aL(eF() + String.valueOf(System.currentTimeMillis()));
    }

    public void c(a aVar) {
        d(aVar);
        b(aVar);
    }

    public void e(a aVar) {
        d(aVar);
        synchronized (this.uy) {
            this.uy.eH();
            String eB = aVar.eB();
            long longValue = ((Number) aVar.au("_db_period")).longValue();
            ArrayList arrayList = new ArrayList();
            int size = this.uy.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.uy.get(i);
                if (eB.equals(aVar2.eB()) && longValue == aVar2.av("_db_period") && aVar.getTimestamp() - aVar2.getTimestamp() < longValue) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            if (!arrayList.isEmpty()) {
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    int intValue = ((Integer) arrayList.get(size2)).intValue();
                    this.uy.remove(intValue);
                    a.a(this.uy.get(intValue));
                }
            }
            this.uy.k(aVar);
            this.uy.notifyAll();
        }
    }

    public void e(List<String> list) {
        this.uF.g(list);
    }

    public void eG() {
        this.uF.eL();
    }

    public void g(a aVar) {
        String eB = aVar.eB();
        a aVar2 = this.ux.get(eB);
        boolean equals = "1".equals(aVar.au("__stt"));
        if (aVar2 == null) {
            if (equals) {
                this.ux.put(eB, aVar);
                a clone = aVar.clone();
                clone.as(eB);
                clone.ax("__stt");
                clone.ax("__falseev");
                c(clone);
            }
        } else if (equals) {
        } else {
            String at = aVar.at("__falseev");
            if (at != null && !at.isEmpty()) {
                a clone2 = aVar.clone();
                clone2.as(at);
                clone2.ax("__stt");
                clone2.ax("__falseev");
                c(clone2);
            }
            this.ux.remove(eB);
            a.a(aVar2);
        }
    }

    public void h(a aVar) {
        String eB = aVar.eB();
        ArrayList<String> az = az(eB);
        if (az.isEmpty()) {
            return;
        }
        c(aVar.clone());
        Iterator<String> it = az.iterator();
        while (it.hasNext()) {
            this.ux.put(eB + ":" + it.next(), aVar);
        }
    }

    public void i(a aVar) {
        String str;
        a aVar2;
        String eB = aVar.eB();
        String aA = aA(eB);
        if (aA == null || aA.isEmpty() || (aVar2 = this.ux.get((aA + ":" + eB))) == null) {
            return;
        }
        Pair<Long, Long> a = a(aVar2.getTimestamp(), aVar.getTimestamp());
        aVar.c("st", String.valueOf(aVar2.getTimestamp()));
        aVar.c("duration", String.valueOf(((Long) a.first).longValue()));
        aVar.c("_pausedt", String.valueOf(((Long) a.second).longValue()));
        c(aVar);
        this.ux.remove(str);
        a.a(aVar2);
    }

    public void j(a aVar) {
        boolean n;
        f(aVar);
        synchronized (this.uF) {
            n = this.uF.n(aVar);
        }
        if (n) {
            return;
        }
        a.a(aVar);
    }
}
