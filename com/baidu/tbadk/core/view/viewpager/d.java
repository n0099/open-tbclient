package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<f> apk;
    private List<f> apl;
    private boolean apm;
    private boolean apn;
    private int apq;
    private int apo = 2;
    private int apr = 1;

    public d(List<f> list, boolean z, int i) {
        this.apq = 2;
        this.apk = list;
        this.apn = z;
        this.apq = i;
        w(list);
    }

    public void w(List<f> list) {
        if (list != null && list.size() >= this.apo && list.size() <= this.apq) {
            this.apm = true;
        } else if (list.size() > this.apq && this.apn) {
            this.apm = true;
        } else {
            this.apm = false;
        }
        this.apl = wV();
    }

    private List<f> wV() {
        ArrayList arrayList = new ArrayList();
        if (this.apk != null) {
            if (this.apm) {
                if (this.apk.size() > this.apq && this.apk.size() >= this.apr) {
                    arrayList.addAll(this.apk.subList(0, this.apq));
                    arrayList.addAll(0, this.apk.subList(this.apq - this.apr, this.apq));
                    arrayList.addAll(this.apk.subList(0, this.apr));
                } else {
                    arrayList.addAll(this.apk);
                    arrayList.addAll(0, this.apk.subList(this.apk.size() - this.apr, this.apk.size()));
                    arrayList.addAll(this.apk.subList(0, this.apr));
                }
            } else if (this.apk != null && this.apk.size() > 0 && this.apk.size() >= this.apr) {
                arrayList.addAll(this.apk.subList(0, this.apr));
            }
        }
        return arrayList;
    }

    public int dI(int i) {
        if (this.apm) {
            int size = this.apl.size();
            if (i == 0) {
                return (size - 1) - this.apr;
            }
            if (i == size - this.apr) {
                return this.apr;
            }
            return i;
        }
        return i;
    }

    public int dJ(int i) {
        if (this.apm) {
            return i - this.apr;
        }
        return i;
    }

    public int wW() {
        if (this.apk == null) {
            return 0;
        }
        return this.apk.size();
    }

    public int wX() {
        if (this.apm) {
            return this.apr;
        }
        return 0;
    }

    public void dK(int i) {
        this.apq = i;
        w(this.apk);
    }

    public void dL(int i) {
        this.apo = i;
        w(this.apk);
    }

    public List<f> wY() {
        return this.apl;
    }

    public void dM(int i) {
        this.apr = i;
        w(this.apk);
    }
}
