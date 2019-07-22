package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int cdY;
    private List<m> cef;
    private List<m> ceg;
    private boolean ceh;
    private boolean cei;
    private int cej = 2;
    private int cek = 1;

    public d(List<m> list, boolean z, int i) {
        this.cdY = 2;
        this.cef = list;
        this.cei = z;
        this.cdY = i;
        ad(list);
    }

    public void ad(List<m> list) {
        if (list != null && list.size() >= this.cej && list.size() <= this.cdY) {
            this.ceh = true;
        } else if (list.size() > this.cdY && this.cei) {
            this.ceh = true;
        } else {
            this.ceh = false;
        }
        this.ceg = alp();
    }

    private List<m> alp() {
        ArrayList arrayList = new ArrayList();
        if (this.cef != null) {
            if (this.ceh) {
                if (this.cef.size() > this.cdY && this.cef.size() >= this.cek) {
                    arrayList.addAll(this.cef.subList(0, this.cdY));
                    arrayList.addAll(0, this.cef.subList(this.cdY - this.cek, this.cdY));
                    arrayList.addAll(this.cef.subList(0, this.cek));
                } else {
                    arrayList.addAll(this.cef);
                    arrayList.addAll(0, this.cef.subList(this.cef.size() - this.cek, this.cef.size()));
                    arrayList.addAll(this.cef.subList(0, this.cek));
                }
            } else if (this.cef != null && this.cef.size() > 0 && this.cef.size() >= this.cek) {
                arrayList.addAll(this.cef.subList(0, this.cek));
            }
        }
        return arrayList;
    }

    public int ji(int i) {
        if (this.ceh) {
            int size = this.ceg.size();
            if (i == 0) {
                return (size - 1) - this.cek;
            }
            if (i == size - this.cek) {
                return this.cek;
            }
            return i;
        }
        return i;
    }

    public int jj(int i) {
        if (this.ceh) {
            return i - this.cek;
        }
        return i;
    }

    public int alq() {
        if (this.cef == null) {
            return 0;
        }
        return this.cef.size();
    }

    public int alr() {
        if (this.ceh) {
            return this.cek;
        }
        return 0;
    }

    public void jk(int i) {
        this.cdY = i;
        ad(this.cef);
    }

    public void jl(int i) {
        this.cej = i;
        ad(this.cef);
    }

    public List<m> als() {
        return this.ceg;
    }

    public void jm(int i) {
        this.cek = i;
        ad(this.cef);
    }
}
