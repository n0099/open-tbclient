package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int ctk;
    private List<m> ctr;
    private List<m> cts;
    private boolean ctt;
    private boolean ctu;
    private int ctv = 2;
    private int ctw = 1;

    public d(List<m> list, boolean z, int i) {
        this.ctk = 2;
        this.ctr = list;
        this.ctu = z;
        this.ctk = i;
        ax(list);
    }

    public void ax(List<m> list) {
        if (list != null && list.size() >= this.ctv && list.size() <= this.ctk) {
            this.ctt = true;
        } else if (list.size() > this.ctk && this.ctu) {
            this.ctt = true;
        } else {
            this.ctt = false;
        }
        this.cts = aor();
    }

    private List<m> aor() {
        ArrayList arrayList = new ArrayList();
        if (this.ctr != null) {
            if (this.ctt) {
                if (this.ctr.size() > this.ctk && this.ctr.size() >= this.ctw) {
                    arrayList.addAll(this.ctr.subList(0, this.ctk));
                    arrayList.addAll(0, this.ctr.subList(this.ctk - this.ctw, this.ctk));
                    arrayList.addAll(this.ctr.subList(0, this.ctw));
                } else {
                    arrayList.addAll(this.ctr);
                    arrayList.addAll(0, this.ctr.subList(this.ctr.size() - this.ctw, this.ctr.size()));
                    arrayList.addAll(this.ctr.subList(0, this.ctw));
                }
            } else if (this.ctr != null && this.ctr.size() > 0 && this.ctr.size() >= this.ctw) {
                arrayList.addAll(this.ctr.subList(0, this.ctw));
            }
        }
        return arrayList;
    }

    public int iY(int i) {
        if (this.ctt) {
            int size = this.cts.size();
            if (i == 0) {
                return (size - 1) - this.ctw;
            }
            if (i == size - this.ctw) {
                return this.ctw;
            }
            return i;
        }
        return i;
    }

    public int iZ(int i) {
        if (this.ctt) {
            return i - this.ctw;
        }
        return i;
    }

    public int aos() {
        if (this.ctr == null) {
            return 0;
        }
        return this.ctr.size();
    }

    public int aot() {
        if (this.ctt) {
            return this.ctw;
        }
        return 0;
    }

    public void ja(int i) {
        this.ctk = i;
        ax(this.ctr);
    }

    public void jb(int i) {
        this.ctv = i;
        ax(this.ctr);
    }

    public List<m> aou() {
        return this.cts;
    }

    public void jc(int i) {
        this.ctw = i;
        ax(this.ctr);
    }
}
