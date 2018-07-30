package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<h> aAc;
    private List<h> aAd;
    private boolean aAe;
    private boolean aAf;
    private int aAg = 2;
    private int aAh = 1;
    private int azV;

    public d(List<h> list, boolean z, int i) {
        this.azV = 2;
        this.aAc = list;
        this.aAf = z;
        this.azV = i;
        A(list);
    }

    public void A(List<h> list) {
        if (list != null && list.size() >= this.aAg && list.size() <= this.azV) {
            this.aAe = true;
        } else if (list.size() > this.azV && this.aAf) {
            this.aAe = true;
        } else {
            this.aAe = false;
        }
        this.aAd = Be();
    }

    private List<h> Be() {
        ArrayList arrayList = new ArrayList();
        if (this.aAc != null) {
            if (this.aAe) {
                if (this.aAc.size() > this.azV && this.aAc.size() >= this.aAh) {
                    arrayList.addAll(this.aAc.subList(0, this.azV));
                    arrayList.addAll(0, this.aAc.subList(this.azV - this.aAh, this.azV));
                    arrayList.addAll(this.aAc.subList(0, this.aAh));
                } else {
                    arrayList.addAll(this.aAc);
                    arrayList.addAll(0, this.aAc.subList(this.aAc.size() - this.aAh, this.aAc.size()));
                    arrayList.addAll(this.aAc.subList(0, this.aAh));
                }
            } else if (this.aAc != null && this.aAc.size() > 0 && this.aAc.size() >= this.aAh) {
                arrayList.addAll(this.aAc.subList(0, this.aAh));
            }
        }
        return arrayList;
    }

    public int dL(int i) {
        if (this.aAe) {
            int size = this.aAd.size();
            if (i == 0) {
                return (size - 1) - this.aAh;
            }
            if (i == size - this.aAh) {
                return this.aAh;
            }
            return i;
        }
        return i;
    }

    public int dM(int i) {
        if (this.aAe) {
            return i - this.aAh;
        }
        return i;
    }

    public int Bf() {
        if (this.aAc == null) {
            return 0;
        }
        return this.aAc.size();
    }

    public int Bg() {
        if (this.aAe) {
            return this.aAh;
        }
        return 0;
    }

    public void dN(int i) {
        this.azV = i;
        A(this.aAc);
    }

    public void dO(int i) {
        this.aAg = i;
        A(this.aAc);
    }

    public List<h> Bh() {
        return this.aAd;
    }

    public void dP(int i) {
        this.aAh = i;
        A(this.aAc);
    }
}
