package com.baidu.ar.statistic;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
class i {
    protected int wF;
    protected boolean wG;
    protected e wH;
    protected d wp;

    public i(d dVar, int i, e eVar, boolean z) {
        if (dVar == null || eVar == null) {
            throw new NullPointerException();
        }
        this.wp = dVar;
        this.wH = eVar;
        this.wF = i <= 0 ? 10 : i;
        this.wG = z;
    }

    private boolean l(a aVar) {
        Object aC = aVar.aC("_db_period");
        if (aC == null || !(aC instanceof Number)) {
            return false;
        }
        return System.currentTimeMillis() - aVar.getTimestamp() < ((Number) aC).longValue();
    }

    public void a(Context context, List<a> list) {
        if (list.size() == 0) {
            return;
        }
        if (list.size() == 1) {
            this.wH.a(context, list.get(0));
        } else {
            this.wH.a(context, list);
        }
    }

    public List<List<a>> gn() {
        ArrayList arrayList;
        synchronized (this.wp) {
            ArrayList arrayList2 = new ArrayList();
            if (this.wp.isEmpty()) {
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList();
            HashMap hashMap = new HashMap();
            int size = this.wp.size();
            ArrayList arrayList4 = new ArrayList();
            int i = 0;
            while (i < size) {
                a aVar = this.wp.get(i);
                String gg = aVar.gg();
                if (hashMap.containsKey(gg)) {
                    arrayList = arrayList3;
                } else if (l(aVar)) {
                    arrayList4.add(Integer.valueOf(i));
                    arrayList = arrayList3;
                } else {
                    hashMap.put(gg, 1);
                    arrayList3.add(aVar);
                    if (arrayList3.size() == this.wF) {
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
                    arrayList5.add(this.wp.remove(((Integer) arrayList4.get(size2)).intValue()));
                }
                for (int size3 = arrayList5.size() - 1; size3 >= 0; size3--) {
                    this.wp.k((a) arrayList5.get(size3));
                }
            }
            return arrayList2;
        }
    }

    public boolean go() {
        return !this.wp.isEmpty();
    }

    public void save() {
        if (this.wG) {
            synchronized (this.wp) {
                this.wp.flush();
            }
        }
    }

    public void update(int i) {
        synchronized (this.wp) {
            this.wp.S(i);
        }
    }
}
