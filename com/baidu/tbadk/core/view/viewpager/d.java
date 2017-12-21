package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<f> apJ;
    private List<f> apK;
    private boolean apL;
    private boolean apM;
    private int apO;
    private int apN = 2;
    private int apP = 1;

    public d(List<f> list, boolean z, int i) {
        this.apO = 2;
        this.apJ = list;
        this.apM = z;
        this.apO = i;
        x(list);
    }

    public void x(List<f> list) {
        if (list != null && list.size() >= this.apN && list.size() <= this.apO) {
            this.apL = true;
        } else if (list.size() > this.apO && this.apM) {
            this.apL = true;
        } else {
            this.apL = false;
        }
        this.apK = wV();
    }

    private List<f> wV() {
        ArrayList arrayList = new ArrayList();
        if (this.apJ != null) {
            if (this.apL) {
                if (this.apJ.size() > this.apO && this.apJ.size() >= this.apP) {
                    arrayList.addAll(this.apJ.subList(0, this.apO));
                    arrayList.addAll(0, this.apJ.subList(this.apO - this.apP, this.apO));
                    arrayList.addAll(this.apJ.subList(0, this.apP));
                } else {
                    arrayList.addAll(this.apJ);
                    arrayList.addAll(0, this.apJ.subList(this.apJ.size() - this.apP, this.apJ.size()));
                    arrayList.addAll(this.apJ.subList(0, this.apP));
                }
            } else if (this.apJ != null && this.apJ.size() > 0 && this.apJ.size() >= this.apP) {
                arrayList.addAll(this.apJ.subList(0, this.apP));
            }
        }
        return arrayList;
    }

    public int dJ(int i) {
        if (this.apL) {
            int size = this.apK.size();
            if (i == 0) {
                return (size - 1) - this.apP;
            }
            if (i == size - this.apP) {
                return this.apP;
            }
            return i;
        }
        return i;
    }

    public int dK(int i) {
        if (this.apL) {
            return i - this.apP;
        }
        return i;
    }

    public int wW() {
        if (this.apJ == null) {
            return 0;
        }
        return this.apJ.size();
    }

    public int wX() {
        if (this.apL) {
            return this.apP;
        }
        return 0;
    }

    public void dL(int i) {
        this.apO = i;
        x(this.apJ);
    }

    public void dM(int i) {
        this.apN = i;
        x(this.apJ);
    }

    public List<f> wY() {
        return this.apK;
    }

    public void dN(int i) {
        this.apP = i;
        x(this.apJ);
    }
}
