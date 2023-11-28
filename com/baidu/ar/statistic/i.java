package com.baidu.ar.statistic;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    public int wF;
    public boolean wG;
    public e wH;
    public d wp;

    public i(d dVar, int i, e eVar, boolean z) {
        if (dVar == null || eVar == null) {
            throw null;
        }
        this.wp = dVar;
        this.wH = eVar;
        this.wF = i <= 0 ? 10 : i;
        this.wG = z;
    }

    private boolean l(a aVar) {
        Object aC = aVar.aC("_db_period");
        if (aC != null && (aC instanceof Number)) {
            if (System.currentTimeMillis() - aVar.getTimestamp() < ((Number) aC).longValue()) {
                return true;
            }
        }
        return false;
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
        synchronized (this.wp) {
            ArrayList arrayList = new ArrayList();
            if (this.wp.isEmpty()) {
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap = new HashMap();
            int size = this.wp.size();
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < size; i++) {
                a aVar = this.wp.get(i);
                String gg = aVar.gg();
                if (!hashMap.containsKey(gg)) {
                    if (l(aVar)) {
                        arrayList3.add(Integer.valueOf(i));
                    } else {
                        hashMap.put(gg, 1);
                        arrayList2.add(aVar);
                        if (arrayList2.size() == this.wF) {
                            arrayList.add(arrayList2);
                            arrayList2 = new ArrayList();
                        }
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(arrayList2);
            }
            if (!arrayList3.isEmpty()) {
                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                    arrayList4.add(this.wp.remove(((Integer) arrayList3.get(size2)).intValue()));
                }
                for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
                    this.wp.k((a) arrayList4.get(size3));
                }
            }
            return arrayList;
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
