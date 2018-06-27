package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int aAc;
    private List<h> aAj;
    private List<h> aAk;
    private boolean aAl;
    private boolean aAm;
    private int aAn = 2;
    private int aAo = 1;

    public d(List<h> list, boolean z, int i) {
        this.aAc = 2;
        this.aAj = list;
        this.aAm = z;
        this.aAc = i;
        B(list);
    }

    public void B(List<h> list) {
        if (list != null && list.size() >= this.aAn && list.size() <= this.aAc) {
            this.aAl = true;
        } else if (list.size() > this.aAc && this.aAm) {
            this.aAl = true;
        } else {
            this.aAl = false;
        }
        this.aAk = Bn();
    }

    private List<h> Bn() {
        ArrayList arrayList = new ArrayList();
        if (this.aAj != null) {
            if (this.aAl) {
                if (this.aAj.size() > this.aAc && this.aAj.size() >= this.aAo) {
                    arrayList.addAll(this.aAj.subList(0, this.aAc));
                    arrayList.addAll(0, this.aAj.subList(this.aAc - this.aAo, this.aAc));
                    arrayList.addAll(this.aAj.subList(0, this.aAo));
                } else {
                    arrayList.addAll(this.aAj);
                    arrayList.addAll(0, this.aAj.subList(this.aAj.size() - this.aAo, this.aAj.size()));
                    arrayList.addAll(this.aAj.subList(0, this.aAo));
                }
            } else if (this.aAj != null && this.aAj.size() > 0 && this.aAj.size() >= this.aAo) {
                arrayList.addAll(this.aAj.subList(0, this.aAo));
            }
        }
        return arrayList;
    }

    public int dI(int i) {
        if (this.aAl) {
            int size = this.aAk.size();
            if (i == 0) {
                return (size - 1) - this.aAo;
            }
            if (i == size - this.aAo) {
                return this.aAo;
            }
            return i;
        }
        return i;
    }

    public int dJ(int i) {
        if (this.aAl) {
            return i - this.aAo;
        }
        return i;
    }

    public int Bo() {
        if (this.aAj == null) {
            return 0;
        }
        return this.aAj.size();
    }

    public int Bp() {
        if (this.aAl) {
            return this.aAo;
        }
        return 0;
    }

    public void dK(int i) {
        this.aAc = i;
        B(this.aAj);
    }

    public void dL(int i) {
        this.aAn = i;
        B(this.aAj);
    }

    public List<h> Bq() {
        return this.aAk;
    }

    public void dM(int i) {
        this.aAo = i;
        B(this.aAj);
    }
}
