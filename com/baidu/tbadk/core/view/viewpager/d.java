package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<i> bdH;
    private List<i> bdI;
    private boolean bdJ;
    private boolean bdK;
    private int bdM;
    private int bdL = 2;
    private int bdN = 1;

    public d(List<i> list, boolean z, int i) {
        this.bdM = 2;
        this.bdH = list;
        this.bdK = z;
        this.bdM = i;
        H(list);
    }

    public void H(List<i> list) {
        if (list != null && list.size() >= this.bdL && list.size() <= this.bdM) {
            this.bdJ = true;
        } else if (list.size() > this.bdM && this.bdK) {
            this.bdJ = true;
        } else {
            this.bdJ = false;
        }
        this.bdI = Eu();
    }

    private List<i> Eu() {
        ArrayList arrayList = new ArrayList();
        if (this.bdH != null) {
            if (this.bdJ) {
                if (this.bdH.size() > this.bdM && this.bdH.size() >= this.bdN) {
                    arrayList.addAll(this.bdH.subList(0, this.bdM));
                    arrayList.addAll(0, this.bdH.subList(this.bdM - this.bdN, this.bdM));
                    arrayList.addAll(this.bdH.subList(0, this.bdN));
                } else {
                    arrayList.addAll(this.bdH);
                    arrayList.addAll(0, this.bdH.subList(this.bdH.size() - this.bdN, this.bdH.size()));
                    arrayList.addAll(this.bdH.subList(0, this.bdN));
                }
            } else if (this.bdH != null && this.bdH.size() > 0 && this.bdH.size() >= this.bdN) {
                arrayList.addAll(this.bdH.subList(0, this.bdN));
            }
        }
        return arrayList;
    }

    public int gH(int i) {
        if (this.bdJ) {
            int size = this.bdI.size();
            if (i == 0) {
                return (size - 1) - this.bdN;
            }
            if (i == size - this.bdN) {
                return this.bdN;
            }
            return i;
        }
        return i;
    }

    public int gI(int i) {
        if (this.bdJ) {
            return i - this.bdN;
        }
        return i;
    }

    public int Ev() {
        if (this.bdH == null) {
            return 0;
        }
        return this.bdH.size();
    }

    public int Ew() {
        if (this.bdJ) {
            return this.bdN;
        }
        return 0;
    }

    public void gJ(int i) {
        this.bdM = i;
        H(this.bdH);
    }

    public void gK(int i) {
        this.bdL = i;
        H(this.bdH);
    }

    public List<i> Ex() {
        return this.bdI;
    }

    public void gL(int i) {
        this.bdN = i;
        H(this.bdH);
    }
}
