package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int bUW;
    private List<m> bVd;
    private List<m> bVe;
    private boolean bVf;
    private boolean bVg;
    private int bVh = 2;
    private int bVi = 1;

    public d(List<m> list, boolean z, int i) {
        this.bUW = 2;
        this.bVd = list;
        this.bVg = z;
        this.bUW = i;
        W(list);
    }

    public void W(List<m> list) {
        if (list != null && list.size() >= this.bVh && list.size() <= this.bUW) {
            this.bVf = true;
        } else if (list.size() > this.bUW && this.bVg) {
            this.bVf = true;
        } else {
            this.bVf = false;
        }
        this.bVe = afo();
    }

    private List<m> afo() {
        ArrayList arrayList = new ArrayList();
        if (this.bVd != null) {
            if (this.bVf) {
                if (this.bVd.size() > this.bUW && this.bVd.size() >= this.bVi) {
                    arrayList.addAll(this.bVd.subList(0, this.bUW));
                    arrayList.addAll(0, this.bVd.subList(this.bUW - this.bVi, this.bUW));
                    arrayList.addAll(this.bVd.subList(0, this.bVi));
                } else {
                    arrayList.addAll(this.bVd);
                    arrayList.addAll(0, this.bVd.subList(this.bVd.size() - this.bVi, this.bVd.size()));
                    arrayList.addAll(this.bVd.subList(0, this.bVi));
                }
            } else if (this.bVd != null && this.bVd.size() > 0 && this.bVd.size() >= this.bVi) {
                arrayList.addAll(this.bVd.subList(0, this.bVi));
            }
        }
        return arrayList;
    }

    public int ip(int i) {
        if (this.bVf) {
            int size = this.bVe.size();
            if (i == 0) {
                return (size - 1) - this.bVi;
            }
            if (i == size - this.bVi) {
                return this.bVi;
            }
            return i;
        }
        return i;
    }

    public int iq(int i) {
        if (this.bVf) {
            return i - this.bVi;
        }
        return i;
    }

    public int afp() {
        if (this.bVd == null) {
            return 0;
        }
        return this.bVd.size();
    }

    public int afq() {
        if (this.bVf) {
            return this.bVi;
        }
        return 0;
    }

    public void ir(int i) {
        this.bUW = i;
        W(this.bVd);
    }

    public void is(int i) {
        this.bVh = i;
        W(this.bVd);
    }

    public List<m> afr() {
        return this.bVe;
    }

    public void it(int i) {
        this.bVi = i;
        W(this.bVd);
    }
}
