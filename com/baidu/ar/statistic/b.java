package com.baidu.ar.statistic;

import android.content.Context;
import android.util.Pair;
import com.baidu.ar.statistic.k;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public class b implements k.a {
    public WeakReference<Context> wn;
    public d wp;
    public String wq;
    public String wr;
    public String[][] ws;
    public Map<String, String> wt;
    public k ww;
    public Map<String, a> wo = new HashMap();
    public long wu = 0;
    public long wv = 0;

    public b(Context context, d dVar, String[][] strArr, Map<String, String> map, k kVar) {
        this.wn = new WeakReference<>(context);
        this.wp = dVar;
        this.ws = strArr;
        this.wt = map == null ? new HashMap<>() : map;
        this.ww = kVar;
        kVar.a(this);
    }

    private Pair<Long, Long> a(long j, long j2) {
        long j3;
        long j4;
        long j5 = this.wu;
        if (j5 <= 0 || j > j5) {
            j3 = j2 - j;
            j4 = 0;
        } else {
            long j6 = this.wv;
            if (j6 <= 0 || j2 < j6) {
                long j7 = this.wu;
                j3 = j7 - j;
                j4 = j2 - j7;
            } else {
                j3 = (j5 - j) + (j6 - j2);
                j4 = j6 - j5;
            }
        }
        if (j3 < 0) {
            j3 = 0;
        }
        return new Pair<>(Long.valueOf(j3), Long.valueOf(j4 >= 0 ? j4 : 0L));
    }

    private ArrayList<String> aH(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[][] strArr = this.ws;
        if (strArr != null && strArr.length > 0) {
            for (String[] strArr2 : strArr) {
                if (strArr2 != null && strArr2.length >= 2 && str.equals(strArr2[0])) {
                    for (int i = 1; i < strArr2.length; i++) {
                        arrayList.add(strArr2[i]);
                    }
                }
            }
        }
        return arrayList;
    }

    private String aI(String str) {
        Object[][] objArr = this.ws;
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        for (Object[] objArr2 : objArr) {
            if (objArr2 != null && objArr2.length >= 2) {
                for (int i = 1; i < objArr2.length; i++) {
                    if (str.equals(objArr2[i])) {
                        return objArr2[0];
                    }
                }
                continue;
            }
        }
        return null;
    }

    private void b(a... aVarArr) {
        synchronized (this.wp) {
            this.wp.gl();
            for (a aVar : aVarArr) {
                this.wp.k(aVar);
            }
            this.wp.notifyAll();
        }
    }

    private void d(a aVar) {
        f(aVar);
        if (aVar.aE("event_label") || !this.wt.containsKey(aVar.gf())) {
            return;
        }
        aVar.b("event_label", this.wt.get(aVar.gf()));
    }

    private void f(a aVar) {
        aVar.b(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, this.wr);
    }

    private String gj() {
        if (this.wq == null) {
            Context context = this.wn.get();
            if (context == null) {
                return "";
            }
            UUID gz = new com.baidu.ar.h.g(context).gz();
            this.wq = gz != null ? gz.toString() : "";
        }
        return this.wq;
    }

    private void x(long j) {
        this.wu = j;
    }

    private void y(long j) {
        long j2 = this.wu;
        if (j < j2) {
            j = j2;
        }
        this.wv = j;
    }

    public void A(long j) {
        y(j);
    }

    @Override // com.baidu.ar.statistic.k.a
    public void R(int i) {
        if (i > 0) {
            synchronized (this.wp) {
                this.wp.notifyAll();
            }
        }
    }

    public void c(a aVar) {
        d(aVar);
        b(aVar);
    }

    public void e(a aVar) {
        d(aVar);
        synchronized (this.wp) {
            this.wp.gl();
            String gf = aVar.gf();
            long longValue = ((Number) aVar.aC("_db_period")).longValue();
            ArrayList arrayList = new ArrayList();
            int size = this.wp.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.wp.get(i);
                if (gf.equals(aVar2.gf()) && longValue == aVar2.aD("_db_period") && aVar.getTimestamp() - aVar2.getTimestamp() < longValue) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            if (!arrayList.isEmpty()) {
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    int intValue = ((Integer) arrayList.get(size2)).intValue();
                    this.wp.remove(intValue);
                    a.a(this.wp.get(intValue));
                }
            }
            this.wp.k(aVar);
            this.wp.notifyAll();
        }
    }

    public void g(a aVar) {
        String gf = aVar.gf();
        a aVar2 = this.wo.get(gf);
        boolean equals = "1".equals(aVar.aC("__stt"));
        if (aVar2 == null) {
            if (equals) {
                this.wo.put(gf, aVar);
                a clone = aVar.clone();
                clone.aA(gf);
                clone.aF("__stt");
                clone.aF("__falseev");
                c(clone);
            }
        } else if (equals) {
        } else {
            String aB = aVar.aB("__falseev");
            if (aB != null && !aB.isEmpty()) {
                a clone2 = aVar.clone();
                clone2.aA(aB);
                clone2.aF("__stt");
                clone2.aF("__falseev");
                c(clone2);
            }
            this.wo.remove(gf);
            a.a(aVar2);
        }
    }

    public void gk() {
        this.ww.gp();
    }

    public void h(a aVar) {
        String gf = aVar.gf();
        ArrayList<String> aH = aH(gf);
        if (aH.isEmpty()) {
            return;
        }
        c(aVar.clone());
        Iterator<String> it = aH.iterator();
        while (it.hasNext()) {
            Map<String, a> map = this.wo;
            map.put(gf + ":" + it.next(), aVar);
        }
    }

    public void h(List<String> list) {
        this.ww.j(list);
    }

    public void i(a aVar) {
        String gf = aVar.gf();
        String aI = aI(gf);
        if (aI == null || aI.isEmpty()) {
            return;
        }
        String str = aI + ":" + gf;
        a aVar2 = this.wo.get(str);
        if (aVar2 != null) {
            Pair<Long, Long> a = a(aVar2.getTimestamp(), aVar.getTimestamp());
            aVar.b("st", String.valueOf(aVar2.getTimestamp()));
            aVar.b("duration", String.valueOf(((Long) a.first).longValue()));
            aVar.b("_pausedt", String.valueOf(((Long) a.second).longValue()));
            c(aVar);
            this.wo.remove(str);
            a.a(aVar2);
        }
    }

    public void init() {
        if (this.wn.get() == null) {
            return;
        }
        this.wr = com.baidu.ar.h.l.aT(gj() + String.valueOf(System.currentTimeMillis()));
    }

    public void j(a aVar) {
        boolean n;
        f(aVar);
        synchronized (this.ww) {
            n = this.ww.n(aVar);
        }
        if (n) {
            return;
        }
        a.a(aVar);
    }

    public void z(long j) {
        x(j);
        synchronized (this.wp) {
            this.wp.flush();
        }
        gk();
    }
}
