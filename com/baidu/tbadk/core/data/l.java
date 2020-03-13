package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l extends bj {
    public static final BdUniqueId cNV = BdUniqueId.gen();
    private boolean cNW = false;
    private boolean cNX = false;
    private boolean cNY = false;
    private int cNZ;

    public boolean aAs() {
        return this.cNW;
    }

    public void fu(boolean z) {
        this.cNW = z;
    }

    public boolean aAt() {
        return this.cNX;
    }

    public void fv(boolean z) {
        this.cNX = z;
    }

    public boolean aAu() {
        return this.cNY;
    }

    public void fw(boolean z) {
        this.cNY = z;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cNV;
    }

    public void setFloorNum(int i) {
        this.cNZ = i;
    }

    public int getFloorNum() {
        return this.cNZ;
    }
}
