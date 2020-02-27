package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l extends bj {
    public static final BdUniqueId cNT = BdUniqueId.gen();
    private boolean cNU = false;
    private boolean cNV = false;
    private boolean cNW = false;
    private int cNX;

    public boolean aAq() {
        return this.cNU;
    }

    public void fu(boolean z) {
        this.cNU = z;
    }

    public boolean aAr() {
        return this.cNV;
    }

    public void fv(boolean z) {
        this.cNV = z;
    }

    public boolean aAs() {
        return this.cNW;
    }

    public void fw(boolean z) {
        this.cNW = z;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cNT;
    }

    public void setFloorNum(int i) {
        this.cNX = i;
    }

    public int getFloorNum() {
        return this.cNX;
    }
}
