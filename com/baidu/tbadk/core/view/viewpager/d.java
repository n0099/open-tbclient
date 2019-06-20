package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int ccW;
    private List<m> cdd;
    private List<m> cde;
    private boolean cdf;
    private boolean cdg;
    private int cdh = 2;
    private int cdi = 1;

    public d(List<m> list, boolean z, int i) {
        this.ccW = 2;
        this.cdd = list;
        this.cdg = z;
        this.ccW = i;
        ad(list);
    }

    public void ad(List<m> list) {
        if (list != null && list.size() >= this.cdh && list.size() <= this.ccW) {
            this.cdf = true;
        } else if (list.size() > this.ccW && this.cdg) {
            this.cdf = true;
        } else {
            this.cdf = false;
        }
        this.cde = akk();
    }

    private List<m> akk() {
        ArrayList arrayList = new ArrayList();
        if (this.cdd != null) {
            if (this.cdf) {
                if (this.cdd.size() > this.ccW && this.cdd.size() >= this.cdi) {
                    arrayList.addAll(this.cdd.subList(0, this.ccW));
                    arrayList.addAll(0, this.cdd.subList(this.ccW - this.cdi, this.ccW));
                    arrayList.addAll(this.cdd.subList(0, this.cdi));
                } else {
                    arrayList.addAll(this.cdd);
                    arrayList.addAll(0, this.cdd.subList(this.cdd.size() - this.cdi, this.cdd.size()));
                    arrayList.addAll(this.cdd.subList(0, this.cdi));
                }
            } else if (this.cdd != null && this.cdd.size() > 0 && this.cdd.size() >= this.cdi) {
                arrayList.addAll(this.cdd.subList(0, this.cdi));
            }
        }
        return arrayList;
    }

    public int jc(int i) {
        if (this.cdf) {
            int size = this.cde.size();
            if (i == 0) {
                return (size - 1) - this.cdi;
            }
            if (i == size - this.cdi) {
                return this.cdi;
            }
            return i;
        }
        return i;
    }

    public int jd(int i) {
        if (this.cdf) {
            return i - this.cdi;
        }
        return i;
    }

    public int akl() {
        if (this.cdd == null) {
            return 0;
        }
        return this.cdd.size();
    }

    public int akm() {
        if (this.cdf) {
            return this.cdi;
        }
        return 0;
    }

    public void je(int i) {
        this.ccW = i;
        ad(this.cdd);
    }

    public void jf(int i) {
        this.cdh = i;
        ad(this.cdd);
    }

    public List<m> akn() {
        return this.cde;
    }

    public void jg(int i) {
        this.cdi = i;
        ad(this.cdd);
    }
}
