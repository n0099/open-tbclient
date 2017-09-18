package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<f> apT;
    private List<f> apU;
    private boolean apV;
    private boolean apW;
    private int apY;
    private int apX = 2;
    private int apZ = 1;

    public d(List<f> list, boolean z, int i) {
        this.apY = 2;
        this.apT = list;
        this.apW = z;
        this.apY = i;
        w(list);
    }

    public void w(List<f> list) {
        if (list != null && list.size() >= this.apX && list.size() <= this.apY) {
            this.apV = true;
        } else if (list.size() > this.apY && this.apW) {
            this.apV = true;
        } else {
            this.apV = false;
        }
        this.apU = xw();
    }

    private List<f> xw() {
        ArrayList arrayList = new ArrayList();
        if (this.apT != null) {
            if (this.apV) {
                if (this.apT.size() > this.apY && this.apT.size() >= this.apZ) {
                    arrayList.addAll(this.apT.subList(0, this.apY));
                    arrayList.addAll(0, this.apT.subList(this.apY - this.apZ, this.apY));
                    arrayList.addAll(this.apT.subList(0, this.apZ));
                } else {
                    arrayList.addAll(this.apT);
                    arrayList.addAll(0, this.apT.subList(this.apT.size() - this.apZ, this.apT.size()));
                    arrayList.addAll(this.apT.subList(0, this.apZ));
                }
            } else if (this.apT != null && this.apT.size() > 0 && this.apT.size() >= this.apZ) {
                arrayList.addAll(this.apT.subList(0, this.apZ));
            }
        }
        return arrayList;
    }

    public int dz(int i) {
        if (this.apV) {
            int size = this.apU.size();
            if (i == 0) {
                return (size - 1) - this.apZ;
            }
            if (i == size - this.apZ) {
                return this.apZ;
            }
            return i;
        }
        return i;
    }

    public int dA(int i) {
        if (this.apV) {
            return i - this.apZ;
        }
        return i;
    }

    public int xx() {
        if (this.apT == null) {
            return 0;
        }
        return this.apT.size();
    }

    public int xy() {
        if (this.apV) {
            return this.apZ;
        }
        return 0;
    }

    public void dB(int i) {
        this.apY = i;
        w(this.apT);
    }

    public void dC(int i) {
        this.apX = i;
        w(this.apT);
    }

    public List<f> xz() {
        return this.apU;
    }

    public void dD(int i) {
        this.apZ = i;
        w(this.apT);
    }
}
