package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<h> aAa;
    private boolean aAb;
    private boolean aAc;
    private int aAd = 2;
    private int aAe = 1;
    private int azS;
    private List<h> azZ;

    public d(List<h> list, boolean z, int i) {
        this.azS = 2;
        this.azZ = list;
        this.aAc = z;
        this.azS = i;
        A(list);
    }

    public void A(List<h> list) {
        if (list != null && list.size() >= this.aAd && list.size() <= this.azS) {
            this.aAb = true;
        } else if (list.size() > this.azS && this.aAc) {
            this.aAb = true;
        } else {
            this.aAb = false;
        }
        this.aAa = Bb();
    }

    private List<h> Bb() {
        ArrayList arrayList = new ArrayList();
        if (this.azZ != null) {
            if (this.aAb) {
                if (this.azZ.size() > this.azS && this.azZ.size() >= this.aAe) {
                    arrayList.addAll(this.azZ.subList(0, this.azS));
                    arrayList.addAll(0, this.azZ.subList(this.azS - this.aAe, this.azS));
                    arrayList.addAll(this.azZ.subList(0, this.aAe));
                } else {
                    arrayList.addAll(this.azZ);
                    arrayList.addAll(0, this.azZ.subList(this.azZ.size() - this.aAe, this.azZ.size()));
                    arrayList.addAll(this.azZ.subList(0, this.aAe));
                }
            } else if (this.azZ != null && this.azZ.size() > 0 && this.azZ.size() >= this.aAe) {
                arrayList.addAll(this.azZ.subList(0, this.aAe));
            }
        }
        return arrayList;
    }

    public int dK(int i) {
        if (this.aAb) {
            int size = this.aAa.size();
            if (i == 0) {
                return (size - 1) - this.aAe;
            }
            if (i == size - this.aAe) {
                return this.aAe;
            }
            return i;
        }
        return i;
    }

    public int dL(int i) {
        if (this.aAb) {
            return i - this.aAe;
        }
        return i;
    }

    public int Bc() {
        if (this.azZ == null) {
            return 0;
        }
        return this.azZ.size();
    }

    public int Bd() {
        if (this.aAb) {
            return this.aAe;
        }
        return 0;
    }

    public void dM(int i) {
        this.azS = i;
        A(this.azZ);
    }

    public void dN(int i) {
        this.aAd = i;
        A(this.azZ);
    }

    public List<h> Be() {
        return this.aAa;
    }

    public void dO(int i) {
        this.aAe = i;
        A(this.azZ);
    }
}
