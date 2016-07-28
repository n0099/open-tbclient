package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private List<v> afB;
    private List<v> afC;
    private boolean afD;
    private boolean afE;
    private int afG;
    private int afF = 2;
    private int afH = 1;

    public c(List<v> list, boolean z, int i) {
        this.afG = 2;
        this.afB = list;
        this.afE = z;
        this.afG = i;
        u(list);
    }

    public void u(List<v> list) {
        if (list != null && list.size() >= this.afF && list.size() <= this.afG) {
            this.afD = true;
        } else if (list.size() > this.afG && this.afE) {
            this.afD = true;
        } else {
            this.afD = false;
        }
        this.afC = vR();
    }

    private List<v> vR() {
        ArrayList arrayList = new ArrayList();
        if (this.afB != null) {
            if (this.afD) {
                if (this.afB.size() > this.afG && this.afB.size() >= this.afH) {
                    arrayList.addAll(this.afB.subList(0, this.afG));
                    arrayList.addAll(0, this.afB.subList(this.afG - this.afH, this.afG));
                    arrayList.addAll(this.afB.subList(0, this.afH));
                } else {
                    arrayList.addAll(this.afB);
                    arrayList.addAll(0, this.afB.subList(this.afB.size() - this.afH, this.afB.size()));
                    arrayList.addAll(this.afB.subList(0, this.afH));
                }
            } else if (this.afB != null && this.afB.size() > 0 && this.afB.size() >= this.afH) {
                arrayList.addAll(this.afB.subList(0, this.afH));
            }
        }
        return arrayList;
    }

    public int db(int i) {
        if (this.afD) {
            int size = this.afC.size();
            if (i == 0) {
                return (size - 1) - this.afH;
            }
            if (i == size - this.afH) {
                return this.afH;
            }
            return i;
        }
        return i;
    }

    public int dc(int i) {
        if (this.afD) {
            return i - this.afH;
        }
        return i;
    }

    public int vS() {
        if (this.afB == null) {
            return 0;
        }
        return this.afB.size();
    }

    public int vT() {
        if (this.afD) {
            return this.afH;
        }
        return 0;
    }

    public void dd(int i) {
        this.afG = i;
        u(this.afB);
    }

    public void de(int i) {
        this.afF = i;
        u(this.afB);
    }

    public List<v> vU() {
        return this.afC;
    }

    public void df(int i) {
        this.afH = i;
        u(this.afB);
    }
}
