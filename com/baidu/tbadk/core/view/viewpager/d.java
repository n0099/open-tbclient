package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int dKY;
    private List<m> dLe;
    private List<m> dLf;
    private boolean dLg;
    private boolean dLh;
    private int dLi = 2;
    private int dLj = 1;

    public d(List<m> list, boolean z, int i) {
        this.dKY = 2;
        this.dLe = list;
        this.dLh = z;
        this.dKY = i;
        aM(list);
    }

    public void aM(List<m> list) {
        if (list != null && list.size() >= this.dLi && list.size() <= this.dKY) {
            this.dLg = true;
        } else if (list.size() > this.dKY && this.dLh) {
            this.dLg = true;
        } else {
            this.dLg = false;
        }
        this.dLf = aRa();
    }

    private List<m> aRa() {
        ArrayList arrayList = new ArrayList();
        if (this.dLe != null) {
            if (this.dLg) {
                if (this.dLe.size() > this.dKY && this.dLe.size() >= this.dLj) {
                    arrayList.addAll(this.dLe.subList(0, this.dKY));
                    arrayList.addAll(0, this.dLe.subList(this.dKY - this.dLj, this.dKY));
                    arrayList.addAll(this.dLe.subList(0, this.dLj));
                } else {
                    arrayList.addAll(this.dLe);
                    arrayList.addAll(0, this.dLe.subList(this.dLe.size() - this.dLj, this.dLe.size()));
                    arrayList.addAll(this.dLe.subList(0, this.dLj));
                }
            } else if (this.dLe != null && this.dLe.size() > 0 && this.dLe.size() >= this.dLj) {
                arrayList.addAll(this.dLe.subList(0, this.dLj));
            }
        }
        return arrayList;
    }

    public int lP(int i) {
        if (this.dLg) {
            int size = this.dLf.size();
            if (i == 0) {
                return (size - 1) - this.dLj;
            }
            if (i == size - this.dLj) {
                return this.dLj;
            }
            return i;
        }
        return i;
    }

    public int lQ(int i) {
        if (this.dLg) {
            return i - this.dLj;
        }
        return i;
    }

    public int aRb() {
        if (this.dLe == null) {
            return 0;
        }
        return this.dLe.size();
    }

    public int aRc() {
        if (this.dLg) {
            return this.dLj;
        }
        return 0;
    }

    public void lR(int i) {
        this.dKY = i;
        aM(this.dLe);
    }

    public void lS(int i) {
        this.dLi = i;
        aM(this.dLe);
    }

    public List<m> aRd() {
        return this.dLf;
    }

    public void lT(int i) {
        this.dLj = i;
        aM(this.dLe);
    }
}
