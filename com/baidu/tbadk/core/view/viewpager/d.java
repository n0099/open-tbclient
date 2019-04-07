package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int bUZ;
    private List<m> bVg;
    private List<m> bVh;
    private boolean bVi;
    private boolean bVj;
    private int bVk = 2;
    private int bVl = 1;

    public d(List<m> list, boolean z, int i) {
        this.bUZ = 2;
        this.bVg = list;
        this.bVj = z;
        this.bUZ = i;
        W(list);
    }

    public void W(List<m> list) {
        if (list != null && list.size() >= this.bVk && list.size() <= this.bUZ) {
            this.bVi = true;
        } else if (list.size() > this.bUZ && this.bVj) {
            this.bVi = true;
        } else {
            this.bVi = false;
        }
        this.bVh = afl();
    }

    private List<m> afl() {
        ArrayList arrayList = new ArrayList();
        if (this.bVg != null) {
            if (this.bVi) {
                if (this.bVg.size() > this.bUZ && this.bVg.size() >= this.bVl) {
                    arrayList.addAll(this.bVg.subList(0, this.bUZ));
                    arrayList.addAll(0, this.bVg.subList(this.bUZ - this.bVl, this.bUZ));
                    arrayList.addAll(this.bVg.subList(0, this.bVl));
                } else {
                    arrayList.addAll(this.bVg);
                    arrayList.addAll(0, this.bVg.subList(this.bVg.size() - this.bVl, this.bVg.size()));
                    arrayList.addAll(this.bVg.subList(0, this.bVl));
                }
            } else if (this.bVg != null && this.bVg.size() > 0 && this.bVg.size() >= this.bVl) {
                arrayList.addAll(this.bVg.subList(0, this.bVl));
            }
        }
        return arrayList;
    }

    public int io(int i) {
        if (this.bVi) {
            int size = this.bVh.size();
            if (i == 0) {
                return (size - 1) - this.bVl;
            }
            if (i == size - this.bVl) {
                return this.bVl;
            }
            return i;
        }
        return i;
    }

    public int ip(int i) {
        if (this.bVi) {
            return i - this.bVl;
        }
        return i;
    }

    public int afm() {
        if (this.bVg == null) {
            return 0;
        }
        return this.bVg.size();
    }

    public int afn() {
        if (this.bVi) {
            return this.bVl;
        }
        return 0;
    }

    public void iq(int i) {
        this.bUZ = i;
        W(this.bVg);
    }

    public void ir(int i) {
        this.bVk = i;
        W(this.bVg);
    }

    public List<m> afo() {
        return this.bVh;
    }

    public void is(int i) {
        this.bVl = i;
        W(this.bVg);
    }
}
