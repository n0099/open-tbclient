package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private int anm;
    private List<v> anu;
    private List<v> anv;
    private boolean anw;
    private boolean anx;
    private int any = 2;
    private int anz = 1;

    public g(List<v> list, boolean z, int i) {
        this.anm = 2;
        this.anu = list;
        this.anx = z;
        this.anm = i;
        s(list);
    }

    public void s(List<v> list) {
        if (list != null && list.size() >= this.any && list.size() <= this.anm) {
            this.anw = true;
        } else if (list.size() > this.anm && this.anx) {
            this.anw = true;
        } else {
            this.anw = false;
        }
        this.anv = wQ();
    }

    private List<v> wQ() {
        ArrayList arrayList = new ArrayList();
        if (this.anu != null) {
            if (this.anw) {
                if (this.anu.size() > this.anm && this.anu.size() >= this.anz) {
                    arrayList.addAll(this.anu.subList(0, this.anm));
                    arrayList.addAll(0, this.anu.subList(this.anm - this.anz, this.anm));
                    arrayList.addAll(this.anu.subList(0, this.anz));
                } else {
                    arrayList.addAll(this.anu);
                    arrayList.addAll(0, this.anu.subList(this.anu.size() - this.anz, this.anu.size()));
                    arrayList.addAll(this.anu.subList(0, this.anz));
                }
            } else if (this.anu != null && this.anu.size() > 0 && this.anu.size() >= this.anz) {
                arrayList.addAll(this.anu.subList(0, this.anz));
            }
        }
        return arrayList;
    }

    public int dr(int i) {
        if (this.anw) {
            int size = this.anv.size();
            if (i == 0) {
                return (size - 1) - this.anz;
            }
            if (i == size - this.anz) {
                return this.anz;
            }
            return i;
        }
        return i;
    }

    public int ds(int i) {
        if (this.anw) {
            return i - this.anz;
        }
        return i;
    }

    public int wR() {
        if (this.anu == null) {
            return 0;
        }
        return this.anu.size();
    }

    public int wS() {
        if (this.anw) {
            return this.anz;
        }
        return 0;
    }

    public void dt(int i) {
        this.anm = i;
        s(this.anu);
    }

    public void du(int i) {
        this.any = i;
        s(this.anu);
    }

    public List<v> wT() {
        return this.anv;
    }

    public void dv(int i) {
        this.anz = i;
        s(this.anu);
    }
}
