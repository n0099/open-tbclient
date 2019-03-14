package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int bUX;
    private List<m> bVe;
    private List<m> bVf;
    private boolean bVg;
    private boolean bVh;
    private int bVi = 2;
    private int bVj = 1;

    public d(List<m> list, boolean z, int i) {
        this.bUX = 2;
        this.bVe = list;
        this.bVh = z;
        this.bUX = i;
        W(list);
    }

    public void W(List<m> list) {
        if (list != null && list.size() >= this.bVi && list.size() <= this.bUX) {
            this.bVg = true;
        } else if (list.size() > this.bUX && this.bVh) {
            this.bVg = true;
        } else {
            this.bVg = false;
        }
        this.bVf = afo();
    }

    private List<m> afo() {
        ArrayList arrayList = new ArrayList();
        if (this.bVe != null) {
            if (this.bVg) {
                if (this.bVe.size() > this.bUX && this.bVe.size() >= this.bVj) {
                    arrayList.addAll(this.bVe.subList(0, this.bUX));
                    arrayList.addAll(0, this.bVe.subList(this.bUX - this.bVj, this.bUX));
                    arrayList.addAll(this.bVe.subList(0, this.bVj));
                } else {
                    arrayList.addAll(this.bVe);
                    arrayList.addAll(0, this.bVe.subList(this.bVe.size() - this.bVj, this.bVe.size()));
                    arrayList.addAll(this.bVe.subList(0, this.bVj));
                }
            } else if (this.bVe != null && this.bVe.size() > 0 && this.bVe.size() >= this.bVj) {
                arrayList.addAll(this.bVe.subList(0, this.bVj));
            }
        }
        return arrayList;
    }

    public int ip(int i) {
        if (this.bVg) {
            int size = this.bVf.size();
            if (i == 0) {
                return (size - 1) - this.bVj;
            }
            if (i == size - this.bVj) {
                return this.bVj;
            }
            return i;
        }
        return i;
    }

    public int iq(int i) {
        if (this.bVg) {
            return i - this.bVj;
        }
        return i;
    }

    public int afp() {
        if (this.bVe == null) {
            return 0;
        }
        return this.bVe.size();
    }

    public int afq() {
        if (this.bVg) {
            return this.bVj;
        }
        return 0;
    }

    public void ir(int i) {
        this.bUX = i;
        W(this.bVe);
    }

    public void is(int i) {
        this.bVi = i;
        W(this.bVe);
    }

    public List<m> afr() {
        return this.bVf;
    }

    public void it(int i) {
        this.bVj = i;
        W(this.bVe);
    }
}
