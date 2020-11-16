package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int faf;
    private List<q> fal;
    private List<q> fam;
    private boolean fan;
    private boolean fao;
    private int fap = 2;
    private int faq = 1;

    public d(List<q> list, boolean z, int i) {
        this.faf = 2;
        this.fal = list;
        this.fao = z;
        this.faf = i;
        bv(list);
    }

    public void bv(List<q> list) {
        if (list != null && list.size() >= this.fap && list.size() <= this.faf) {
            this.fan = true;
        } else if (list.size() > this.faf && this.fao) {
            this.fan = true;
        } else {
            this.fan = false;
        }
        this.fam = bte();
    }

    private List<q> bte() {
        ArrayList arrayList = new ArrayList();
        if (this.fal != null) {
            if (this.fan) {
                if (this.fal.size() > this.faf && this.fal.size() >= this.faq) {
                    arrayList.addAll(this.fal.subList(0, this.faf));
                    arrayList.addAll(0, this.fal.subList(this.faf - this.faq, this.faf));
                    arrayList.addAll(this.fal.subList(0, this.faq));
                } else {
                    arrayList.addAll(this.fal);
                    arrayList.addAll(0, this.fal.subList(this.fal.size() - this.faq, this.fal.size()));
                    arrayList.addAll(this.fal.subList(0, this.faq));
                }
            } else if (this.fal != null && this.fal.size() > 0 && this.fal.size() >= this.faq) {
                arrayList.addAll(this.fal.subList(0, this.faq));
            }
        }
        return arrayList;
    }

    public int qT(int i) {
        if (this.fan) {
            int size = this.fam.size();
            if (i == 0) {
                return (size - 1) - this.faq;
            }
            if (i == size - this.faq) {
                return this.faq;
            }
            return i;
        }
        return i;
    }

    public int qU(int i) {
        if (this.fan) {
            return i - this.faq;
        }
        return i;
    }

    public int btf() {
        if (this.fal == null) {
            return 0;
        }
        return this.fal.size();
    }

    public int btg() {
        if (this.fan) {
            return this.faq;
        }
        return 0;
    }

    public void qV(int i) {
        this.faf = i;
        bv(this.fal);
    }

    public void qW(int i) {
        this.fap = i;
        bv(this.fal);
    }

    public List<q> bth() {
        return this.fam;
    }

    public void qX(int i) {
        this.faq = i;
        bv(this.fal);
    }
}
