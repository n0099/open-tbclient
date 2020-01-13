package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l extends bj {
    public static final BdUniqueId cJQ = BdUniqueId.gen();
    private boolean cJR = false;
    private boolean cJS = false;
    private boolean cJT = false;
    private int cJU;

    public boolean ayc() {
        return this.cJR;
    }

    public void fn(boolean z) {
        this.cJR = z;
    }

    public boolean ayd() {
        return this.cJS;
    }

    public void fo(boolean z) {
        this.cJS = z;
    }

    public boolean aye() {
        return this.cJT;
    }

    public void fp(boolean z) {
        this.cJT = z;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cJQ;
    }

    public void setFloorNum(int i) {
        this.cJU = i;
    }

    public int getFloorNum() {
        return this.cJU;
    }
}
