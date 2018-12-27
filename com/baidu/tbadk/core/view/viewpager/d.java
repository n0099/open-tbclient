package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int aLU;
    private List<h> aMb;
    private List<h> aMc;
    private boolean aMd;
    private boolean aMe;
    private int aMf = 2;
    private int aMg = 1;

    public d(List<h> list, boolean z, int i) {
        this.aLU = 2;
        this.aMb = list;
        this.aMe = z;
        this.aLU = i;
        K(list);
    }

    public void K(List<h> list) {
        if (list != null && list.size() >= this.aMf && list.size() <= this.aLU) {
            this.aMd = true;
        } else if (list.size() > this.aLU && this.aMe) {
            this.aMd = true;
        } else {
            this.aMd = false;
        }
        this.aMc = FH();
    }

    private List<h> FH() {
        ArrayList arrayList = new ArrayList();
        if (this.aMb != null) {
            if (this.aMd) {
                if (this.aMb.size() > this.aLU && this.aMb.size() >= this.aMg) {
                    arrayList.addAll(this.aMb.subList(0, this.aLU));
                    arrayList.addAll(0, this.aMb.subList(this.aLU - this.aMg, this.aLU));
                    arrayList.addAll(this.aMb.subList(0, this.aMg));
                } else {
                    arrayList.addAll(this.aMb);
                    arrayList.addAll(0, this.aMb.subList(this.aMb.size() - this.aMg, this.aMb.size()));
                    arrayList.addAll(this.aMb.subList(0, this.aMg));
                }
            } else if (this.aMb != null && this.aMb.size() > 0 && this.aMb.size() >= this.aMg) {
                arrayList.addAll(this.aMb.subList(0, this.aMg));
            }
        }
        return arrayList;
    }

    public int eJ(int i) {
        if (this.aMd) {
            int size = this.aMc.size();
            if (i == 0) {
                return (size - 1) - this.aMg;
            }
            if (i == size - this.aMg) {
                return this.aMg;
            }
            return i;
        }
        return i;
    }

    public int eK(int i) {
        if (this.aMd) {
            return i - this.aMg;
        }
        return i;
    }

    public int FI() {
        if (this.aMb == null) {
            return 0;
        }
        return this.aMb.size();
    }

    public int FJ() {
        if (this.aMd) {
            return this.aMg;
        }
        return 0;
    }

    public void eL(int i) {
        this.aLU = i;
        K(this.aMb);
    }

    public void eM(int i) {
        this.aMf = i;
        K(this.aMb);
    }

    public List<h> FK() {
        return this.aMc;
    }

    public void eN(int i) {
        this.aMg = i;
        K(this.aMb);
    }
}
