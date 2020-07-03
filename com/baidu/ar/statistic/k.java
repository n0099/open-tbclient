package com.baidu.ar.statistic;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
final class k {
    private d vr;
    private ArrayList<com.baidu.ar.statistic.a> vs;
    private int vt;
    private int vu;
    private boolean vv;
    private List<String> vw;
    private a vx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void M(int i);
    }

    public k(d dVar, int i, int i2) {
        this.vr = dVar;
        this.vt = i <= 0 ? 20 : i;
        this.vu = i2 < this.vt ? this.vt : i2;
        this.vs = new ArrayList<>(this.vt);
        this.vv = false;
        this.vw = null;
        this.vx = null;
    }

    private boolean m(com.baidu.ar.statistic.a aVar) {
        return aD(aVar.eR());
    }

    public void a(a aVar) {
        this.vx = aVar;
    }

    public boolean aC(String str) {
        return !this.vv || aD(str);
    }

    public boolean aD(String str) {
        return this.vw != null && this.vw.contains(str);
    }

    public int fb() {
        int size = this.vs.size();
        if (size > 0) {
            synchronized (this.vr) {
                this.vr.addAll(this.vs);
            }
            this.vs.clear();
            if (this.vx != null) {
                this.vx.M(size);
            }
        }
        return size;
    }

    public void i(List<String> list) {
        this.vw = list;
        this.vv = true;
        if (this.vs.isEmpty()) {
            return;
        }
        if (this.vw == null || this.vw.isEmpty()) {
            this.vs.clear();
            return;
        }
        for (int size = this.vs.size() - 1; size >= 0; size--) {
            if (!this.vw.contains(this.vs.get(size).eR())) {
                this.vw.remove(size);
            }
        }
        if (this.vs.size() >= this.vt) {
            fb();
        }
    }

    public boolean n(com.baidu.ar.statistic.a aVar) {
        if (this.vv) {
            if (m(aVar)) {
                this.vs.add(aVar);
                if (this.vs.size() >= this.vt) {
                    fb();
                    return true;
                }
                return true;
            }
        } else if (this.vs.size() < this.vu) {
            this.vs.add(aVar);
            return true;
        }
        return false;
    }
}
