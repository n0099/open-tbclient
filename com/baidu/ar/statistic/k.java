package com.baidu.ar.statistic;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
final class k {
    private d uR;
    private ArrayList<com.baidu.ar.statistic.a> uS;
    private int uT;
    private int uU;
    private boolean uV;
    private List<String> uW;
    private a uX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void G(int i);
    }

    public k(d dVar, int i, int i2) {
        this.uR = dVar;
        this.uT = i <= 0 ? 20 : i;
        this.uU = i2 < this.uT ? this.uT : i2;
        this.uS = new ArrayList<>(this.uT);
        this.uV = false;
        this.uW = null;
        this.uX = null;
    }

    private boolean m(com.baidu.ar.statistic.a aVar) {
        return aC(aVar.eB());
    }

    public void a(a aVar) {
        this.uX = aVar;
    }

    public boolean aB(String str) {
        return !this.uV || aC(str);
    }

    public boolean aC(String str) {
        return this.uW != null && this.uW.contains(str);
    }

    public int eL() {
        int size = this.uS.size();
        if (size > 0) {
            synchronized (this.uR) {
                this.uR.addAll(this.uS);
            }
            this.uS.clear();
            if (this.uX != null) {
                this.uX.G(size);
            }
        }
        return size;
    }

    public void g(List<String> list) {
        this.uW = list;
        this.uV = true;
        if (this.uS.isEmpty()) {
            return;
        }
        if (this.uW == null || this.uW.isEmpty()) {
            this.uS.clear();
            return;
        }
        for (int size = this.uS.size() - 1; size >= 0; size--) {
            if (!this.uW.contains(this.uS.get(size).eB())) {
                this.uW.remove(size);
            }
        }
        if (this.uS.size() >= this.uT) {
            eL();
        }
    }

    public boolean n(com.baidu.ar.statistic.a aVar) {
        if (this.uV) {
            if (m(aVar)) {
                this.uS.add(aVar);
                if (this.uS.size() >= this.uT) {
                    eL();
                    return true;
                }
                return true;
            }
        } else if (this.uS.size() < this.uU) {
            this.uS.add(aVar);
            return true;
        }
        return false;
    }
}
