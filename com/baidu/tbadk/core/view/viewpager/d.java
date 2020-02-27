package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<m> dkF;
    private List<m> dkG;
    private boolean dkH;
    private boolean dkI;
    private int dkJ = 2;
    private int dkK = 1;
    private int dkz;

    public d(List<m> list, boolean z, int i) {
        this.dkz = 2;
        this.dkF = list;
        this.dkI = z;
        this.dkz = i;
        aD(list);
    }

    public void aD(List<m> list) {
        if (list != null && list.size() >= this.dkJ && list.size() <= this.dkz) {
            this.dkH = true;
        } else if (list.size() > this.dkz && this.dkI) {
            this.dkH = true;
        } else {
            this.dkH = false;
        }
        this.dkG = aIA();
    }

    private List<m> aIA() {
        ArrayList arrayList = new ArrayList();
        if (this.dkF != null) {
            if (this.dkH) {
                if (this.dkF.size() > this.dkz && this.dkF.size() >= this.dkK) {
                    arrayList.addAll(this.dkF.subList(0, this.dkz));
                    arrayList.addAll(0, this.dkF.subList(this.dkz - this.dkK, this.dkz));
                    arrayList.addAll(this.dkF.subList(0, this.dkK));
                } else {
                    arrayList.addAll(this.dkF);
                    arrayList.addAll(0, this.dkF.subList(this.dkF.size() - this.dkK, this.dkF.size()));
                    arrayList.addAll(this.dkF.subList(0, this.dkK));
                }
            } else if (this.dkF != null && this.dkF.size() > 0 && this.dkF.size() >= this.dkK) {
                arrayList.addAll(this.dkF.subList(0, this.dkK));
            }
        }
        return arrayList;
    }

    public int lB(int i) {
        if (this.dkH) {
            int size = this.dkG.size();
            if (i == 0) {
                return (size - 1) - this.dkK;
            }
            if (i == size - this.dkK) {
                return this.dkK;
            }
            return i;
        }
        return i;
    }

    public int lC(int i) {
        if (this.dkH) {
            return i - this.dkK;
        }
        return i;
    }

    public int aIB() {
        if (this.dkF == null) {
            return 0;
        }
        return this.dkF.size();
    }

    public int aIC() {
        if (this.dkH) {
            return this.dkK;
        }
        return 0;
    }

    public void lD(int i) {
        this.dkz = i;
        aD(this.dkF);
    }

    public void lE(int i) {
        this.dkJ = i;
        aD(this.dkF);
    }

    public List<m> aID() {
        return this.dkG;
    }

    public void lF(int i) {
        this.dkK = i;
        aD(this.dkF);
    }
}
