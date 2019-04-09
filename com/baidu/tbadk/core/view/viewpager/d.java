package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int bVa;
    private List<m> bVh;
    private List<m> bVi;
    private boolean bVj;
    private boolean bVk;
    private int bVl = 2;
    private int bVm = 1;

    public d(List<m> list, boolean z, int i) {
        this.bVa = 2;
        this.bVh = list;
        this.bVk = z;
        this.bVa = i;
        W(list);
    }

    public void W(List<m> list) {
        if (list != null && list.size() >= this.bVl && list.size() <= this.bVa) {
            this.bVj = true;
        } else if (list.size() > this.bVa && this.bVk) {
            this.bVj = true;
        } else {
            this.bVj = false;
        }
        this.bVi = afl();
    }

    private List<m> afl() {
        ArrayList arrayList = new ArrayList();
        if (this.bVh != null) {
            if (this.bVj) {
                if (this.bVh.size() > this.bVa && this.bVh.size() >= this.bVm) {
                    arrayList.addAll(this.bVh.subList(0, this.bVa));
                    arrayList.addAll(0, this.bVh.subList(this.bVa - this.bVm, this.bVa));
                    arrayList.addAll(this.bVh.subList(0, this.bVm));
                } else {
                    arrayList.addAll(this.bVh);
                    arrayList.addAll(0, this.bVh.subList(this.bVh.size() - this.bVm, this.bVh.size()));
                    arrayList.addAll(this.bVh.subList(0, this.bVm));
                }
            } else if (this.bVh != null && this.bVh.size() > 0 && this.bVh.size() >= this.bVm) {
                arrayList.addAll(this.bVh.subList(0, this.bVm));
            }
        }
        return arrayList;
    }

    public int io(int i) {
        if (this.bVj) {
            int size = this.bVi.size();
            if (i == 0) {
                return (size - 1) - this.bVm;
            }
            if (i == size - this.bVm) {
                return this.bVm;
            }
            return i;
        }
        return i;
    }

    public int ip(int i) {
        if (this.bVj) {
            return i - this.bVm;
        }
        return i;
    }

    public int afm() {
        if (this.bVh == null) {
            return 0;
        }
        return this.bVh.size();
    }

    public int afn() {
        if (this.bVj) {
            return this.bVm;
        }
        return 0;
    }

    public void iq(int i) {
        this.bVa = i;
        W(this.bVh);
    }

    public void ir(int i) {
        this.bVl = i;
        W(this.bVh);
    }

    public List<m> afo() {
        return this.bVi;
    }

    public void is(int i) {
        this.bVm = i;
        W(this.bVh);
    }
}
