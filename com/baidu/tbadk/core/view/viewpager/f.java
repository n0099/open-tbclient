package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private List<u> aiB;
    private List<u> aiC;
    private boolean aiD;
    private boolean aiE;
    private int aiF = 2;
    private int aiG = 1;
    private int ait;

    public f(List<u> list, boolean z, int i) {
        this.ait = 2;
        this.aiB = list;
        this.aiE = z;
        this.ait = i;
        r(list);
    }

    public void r(List<u> list) {
        if (list != null && list.size() >= this.aiF && list.size() <= this.ait) {
            this.aiD = true;
        } else if (list.size() > this.ait && this.aiE) {
            this.aiD = true;
        } else {
            this.aiD = false;
        }
        this.aiC = xT();
    }

    private List<u> xT() {
        ArrayList arrayList = new ArrayList();
        if (this.aiB != null) {
            if (this.aiD) {
                if (this.aiB.size() > this.ait && this.aiB.size() >= this.aiG) {
                    arrayList.addAll(this.aiB.subList(0, this.ait));
                    arrayList.addAll(0, this.aiB.subList(this.ait - this.aiG, this.ait));
                    arrayList.addAll(this.aiB.subList(0, this.aiG));
                } else {
                    arrayList.addAll(this.aiB);
                    arrayList.addAll(0, this.aiB.subList(this.aiB.size() - this.aiG, this.aiB.size()));
                    arrayList.addAll(this.aiB.subList(0, this.aiG));
                }
            } else if (this.aiB != null && this.aiB.size() > 0 && this.aiB.size() >= this.aiG) {
                arrayList.addAll(this.aiB.subList(0, this.aiG));
            }
        }
        return arrayList;
    }

    public int ds(int i) {
        if (this.aiD) {
            int size = this.aiC.size();
            if (i == 0) {
                return (size - 1) - this.aiG;
            }
            if (i == size - this.aiG) {
                return this.aiG;
            }
            return i;
        }
        return i;
    }

    public int dt(int i) {
        if (this.aiD) {
            return i - this.aiG;
        }
        return i;
    }

    public int xU() {
        if (this.aiB == null) {
            return 0;
        }
        return this.aiB.size();
    }

    public int xV() {
        if (this.aiD) {
            return this.aiG;
        }
        return 0;
    }

    public void du(int i) {
        this.ait = i;
        r(this.aiB);
    }

    public void dv(int i) {
        this.aiF = i;
        r(this.aiB);
    }

    public List<u> xW() {
        return this.aiC;
    }

    public void dw(int i) {
        this.aiG = i;
        r(this.aiB);
    }
}
