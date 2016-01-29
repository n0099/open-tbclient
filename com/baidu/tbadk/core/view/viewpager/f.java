package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private int aid;
    private List<u> ail;
    private List<u> aim;
    private boolean ain;
    private boolean aio;
    private int aip = 2;
    private int aiq = 1;

    public f(List<u> list, boolean z, int i) {
        this.aid = 2;
        this.ail = list;
        this.aio = z;
        this.aid = i;
        q(list);
    }

    public void q(List<u> list) {
        if (list != null && list.size() >= this.aip && list.size() <= this.aid) {
            this.ain = true;
        } else if (list.size() > this.aid && this.aio) {
            this.ain = true;
        } else {
            this.ain = false;
        }
        this.aim = xt();
    }

    private List<u> xt() {
        ArrayList arrayList = new ArrayList();
        if (this.ail != null) {
            if (this.ain) {
                if (this.ail.size() > this.aid && this.ail.size() >= this.aiq) {
                    arrayList.addAll(this.ail.subList(0, this.aid));
                    arrayList.addAll(0, this.ail.subList(this.aid - this.aiq, this.aid));
                    arrayList.addAll(this.ail.subList(0, this.aiq));
                } else {
                    arrayList.addAll(this.ail);
                    arrayList.addAll(0, this.ail.subList(this.ail.size() - this.aiq, this.ail.size()));
                    arrayList.addAll(this.ail.subList(0, this.aiq));
                }
            } else if (this.ail != null && this.ail.size() > 0 && this.ail.size() >= this.aiq) {
                arrayList.addAll(this.ail.subList(0, this.aiq));
            }
        }
        return arrayList;
    }

    public int dp(int i) {
        if (this.ain) {
            int size = this.aim.size();
            if (i == 0) {
                return (size - 1) - this.aiq;
            }
            if (i == size - this.aiq) {
                return this.aiq;
            }
            return i;
        }
        return i;
    }

    public int dq(int i) {
        if (this.ain) {
            return i - this.aiq;
        }
        return i;
    }

    public int xu() {
        if (this.ail == null) {
            return 0;
        }
        return this.ail.size();
    }

    public int xv() {
        if (this.ain) {
            return this.aiq;
        }
        return 0;
    }

    public void dr(int i) {
        this.aid = i;
        q(this.ail);
    }

    public void ds(int i) {
        this.aip = i;
        q(this.ail);
    }

    public List<u> xw() {
        return this.aim;
    }

    public void dt(int i) {
        this.aiq = i;
        q(this.ail);
    }
}
