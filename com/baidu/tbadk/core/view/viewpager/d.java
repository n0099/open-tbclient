package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<v> aod;
    private List<v> aoe;
    private boolean aof;
    private boolean aog;
    private int aoi;
    private int aoh = 2;
    private int aoj = 1;

    public d(List<v> list, boolean z, int i) {
        this.aoi = 2;
        this.aod = list;
        this.aog = z;
        this.aoi = i;
        u(list);
    }

    public void u(List<v> list) {
        if (list != null && list.size() >= this.aoh && list.size() <= this.aoi) {
            this.aof = true;
        } else if (list.size() > this.aoi && this.aog) {
            this.aof = true;
        } else {
            this.aof = false;
        }
        this.aoe = xb();
    }

    private List<v> xb() {
        ArrayList arrayList = new ArrayList();
        if (this.aod != null) {
            if (this.aof) {
                if (this.aod.size() > this.aoi && this.aod.size() >= this.aoj) {
                    arrayList.addAll(this.aod.subList(0, this.aoi));
                    arrayList.addAll(0, this.aod.subList(this.aoi - this.aoj, this.aoi));
                    arrayList.addAll(this.aod.subList(0, this.aoj));
                } else {
                    arrayList.addAll(this.aod);
                    arrayList.addAll(0, this.aod.subList(this.aod.size() - this.aoj, this.aod.size()));
                    arrayList.addAll(this.aod.subList(0, this.aoj));
                }
            } else if (this.aod != null && this.aod.size() > 0 && this.aod.size() >= this.aoj) {
                arrayList.addAll(this.aod.subList(0, this.aoj));
            }
        }
        return arrayList;
    }

    public int du(int i) {
        if (this.aof) {
            int size = this.aoe.size();
            if (i == 0) {
                return (size - 1) - this.aoj;
            }
            if (i == size - this.aoj) {
                return this.aoj;
            }
            return i;
        }
        return i;
    }

    public int dv(int i) {
        if (this.aof) {
            return i - this.aoj;
        }
        return i;
    }

    public int xc() {
        if (this.aod == null) {
            return 0;
        }
        return this.aod.size();
    }

    public int xd() {
        if (this.aof) {
            return this.aoj;
        }
        return 0;
    }

    public void dw(int i) {
        this.aoi = i;
        u(this.aod);
    }

    public void dx(int i) {
        this.aoh = i;
        u(this.aod);
    }

    public List<v> xe() {
        return this.aoe;
    }

    public void dy(int i) {
        this.aoj = i;
        u(this.aod);
    }
}
