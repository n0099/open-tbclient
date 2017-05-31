package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<v> and;
    private List<v> ane;
    private boolean anf;
    private boolean ang;
    private int ani;
    private int anh = 2;
    private int anj = 1;

    public d(List<v> list, boolean z, int i) {
        this.ani = 2;
        this.and = list;
        this.ang = z;
        this.ani = i;
        s(list);
    }

    public void s(List<v> list) {
        if (list != null && list.size() >= this.anh && list.size() <= this.ani) {
            this.anf = true;
        } else if (list.size() > this.ani && this.ang) {
            this.anf = true;
        } else {
            this.anf = false;
        }
        this.ane = wJ();
    }

    private List<v> wJ() {
        ArrayList arrayList = new ArrayList();
        if (this.and != null) {
            if (this.anf) {
                if (this.and.size() > this.ani && this.and.size() >= this.anj) {
                    arrayList.addAll(this.and.subList(0, this.ani));
                    arrayList.addAll(0, this.and.subList(this.ani - this.anj, this.ani));
                    arrayList.addAll(this.and.subList(0, this.anj));
                } else {
                    arrayList.addAll(this.and);
                    arrayList.addAll(0, this.and.subList(this.and.size() - this.anj, this.and.size()));
                    arrayList.addAll(this.and.subList(0, this.anj));
                }
            } else if (this.and != null && this.and.size() > 0 && this.and.size() >= this.anj) {
                arrayList.addAll(this.and.subList(0, this.anj));
            }
        }
        return arrayList;
    }

    public int ds(int i) {
        if (this.anf) {
            int size = this.ane.size();
            if (i == 0) {
                return (size - 1) - this.anj;
            }
            if (i == size - this.anj) {
                return this.anj;
            }
            return i;
        }
        return i;
    }

    public int dt(int i) {
        if (this.anf) {
            return i - this.anj;
        }
        return i;
    }

    public int wK() {
        if (this.and == null) {
            return 0;
        }
        return this.and.size();
    }

    public int wL() {
        if (this.anf) {
            return this.anj;
        }
        return 0;
    }

    public void du(int i) {
        this.ani = i;
        s(this.and);
    }

    public void dv(int i) {
        this.anh = i;
        s(this.and);
    }

    public List<v> wM() {
        return this.ane;
    }

    public void dw(int i) {
        this.anj = i;
        s(this.and);
    }
}
