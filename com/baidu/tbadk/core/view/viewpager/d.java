package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<f> apG;
    private List<f> apH;
    private boolean apI;
    private boolean apJ;
    private int apL;
    private int apK = 2;
    private int apM = 1;

    public d(List<f> list, boolean z, int i) {
        this.apL = 2;
        this.apG = list;
        this.apJ = z;
        this.apL = i;
        x(list);
    }

    public void x(List<f> list) {
        if (list != null && list.size() >= this.apK && list.size() <= this.apL) {
            this.apI = true;
        } else if (list.size() > this.apL && this.apJ) {
            this.apI = true;
        } else {
            this.apI = false;
        }
        this.apH = wV();
    }

    private List<f> wV() {
        ArrayList arrayList = new ArrayList();
        if (this.apG != null) {
            if (this.apI) {
                if (this.apG.size() > this.apL && this.apG.size() >= this.apM) {
                    arrayList.addAll(this.apG.subList(0, this.apL));
                    arrayList.addAll(0, this.apG.subList(this.apL - this.apM, this.apL));
                    arrayList.addAll(this.apG.subList(0, this.apM));
                } else {
                    arrayList.addAll(this.apG);
                    arrayList.addAll(0, this.apG.subList(this.apG.size() - this.apM, this.apG.size()));
                    arrayList.addAll(this.apG.subList(0, this.apM));
                }
            } else if (this.apG != null && this.apG.size() > 0 && this.apG.size() >= this.apM) {
                arrayList.addAll(this.apG.subList(0, this.apM));
            }
        }
        return arrayList;
    }

    public int dJ(int i) {
        if (this.apI) {
            int size = this.apH.size();
            if (i == 0) {
                return (size - 1) - this.apM;
            }
            if (i == size - this.apM) {
                return this.apM;
            }
            return i;
        }
        return i;
    }

    public int dK(int i) {
        if (this.apI) {
            return i - this.apM;
        }
        return i;
    }

    public int wW() {
        if (this.apG == null) {
            return 0;
        }
        return this.apG.size();
    }

    public int wX() {
        if (this.apI) {
            return this.apM;
        }
        return 0;
    }

    public void dL(int i) {
        this.apL = i;
        x(this.apG);
    }

    public void dM(int i) {
        this.apK = i;
        x(this.apG);
    }

    public List<f> wY() {
        return this.apH;
    }

    public void dN(int i) {
        this.apM = i;
        x(this.apG);
    }
}
