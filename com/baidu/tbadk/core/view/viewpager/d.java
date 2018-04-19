package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int ard;
    private List<h> arl;
    private List<h> arm;
    private boolean arn;
    private boolean aro;
    private int arp = 2;
    private int arq = 1;

    public d(List<h> list, boolean z, int i) {
        this.ard = 2;
        this.arl = list;
        this.aro = z;
        this.ard = i;
        x(list);
    }

    public void x(List<h> list) {
        if (list != null && list.size() >= this.arp && list.size() <= this.ard) {
            this.arn = true;
        } else if (list.size() > this.ard && this.aro) {
            this.arn = true;
        } else {
            this.arn = false;
        }
        this.arm = xv();
    }

    private List<h> xv() {
        ArrayList arrayList = new ArrayList();
        if (this.arl != null) {
            if (this.arn) {
                if (this.arl.size() > this.ard && this.arl.size() >= this.arq) {
                    arrayList.addAll(this.arl.subList(0, this.ard));
                    arrayList.addAll(0, this.arl.subList(this.ard - this.arq, this.ard));
                    arrayList.addAll(this.arl.subList(0, this.arq));
                } else {
                    arrayList.addAll(this.arl);
                    arrayList.addAll(0, this.arl.subList(this.arl.size() - this.arq, this.arl.size()));
                    arrayList.addAll(this.arl.subList(0, this.arq));
                }
            } else if (this.arl != null && this.arl.size() > 0 && this.arl.size() >= this.arq) {
                arrayList.addAll(this.arl.subList(0, this.arq));
            }
        }
        return arrayList;
    }

    public int dE(int i) {
        if (this.arn) {
            int size = this.arm.size();
            if (i == 0) {
                return (size - 1) - this.arq;
            }
            if (i == size - this.arq) {
                return this.arq;
            }
            return i;
        }
        return i;
    }

    public int dF(int i) {
        if (this.arn) {
            return i - this.arq;
        }
        return i;
    }

    public int xw() {
        if (this.arl == null) {
            return 0;
        }
        return this.arl.size();
    }

    public int xx() {
        if (this.arn) {
            return this.arq;
        }
        return 0;
    }

    public void dG(int i) {
        this.ard = i;
        x(this.arl);
    }

    public void dH(int i) {
        this.arp = i;
        x(this.arl);
    }

    public List<h> xy() {
        return this.arm;
    }

    public void dI(int i) {
        this.arq = i;
        x(this.arl);
    }
}
