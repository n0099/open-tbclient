package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<f> aoQ;
    private List<f> aoR;
    private boolean aoS;
    private boolean aoT;
    private int aoV;
    private int aoU = 2;
    private int aoW = 1;

    public d(List<f> list, boolean z, int i) {
        this.aoV = 2;
        this.aoQ = list;
        this.aoT = z;
        this.aoV = i;
        v(list);
    }

    public void v(List<f> list) {
        if (list != null && list.size() >= this.aoU && list.size() <= this.aoV) {
            this.aoS = true;
        } else if (list.size() > this.aoV && this.aoT) {
            this.aoS = true;
        } else {
            this.aoS = false;
        }
        this.aoR = wO();
    }

    private List<f> wO() {
        ArrayList arrayList = new ArrayList();
        if (this.aoQ != null) {
            if (this.aoS) {
                if (this.aoQ.size() > this.aoV && this.aoQ.size() >= this.aoW) {
                    arrayList.addAll(this.aoQ.subList(0, this.aoV));
                    arrayList.addAll(0, this.aoQ.subList(this.aoV - this.aoW, this.aoV));
                    arrayList.addAll(this.aoQ.subList(0, this.aoW));
                } else {
                    arrayList.addAll(this.aoQ);
                    arrayList.addAll(0, this.aoQ.subList(this.aoQ.size() - this.aoW, this.aoQ.size()));
                    arrayList.addAll(this.aoQ.subList(0, this.aoW));
                }
            } else if (this.aoQ != null && this.aoQ.size() > 0 && this.aoQ.size() >= this.aoW) {
                arrayList.addAll(this.aoQ.subList(0, this.aoW));
            }
        }
        return arrayList;
    }

    public int dI(int i) {
        if (this.aoS) {
            int size = this.aoR.size();
            if (i == 0) {
                return (size - 1) - this.aoW;
            }
            if (i == size - this.aoW) {
                return this.aoW;
            }
            return i;
        }
        return i;
    }

    public int dJ(int i) {
        if (this.aoS) {
            return i - this.aoW;
        }
        return i;
    }

    public int wP() {
        if (this.aoQ == null) {
            return 0;
        }
        return this.aoQ.size();
    }

    public int wQ() {
        if (this.aoS) {
            return this.aoW;
        }
        return 0;
    }

    public void dK(int i) {
        this.aoV = i;
        v(this.aoQ);
    }

    public void dL(int i) {
        this.aoU = i;
        v(this.aoQ);
    }

    public List<f> wR() {
        return this.aoR;
    }

    public void dM(int i) {
        this.aoW = i;
        v(this.aoQ);
    }
}
