package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<f> apl;
    private List<f> apm;
    private boolean apn;
    private boolean apo;
    private int apr;
    private int apq = 2;
    private int aps = 1;

    public d(List<f> list, boolean z, int i) {
        this.apr = 2;
        this.apl = list;
        this.apo = z;
        this.apr = i;
        w(list);
    }

    public void w(List<f> list) {
        if (list != null && list.size() >= this.apq && list.size() <= this.apr) {
            this.apn = true;
        } else if (list.size() > this.apr && this.apo) {
            this.apn = true;
        } else {
            this.apn = false;
        }
        this.apm = wV();
    }

    private List<f> wV() {
        ArrayList arrayList = new ArrayList();
        if (this.apl != null) {
            if (this.apn) {
                if (this.apl.size() > this.apr && this.apl.size() >= this.aps) {
                    arrayList.addAll(this.apl.subList(0, this.apr));
                    arrayList.addAll(0, this.apl.subList(this.apr - this.aps, this.apr));
                    arrayList.addAll(this.apl.subList(0, this.aps));
                } else {
                    arrayList.addAll(this.apl);
                    arrayList.addAll(0, this.apl.subList(this.apl.size() - this.aps, this.apl.size()));
                    arrayList.addAll(this.apl.subList(0, this.aps));
                }
            } else if (this.apl != null && this.apl.size() > 0 && this.apl.size() >= this.aps) {
                arrayList.addAll(this.apl.subList(0, this.aps));
            }
        }
        return arrayList;
    }

    public int dJ(int i) {
        if (this.apn) {
            int size = this.apm.size();
            if (i == 0) {
                return (size - 1) - this.aps;
            }
            if (i == size - this.aps) {
                return this.aps;
            }
            return i;
        }
        return i;
    }

    public int dK(int i) {
        if (this.apn) {
            return i - this.aps;
        }
        return i;
    }

    public int wW() {
        if (this.apl == null) {
            return 0;
        }
        return this.apl.size();
    }

    public int wX() {
        if (this.apn) {
            return this.aps;
        }
        return 0;
    }

    public void dL(int i) {
        this.apr = i;
        w(this.apl);
    }

    public void dM(int i) {
        this.apq = i;
        w(this.apl);
    }

    public List<f> wY() {
        return this.apm;
    }

    public void dN(int i) {
        this.aps = i;
        w(this.apl);
    }
}
