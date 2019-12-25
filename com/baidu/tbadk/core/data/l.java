package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l extends bj {
    public static final BdUniqueId cJF = BdUniqueId.gen();
    private boolean cJG = false;
    private boolean cJH = false;
    private boolean cJI = false;
    private int cJJ;

    public boolean axJ() {
        return this.cJG;
    }

    public void fi(boolean z) {
        this.cJG = z;
    }

    public boolean axK() {
        return this.cJH;
    }

    public void fj(boolean z) {
        this.cJH = z;
    }

    public boolean axL() {
        return this.cJI;
    }

    public void fk(boolean z) {
        this.cJI = z;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cJF;
    }

    public void setFloorNum(int i) {
        this.cJJ = i;
    }

    public int getFloorNum() {
        return this.cJJ;
    }
}
