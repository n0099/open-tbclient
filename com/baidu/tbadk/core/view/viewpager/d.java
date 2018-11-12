package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<h> aIA;
    private boolean aIB;
    private boolean aIC;
    private int aID = 2;
    private int aIE = 1;
    private int aIs;
    private List<h> aIz;

    public d(List<h> list, boolean z, int i) {
        this.aIs = 2;
        this.aIz = list;
        this.aIC = z;
        this.aIs = i;
        K(list);
    }

    public void K(List<h> list) {
        if (list != null && list.size() >= this.aID && list.size() <= this.aIs) {
            this.aIB = true;
        } else if (list.size() > this.aIs && this.aIC) {
            this.aIB = true;
        } else {
            this.aIB = false;
        }
        this.aIA = EC();
    }

    private List<h> EC() {
        ArrayList arrayList = new ArrayList();
        if (this.aIz != null) {
            if (this.aIB) {
                if (this.aIz.size() > this.aIs && this.aIz.size() >= this.aIE) {
                    arrayList.addAll(this.aIz.subList(0, this.aIs));
                    arrayList.addAll(0, this.aIz.subList(this.aIs - this.aIE, this.aIs));
                    arrayList.addAll(this.aIz.subList(0, this.aIE));
                } else {
                    arrayList.addAll(this.aIz);
                    arrayList.addAll(0, this.aIz.subList(this.aIz.size() - this.aIE, this.aIz.size()));
                    arrayList.addAll(this.aIz.subList(0, this.aIE));
                }
            } else if (this.aIz != null && this.aIz.size() > 0 && this.aIz.size() >= this.aIE) {
                arrayList.addAll(this.aIz.subList(0, this.aIE));
            }
        }
        return arrayList;
    }

    public int eu(int i) {
        if (this.aIB) {
            int size = this.aIA.size();
            if (i == 0) {
                return (size - 1) - this.aIE;
            }
            if (i == size - this.aIE) {
                return this.aIE;
            }
            return i;
        }
        return i;
    }

    public int ev(int i) {
        if (this.aIB) {
            return i - this.aIE;
        }
        return i;
    }

    public int ED() {
        if (this.aIz == null) {
            return 0;
        }
        return this.aIz.size();
    }

    public int EE() {
        if (this.aIB) {
            return this.aIE;
        }
        return 0;
    }

    public void ew(int i) {
        this.aIs = i;
        K(this.aIz);
    }

    public void ex(int i) {
        this.aID = i;
        K(this.aIz);
    }

    public List<h> EF() {
        return this.aIA;
    }

    public void ey(int i) {
        this.aIE = i;
        K(this.aIz);
    }
}
