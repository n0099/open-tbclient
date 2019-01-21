package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<h> aME;
    private List<h> aMF;
    private boolean aMG;
    private boolean aMH;
    private int aMI = 2;
    private int aMJ = 1;
    private int aMx;

    public d(List<h> list, boolean z, int i) {
        this.aMx = 2;
        this.aME = list;
        this.aMH = z;
        this.aMx = i;
        L(list);
    }

    public void L(List<h> list) {
        if (list != null && list.size() >= this.aMI && list.size() <= this.aMx) {
            this.aMG = true;
        } else if (list.size() > this.aMx && this.aMH) {
            this.aMG = true;
        } else {
            this.aMG = false;
        }
        this.aMF = FU();
    }

    private List<h> FU() {
        ArrayList arrayList = new ArrayList();
        if (this.aME != null) {
            if (this.aMG) {
                if (this.aME.size() > this.aMx && this.aME.size() >= this.aMJ) {
                    arrayList.addAll(this.aME.subList(0, this.aMx));
                    arrayList.addAll(0, this.aME.subList(this.aMx - this.aMJ, this.aMx));
                    arrayList.addAll(this.aME.subList(0, this.aMJ));
                } else {
                    arrayList.addAll(this.aME);
                    arrayList.addAll(0, this.aME.subList(this.aME.size() - this.aMJ, this.aME.size()));
                    arrayList.addAll(this.aME.subList(0, this.aMJ));
                }
            } else if (this.aME != null && this.aME.size() > 0 && this.aME.size() >= this.aMJ) {
                arrayList.addAll(this.aME.subList(0, this.aMJ));
            }
        }
        return arrayList;
    }

    public int eJ(int i) {
        if (this.aMG) {
            int size = this.aMF.size();
            if (i == 0) {
                return (size - 1) - this.aMJ;
            }
            if (i == size - this.aMJ) {
                return this.aMJ;
            }
            return i;
        }
        return i;
    }

    public int eK(int i) {
        if (this.aMG) {
            return i - this.aMJ;
        }
        return i;
    }

    public int FV() {
        if (this.aME == null) {
            return 0;
        }
        return this.aME.size();
    }

    public int FW() {
        if (this.aMG) {
            return this.aMJ;
        }
        return 0;
    }

    public void eL(int i) {
        this.aMx = i;
        L(this.aME);
    }

    public void eM(int i) {
        this.aMI = i;
        L(this.aME);
    }

    public List<h> FX() {
        return this.aMF;
    }

    public void eN(int i) {
        this.aMJ = i;
        L(this.aME);
    }
}
