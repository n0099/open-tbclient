package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l extends bj {
    public static final BdUniqueId dnq = BdUniqueId.gen();
    private boolean dnr = false;
    private boolean dnt = false;
    private boolean dnu = false;
    private int dnv;

    public boolean aIG() {
        return this.dnr;
    }

    public void gs(boolean z) {
        this.dnr = z;
    }

    public boolean aIH() {
        return this.dnt;
    }

    public void gt(boolean z) {
        this.dnt = z;
    }

    public boolean aII() {
        return this.dnu;
    }

    public void gu(boolean z) {
        this.dnu = z;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dnq;
    }

    public void setFloorNum(int i) {
        this.dnv = i;
    }

    public int getFloorNum() {
        return this.dnv;
    }
}
