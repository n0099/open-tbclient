package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<f> apV;
    private List<f> apW;
    private boolean apX;
    private boolean apY;
    private int aqa;
    private int apZ = 2;
    private int aqb = 1;

    public d(List<f> list, boolean z, int i) {
        this.aqa = 2;
        this.apV = list;
        this.apY = z;
        this.aqa = i;
        w(list);
    }

    public void w(List<f> list) {
        if (list != null && list.size() >= this.apZ && list.size() <= this.aqa) {
            this.apX = true;
        } else if (list.size() > this.aqa && this.apY) {
            this.apX = true;
        } else {
            this.apX = false;
        }
        this.apW = xw();
    }

    private List<f> xw() {
        ArrayList arrayList = new ArrayList();
        if (this.apV != null) {
            if (this.apX) {
                if (this.apV.size() > this.aqa && this.apV.size() >= this.aqb) {
                    arrayList.addAll(this.apV.subList(0, this.aqa));
                    arrayList.addAll(0, this.apV.subList(this.aqa - this.aqb, this.aqa));
                    arrayList.addAll(this.apV.subList(0, this.aqb));
                } else {
                    arrayList.addAll(this.apV);
                    arrayList.addAll(0, this.apV.subList(this.apV.size() - this.aqb, this.apV.size()));
                    arrayList.addAll(this.apV.subList(0, this.aqb));
                }
            } else if (this.apV != null && this.apV.size() > 0 && this.apV.size() >= this.aqb) {
                arrayList.addAll(this.apV.subList(0, this.aqb));
            }
        }
        return arrayList;
    }

    public int dz(int i) {
        if (this.apX) {
            int size = this.apW.size();
            if (i == 0) {
                return (size - 1) - this.aqb;
            }
            if (i == size - this.aqb) {
                return this.aqb;
            }
            return i;
        }
        return i;
    }

    public int dA(int i) {
        if (this.apX) {
            return i - this.aqb;
        }
        return i;
    }

    public int xx() {
        if (this.apV == null) {
            return 0;
        }
        return this.apV.size();
    }

    public int xy() {
        if (this.apX) {
            return this.aqb;
        }
        return 0;
    }

    public void dB(int i) {
        this.aqa = i;
        w(this.apV);
    }

    public void dC(int i) {
        this.apZ = i;
        w(this.apV);
    }

    public List<f> xz() {
        return this.apW;
    }

    public void dD(int i) {
        this.aqb = i;
        w(this.apV);
    }
}
