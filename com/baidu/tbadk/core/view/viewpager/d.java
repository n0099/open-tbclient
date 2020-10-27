package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int eVi;
    private List<q> eVo;
    private List<q> eVp;
    private boolean eVq;
    private boolean eVr;
    private int eVs = 2;
    private int eVt = 1;

    public d(List<q> list, boolean z, int i) {
        this.eVi = 2;
        this.eVo = list;
        this.eVr = z;
        this.eVi = i;
        bo(list);
    }

    public void bo(List<q> list) {
        if (list != null && list.size() >= this.eVs && list.size() <= this.eVi) {
            this.eVq = true;
        } else if (list.size() > this.eVi && this.eVr) {
            this.eVq = true;
        } else {
            this.eVq = false;
        }
        this.eVp = bro();
    }

    private List<q> bro() {
        ArrayList arrayList = new ArrayList();
        if (this.eVo != null) {
            if (this.eVq) {
                if (this.eVo.size() > this.eVi && this.eVo.size() >= this.eVt) {
                    arrayList.addAll(this.eVo.subList(0, this.eVi));
                    arrayList.addAll(0, this.eVo.subList(this.eVi - this.eVt, this.eVi));
                    arrayList.addAll(this.eVo.subList(0, this.eVt));
                } else {
                    arrayList.addAll(this.eVo);
                    arrayList.addAll(0, this.eVo.subList(this.eVo.size() - this.eVt, this.eVo.size()));
                    arrayList.addAll(this.eVo.subList(0, this.eVt));
                }
            } else if (this.eVo != null && this.eVo.size() > 0 && this.eVo.size() >= this.eVt) {
                arrayList.addAll(this.eVo.subList(0, this.eVt));
            }
        }
        return arrayList;
    }

    public int ql(int i) {
        if (this.eVq) {
            int size = this.eVp.size();
            if (i == 0) {
                return (size - 1) - this.eVt;
            }
            if (i == size - this.eVt) {
                return this.eVt;
            }
            return i;
        }
        return i;
    }

    public int qm(int i) {
        if (this.eVq) {
            return i - this.eVt;
        }
        return i;
    }

    public int brp() {
        if (this.eVo == null) {
            return 0;
        }
        return this.eVo.size();
    }

    public int brq() {
        if (this.eVq) {
            return this.eVt;
        }
        return 0;
    }

    public void qn(int i) {
        this.eVi = i;
        bo(this.eVo);
    }

    public void qo(int i) {
        this.eVs = i;
        bo(this.eVo);
    }

    public List<q> brr() {
        return this.eVp;
    }

    public void qp(int i) {
        this.eVt = i;
        bo(this.eVo);
    }
}
