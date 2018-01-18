package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<i> bdN;
    private List<i> bdO;
    private boolean bdP;
    private boolean bdQ;
    private int bdS;
    private int bdR = 2;
    private int bdT = 1;

    public d(List<i> list, boolean z, int i) {
        this.bdS = 2;
        this.bdN = list;
        this.bdQ = z;
        this.bdS = i;
        F(list);
    }

    public void F(List<i> list) {
        if (list != null && list.size() >= this.bdR && list.size() <= this.bdS) {
            this.bdP = true;
        } else if (list.size() > this.bdS && this.bdQ) {
            this.bdP = true;
        } else {
            this.bdP = false;
        }
        this.bdO = El();
    }

    private List<i> El() {
        ArrayList arrayList = new ArrayList();
        if (this.bdN != null) {
            if (this.bdP) {
                if (this.bdN.size() > this.bdS && this.bdN.size() >= this.bdT) {
                    arrayList.addAll(this.bdN.subList(0, this.bdS));
                    arrayList.addAll(0, this.bdN.subList(this.bdS - this.bdT, this.bdS));
                    arrayList.addAll(this.bdN.subList(0, this.bdT));
                } else {
                    arrayList.addAll(this.bdN);
                    arrayList.addAll(0, this.bdN.subList(this.bdN.size() - this.bdT, this.bdN.size()));
                    arrayList.addAll(this.bdN.subList(0, this.bdT));
                }
            } else if (this.bdN != null && this.bdN.size() > 0 && this.bdN.size() >= this.bdT) {
                arrayList.addAll(this.bdN.subList(0, this.bdT));
            }
        }
        return arrayList;
    }

    public int gE(int i) {
        if (this.bdP) {
            int size = this.bdO.size();
            if (i == 0) {
                return (size - 1) - this.bdT;
            }
            if (i == size - this.bdT) {
                return this.bdT;
            }
            return i;
        }
        return i;
    }

    public int gF(int i) {
        if (this.bdP) {
            return i - this.bdT;
        }
        return i;
    }

    public int Em() {
        if (this.bdN == null) {
            return 0;
        }
        return this.bdN.size();
    }

    public int En() {
        if (this.bdP) {
            return this.bdT;
        }
        return 0;
    }

    public void gG(int i) {
        this.bdS = i;
        F(this.bdN);
    }

    public void gH(int i) {
        this.bdR = i;
        F(this.bdN);
    }

    public List<i> Eo() {
        return this.bdO;
    }

    public void gI(int i) {
        this.bdT = i;
        F(this.bdN);
    }
}
