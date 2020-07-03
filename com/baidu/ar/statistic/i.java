package com.baidu.ar.statistic;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
class i {
    protected d uY;
    protected int vo;
    protected boolean vp;
    protected e vq;

    public i(d dVar, int i, e eVar, boolean z) {
        if (dVar == null || eVar == null) {
            throw new NullPointerException();
        }
        this.uY = dVar;
        this.vq = eVar;
        this.vo = i <= 0 ? 10 : i;
        this.vp = z;
    }

    private boolean l(a aVar) {
        Object av = aVar.av("_db_period");
        if (av == null || !(av instanceof Number)) {
            return false;
        }
        return System.currentTimeMillis() - aVar.getTimestamp() < ((Number) av).longValue();
    }

    public void a(Context context, List<a> list) {
        if (list.size() == 0) {
            return;
        }
        if (list.size() == 1) {
            this.vq.a(context, list.get(0));
        } else {
            this.vq.a(context, list);
        }
    }

    public List<List<a>> eZ() {
        ArrayList arrayList;
        synchronized (this.uY) {
            ArrayList arrayList2 = new ArrayList();
            if (this.uY.isEmpty()) {
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList();
            HashMap hashMap = new HashMap();
            int size = this.uY.size();
            ArrayList arrayList4 = new ArrayList();
            int i = 0;
            while (i < size) {
                a aVar = this.uY.get(i);
                String eS = aVar.eS();
                if (hashMap.containsKey(eS)) {
                    arrayList = arrayList3;
                } else if (l(aVar)) {
                    arrayList4.add(Integer.valueOf(i));
                    arrayList = arrayList3;
                } else {
                    hashMap.put(eS, 1);
                    arrayList3.add(aVar);
                    if (arrayList3.size() == this.vo) {
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
                    arrayList5.add(this.uY.remove(((Integer) arrayList4.get(size2)).intValue()));
                }
                for (int size3 = arrayList5.size() - 1; size3 >= 0; size3--) {
                    this.uY.k((a) arrayList5.get(size3));
                }
            }
            return arrayList2;
        }
    }

    public boolean fa() {
        return !this.uY.isEmpty();
    }

    public void save() {
        if (this.vp) {
            synchronized (this.uY) {
                this.uY.flush();
            }
        }
    }

    public void update(int i) {
        synchronized (this.uY) {
            this.uY.N(i);
        }
    }
}
