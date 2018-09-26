package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int aCW;
    private List<h> aDd;
    private List<h> aDe;
    private boolean aDf;
    private boolean aDg;
    private int aDh = 2;
    private int aDi = 1;

    public d(List<h> list, boolean z, int i) {
        this.aCW = 2;
        this.aDd = list;
        this.aDg = z;
        this.aCW = i;
        B(list);
    }

    public void B(List<h> list) {
        if (list != null && list.size() >= this.aDh && list.size() <= this.aCW) {
            this.aDf = true;
        } else if (list.size() > this.aCW && this.aDg) {
            this.aDf = true;
        } else {
            this.aDf = false;
        }
        this.aDe = Cn();
    }

    private List<h> Cn() {
        ArrayList arrayList = new ArrayList();
        if (this.aDd != null) {
            if (this.aDf) {
                if (this.aDd.size() > this.aCW && this.aDd.size() >= this.aDi) {
                    arrayList.addAll(this.aDd.subList(0, this.aCW));
                    arrayList.addAll(0, this.aDd.subList(this.aCW - this.aDi, this.aCW));
                    arrayList.addAll(this.aDd.subList(0, this.aDi));
                } else {
                    arrayList.addAll(this.aDd);
                    arrayList.addAll(0, this.aDd.subList(this.aDd.size() - this.aDi, this.aDd.size()));
                    arrayList.addAll(this.aDd.subList(0, this.aDi));
                }
            } else if (this.aDd != null && this.aDd.size() > 0 && this.aDd.size() >= this.aDi) {
                arrayList.addAll(this.aDd.subList(0, this.aDi));
            }
        }
        return arrayList;
    }

    public int dW(int i) {
        if (this.aDf) {
            int size = this.aDe.size();
            if (i == 0) {
                return (size - 1) - this.aDi;
            }
            if (i == size - this.aDi) {
                return this.aDi;
            }
            return i;
        }
        return i;
    }

    public int dX(int i) {
        if (this.aDf) {
            return i - this.aDi;
        }
        return i;
    }

    public int Co() {
        if (this.aDd == null) {
            return 0;
        }
        return this.aDd.size();
    }

    public int Cp() {
        if (this.aDf) {
            return this.aDi;
        }
        return 0;
    }

    public void dY(int i) {
        this.aCW = i;
        B(this.aDd);
    }

    public void dZ(int i) {
        this.aDh = i;
        B(this.aDd);
    }

    public List<h> Cq() {
        return this.aDe;
    }

    public void ea(int i) {
        this.aDi = i;
        B(this.aDd);
    }
}
