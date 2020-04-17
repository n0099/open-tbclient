package com.baidu.ar.statistic;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
class i {
    protected int uO;
    protected boolean uP;
    protected e uQ;
    protected d uy;

    public i(d dVar, int i, e eVar, boolean z) {
        if (dVar == null || eVar == null) {
            throw new NullPointerException();
        }
        this.uy = dVar;
        this.uQ = eVar;
        this.uO = i <= 0 ? 10 : i;
        this.uP = z;
    }

    private boolean l(a aVar) {
        Object au = aVar.au("_db_period");
        if (au == null || !(au instanceof Number)) {
            return false;
        }
        return System.currentTimeMillis() - aVar.getTimestamp() < ((Number) au).longValue();
    }

    public void a(Context context, List<a> list) {
        if (list.size() == 0) {
            return;
        }
        if (list.size() == 1) {
            this.uQ.a(context, list.get(0));
        } else {
            this.uQ.a(context, list);
        }
    }

    public List<List<a>> eJ() {
        ArrayList arrayList;
        synchronized (this.uy) {
            ArrayList arrayList2 = new ArrayList();
            if (this.uy.isEmpty()) {
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList();
            HashMap hashMap = new HashMap();
            int size = this.uy.size();
            ArrayList arrayList4 = new ArrayList();
            int i = 0;
            while (i < size) {
                a aVar = this.uy.get(i);
                String eC = aVar.eC();
                if (hashMap.containsKey(eC)) {
                    arrayList = arrayList3;
                } else if (l(aVar)) {
                    arrayList4.add(Integer.valueOf(i));
                    arrayList = arrayList3;
                } else {
                    hashMap.put(eC, 1);
                    arrayList3.add(aVar);
                    if (arrayList3.size() == this.uO) {
                        arrayList2.add(arrayList3);
                        arrayList = new ArrayList();
                    } else {
                        arrayList = arrayList3;
                    }
                }
                i++;
                arrayList3 = arrayList;
            }
            if (!arrayList3.isEmpty()) {
                arrayList2.add(arrayList3);
            }
            if (!arrayList4.isEmpty()) {
                ArrayList arrayList5 = new ArrayList(arrayList4.size());
                for (int size2 = arrayList4.size() - 1; size2 >= 0; size2--) {
                    arrayList5.add(this.uy.remove(((Integer) arrayList4.get(size2)).intValue()));
                }
                for (int size3 = arrayList5.size() - 1; size3 >= 0; size3--) {
                    this.uy.k((a) arrayList5.get(size3));
                }
            }
            return arrayList2;
        }
    }

    public boolean eK() {
        return !this.uy.isEmpty();
    }

    public void save() {
        if (this.uP) {
            synchronized (this.uy) {
                this.uy.flush();
            }
        }
    }

    public void update(int i) {
        synchronized (this.uy) {
            this.uy.H(i);
        }
    }
}
