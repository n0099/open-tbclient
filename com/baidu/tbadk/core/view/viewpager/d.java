package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<f> apc;
    private List<f> apd;
    private boolean ape;
    private boolean apf;
    private int aph;
    private int apg = 2;
    private int api = 1;

    public d(List<f> list, boolean z, int i) {
        this.aph = 2;
        this.apc = list;
        this.apf = z;
        this.aph = i;
        v(list);
    }

    public void v(List<f> list) {
        if (list != null && list.size() >= this.apg && list.size() <= this.aph) {
            this.ape = true;
        } else if (list.size() > this.aph && this.apf) {
            this.ape = true;
        } else {
            this.ape = false;
        }
        this.apd = wV();
    }

    private List<f> wV() {
        ArrayList arrayList = new ArrayList();
        if (this.apc != null) {
            if (this.ape) {
                if (this.apc.size() > this.aph && this.apc.size() >= this.api) {
                    arrayList.addAll(this.apc.subList(0, this.aph));
                    arrayList.addAll(0, this.apc.subList(this.aph - this.api, this.aph));
                    arrayList.addAll(this.apc.subList(0, this.api));
                } else {
                    arrayList.addAll(this.apc);
                    arrayList.addAll(0, this.apc.subList(this.apc.size() - this.api, this.apc.size()));
                    arrayList.addAll(this.apc.subList(0, this.api));
                }
            } else if (this.apc != null && this.apc.size() > 0 && this.apc.size() >= this.api) {
                arrayList.addAll(this.apc.subList(0, this.api));
            }
        }
        return arrayList;
    }

    public int dJ(int i) {
        if (this.ape) {
            int size = this.apd.size();
            if (i == 0) {
                return (size - 1) - this.api;
            }
            if (i == size - this.api) {
                return this.api;
            }
            return i;
        }
        return i;
    }

    public int dK(int i) {
        if (this.ape) {
            return i - this.api;
        }
        return i;
    }

    public int wW() {
        if (this.apc == null) {
            return 0;
        }
        return this.apc.size();
    }

    public int wX() {
        if (this.ape) {
            return this.api;
        }
        return 0;
    }

    public void dL(int i) {
        this.aph = i;
        v(this.apc);
    }

    public void dM(int i) {
        this.apg = i;
        v(this.apc);
    }

    public List<f> wY() {
        return this.apd;
    }

    public void dN(int i) {
        this.api = i;
        v(this.apc);
    }
}
