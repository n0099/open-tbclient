package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<f> aqp;
    private List<f> aqq;
    private boolean aqr;
    private boolean aqs;
    private int aqu;
    private int aqt = 2;
    private int aqv = 1;

    public d(List<f> list, boolean z, int i) {
        this.aqu = 2;
        this.aqp = list;
        this.aqs = z;
        this.aqu = i;
        w(list);
    }

    public void w(List<f> list) {
        if (list != null && list.size() >= this.aqt && list.size() <= this.aqu) {
            this.aqr = true;
        } else if (list.size() > this.aqu && this.aqs) {
            this.aqr = true;
        } else {
            this.aqr = false;
        }
        this.aqq = xu();
    }

    private List<f> xu() {
        ArrayList arrayList = new ArrayList();
        if (this.aqp != null) {
            if (this.aqr) {
                if (this.aqp.size() > this.aqu && this.aqp.size() >= this.aqv) {
                    arrayList.addAll(this.aqp.subList(0, this.aqu));
                    arrayList.addAll(0, this.aqp.subList(this.aqu - this.aqv, this.aqu));
                    arrayList.addAll(this.aqp.subList(0, this.aqv));
                } else {
                    arrayList.addAll(this.aqp);
                    arrayList.addAll(0, this.aqp.subList(this.aqp.size() - this.aqv, this.aqp.size()));
                    arrayList.addAll(this.aqp.subList(0, this.aqv));
                }
            } else if (this.aqp != null && this.aqp.size() > 0 && this.aqp.size() >= this.aqv) {
                arrayList.addAll(this.aqp.subList(0, this.aqv));
            }
        }
        return arrayList;
    }

    public int dy(int i) {
        if (this.aqr) {
            int size = this.aqq.size();
            if (i == 0) {
                return (size - 1) - this.aqv;
            }
            if (i == size - this.aqv) {
                return this.aqv;
            }
            return i;
        }
        return i;
    }

    public int dz(int i) {
        if (this.aqr) {
            return i - this.aqv;
        }
        return i;
    }

    public int xv() {
        if (this.aqp == null) {
            return 0;
        }
        return this.aqp.size();
    }

    public int xw() {
        if (this.aqr) {
            return this.aqv;
        }
        return 0;
    }

    public void dA(int i) {
        this.aqu = i;
        w(this.aqp);
    }

    public void dB(int i) {
        this.aqt = i;
        w(this.aqp);
    }

    public List<f> xx() {
        return this.aqq;
    }

    public void dC(int i) {
        this.aqv = i;
        w(this.aqp);
    }
}
