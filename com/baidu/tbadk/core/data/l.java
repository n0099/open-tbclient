package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l extends bj {
    public static final BdUniqueId dnm = BdUniqueId.gen();
    private boolean dnn = false;
    private boolean dno = false;
    private boolean dnp = false;
    private int dnq;

    public boolean aII() {
        return this.dnn;
    }

    public void gs(boolean z) {
        this.dnn = z;
    }

    public boolean aIJ() {
        return this.dno;
    }

    public void gt(boolean z) {
        this.dno = z;
    }

    public boolean aIK() {
        return this.dnp;
    }

    public void gu(boolean z) {
        this.dnp = z;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dnm;
    }

    public void setFloorNum(int i) {
        this.dnq = i;
    }

    public int getFloorNum() {
        return this.dnq;
    }
}
