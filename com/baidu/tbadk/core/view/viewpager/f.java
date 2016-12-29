package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private int aik;
    private List<v> ais;
    private List<v> ait;
    private boolean aiu;
    private boolean aiv;
    private int aiw = 2;
    private int aix = 1;

    public f(List<v> list, boolean z, int i) {
        this.aik = 2;
        this.ais = list;
        this.aiv = z;
        this.aik = i;
        u(list);
    }

    public void u(List<v> list) {
        if (list != null && list.size() >= this.aiw && list.size() <= this.aik) {
            this.aiu = true;
        } else if (list.size() > this.aik && this.aiv) {
            this.aiu = true;
        } else {
            this.aiu = false;
        }
        this.ait = wP();
    }

    private List<v> wP() {
        ArrayList arrayList = new ArrayList();
        if (this.ais != null) {
            if (this.aiu) {
                if (this.ais.size() > this.aik && this.ais.size() >= this.aix) {
                    arrayList.addAll(this.ais.subList(0, this.aik));
                    arrayList.addAll(0, this.ais.subList(this.aik - this.aix, this.aik));
                    arrayList.addAll(this.ais.subList(0, this.aix));
                } else {
                    arrayList.addAll(this.ais);
                    arrayList.addAll(0, this.ais.subList(this.ais.size() - this.aix, this.ais.size()));
                    arrayList.addAll(this.ais.subList(0, this.aix));
                }
            } else if (this.ais != null && this.ais.size() > 0 && this.ais.size() >= this.aix) {
                arrayList.addAll(this.ais.subList(0, this.aix));
            }
        }
        return arrayList;
    }

    public int dt(int i) {
        if (this.aiu) {
            int size = this.ait.size();
            if (i == 0) {
                return (size - 1) - this.aix;
            }
            if (i == size - this.aix) {
                return this.aix;
            }
            return i;
        }
        return i;
    }

    public int du(int i) {
        if (this.aiu) {
            return i - this.aix;
        }
        return i;
    }

    public int wQ() {
        if (this.ais == null) {
            return 0;
        }
        return this.ais.size();
    }

    public int wR() {
        if (this.aiu) {
            return this.aix;
        }
        return 0;
    }

    public void dv(int i) {
        this.aik = i;
        u(this.ais);
    }

    public void dw(int i) {
        this.aiw = i;
        u(this.ais);
    }

    public List<v> wS() {
        return this.ait;
    }

    public void dx(int i) {
        this.aix = i;
        u(this.ais);
    }
}
