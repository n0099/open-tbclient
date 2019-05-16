package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int ccV;
    private List<m> cdc;
    private List<m> cdd;
    private boolean cde;
    private boolean cdf;
    private int cdg = 2;
    private int cdh = 1;

    public d(List<m> list, boolean z, int i) {
        this.ccV = 2;
        this.cdc = list;
        this.cdf = z;
        this.ccV = i;
        ad(list);
    }

    public void ad(List<m> list) {
        if (list != null && list.size() >= this.cdg && list.size() <= this.ccV) {
            this.cde = true;
        } else if (list.size() > this.ccV && this.cdf) {
            this.cde = true;
        } else {
            this.cde = false;
        }
        this.cdd = akk();
    }

    private List<m> akk() {
        ArrayList arrayList = new ArrayList();
        if (this.cdc != null) {
            if (this.cde) {
                if (this.cdc.size() > this.ccV && this.cdc.size() >= this.cdh) {
                    arrayList.addAll(this.cdc.subList(0, this.ccV));
                    arrayList.addAll(0, this.cdc.subList(this.ccV - this.cdh, this.ccV));
                    arrayList.addAll(this.cdc.subList(0, this.cdh));
                } else {
                    arrayList.addAll(this.cdc);
                    arrayList.addAll(0, this.cdc.subList(this.cdc.size() - this.cdh, this.cdc.size()));
                    arrayList.addAll(this.cdc.subList(0, this.cdh));
                }
            } else if (this.cdc != null && this.cdc.size() > 0 && this.cdc.size() >= this.cdh) {
                arrayList.addAll(this.cdc.subList(0, this.cdh));
            }
        }
        return arrayList;
    }

    public int jc(int i) {
        if (this.cde) {
            int size = this.cdd.size();
            if (i == 0) {
                return (size - 1) - this.cdh;
            }
            if (i == size - this.cdh) {
                return this.cdh;
            }
            return i;
        }
        return i;
    }

    public int jd(int i) {
        if (this.cde) {
            return i - this.cdh;
        }
        return i;
    }

    public int akl() {
        if (this.cdc == null) {
            return 0;
        }
        return this.cdc.size();
    }

    public int akm() {
        if (this.cde) {
            return this.cdh;
        }
        return 0;
    }

    public void je(int i) {
        this.ccV = i;
        ad(this.cdc);
    }

    public void jf(int i) {
        this.cdg = i;
        ad(this.cdc);
    }

    public List<m> akn() {
        return this.cdd;
    }

    public void jg(int i) {
        this.cdh = i;
        ad(this.cdc);
    }
}
