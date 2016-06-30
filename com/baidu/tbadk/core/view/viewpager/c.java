package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private List<v> aeN;
    private List<v> aeO;
    private boolean aeP;
    private boolean aeQ;
    private int aeS;
    private int aeR = 2;
    private int aeT = 1;

    public c(List<v> list, boolean z, int i) {
        this.aeS = 2;
        this.aeN = list;
        this.aeQ = z;
        this.aeS = i;
        u(list);
    }

    public void u(List<v> list) {
        if (list != null && list.size() >= this.aeR && list.size() <= this.aeS) {
            this.aeP = true;
        } else if (list.size() > this.aeS && this.aeQ) {
            this.aeP = true;
        } else {
            this.aeP = false;
        }
        this.aeO = vR();
    }

    private List<v> vR() {
        ArrayList arrayList = new ArrayList();
        if (this.aeN != null) {
            if (this.aeP) {
                if (this.aeN.size() > this.aeS && this.aeN.size() >= this.aeT) {
                    arrayList.addAll(this.aeN.subList(0, this.aeS));
                    arrayList.addAll(0, this.aeN.subList(this.aeS - this.aeT, this.aeS));
                    arrayList.addAll(this.aeN.subList(0, this.aeT));
                } else {
                    arrayList.addAll(this.aeN);
                    arrayList.addAll(0, this.aeN.subList(this.aeN.size() - this.aeT, this.aeN.size()));
                    arrayList.addAll(this.aeN.subList(0, this.aeT));
                }
            } else if (this.aeN != null && this.aeN.size() > 0 && this.aeN.size() >= this.aeT) {
                arrayList.addAll(this.aeN.subList(0, this.aeT));
            }
        }
        return arrayList;
    }

    public int db(int i) {
        if (this.aeP) {
            int size = this.aeO.size();
            if (i == 0) {
                return (size - 1) - this.aeT;
            }
            if (i == size - this.aeT) {
                return this.aeT;
            }
            return i;
        }
        return i;
    }

    public int dc(int i) {
        if (this.aeP) {
            return i - this.aeT;
        }
        return i;
    }

    public int vS() {
        if (this.aeN == null) {
            return 0;
        }
        return this.aeN.size();
    }

    public int vT() {
        if (this.aeP) {
            return this.aeT;
        }
        return 0;
    }

    public void dd(int i) {
        this.aeS = i;
        u(this.aeN);
    }

    public void de(int i) {
        this.aeR = i;
        u(this.aeN);
    }

    public List<v> vU() {
        return this.aeO;
    }

    public void df(int i) {
        this.aeT = i;
        u(this.aeN);
    }
}
