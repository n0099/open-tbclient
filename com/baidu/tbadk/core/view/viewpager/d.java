package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<f> aoU;
    private List<f> aoV;
    private boolean aoW;
    private boolean aoX;
    private int aoZ;
    private int aoY = 2;
    private int apa = 1;

    public d(List<f> list, boolean z, int i) {
        this.aoZ = 2;
        this.aoU = list;
        this.aoX = z;
        this.aoZ = i;
        w(list);
    }

    public void w(List<f> list) {
        if (list != null && list.size() >= this.aoY && list.size() <= this.aoZ) {
            this.aoW = true;
        } else if (list.size() > this.aoZ && this.aoX) {
            this.aoW = true;
        } else {
            this.aoW = false;
        }
        this.aoV = xm();
    }

    private List<f> xm() {
        ArrayList arrayList = new ArrayList();
        if (this.aoU != null) {
            if (this.aoW) {
                if (this.aoU.size() > this.aoZ && this.aoU.size() >= this.apa) {
                    arrayList.addAll(this.aoU.subList(0, this.aoZ));
                    arrayList.addAll(0, this.aoU.subList(this.aoZ - this.apa, this.aoZ));
                    arrayList.addAll(this.aoU.subList(0, this.apa));
                } else {
                    arrayList.addAll(this.aoU);
                    arrayList.addAll(0, this.aoU.subList(this.aoU.size() - this.apa, this.aoU.size()));
                    arrayList.addAll(this.aoU.subList(0, this.apa));
                }
            } else if (this.aoU != null && this.aoU.size() > 0 && this.aoU.size() >= this.apa) {
                arrayList.addAll(this.aoU.subList(0, this.apa));
            }
        }
        return arrayList;
    }

    public int dw(int i) {
        if (this.aoW) {
            int size = this.aoV.size();
            if (i == 0) {
                return (size - 1) - this.apa;
            }
            if (i == size - this.apa) {
                return this.apa;
            }
            return i;
        }
        return i;
    }

    public int dx(int i) {
        if (this.aoW) {
            return i - this.apa;
        }
        return i;
    }

    public int xn() {
        if (this.aoU == null) {
            return 0;
        }
        return this.aoU.size();
    }

    public int xo() {
        if (this.aoW) {
            return this.apa;
        }
        return 0;
    }

    public void dy(int i) {
        this.aoZ = i;
        w(this.aoU);
    }

    public void dz(int i) {
        this.aoY = i;
        w(this.aoU);
    }

    public List<f> xp() {
        return this.aoV;
    }

    public void dA(int i) {
        this.apa = i;
        w(this.aoU);
    }
}
