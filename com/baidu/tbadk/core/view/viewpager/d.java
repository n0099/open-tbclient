package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int aLS;
    private List<h> aLZ;
    private List<h> aMa;
    private boolean aMb;
    private boolean aMc;
    private int aMd = 2;
    private int aMe = 1;

    public d(List<h> list, boolean z, int i) {
        this.aLS = 2;
        this.aLZ = list;
        this.aMc = z;
        this.aLS = i;
        K(list);
    }

    public void K(List<h> list) {
        if (list != null && list.size() >= this.aMd && list.size() <= this.aLS) {
            this.aMb = true;
        } else if (list.size() > this.aLS && this.aMc) {
            this.aMb = true;
        } else {
            this.aMb = false;
        }
        this.aMa = FG();
    }

    private List<h> FG() {
        ArrayList arrayList = new ArrayList();
        if (this.aLZ != null) {
            if (this.aMb) {
                if (this.aLZ.size() > this.aLS && this.aLZ.size() >= this.aMe) {
                    arrayList.addAll(this.aLZ.subList(0, this.aLS));
                    arrayList.addAll(0, this.aLZ.subList(this.aLS - this.aMe, this.aLS));
                    arrayList.addAll(this.aLZ.subList(0, this.aMe));
                } else {
                    arrayList.addAll(this.aLZ);
                    arrayList.addAll(0, this.aLZ.subList(this.aLZ.size() - this.aMe, this.aLZ.size()));
                    arrayList.addAll(this.aLZ.subList(0, this.aMe));
                }
            } else if (this.aLZ != null && this.aLZ.size() > 0 && this.aLZ.size() >= this.aMe) {
                arrayList.addAll(this.aLZ.subList(0, this.aMe));
            }
        }
        return arrayList;
    }

    public int eI(int i) {
        if (this.aMb) {
            int size = this.aMa.size();
            if (i == 0) {
                return (size - 1) - this.aMe;
            }
            if (i == size - this.aMe) {
                return this.aMe;
            }
            return i;
        }
        return i;
    }

    public int eJ(int i) {
        if (this.aMb) {
            return i - this.aMe;
        }
        return i;
    }

    public int FH() {
        if (this.aLZ == null) {
            return 0;
        }
        return this.aLZ.size();
    }

    public int FI() {
        if (this.aMb) {
            return this.aMe;
        }
        return 0;
    }

    public void eK(int i) {
        this.aLS = i;
        K(this.aLZ);
    }

    public void eL(int i) {
        this.aMd = i;
        K(this.aLZ);
    }

    public List<h> FJ() {
        return this.aMa;
    }

    public void eM(int i) {
        this.aMe = i;
        K(this.aLZ);
    }
}
