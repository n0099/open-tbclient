package com.baidu.tbadk.core.view.viewpager;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int dkN;
    private List<m> dkT;
    private List<m> dkU;
    private boolean dkV;
    private boolean dkW;
    private int dkX = 2;
    private int dkY = 1;

    public d(List<m> list, boolean z, int i) {
        this.dkN = 2;
        this.dkT = list;
        this.dkW = z;
        this.dkN = i;
        aD(list);
    }

    public void aD(List<m> list) {
        if (list != null && list.size() >= this.dkX && list.size() <= this.dkN) {
            this.dkV = true;
        } else if (list.size() > this.dkN && this.dkW) {
            this.dkV = true;
        } else {
            this.dkV = false;
        }
        this.dkU = aID();
    }

    private List<m> aID() {
        ArrayList arrayList = new ArrayList();
        if (this.dkT != null) {
            if (this.dkV) {
                if (this.dkT.size() > this.dkN && this.dkT.size() >= this.dkY) {
                    arrayList.addAll(this.dkT.subList(0, this.dkN));
                    arrayList.addAll(0, this.dkT.subList(this.dkN - this.dkY, this.dkN));
                    arrayList.addAll(this.dkT.subList(0, this.dkY));
                } else {
                    arrayList.addAll(this.dkT);
                    arrayList.addAll(0, this.dkT.subList(this.dkT.size() - this.dkY, this.dkT.size()));
                    arrayList.addAll(this.dkT.subList(0, this.dkY));
                }
            } else if (this.dkT != null && this.dkT.size() > 0 && this.dkT.size() >= this.dkY) {
                arrayList.addAll(this.dkT.subList(0, this.dkY));
            }
        }
        return arrayList;
    }

    public int lB(int i) {
        if (this.dkV) {
            int size = this.dkU.size();
            if (i == 0) {
                return (size - 1) - this.dkY;
            }
            if (i == size - this.dkY) {
                return this.dkY;
            }
            return i;
        }
        return i;
    }

    public int lC(int i) {
        if (this.dkV) {
            return i - this.dkY;
        }
        return i;
    }

    public int aIE() {
        if (this.dkT == null) {
            return 0;
        }
        return this.dkT.size();
    }

    public int aIF() {
        if (this.dkV) {
            return this.dkY;
        }
        return 0;
    }

    public void lD(int i) {
        this.dkN = i;
        aD(this.dkT);
    }

    public void lE(int i) {
        this.dkX = i;
        aD(this.dkT);
    }

    public List<m> aIG() {
        return this.dkU;
    }

    public void lF(int i) {
        this.dkY = i;
        aD(this.dkT);
    }
}
