package com.baidu.ar.statistic;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
final class k {
    private d vU;
    private ArrayList<com.baidu.ar.statistic.a> vV;
    private int vW;
    private int vX;
    private boolean vY;
    private List<String> vZ;
    private a wa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public interface a {
        void O(int i);
    }

    public k(d dVar, int i, int i2) {
        this.vU = dVar;
        this.vW = i <= 0 ? 20 : i;
        this.vX = i2 < this.vW ? this.vW : i2;
        this.vV = new ArrayList<>(this.vW);
        this.vY = false;
        this.vZ = null;
        this.wa = null;
    }

    private boolean m(com.baidu.ar.statistic.a aVar) {
        return aH(aVar.gf());
    }

    public void a(a aVar) {
        this.wa = aVar;
    }

    public boolean aG(String str) {
        return !this.vY || aH(str);
    }

    public boolean aH(String str) {
        return this.vZ != null && this.vZ.contains(str);
    }

    public int gp() {
        int size = this.vV.size();
        if (size > 0) {
            synchronized (this.vU) {
                this.vU.addAll(this.vV);
            }
            this.vV.clear();
            if (this.wa != null) {
                this.wa.O(size);
            }
        }
        return size;
    }

    public void j(List<String> list) {
        this.vZ = list;
        this.vY = true;
        if (this.vV.isEmpty()) {
            return;
        }
        if (this.vZ == null || this.vZ.isEmpty()) {
            this.vV.clear();
            return;
        }
        for (int size = this.vV.size() - 1; size >= 0; size--) {
            if (!this.vZ.contains(this.vV.get(size).gf())) {
                this.vZ.remove(size);
            }
        }
        if (this.vV.size() >= this.vW) {
            gp();
        }
    }

    public boolean n(com.baidu.ar.statistic.a aVar) {
        if (this.vY) {
            if (m(aVar)) {
                this.vV.add(aVar);
                if (this.vV.size() >= this.vW) {
                    gp();
                    return true;
                }
                return true;
            }
        } else if (this.vV.size() < this.vX) {
            this.vV.add(aVar);
            return true;
        }
        return false;
    }
}
