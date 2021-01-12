package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private int fmD;
    private List<n> fmJ;
    private List<n> fmK;
    private boolean fmL;
    private boolean fmM;
    private int fmN = 2;
    private int fmO = 1;

    public c(List<n> list, boolean z, int i) {
        this.fmD = 2;
        this.fmJ = list;
        this.fmM = z;
        this.fmD = i;
        bG(list);
    }

    public void bG(List<n> list) {
        if (list != null && list.size() >= this.fmN && list.size() <= this.fmD) {
            this.fmL = true;
        } else if (list.size() > this.fmD && this.fmM) {
            this.fmL = true;
        } else {
            this.fmL = false;
        }
        this.fmK = bve();
    }

    private List<n> bve() {
        ArrayList arrayList = new ArrayList();
        if (this.fmJ != null) {
            if (this.fmL) {
                if (this.fmJ.size() > this.fmD && this.fmJ.size() >= this.fmO) {
                    arrayList.addAll(this.fmJ.subList(0, this.fmD));
                    arrayList.addAll(0, this.fmJ.subList(this.fmD - this.fmO, this.fmD));
                    arrayList.addAll(this.fmJ.subList(0, this.fmO));
                } else {
                    arrayList.addAll(this.fmJ);
                    arrayList.addAll(0, this.fmJ.subList(this.fmJ.size() - this.fmO, this.fmJ.size()));
                    arrayList.addAll(this.fmJ.subList(0, this.fmO));
                }
            } else if (this.fmJ != null && this.fmJ.size() > 0 && this.fmJ.size() >= this.fmO) {
                arrayList.addAll(this.fmJ.subList(0, this.fmO));
            }
        }
        return arrayList;
    }

    public int qa(int i) {
        if (this.fmL) {
            int size = this.fmK.size();
            if (i == 0) {
                return (size - 1) - this.fmO;
            }
            if (i == size - this.fmO) {
                return this.fmO;
            }
            return i;
        }
        return i;
    }

    public int qb(int i) {
        if (this.fmL) {
            return i - this.fmO;
        }
        return i;
    }

    public int bvf() {
        if (this.fmJ == null) {
            return 0;
        }
        return this.fmJ.size();
    }

    public int bvg() {
        if (this.fmL) {
            return this.fmO;
        }
        return 0;
    }

    public void qc(int i) {
        this.fmD = i;
        bG(this.fmJ);
    }

    public void qd(int i) {
        this.fmN = i;
        bG(this.fmJ);
    }

    public List<n> bvh() {
        return this.fmK;
    }

    public void qe(int i) {
        this.fmO = i;
        bG(this.fmJ);
    }
}
