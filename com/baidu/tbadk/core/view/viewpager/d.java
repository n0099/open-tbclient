package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<f> aqo;
    private List<f> aqp;
    private boolean aqq;
    private boolean aqr;
    private int aqt;
    private int aqs = 2;
    private int aqu = 1;

    public d(List<f> list, boolean z, int i) {
        this.aqt = 2;
        this.aqo = list;
        this.aqr = z;
        this.aqt = i;
        w(list);
    }

    public void w(List<f> list) {
        if (list != null && list.size() >= this.aqs && list.size() <= this.aqt) {
            this.aqq = true;
        } else if (list.size() > this.aqt && this.aqr) {
            this.aqq = true;
        } else {
            this.aqq = false;
        }
        this.aqp = xu();
    }

    private List<f> xu() {
        ArrayList arrayList = new ArrayList();
        if (this.aqo != null) {
            if (this.aqq) {
                if (this.aqo.size() > this.aqt && this.aqo.size() >= this.aqu) {
                    arrayList.addAll(this.aqo.subList(0, this.aqt));
                    arrayList.addAll(0, this.aqo.subList(this.aqt - this.aqu, this.aqt));
                    arrayList.addAll(this.aqo.subList(0, this.aqu));
                } else {
                    arrayList.addAll(this.aqo);
                    arrayList.addAll(0, this.aqo.subList(this.aqo.size() - this.aqu, this.aqo.size()));
                    arrayList.addAll(this.aqo.subList(0, this.aqu));
                }
            } else if (this.aqo != null && this.aqo.size() > 0 && this.aqo.size() >= this.aqu) {
                arrayList.addAll(this.aqo.subList(0, this.aqu));
            }
        }
        return arrayList;
    }

    public int dy(int i) {
        if (this.aqq) {
            int size = this.aqp.size();
            if (i == 0) {
                return (size - 1) - this.aqu;
            }
            if (i == size - this.aqu) {
                return this.aqu;
            }
            return i;
        }
        return i;
    }

    public int dz(int i) {
        if (this.aqq) {
            return i - this.aqu;
        }
        return i;
    }

    public int xv() {
        if (this.aqo == null) {
            return 0;
        }
        return this.aqo.size();
    }

    public int xw() {
        if (this.aqq) {
            return this.aqu;
        }
        return 0;
    }

    public void dA(int i) {
        this.aqt = i;
        w(this.aqo);
    }

    public void dB(int i) {
        this.aqs = i;
        w(this.aqo);
    }

    public List<f> xx() {
        return this.aqp;
    }

    public void dC(int i) {
        this.aqu = i;
        w(this.aqo);
    }
}
