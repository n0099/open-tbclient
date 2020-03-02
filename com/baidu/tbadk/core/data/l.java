package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l extends bj {
    public static final BdUniqueId cNU = BdUniqueId.gen();
    private boolean cNV = false;
    private boolean cNW = false;
    private boolean cNX = false;
    private int cNY;

    public boolean aAs() {
        return this.cNV;
    }

    public void fu(boolean z) {
        this.cNV = z;
    }

    public boolean aAt() {
        return this.cNW;
    }

    public void fv(boolean z) {
        this.cNW = z;
    }

    public boolean aAu() {
        return this.cNX;
    }

    public void fw(boolean z) {
        this.cNX = z;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cNU;
    }

    public void setFloorNum(int i) {
        this.cNY = i;
    }

    public int getFloorNum() {
        return this.cNY;
    }
}
