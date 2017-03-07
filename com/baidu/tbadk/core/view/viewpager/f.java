package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private int amT;
    private List<v> anb;
    private List<v> anc;
    private boolean and;
    private boolean ane;
    private int anf = 2;
    private int ang = 1;

    public f(List<v> list, boolean z, int i) {
        this.amT = 2;
        this.anb = list;
        this.ane = z;
        this.amT = i;
        r(list);
    }

    public void r(List<v> list) {
        if (list != null && list.size() >= this.anf && list.size() <= this.amT) {
            this.and = true;
        } else if (list.size() > this.amT && this.ane) {
            this.and = true;
        } else {
            this.and = false;
        }
        this.anc = xg();
    }

    private List<v> xg() {
        ArrayList arrayList = new ArrayList();
        if (this.anb != null) {
            if (this.and) {
                if (this.anb.size() > this.amT && this.anb.size() >= this.ang) {
                    arrayList.addAll(this.anb.subList(0, this.amT));
                    arrayList.addAll(0, this.anb.subList(this.amT - this.ang, this.amT));
                    arrayList.addAll(this.anb.subList(0, this.ang));
                } else {
                    arrayList.addAll(this.anb);
                    arrayList.addAll(0, this.anb.subList(this.anb.size() - this.ang, this.anb.size()));
                    arrayList.addAll(this.anb.subList(0, this.ang));
                }
            } else if (this.anb != null && this.anb.size() > 0 && this.anb.size() >= this.ang) {
                arrayList.addAll(this.anb.subList(0, this.ang));
            }
        }
        return arrayList;
    }

    public int dq(int i) {
        if (this.and) {
            int size = this.anc.size();
            if (i == 0) {
                return (size - 1) - this.ang;
            }
            if (i == size - this.ang) {
                return this.ang;
            }
            return i;
        }
        return i;
    }

    public int dr(int i) {
        if (this.and) {
            return i - this.ang;
        }
        return i;
    }

    public int xh() {
        if (this.anb == null) {
            return 0;
        }
        return this.anb.size();
    }

    public int xi() {
        if (this.and) {
            return this.ang;
        }
        return 0;
    }

    public void ds(int i) {
        this.amT = i;
        r(this.anb);
    }

    public void dt(int i) {
        this.anf = i;
        r(this.anb);
    }

    public List<v> xj() {
        return this.anc;
    }

    public void du(int i) {
        this.ang = i;
        r(this.anb);
    }
}
