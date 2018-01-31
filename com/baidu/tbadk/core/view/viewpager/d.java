package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<i> bdV;
    private List<i> bdW;
    private boolean bdX;
    private boolean bdY;
    private int bea;
    private int bdZ = 2;
    private int beb = 1;

    public d(List<i> list, boolean z, int i) {
        this.bea = 2;
        this.bdV = list;
        this.bdY = z;
        this.bea = i;
        F(list);
    }

    public void F(List<i> list) {
        if (list != null && list.size() >= this.bdZ && list.size() <= this.bea) {
            this.bdX = true;
        } else if (list.size() > this.bea && this.bdY) {
            this.bdX = true;
        } else {
            this.bdX = false;
        }
        this.bdW = En();
    }

    private List<i> En() {
        ArrayList arrayList = new ArrayList();
        if (this.bdV != null) {
            if (this.bdX) {
                if (this.bdV.size() > this.bea && this.bdV.size() >= this.beb) {
                    arrayList.addAll(this.bdV.subList(0, this.bea));
                    arrayList.addAll(0, this.bdV.subList(this.bea - this.beb, this.bea));
                    arrayList.addAll(this.bdV.subList(0, this.beb));
                } else {
                    arrayList.addAll(this.bdV);
                    arrayList.addAll(0, this.bdV.subList(this.bdV.size() - this.beb, this.bdV.size()));
                    arrayList.addAll(this.bdV.subList(0, this.beb));
                }
            } else if (this.bdV != null && this.bdV.size() > 0 && this.bdV.size() >= this.beb) {
                arrayList.addAll(this.bdV.subList(0, this.beb));
            }
        }
        return arrayList;
    }

    public int gE(int i) {
        if (this.bdX) {
            int size = this.bdW.size();
            if (i == 0) {
                return (size - 1) - this.beb;
            }
            if (i == size - this.beb) {
                return this.beb;
            }
            return i;
        }
        return i;
    }

    public int gF(int i) {
        if (this.bdX) {
            return i - this.beb;
        }
        return i;
    }

    public int Eo() {
        if (this.bdV == null) {
            return 0;
        }
        return this.bdV.size();
    }

    public int Ep() {
        if (this.bdX) {
            return this.beb;
        }
        return 0;
    }

    public void gG(int i) {
        this.bea = i;
        F(this.bdV);
    }

    public void gH(int i) {
        this.bdZ = i;
        F(this.bdV);
    }

    public List<i> Eq() {
        return this.bdW;
    }

    public void gI(int i) {
        this.beb = i;
        F(this.bdV);
    }
}
