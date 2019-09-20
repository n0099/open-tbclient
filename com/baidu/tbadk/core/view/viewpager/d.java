package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int ceY;
    private List<m> cff;
    private List<m> cfg;
    private boolean cfh;
    private boolean cfi;
    private int cfj = 2;
    private int cfk = 1;

    public d(List<m> list, boolean z, int i) {
        this.ceY = 2;
        this.cff = list;
        this.cfi = z;
        this.ceY = i;
        ad(list);
    }

    public void ad(List<m> list) {
        if (list != null && list.size() >= this.cfj && list.size() <= this.ceY) {
            this.cfh = true;
        } else if (list.size() > this.ceY && this.cfi) {
            this.cfh = true;
        } else {
            this.cfh = false;
        }
        this.cfg = alD();
    }

    private List<m> alD() {
        ArrayList arrayList = new ArrayList();
        if (this.cff != null) {
            if (this.cfh) {
                if (this.cff.size() > this.ceY && this.cff.size() >= this.cfk) {
                    arrayList.addAll(this.cff.subList(0, this.ceY));
                    arrayList.addAll(0, this.cff.subList(this.ceY - this.cfk, this.ceY));
                    arrayList.addAll(this.cff.subList(0, this.cfk));
                } else {
                    arrayList.addAll(this.cff);
                    arrayList.addAll(0, this.cff.subList(this.cff.size() - this.cfk, this.cff.size()));
                    arrayList.addAll(this.cff.subList(0, this.cfk));
                }
            } else if (this.cff != null && this.cff.size() > 0 && this.cff.size() >= this.cfk) {
                arrayList.addAll(this.cff.subList(0, this.cfk));
            }
        }
        return arrayList;
    }

    public int jm(int i) {
        if (this.cfh) {
            int size = this.cfg.size();
            if (i == 0) {
                return (size - 1) - this.cfk;
            }
            if (i == size - this.cfk) {
                return this.cfk;
            }
            return i;
        }
        return i;
    }

    public int jn(int i) {
        if (this.cfh) {
            return i - this.cfk;
        }
        return i;
    }

    public int alE() {
        if (this.cff == null) {
            return 0;
        }
        return this.cff.size();
    }

    public int alF() {
        if (this.cfh) {
            return this.cfk;
        }
        return 0;
    }

    public void jo(int i) {
        this.ceY = i;
        ad(this.cff);
    }

    public void jp(int i) {
        this.cfj = i;
        ad(this.cff);
    }

    public List<m> alG() {
        return this.cfg;
    }

    public void jq(int i) {
        this.cfk = i;
        ad(this.cff);
    }
}
