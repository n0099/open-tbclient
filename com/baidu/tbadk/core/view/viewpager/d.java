package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<i> bfC;
    private List<i> bfD;
    private boolean bfE;
    private boolean bfF;
    private int bfH;
    private int bfG = 2;
    private int bfI = 1;

    public d(List<i> list, boolean z, int i) {
        this.bfH = 2;
        this.bfC = list;
        this.bfF = z;
        this.bfH = i;
        F(list);
    }

    public void F(List<i> list) {
        if (list != null && list.size() >= this.bfG && list.size() <= this.bfH) {
            this.bfE = true;
        } else if (list.size() > this.bfH && this.bfF) {
            this.bfE = true;
        } else {
            this.bfE = false;
        }
        this.bfD = EH();
    }

    private List<i> EH() {
        ArrayList arrayList = new ArrayList();
        if (this.bfC != null) {
            if (this.bfE) {
                if (this.bfC.size() > this.bfH && this.bfC.size() >= this.bfI) {
                    arrayList.addAll(this.bfC.subList(0, this.bfH));
                    arrayList.addAll(0, this.bfC.subList(this.bfH - this.bfI, this.bfH));
                    arrayList.addAll(this.bfC.subList(0, this.bfI));
                } else {
                    arrayList.addAll(this.bfC);
                    arrayList.addAll(0, this.bfC.subList(this.bfC.size() - this.bfI, this.bfC.size()));
                    arrayList.addAll(this.bfC.subList(0, this.bfI));
                }
            } else if (this.bfC != null && this.bfC.size() > 0 && this.bfC.size() >= this.bfI) {
                arrayList.addAll(this.bfC.subList(0, this.bfI));
            }
        }
        return arrayList;
    }

    public int gG(int i) {
        if (this.bfE) {
            int size = this.bfD.size();
            if (i == 0) {
                return (size - 1) - this.bfI;
            }
            if (i == size - this.bfI) {
                return this.bfI;
            }
            return i;
        }
        return i;
    }

    public int gH(int i) {
        if (this.bfE) {
            return i - this.bfI;
        }
        return i;
    }

    public int EI() {
        if (this.bfC == null) {
            return 0;
        }
        return this.bfC.size();
    }

    public int EJ() {
        if (this.bfE) {
            return this.bfI;
        }
        return 0;
    }

    public void gI(int i) {
        this.bfH = i;
        F(this.bfC);
    }

    public void gJ(int i) {
        this.bfG = i;
        F(this.bfC);
    }

    public List<i> EK() {
        return this.bfD;
    }

    public void gK(int i) {
        this.bfI = i;
        F(this.bfC);
    }
}
