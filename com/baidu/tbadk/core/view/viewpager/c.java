package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private int foV;
    private List<n> fpb;
    private List<n> fpc;
    private boolean fpd;
    private boolean fpe;
    private int fpf = 2;
    private int fpg = 1;

    public c(List<n> list, boolean z, int i) {
        this.foV = 2;
        this.fpb = list;
        this.fpe = z;
        this.foV = i;
        bB(list);
    }

    public void bB(List<n> list) {
        if (list != null && list.size() >= this.fpf && list.size() <= this.foV) {
            this.fpd = true;
        } else if (list.size() > this.foV && this.fpe) {
            this.fpd = true;
        } else {
            this.fpd = false;
        }
        this.fpc = bvy();
    }

    private List<n> bvy() {
        ArrayList arrayList = new ArrayList();
        if (this.fpb != null) {
            if (this.fpd) {
                if (this.fpb.size() > this.foV && this.fpb.size() >= this.fpg) {
                    arrayList.addAll(this.fpb.subList(0, this.foV));
                    arrayList.addAll(0, this.fpb.subList(this.foV - this.fpg, this.foV));
                    arrayList.addAll(this.fpb.subList(0, this.fpg));
                } else {
                    arrayList.addAll(this.fpb);
                    arrayList.addAll(0, this.fpb.subList(this.fpb.size() - this.fpg, this.fpb.size()));
                    arrayList.addAll(this.fpb.subList(0, this.fpg));
                }
            } else if (this.fpb != null && this.fpb.size() > 0 && this.fpb.size() >= this.fpg) {
                arrayList.addAll(this.fpb.subList(0, this.fpg));
            }
        }
        return arrayList;
    }

    public int qf(int i) {
        if (this.fpd) {
            int size = this.fpc.size();
            if (i == 0) {
                return (size - 1) - this.fpg;
            }
            if (i == size - this.fpg) {
                return this.fpg;
            }
            return i;
        }
        return i;
    }

    public int qg(int i) {
        if (this.fpd) {
            return i - this.fpg;
        }
        return i;
    }

    public int bvz() {
        if (this.fpb == null) {
            return 0;
        }
        return this.fpb.size();
    }

    public int bvA() {
        if (this.fpd) {
            return this.fpg;
        }
        return 0;
    }

    public void qh(int i) {
        this.foV = i;
        bB(this.fpb);
    }

    public void qi(int i) {
        this.fpf = i;
        bB(this.fpb);
    }

    public List<n> bvB() {
        return this.fpc;
    }

    public void qj(int i) {
        this.fpg = i;
        bB(this.fpb);
    }
}
