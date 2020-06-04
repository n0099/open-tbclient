package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int dZp;
    private List<o> dZv;
    private List<o> dZw;
    private boolean dZx;
    private boolean dZy;
    private int dZz = 2;
    private int dZA = 1;

    public d(List<o> list, boolean z, int i) {
        this.dZp = 2;
        this.dZv = list;
        this.dZy = z;
        this.dZp = i;
        aH(list);
    }

    public void aH(List<o> list) {
        if (list != null && list.size() >= this.dZz && list.size() <= this.dZp) {
            this.dZx = true;
        } else if (list.size() > this.dZp && this.dZy) {
            this.dZx = true;
        } else {
            this.dZx = false;
        }
        this.dZw = aXi();
    }

    private List<o> aXi() {
        ArrayList arrayList = new ArrayList();
        if (this.dZv != null) {
            if (this.dZx) {
                if (this.dZv.size() > this.dZp && this.dZv.size() >= this.dZA) {
                    arrayList.addAll(this.dZv.subList(0, this.dZp));
                    arrayList.addAll(0, this.dZv.subList(this.dZp - this.dZA, this.dZp));
                    arrayList.addAll(this.dZv.subList(0, this.dZA));
                } else {
                    arrayList.addAll(this.dZv);
                    arrayList.addAll(0, this.dZv.subList(this.dZv.size() - this.dZA, this.dZv.size()));
                    arrayList.addAll(this.dZv.subList(0, this.dZA));
                }
            } else if (this.dZv != null && this.dZv.size() > 0 && this.dZv.size() >= this.dZA) {
                arrayList.addAll(this.dZv.subList(0, this.dZA));
            }
        }
        return arrayList;
    }

    public int mu(int i) {
        if (this.dZx) {
            int size = this.dZw.size();
            if (i == 0) {
                return (size - 1) - this.dZA;
            }
            if (i == size - this.dZA) {
                return this.dZA;
            }
            return i;
        }
        return i;
    }

    public int mv(int i) {
        if (this.dZx) {
            return i - this.dZA;
        }
        return i;
    }

    public int aXj() {
        if (this.dZv == null) {
            return 0;
        }
        return this.dZv.size();
    }

    public int aXk() {
        if (this.dZx) {
            return this.dZA;
        }
        return 0;
    }

    public void mw(int i) {
        this.dZp = i;
        aH(this.dZv);
    }

    public void mx(int i) {
        this.dZz = i;
        aH(this.dZv);
    }

    public List<o> aXl() {
        return this.dZw;
    }

    public void my(int i) {
        this.dZA = i;
        aH(this.dZv);
    }
}
