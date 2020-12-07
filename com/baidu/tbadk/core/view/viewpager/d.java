package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int fhC;
    private List<q> fhI;
    private List<q> fhJ;
    private boolean fhK;
    private boolean fhL;
    private int fhM = 2;
    private int fhN = 1;

    public d(List<q> list, boolean z, int i) {
        this.fhC = 2;
        this.fhI = list;
        this.fhL = z;
        this.fhC = i;
        bz(list);
    }

    public void bz(List<q> list) {
        if (list != null && list.size() >= this.fhM && list.size() <= this.fhC) {
            this.fhK = true;
        } else if (list.size() > this.fhC && this.fhL) {
            this.fhK = true;
        } else {
            this.fhK = false;
        }
        this.fhJ = bwE();
    }

    private List<q> bwE() {
        ArrayList arrayList = new ArrayList();
        if (this.fhI != null) {
            if (this.fhK) {
                if (this.fhI.size() > this.fhC && this.fhI.size() >= this.fhN) {
                    arrayList.addAll(this.fhI.subList(0, this.fhC));
                    arrayList.addAll(0, this.fhI.subList(this.fhC - this.fhN, this.fhC));
                    arrayList.addAll(this.fhI.subList(0, this.fhN));
                } else {
                    arrayList.addAll(this.fhI);
                    arrayList.addAll(0, this.fhI.subList(this.fhI.size() - this.fhN, this.fhI.size()));
                    arrayList.addAll(this.fhI.subList(0, this.fhN));
                }
            } else if (this.fhI != null && this.fhI.size() > 0 && this.fhI.size() >= this.fhN) {
                arrayList.addAll(this.fhI.subList(0, this.fhN));
            }
        }
        return arrayList;
    }

    public int ru(int i) {
        if (this.fhK) {
            int size = this.fhJ.size();
            if (i == 0) {
                return (size - 1) - this.fhN;
            }
            if (i == size - this.fhN) {
                return this.fhN;
            }
            return i;
        }
        return i;
    }

    public int rv(int i) {
        if (this.fhK) {
            return i - this.fhN;
        }
        return i;
    }

    public int bwF() {
        if (this.fhI == null) {
            return 0;
        }
        return this.fhI.size();
    }

    public int bwG() {
        if (this.fhK) {
            return this.fhN;
        }
        return 0;
    }

    public void rw(int i) {
        this.fhC = i;
        bz(this.fhI);
    }

    public void rx(int i) {
        this.fhM = i;
        bz(this.fhI);
    }

    public List<q> bwH() {
        return this.fhJ;
    }

    public void ry(int i) {
        this.fhN = i;
        bz(this.fhI);
    }
}
