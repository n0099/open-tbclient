package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private int aiJ;
    private List<v> aiR;
    private List<v> aiS;
    private boolean aiT;
    private boolean aiU;
    private int aiV = 2;
    private int aiW = 1;

    public f(List<v> list, boolean z, int i) {
        this.aiJ = 2;
        this.aiR = list;
        this.aiU = z;
        this.aiJ = i;
        u(list);
    }

    public void u(List<v> list) {
        if (list != null && list.size() >= this.aiV && list.size() <= this.aiJ) {
            this.aiT = true;
        } else if (list.size() > this.aiJ && this.aiU) {
            this.aiT = true;
        } else {
            this.aiT = false;
        }
        this.aiS = xc();
    }

    private List<v> xc() {
        ArrayList arrayList = new ArrayList();
        if (this.aiR != null) {
            if (this.aiT) {
                if (this.aiR.size() > this.aiJ && this.aiR.size() >= this.aiW) {
                    arrayList.addAll(this.aiR.subList(0, this.aiJ));
                    arrayList.addAll(0, this.aiR.subList(this.aiJ - this.aiW, this.aiJ));
                    arrayList.addAll(this.aiR.subList(0, this.aiW));
                } else {
                    arrayList.addAll(this.aiR);
                    arrayList.addAll(0, this.aiR.subList(this.aiR.size() - this.aiW, this.aiR.size()));
                    arrayList.addAll(this.aiR.subList(0, this.aiW));
                }
            } else if (this.aiR != null && this.aiR.size() > 0 && this.aiR.size() >= this.aiW) {
                arrayList.addAll(this.aiR.subList(0, this.aiW));
            }
        }
        return arrayList;
    }

    public int dr(int i) {
        if (this.aiT) {
            int size = this.aiS.size();
            if (i == 0) {
                return (size - 1) - this.aiW;
            }
            if (i == size - this.aiW) {
                return this.aiW;
            }
            return i;
        }
        return i;
    }

    public int ds(int i) {
        if (this.aiT) {
            return i - this.aiW;
        }
        return i;
    }

    public int xd() {
        if (this.aiR == null) {
            return 0;
        }
        return this.aiR.size();
    }

    public int xe() {
        if (this.aiT) {
            return this.aiW;
        }
        return 0;
    }

    public void dt(int i) {
        this.aiJ = i;
        u(this.aiR);
    }

    public void du(int i) {
        this.aiV = i;
        u(this.aiR);
    }

    public List<v> xf() {
        return this.aiS;
    }

    public void dv(int i) {
        this.aiW = i;
        u(this.aiR);
    }
}
