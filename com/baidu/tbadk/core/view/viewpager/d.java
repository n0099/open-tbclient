package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int dgh;
    private List<m> dgn;
    private List<m> dgo;
    private boolean dgp;
    private boolean dgq;
    private int dgr = 2;
    private int dgs = 1;

    public d(List<m> list, boolean z, int i) {
        this.dgh = 2;
        this.dgn = list;
        this.dgq = z;
        this.dgh = i;
        aE(list);
    }

    public void aE(List<m> list) {
        if (list != null && list.size() >= this.dgr && list.size() <= this.dgh) {
            this.dgp = true;
        } else if (list.size() > this.dgh && this.dgq) {
            this.dgp = true;
        } else {
            this.dgp = false;
        }
        this.dgo = aFS();
    }

    private List<m> aFS() {
        ArrayList arrayList = new ArrayList();
        if (this.dgn != null) {
            if (this.dgp) {
                if (this.dgn.size() > this.dgh && this.dgn.size() >= this.dgs) {
                    arrayList.addAll(this.dgn.subList(0, this.dgh));
                    arrayList.addAll(0, this.dgn.subList(this.dgh - this.dgs, this.dgh));
                    arrayList.addAll(this.dgn.subList(0, this.dgs));
                } else {
                    arrayList.addAll(this.dgn);
                    arrayList.addAll(0, this.dgn.subList(this.dgn.size() - this.dgs, this.dgn.size()));
                    arrayList.addAll(this.dgn.subList(0, this.dgs));
                }
            } else if (this.dgn != null && this.dgn.size() > 0 && this.dgn.size() >= this.dgs) {
                arrayList.addAll(this.dgn.subList(0, this.dgs));
            }
        }
        return arrayList;
    }

    public int lk(int i) {
        if (this.dgp) {
            int size = this.dgo.size();
            if (i == 0) {
                return (size - 1) - this.dgs;
            }
            if (i == size - this.dgs) {
                return this.dgs;
            }
            return i;
        }
        return i;
    }

    public int ll(int i) {
        if (this.dgp) {
            return i - this.dgs;
        }
        return i;
    }

    public int aFT() {
        if (this.dgn == null) {
            return 0;
        }
        return this.dgn.size();
    }

    public int aFU() {
        if (this.dgp) {
            return this.dgs;
        }
        return 0;
    }

    public void lm(int i) {
        this.dgh = i;
        aE(this.dgn);
    }

    public void ln(int i) {
        this.dgr = i;
        aE(this.dgn);
    }

    public List<m> aFV() {
        return this.dgo;
    }

    public void lo(int i) {
        this.dgs = i;
        aE(this.dgn);
    }
}
