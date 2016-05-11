package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private List<v> aem;
    private List<v> aen;
    private boolean aeo;
    private boolean aep;
    private int aer;
    private int aeq = 2;
    private int aes = 1;

    public c(List<v> list, boolean z, int i) {
        this.aer = 2;
        this.aem = list;
        this.aep = z;
        this.aer = i;
        t(list);
    }

    public void t(List<v> list) {
        if (list != null && list.size() >= this.aeq && list.size() <= this.aer) {
            this.aeo = true;
        } else if (list.size() > this.aer && this.aep) {
            this.aeo = true;
        } else {
            this.aeo = false;
        }
        this.aen = vN();
    }

    private List<v> vN() {
        ArrayList arrayList = new ArrayList();
        if (this.aem != null) {
            if (this.aeo) {
                if (this.aem.size() > this.aer && this.aem.size() >= this.aes) {
                    arrayList.addAll(this.aem.subList(0, this.aer));
                    arrayList.addAll(0, this.aem.subList(this.aer - this.aes, this.aer));
                    arrayList.addAll(this.aem.subList(0, this.aes));
                } else {
                    arrayList.addAll(this.aem);
                    arrayList.addAll(0, this.aem.subList(this.aem.size() - this.aes, this.aem.size()));
                    arrayList.addAll(this.aem.subList(0, this.aes));
                }
            } else if (this.aem != null && this.aem.size() > 0 && this.aem.size() >= this.aes) {
                arrayList.addAll(this.aem.subList(0, this.aes));
            }
        }
        return arrayList;
    }

    public int da(int i) {
        if (this.aeo) {
            int size = this.aen.size();
            if (i == 0) {
                return (size - 1) - this.aes;
            }
            if (i == size - this.aes) {
                return this.aes;
            }
            return i;
        }
        return i;
    }

    public int db(int i) {
        if (this.aeo) {
            return i - this.aes;
        }
        return i;
    }

    public int vO() {
        if (this.aem == null) {
            return 0;
        }
        return this.aem.size();
    }

    public int vP() {
        if (this.aeo) {
            return this.aes;
        }
        return 0;
    }

    public void dc(int i) {
        this.aer = i;
        t(this.aem);
    }

    public void dd(int i) {
        this.aeq = i;
        t(this.aem);
    }

    public List<v> vQ() {
        return this.aen;
    }

    public void de(int i) {
        this.aes = i;
        t(this.aem);
    }
}
