package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<i> bfF;
    private List<i> bfG;
    private boolean bfH;
    private boolean bfI;
    private int bfK;
    private int bfJ = 2;
    private int bfL = 1;

    public d(List<i> list, boolean z, int i) {
        this.bfK = 2;
        this.bfF = list;
        this.bfI = z;
        this.bfK = i;
        F(list);
    }

    public void F(List<i> list) {
        if (list != null && list.size() >= this.bfJ && list.size() <= this.bfK) {
            this.bfH = true;
        } else if (list.size() > this.bfK && this.bfI) {
            this.bfH = true;
        } else {
            this.bfH = false;
        }
        this.bfG = EI();
    }

    private List<i> EI() {
        ArrayList arrayList = new ArrayList();
        if (this.bfF != null) {
            if (this.bfH) {
                if (this.bfF.size() > this.bfK && this.bfF.size() >= this.bfL) {
                    arrayList.addAll(this.bfF.subList(0, this.bfK));
                    arrayList.addAll(0, this.bfF.subList(this.bfK - this.bfL, this.bfK));
                    arrayList.addAll(this.bfF.subList(0, this.bfL));
                } else {
                    arrayList.addAll(this.bfF);
                    arrayList.addAll(0, this.bfF.subList(this.bfF.size() - this.bfL, this.bfF.size()));
                    arrayList.addAll(this.bfF.subList(0, this.bfL));
                }
            } else if (this.bfF != null && this.bfF.size() > 0 && this.bfF.size() >= this.bfL) {
                arrayList.addAll(this.bfF.subList(0, this.bfL));
            }
        }
        return arrayList;
    }

    public int gG(int i) {
        if (this.bfH) {
            int size = this.bfG.size();
            if (i == 0) {
                return (size - 1) - this.bfL;
            }
            if (i == size - this.bfL) {
                return this.bfL;
            }
            return i;
        }
        return i;
    }

    public int gH(int i) {
        if (this.bfH) {
            return i - this.bfL;
        }
        return i;
    }

    public int EJ() {
        if (this.bfF == null) {
            return 0;
        }
        return this.bfF.size();
    }

    public int EK() {
        if (this.bfH) {
            return this.bfL;
        }
        return 0;
    }

    public void gI(int i) {
        this.bfK = i;
        F(this.bfF);
    }

    public void gJ(int i) {
        this.bfJ = i;
        F(this.bfF);
    }

    public List<i> EL() {
        return this.bfG;
    }

    public void gK(int i) {
        this.bfL = i;
        F(this.bfF);
    }
}
