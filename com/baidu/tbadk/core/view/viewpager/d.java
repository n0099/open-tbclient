package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<f> apD;
    private List<f> apE;
    private boolean apF;
    private boolean apG;
    private int apI;
    private int apH = 2;
    private int apJ = 1;

    public d(List<f> list, boolean z, int i) {
        this.apI = 2;
        this.apD = list;
        this.apG = z;
        this.apI = i;
        x(list);
    }

    public void x(List<f> list) {
        if (list != null && list.size() >= this.apH && list.size() <= this.apI) {
            this.apF = true;
        } else if (list.size() > this.apI && this.apG) {
            this.apF = true;
        } else {
            this.apF = false;
        }
        this.apE = wW();
    }

    private List<f> wW() {
        ArrayList arrayList = new ArrayList();
        if (this.apD != null) {
            if (this.apF) {
                if (this.apD.size() > this.apI && this.apD.size() >= this.apJ) {
                    arrayList.addAll(this.apD.subList(0, this.apI));
                    arrayList.addAll(0, this.apD.subList(this.apI - this.apJ, this.apI));
                    arrayList.addAll(this.apD.subList(0, this.apJ));
                } else {
                    arrayList.addAll(this.apD);
                    arrayList.addAll(0, this.apD.subList(this.apD.size() - this.apJ, this.apD.size()));
                    arrayList.addAll(this.apD.subList(0, this.apJ));
                }
            } else if (this.apD != null && this.apD.size() > 0 && this.apD.size() >= this.apJ) {
                arrayList.addAll(this.apD.subList(0, this.apJ));
            }
        }
        return arrayList;
    }

    public int dJ(int i) {
        if (this.apF) {
            int size = this.apE.size();
            if (i == 0) {
                return (size - 1) - this.apJ;
            }
            if (i == size - this.apJ) {
                return this.apJ;
            }
            return i;
        }
        return i;
    }

    public int dK(int i) {
        if (this.apF) {
            return i - this.apJ;
        }
        return i;
    }

    public int wX() {
        if (this.apD == null) {
            return 0;
        }
        return this.apD.size();
    }

    public int wY() {
        if (this.apF) {
            return this.apJ;
        }
        return 0;
    }

    public void dL(int i) {
        this.apI = i;
        x(this.apD);
    }

    public void dM(int i) {
        this.apH = i;
        x(this.apD);
    }

    public List<f> wZ() {
        return this.apE;
    }

    public void dN(int i) {
        this.apJ = i;
        x(this.apD);
    }
}
