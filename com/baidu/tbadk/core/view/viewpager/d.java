package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int cef;
    private List<m> cem;
    private List<m> cen;
    private boolean ceo;
    private boolean cep;
    private int ceq = 2;
    private int cer = 1;

    public d(List<m> list, boolean z, int i) {
        this.cef = 2;
        this.cem = list;
        this.cep = z;
        this.cef = i;
        ad(list);
    }

    public void ad(List<m> list) {
        if (list != null && list.size() >= this.ceq && list.size() <= this.cef) {
            this.ceo = true;
        } else if (list.size() > this.cef && this.cep) {
            this.ceo = true;
        } else {
            this.ceo = false;
        }
        this.cen = alr();
    }

    private List<m> alr() {
        ArrayList arrayList = new ArrayList();
        if (this.cem != null) {
            if (this.ceo) {
                if (this.cem.size() > this.cef && this.cem.size() >= this.cer) {
                    arrayList.addAll(this.cem.subList(0, this.cef));
                    arrayList.addAll(0, this.cem.subList(this.cef - this.cer, this.cef));
                    arrayList.addAll(this.cem.subList(0, this.cer));
                } else {
                    arrayList.addAll(this.cem);
                    arrayList.addAll(0, this.cem.subList(this.cem.size() - this.cer, this.cem.size()));
                    arrayList.addAll(this.cem.subList(0, this.cer));
                }
            } else if (this.cem != null && this.cem.size() > 0 && this.cem.size() >= this.cer) {
                arrayList.addAll(this.cem.subList(0, this.cer));
            }
        }
        return arrayList;
    }

    public int jj(int i) {
        if (this.ceo) {
            int size = this.cen.size();
            if (i == 0) {
                return (size - 1) - this.cer;
            }
            if (i == size - this.cer) {
                return this.cer;
            }
            return i;
        }
        return i;
    }

    public int jk(int i) {
        if (this.ceo) {
            return i - this.cer;
        }
        return i;
    }

    public int als() {
        if (this.cem == null) {
            return 0;
        }
        return this.cem.size();
    }

    public int alt() {
        if (this.ceo) {
            return this.cer;
        }
        return 0;
    }

    public void jl(int i) {
        this.cef = i;
        ad(this.cem);
    }

    public void jm(int i) {
        this.ceq = i;
        ad(this.cem);
    }

    public List<m> alu() {
        return this.cen;
    }

    public void jn(int i) {
        this.cer = i;
        ad(this.cem);
    }
}
