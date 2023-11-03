package com.baidu.ar.statistic;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class k {
    public d wI;
    public ArrayList<com.baidu.ar.statistic.a> wJ;
    public int wK;
    public int wL;
    public boolean wM;
    public List<String> wN;
    public a wO;

    /* loaded from: classes3.dex */
    public interface a {
        void R(int i);
    }

    public k(d dVar, int i, int i2) {
        this.wI = dVar;
        i = i <= 0 ? 20 : i;
        this.wK = i;
        this.wL = i2 < i ? i : i2;
        this.wJ = new ArrayList<>(this.wK);
        this.wM = false;
        this.wN = null;
        this.wO = null;
    }

    private boolean m(com.baidu.ar.statistic.a aVar) {
        return aK(aVar.gf());
    }

    public void a(a aVar) {
        this.wO = aVar;
    }

    public boolean aJ(String str) {
        return !this.wM || aK(str);
    }

    public boolean aK(String str) {
        List<String> list = this.wN;
        return list != null && list.contains(str);
    }

    public int gp() {
        int size = this.wJ.size();
        if (size > 0) {
            synchronized (this.wI) {
                this.wI.addAll(this.wJ);
            }
            this.wJ.clear();
            a aVar = this.wO;
            if (aVar != null) {
                aVar.R(size);
            }
        }
        return size;
    }

    public void j(List<String> list) {
        ArrayList<com.baidu.ar.statistic.a> arrayList;
        this.wN = list;
        this.wM = true;
        if (this.wJ.isEmpty()) {
            return;
        }
        List<String> list2 = this.wN;
        if (list2 == null || list2.isEmpty()) {
            this.wJ.clear();
            return;
        }
        int size = this.wJ.size() - 1;
        while (true) {
            arrayList = this.wJ;
            if (size < 0) {
                break;
            }
            if (!this.wN.contains(arrayList.get(size).gf())) {
                this.wN.remove(size);
            }
            size--;
        }
        if (arrayList.size() >= this.wK) {
            gp();
        }
    }

    public boolean n(com.baidu.ar.statistic.a aVar) {
        if (!this.wM) {
            if (this.wJ.size() < this.wL) {
                this.wJ.add(aVar);
                return true;
            }
            return false;
        } else if (m(aVar)) {
            this.wJ.add(aVar);
            if (this.wJ.size() >= this.wK) {
                gp();
            }
            return true;
        } else {
            return false;
        }
    }
}
