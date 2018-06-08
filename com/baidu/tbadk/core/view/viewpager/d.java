package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int azk;
    private List<h> azr;
    private List<h> azs;
    private boolean azt;
    private boolean azu;
    private int azv = 2;
    private int azw = 1;

    public d(List<h> list, boolean z, int i) {
        this.azk = 2;
        this.azr = list;
        this.azu = z;
        this.azk = i;
        A(list);
    }

    public void A(List<h> list) {
        if (list != null && list.size() >= this.azv && list.size() <= this.azk) {
            this.azt = true;
        } else if (list.size() > this.azk && this.azu) {
            this.azt = true;
        } else {
            this.azt = false;
        }
        this.azs = AV();
    }

    private List<h> AV() {
        ArrayList arrayList = new ArrayList();
        if (this.azr != null) {
            if (this.azt) {
                if (this.azr.size() > this.azk && this.azr.size() >= this.azw) {
                    arrayList.addAll(this.azr.subList(0, this.azk));
                    arrayList.addAll(0, this.azr.subList(this.azk - this.azw, this.azk));
                    arrayList.addAll(this.azr.subList(0, this.azw));
                } else {
                    arrayList.addAll(this.azr);
                    arrayList.addAll(0, this.azr.subList(this.azr.size() - this.azw, this.azr.size()));
                    arrayList.addAll(this.azr.subList(0, this.azw));
                }
            } else if (this.azr != null && this.azr.size() > 0 && this.azr.size() >= this.azw) {
                arrayList.addAll(this.azr.subList(0, this.azw));
            }
        }
        return arrayList;
    }

    public int dH(int i) {
        if (this.azt) {
            int size = this.azs.size();
            if (i == 0) {
                return (size - 1) - this.azw;
            }
            if (i == size - this.azw) {
                return this.azw;
            }
            return i;
        }
        return i;
    }

    public int dI(int i) {
        if (this.azt) {
            return i - this.azw;
        }
        return i;
    }

    public int AW() {
        if (this.azr == null) {
            return 0;
        }
        return this.azr.size();
    }

    public int AX() {
        if (this.azt) {
            return this.azw;
        }
        return 0;
    }

    public void dJ(int i) {
        this.azk = i;
        A(this.azr);
    }

    public void dK(int i) {
        this.azv = i;
        A(this.azr);
    }

    public List<h> AY() {
        return this.azs;
    }

    public void dL(int i) {
        this.azw = i;
        A(this.azr);
    }
}
