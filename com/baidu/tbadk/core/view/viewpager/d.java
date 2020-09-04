package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int eyB;
    private List<q> eyH;
    private List<q> eyI;
    private boolean eyJ;
    private boolean eyK;
    private int eyL = 2;
    private int eyM = 1;

    public d(List<q> list, boolean z, int i) {
        this.eyB = 2;
        this.eyH = list;
        this.eyK = z;
        this.eyB = i;
        aX(list);
    }

    public void aX(List<q> list) {
        if (list != null && list.size() >= this.eyL && list.size() <= this.eyB) {
            this.eyJ = true;
        } else if (list.size() > this.eyB && this.eyK) {
            this.eyJ = true;
        } else {
            this.eyJ = false;
        }
        this.eyI = blR();
    }

    private List<q> blR() {
        ArrayList arrayList = new ArrayList();
        if (this.eyH != null) {
            if (this.eyJ) {
                if (this.eyH.size() > this.eyB && this.eyH.size() >= this.eyM) {
                    arrayList.addAll(this.eyH.subList(0, this.eyB));
                    arrayList.addAll(0, this.eyH.subList(this.eyB - this.eyM, this.eyB));
                    arrayList.addAll(this.eyH.subList(0, this.eyM));
                } else {
                    arrayList.addAll(this.eyH);
                    arrayList.addAll(0, this.eyH.subList(this.eyH.size() - this.eyM, this.eyH.size()));
                    arrayList.addAll(this.eyH.subList(0, this.eyM));
                }
            } else if (this.eyH != null && this.eyH.size() > 0 && this.eyH.size() >= this.eyM) {
                arrayList.addAll(this.eyH.subList(0, this.eyM));
            }
        }
        return arrayList;
    }

    public int pp(int i) {
        if (this.eyJ) {
            int size = this.eyI.size();
            if (i == 0) {
                return (size - 1) - this.eyM;
            }
            if (i == size - this.eyM) {
                return this.eyM;
            }
            return i;
        }
        return i;
    }

    public int pq(int i) {
        if (this.eyJ) {
            return i - this.eyM;
        }
        return i;
    }

    public int blS() {
        if (this.eyH == null) {
            return 0;
        }
        return this.eyH.size();
    }

    public int blT() {
        if (this.eyJ) {
            return this.eyM;
        }
        return 0;
    }

    public void pr(int i) {
        this.eyB = i;
        aX(this.eyH);
    }

    public void ps(int i) {
        this.eyL = i;
        aX(this.eyH);
    }

    public List<q> blU() {
        return this.eyI;
    }

    public void pt(int i) {
        this.eyM = i;
        aX(this.eyH);
    }
}
