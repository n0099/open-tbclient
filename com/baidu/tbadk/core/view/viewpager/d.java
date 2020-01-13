package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<m> dgA;
    private boolean dgB;
    private boolean dgC;
    private int dgD = 2;
    private int dgE = 1;
    private int dgt;
    private List<m> dgz;

    public d(List<m> list, boolean z, int i) {
        this.dgt = 2;
        this.dgz = list;
        this.dgC = z;
        this.dgt = i;
        aD(list);
    }

    public void aD(List<m> list) {
        if (list != null && list.size() >= this.dgD && list.size() <= this.dgt) {
            this.dgB = true;
        } else if (list.size() > this.dgt && this.dgC) {
            this.dgB = true;
        } else {
            this.dgB = false;
        }
        this.dgA = aGl();
    }

    private List<m> aGl() {
        ArrayList arrayList = new ArrayList();
        if (this.dgz != null) {
            if (this.dgB) {
                if (this.dgz.size() > this.dgt && this.dgz.size() >= this.dgE) {
                    arrayList.addAll(this.dgz.subList(0, this.dgt));
                    arrayList.addAll(0, this.dgz.subList(this.dgt - this.dgE, this.dgt));
                    arrayList.addAll(this.dgz.subList(0, this.dgE));
                } else {
                    arrayList.addAll(this.dgz);
                    arrayList.addAll(0, this.dgz.subList(this.dgz.size() - this.dgE, this.dgz.size()));
                    arrayList.addAll(this.dgz.subList(0, this.dgE));
                }
            } else if (this.dgz != null && this.dgz.size() > 0 && this.dgz.size() >= this.dgE) {
                arrayList.addAll(this.dgz.subList(0, this.dgE));
            }
        }
        return arrayList;
    }

    public int lk(int i) {
        if (this.dgB) {
            int size = this.dgA.size();
            if (i == 0) {
                return (size - 1) - this.dgE;
            }
            if (i == size - this.dgE) {
                return this.dgE;
            }
            return i;
        }
        return i;
    }

    public int ll(int i) {
        if (this.dgB) {
            return i - this.dgE;
        }
        return i;
    }

    public int aGm() {
        if (this.dgz == null) {
            return 0;
        }
        return this.dgz.size();
    }

    public int aGn() {
        if (this.dgB) {
            return this.dgE;
        }
        return 0;
    }

    public void lm(int i) {
        this.dgt = i;
        aD(this.dgz);
    }

    public void ln(int i) {
        this.dgD = i;
        aD(this.dgz);
    }

    public List<m> aGo() {
        return this.dgA;
    }

    public void lo(int i) {
        this.dgE = i;
        aD(this.dgz);
    }
}
