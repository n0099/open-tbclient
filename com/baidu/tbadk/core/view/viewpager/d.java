package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int aHC;
    private List<h> aHJ;
    private List<h> aHK;
    private boolean aHL;
    private boolean aHM;
    private int aHN = 2;
    private int aHO = 1;

    public d(List<h> list, boolean z, int i) {
        this.aHC = 2;
        this.aHJ = list;
        this.aHM = z;
        this.aHC = i;
        L(list);
    }

    public void L(List<h> list) {
        if (list != null && list.size() >= this.aHN && list.size() <= this.aHC) {
            this.aHL = true;
        } else if (list.size() > this.aHC && this.aHM) {
            this.aHL = true;
        } else {
            this.aHL = false;
        }
        this.aHK = Es();
    }

    private List<h> Es() {
        ArrayList arrayList = new ArrayList();
        if (this.aHJ != null) {
            if (this.aHL) {
                if (this.aHJ.size() > this.aHC && this.aHJ.size() >= this.aHO) {
                    arrayList.addAll(this.aHJ.subList(0, this.aHC));
                    arrayList.addAll(0, this.aHJ.subList(this.aHC - this.aHO, this.aHC));
                    arrayList.addAll(this.aHJ.subList(0, this.aHO));
                } else {
                    arrayList.addAll(this.aHJ);
                    arrayList.addAll(0, this.aHJ.subList(this.aHJ.size() - this.aHO, this.aHJ.size()));
                    arrayList.addAll(this.aHJ.subList(0, this.aHO));
                }
            } else if (this.aHJ != null && this.aHJ.size() > 0 && this.aHJ.size() >= this.aHO) {
                arrayList.addAll(this.aHJ.subList(0, this.aHO));
            }
        }
        return arrayList;
    }

    public int eg(int i) {
        if (this.aHL) {
            int size = this.aHK.size();
            if (i == 0) {
                return (size - 1) - this.aHO;
            }
            if (i == size - this.aHO) {
                return this.aHO;
            }
            return i;
        }
        return i;
    }

    public int eh(int i) {
        if (this.aHL) {
            return i - this.aHO;
        }
        return i;
    }

    public int Et() {
        if (this.aHJ == null) {
            return 0;
        }
        return this.aHJ.size();
    }

    public int Eu() {
        if (this.aHL) {
            return this.aHO;
        }
        return 0;
    }

    public void ei(int i) {
        this.aHC = i;
        L(this.aHJ);
    }

    public void ej(int i) {
        this.aHN = i;
        L(this.aHJ);
    }

    public List<h> Ev() {
        return this.aHK;
    }

    public void ek(int i) {
        this.aHO = i;
        L(this.aHJ);
    }
}
