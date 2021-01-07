package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private int frn;
    private List<n> fru;
    private List<n> frv;
    private boolean frw;
    private boolean frx;
    private int fry = 2;
    private int frz = 1;

    public c(List<n> list, boolean z, int i) {
        this.frn = 2;
        this.fru = list;
        this.frx = z;
        this.frn = i;
        bG(list);
    }

    public void bG(List<n> list) {
        if (list != null && list.size() >= this.fry && list.size() <= this.frn) {
            this.frw = true;
        } else if (list.size() > this.frn && this.frx) {
            this.frw = true;
        } else {
            this.frw = false;
        }
        this.frv = byY();
    }

    private List<n> byY() {
        ArrayList arrayList = new ArrayList();
        if (this.fru != null) {
            if (this.frw) {
                if (this.fru.size() > this.frn && this.fru.size() >= this.frz) {
                    arrayList.addAll(this.fru.subList(0, this.frn));
                    arrayList.addAll(0, this.fru.subList(this.frn - this.frz, this.frn));
                    arrayList.addAll(this.fru.subList(0, this.frz));
                } else {
                    arrayList.addAll(this.fru);
                    arrayList.addAll(0, this.fru.subList(this.fru.size() - this.frz, this.fru.size()));
                    arrayList.addAll(this.fru.subList(0, this.frz));
                }
            } else if (this.fru != null && this.fru.size() > 0 && this.fru.size() >= this.frz) {
                arrayList.addAll(this.fru.subList(0, this.frz));
            }
        }
        return arrayList;
    }

    public int rG(int i) {
        if (this.frw) {
            int size = this.frv.size();
            if (i == 0) {
                return (size - 1) - this.frz;
            }
            if (i == size - this.frz) {
                return this.frz;
            }
            return i;
        }
        return i;
    }

    public int rH(int i) {
        if (this.frw) {
            return i - this.frz;
        }
        return i;
    }

    public int byZ() {
        if (this.fru == null) {
            return 0;
        }
        return this.fru.size();
    }

    public int bza() {
        if (this.frw) {
            return this.frz;
        }
        return 0;
    }

    public void rI(int i) {
        this.frn = i;
        bG(this.fru);
    }

    public void rJ(int i) {
        this.fry = i;
        bG(this.fru);
    }

    public List<n> bzb() {
        return this.frv;
    }

    public void rK(int i) {
        this.frz = i;
        bG(this.fru);
    }
}
