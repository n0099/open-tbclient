package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<h> aMD;
    private List<h> aME;
    private boolean aMF;
    private boolean aMG;
    private int aMH = 2;
    private int aMI = 1;
    private int aMw;

    public d(List<h> list, boolean z, int i) {
        this.aMw = 2;
        this.aMD = list;
        this.aMG = z;
        this.aMw = i;
        L(list);
    }

    public void L(List<h> list) {
        if (list != null && list.size() >= this.aMH && list.size() <= this.aMw) {
            this.aMF = true;
        } else if (list.size() > this.aMw && this.aMG) {
            this.aMF = true;
        } else {
            this.aMF = false;
        }
        this.aME = FU();
    }

    private List<h> FU() {
        ArrayList arrayList = new ArrayList();
        if (this.aMD != null) {
            if (this.aMF) {
                if (this.aMD.size() > this.aMw && this.aMD.size() >= this.aMI) {
                    arrayList.addAll(this.aMD.subList(0, this.aMw));
                    arrayList.addAll(0, this.aMD.subList(this.aMw - this.aMI, this.aMw));
                    arrayList.addAll(this.aMD.subList(0, this.aMI));
                } else {
                    arrayList.addAll(this.aMD);
                    arrayList.addAll(0, this.aMD.subList(this.aMD.size() - this.aMI, this.aMD.size()));
                    arrayList.addAll(this.aMD.subList(0, this.aMI));
                }
            } else if (this.aMD != null && this.aMD.size() > 0 && this.aMD.size() >= this.aMI) {
                arrayList.addAll(this.aMD.subList(0, this.aMI));
            }
        }
        return arrayList;
    }

    public int eJ(int i) {
        if (this.aMF) {
            int size = this.aME.size();
            if (i == 0) {
                return (size - 1) - this.aMI;
            }
            if (i == size - this.aMI) {
                return this.aMI;
            }
            return i;
        }
        return i;
    }

    public int eK(int i) {
        if (this.aMF) {
            return i - this.aMI;
        }
        return i;
    }

    public int FV() {
        if (this.aMD == null) {
            return 0;
        }
        return this.aMD.size();
    }

    public int FW() {
        if (this.aMF) {
            return this.aMI;
        }
        return 0;
    }

    public void eL(int i) {
        this.aMw = i;
        L(this.aMD);
    }

    public void eM(int i) {
        this.aMH = i;
        L(this.aMD);
    }

    public List<h> FX() {
        return this.aME;
    }

    public void eN(int i) {
        this.aMI = i;
        L(this.aMD);
    }
}
