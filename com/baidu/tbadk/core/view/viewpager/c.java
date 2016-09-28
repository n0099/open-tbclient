package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private List<v> ahY;
    private List<v> ahZ;
    private boolean aia;
    private boolean aib;
    private int aid;
    private int aic = 2;
    private int aie = 1;

    public c(List<v> list, boolean z, int i) {
        this.aid = 2;
        this.ahY = list;
        this.aib = z;
        this.aid = i;
        u(list);
    }

    public void u(List<v> list) {
        if (list != null && list.size() >= this.aic && list.size() <= this.aid) {
            this.aia = true;
        } else if (list.size() > this.aid && this.aib) {
            this.aia = true;
        } else {
            this.aia = false;
        }
        this.ahZ = wX();
    }

    private List<v> wX() {
        ArrayList arrayList = new ArrayList();
        if (this.ahY != null) {
            if (this.aia) {
                if (this.ahY.size() > this.aid && this.ahY.size() >= this.aie) {
                    arrayList.addAll(this.ahY.subList(0, this.aid));
                    arrayList.addAll(0, this.ahY.subList(this.aid - this.aie, this.aid));
                    arrayList.addAll(this.ahY.subList(0, this.aie));
                } else {
                    arrayList.addAll(this.ahY);
                    arrayList.addAll(0, this.ahY.subList(this.ahY.size() - this.aie, this.ahY.size()));
                    arrayList.addAll(this.ahY.subList(0, this.aie));
                }
            } else if (this.ahY != null && this.ahY.size() > 0 && this.ahY.size() >= this.aie) {
                arrayList.addAll(this.ahY.subList(0, this.aie));
            }
        }
        return arrayList;
    }

    public int dp(int i) {
        if (this.aia) {
            int size = this.ahZ.size();
            if (i == 0) {
                return (size - 1) - this.aie;
            }
            if (i == size - this.aie) {
                return this.aie;
            }
            return i;
        }
        return i;
    }

    public int dq(int i) {
        if (this.aia) {
            return i - this.aie;
        }
        return i;
    }

    public int wY() {
        if (this.ahY == null) {
            return 0;
        }
        return this.ahY.size();
    }

    public int wZ() {
        if (this.aia) {
            return this.aie;
        }
        return 0;
    }

    public void dr(int i) {
        this.aid = i;
        u(this.ahY);
    }

    public void ds(int i) {
        this.aic = i;
        u(this.ahY);
    }

    public List<v> xa() {
        return this.ahZ;
    }

    public void dt(int i) {
        this.aie = i;
        u(this.ahY);
    }
}
