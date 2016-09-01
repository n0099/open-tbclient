package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private int aiB;
    private List<v> aiw;
    private List<v> aix;
    private boolean aiy;
    private boolean aiz;
    private int aiA = 2;
    private int aiC = 1;

    public c(List<v> list, boolean z, int i) {
        this.aiB = 2;
        this.aiw = list;
        this.aiz = z;
        this.aiB = i;
        u(list);
    }

    public void u(List<v> list) {
        if (list != null && list.size() >= this.aiA && list.size() <= this.aiB) {
            this.aiy = true;
        } else if (list.size() > this.aiB && this.aiz) {
            this.aiy = true;
        } else {
            this.aiy = false;
        }
        this.aix = wV();
    }

    private List<v> wV() {
        ArrayList arrayList = new ArrayList();
        if (this.aiw != null) {
            if (this.aiy) {
                if (this.aiw.size() > this.aiB && this.aiw.size() >= this.aiC) {
                    arrayList.addAll(this.aiw.subList(0, this.aiB));
                    arrayList.addAll(0, this.aiw.subList(this.aiB - this.aiC, this.aiB));
                    arrayList.addAll(this.aiw.subList(0, this.aiC));
                } else {
                    arrayList.addAll(this.aiw);
                    arrayList.addAll(0, this.aiw.subList(this.aiw.size() - this.aiC, this.aiw.size()));
                    arrayList.addAll(this.aiw.subList(0, this.aiC));
                }
            } else if (this.aiw != null && this.aiw.size() > 0 && this.aiw.size() >= this.aiC) {
                arrayList.addAll(this.aiw.subList(0, this.aiC));
            }
        }
        return arrayList;
    }

    public int dp(int i) {
        if (this.aiy) {
            int size = this.aix.size();
            if (i == 0) {
                return (size - 1) - this.aiC;
            }
            if (i == size - this.aiC) {
                return this.aiC;
            }
            return i;
        }
        return i;
    }

    public int dq(int i) {
        if (this.aiy) {
            return i - this.aiC;
        }
        return i;
    }

    public int wW() {
        if (this.aiw == null) {
            return 0;
        }
        return this.aiw.size();
    }

    public int wX() {
        if (this.aiy) {
            return this.aiC;
        }
        return 0;
    }

    public void dr(int i) {
        this.aiB = i;
        u(this.aiw);
    }

    public void ds(int i) {
        this.aiA = i;
        u(this.aiw);
    }

    public List<v> wY() {
        return this.aix;
    }

    public void dt(int i) {
        this.aiC = i;
        u(this.aiw);
    }
}
