package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<i> bfO;
    private List<i> bfP;
    private boolean bfQ;
    private boolean bfR;
    private int bfT;
    private int bfS = 2;
    private int bfU = 1;

    public d(List<i> list, boolean z, int i) {
        this.bfT = 2;
        this.bfO = list;
        this.bfR = z;
        this.bfT = i;
        F(list);
    }

    public void F(List<i> list) {
        if (list != null && list.size() >= this.bfS && list.size() <= this.bfT) {
            this.bfQ = true;
        } else if (list.size() > this.bfT && this.bfR) {
            this.bfQ = true;
        } else {
            this.bfQ = false;
        }
        this.bfP = EI();
    }

    private List<i> EI() {
        ArrayList arrayList = new ArrayList();
        if (this.bfO != null) {
            if (this.bfQ) {
                if (this.bfO.size() > this.bfT && this.bfO.size() >= this.bfU) {
                    arrayList.addAll(this.bfO.subList(0, this.bfT));
                    arrayList.addAll(0, this.bfO.subList(this.bfT - this.bfU, this.bfT));
                    arrayList.addAll(this.bfO.subList(0, this.bfU));
                } else {
                    arrayList.addAll(this.bfO);
                    arrayList.addAll(0, this.bfO.subList(this.bfO.size() - this.bfU, this.bfO.size()));
                    arrayList.addAll(this.bfO.subList(0, this.bfU));
                }
            } else if (this.bfO != null && this.bfO.size() > 0 && this.bfO.size() >= this.bfU) {
                arrayList.addAll(this.bfO.subList(0, this.bfU));
            }
        }
        return arrayList;
    }

    public int gG(int i) {
        if (this.bfQ) {
            int size = this.bfP.size();
            if (i == 0) {
                return (size - 1) - this.bfU;
            }
            if (i == size - this.bfU) {
                return this.bfU;
            }
            return i;
        }
        return i;
    }

    public int gH(int i) {
        if (this.bfQ) {
            return i - this.bfU;
        }
        return i;
    }

    public int EJ() {
        if (this.bfO == null) {
            return 0;
        }
        return this.bfO.size();
    }

    public int EK() {
        if (this.bfQ) {
            return this.bfU;
        }
        return 0;
    }

    public void gI(int i) {
        this.bfT = i;
        F(this.bfO);
    }

    public void gJ(int i) {
        this.bfS = i;
        F(this.bfO);
    }

    public List<i> EL() {
        return this.bfP;
    }

    public void gK(int i) {
        this.bfU = i;
        F(this.bfO);
    }
}
