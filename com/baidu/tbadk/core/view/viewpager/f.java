package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private int anh;
    private List<v> anp;
    private List<v> anq;
    private boolean anr;
    private boolean ans;
    private int ant = 2;
    private int anu = 1;

    public f(List<v> list, boolean z, int i) {
        this.anh = 2;
        this.anp = list;
        this.ans = z;
        this.anh = i;
        r(list);
    }

    public void r(List<v> list) {
        if (list != null && list.size() >= this.ant && list.size() <= this.anh) {
            this.anr = true;
        } else if (list.size() > this.anh && this.ans) {
            this.anr = true;
        } else {
            this.anr = false;
        }
        this.anq = xC();
    }

    private List<v> xC() {
        ArrayList arrayList = new ArrayList();
        if (this.anp != null) {
            if (this.anr) {
                if (this.anp.size() > this.anh && this.anp.size() >= this.anu) {
                    arrayList.addAll(this.anp.subList(0, this.anh));
                    arrayList.addAll(0, this.anp.subList(this.anh - this.anu, this.anh));
                    arrayList.addAll(this.anp.subList(0, this.anu));
                } else {
                    arrayList.addAll(this.anp);
                    arrayList.addAll(0, this.anp.subList(this.anp.size() - this.anu, this.anp.size()));
                    arrayList.addAll(this.anp.subList(0, this.anu));
                }
            } else if (this.anp != null && this.anp.size() > 0 && this.anp.size() >= this.anu) {
                arrayList.addAll(this.anp.subList(0, this.anu));
            }
        }
        return arrayList;
    }

    public int dt(int i) {
        if (this.anr) {
            int size = this.anq.size();
            if (i == 0) {
                return (size - 1) - this.anu;
            }
            if (i == size - this.anu) {
                return this.anu;
            }
            return i;
        }
        return i;
    }

    public int du(int i) {
        if (this.anr) {
            return i - this.anu;
        }
        return i;
    }

    public int xD() {
        if (this.anp == null) {
            return 0;
        }
        return this.anp.size();
    }

    public int xE() {
        if (this.anr) {
            return this.anu;
        }
        return 0;
    }

    public void dv(int i) {
        this.anh = i;
        r(this.anp);
    }

    public void dw(int i) {
        this.ant = i;
        r(this.anp);
    }

    public List<v> xF() {
        return this.anq;
    }

    public void dx(int i) {
        this.anu = i;
        r(this.anp);
    }
}
