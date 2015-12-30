package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private List<u> ahA;
    private List<u> ahB;
    private boolean ahC;
    private boolean ahD;
    private int ahE = 2;
    private int ahF = 1;
    private int aht;

    public h(List<u> list, boolean z, int i) {
        this.aht = 2;
        this.ahA = list;
        this.ahD = z;
        this.aht = i;
        m(list);
    }

    public void m(List<u> list) {
        if (list != null && list.size() >= this.ahE && list.size() <= this.aht) {
            this.ahC = true;
        } else if (list.size() > this.aht && this.ahD) {
            this.ahC = true;
        } else {
            this.ahC = false;
        }
        this.ahB = wf();
    }

    private List<u> wf() {
        ArrayList arrayList = new ArrayList();
        if (this.ahA != null) {
            if (this.ahC) {
                if (this.ahA.size() > this.aht && this.ahA.size() >= this.ahF) {
                    arrayList.addAll(this.ahA.subList(0, this.aht));
                    arrayList.addAll(0, this.ahA.subList(this.aht - this.ahF, this.aht));
                    arrayList.addAll(this.ahA.subList(0, this.ahF));
                } else {
                    arrayList.addAll(this.ahA);
                    arrayList.addAll(0, this.ahA.subList(this.ahA.size() - this.ahF, this.ahA.size()));
                    arrayList.addAll(this.ahA.subList(0, this.ahF));
                }
            } else if (this.ahA != null && this.ahA.size() > 0 && this.ahA.size() >= this.ahF) {
                arrayList.addAll(this.ahA.subList(0, this.ahF));
            }
        }
        return arrayList;
    }

    public int cT(int i) {
        if (this.ahC) {
            int size = this.ahB.size();
            if (i == 0) {
                return (size - 1) - this.ahF;
            }
            if (i == size - this.ahF) {
                return this.ahF;
            }
            return i;
        }
        return i;
    }

    public int cU(int i) {
        if (this.ahC) {
            return i - this.ahF;
        }
        return i;
    }

    public int wg() {
        if (this.ahA == null) {
            return 0;
        }
        return this.ahA.size();
    }

    public int wh() {
        if (this.ahC) {
            return this.ahF;
        }
        return 0;
    }

    public void cV(int i) {
        this.aht = i;
        m(this.ahA);
    }

    public void cW(int i) {
        this.ahE = i;
        m(this.ahA);
    }

    public List<u> wi() {
        return this.ahB;
    }

    public void cX(int i) {
        this.ahF = i;
        m(this.ahA);
    }
}
