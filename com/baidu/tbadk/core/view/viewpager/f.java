package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private List<v> ahF;
    private List<v> ahG;
    private boolean ahH;
    private boolean ahI;
    private int ahJ = 2;
    private int ahK = 1;
    private int ahx;

    public f(List<v> list, boolean z, int i) {
        this.ahx = 2;
        this.ahF = list;
        this.ahI = z;
        this.ahx = i;
        t(list);
    }

    public void t(List<v> list) {
        if (list != null && list.size() >= this.ahJ && list.size() <= this.ahx) {
            this.ahH = true;
        } else if (list.size() > this.ahx && this.ahI) {
            this.ahH = true;
        } else {
            this.ahH = false;
        }
        this.ahG = wJ();
    }

    private List<v> wJ() {
        ArrayList arrayList = new ArrayList();
        if (this.ahF != null) {
            if (this.ahH) {
                if (this.ahF.size() > this.ahx && this.ahF.size() >= this.ahK) {
                    arrayList.addAll(this.ahF.subList(0, this.ahx));
                    arrayList.addAll(0, this.ahF.subList(this.ahx - this.ahK, this.ahx));
                    arrayList.addAll(this.ahF.subList(0, this.ahK));
                } else {
                    arrayList.addAll(this.ahF);
                    arrayList.addAll(0, this.ahF.subList(this.ahF.size() - this.ahK, this.ahF.size()));
                    arrayList.addAll(this.ahF.subList(0, this.ahK));
                }
            } else if (this.ahF != null && this.ahF.size() > 0 && this.ahF.size() >= this.ahK) {
                arrayList.addAll(this.ahF.subList(0, this.ahK));
            }
        }
        return arrayList;
    }

    public int du(int i) {
        if (this.ahH) {
            int size = this.ahG.size();
            if (i == 0) {
                return (size - 1) - this.ahK;
            }
            if (i == size - this.ahK) {
                return this.ahK;
            }
            return i;
        }
        return i;
    }

    public int dv(int i) {
        if (this.ahH) {
            return i - this.ahK;
        }
        return i;
    }

    public int wK() {
        if (this.ahF == null) {
            return 0;
        }
        return this.ahF.size();
    }

    public int wL() {
        if (this.ahH) {
            return this.ahK;
        }
        return 0;
    }

    public void dw(int i) {
        this.ahx = i;
        t(this.ahF);
    }

    public void dx(int i) {
        this.ahJ = i;
        t(this.ahF);
    }

    public List<v> wM() {
        return this.ahG;
    }

    public void dy(int i) {
        this.ahK = i;
        t(this.ahF);
    }
}
