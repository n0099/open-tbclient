package com.baidu.ar.statistic;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
final class k {
    private d wI;
    private ArrayList<com.baidu.ar.statistic.a> wJ;
    private int wK;
    private int wL;
    private boolean wM;
    private List<String> wN;
    private a wO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void R(int i);
    }

    public k(d dVar, int i, int i2) {
        this.wI = dVar;
        this.wK = i <= 0 ? 20 : i;
        this.wL = i2 < this.wK ? this.wK : i2;
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
        return this.wN != null && this.wN.contains(str);
    }

    public int gp() {
        int size = this.wJ.size();
        if (size > 0) {
            synchronized (this.wI) {
                this.wI.addAll(this.wJ);
            }
            this.wJ.clear();
            if (this.wO != null) {
                this.wO.R(size);
            }
        }
        return size;
    }

    public void j(List<String> list) {
        this.wN = list;
        this.wM = true;
        if (this.wJ.isEmpty()) {
            return;
        }
        if (this.wN == null || this.wN.isEmpty()) {
            this.wJ.clear();
            return;
        }
        for (int size = this.wJ.size() - 1; size >= 0; size--) {
            if (!this.wN.contains(this.wJ.get(size).gf())) {
                this.wN.remove(size);
            }
        }
        if (this.wJ.size() >= this.wK) {
            gp();
        }
    }

    public boolean n(com.baidu.ar.statistic.a aVar) {
        if (this.wM) {
            if (m(aVar)) {
                this.wJ.add(aVar);
                if (this.wJ.size() >= this.wK) {
                    gp();
                    return true;
                }
                return true;
            }
        } else if (this.wJ.size() < this.wL) {
            this.wJ.add(aVar);
            return true;
        }
        return false;
    }
}
