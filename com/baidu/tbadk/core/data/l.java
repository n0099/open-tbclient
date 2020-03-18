package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l extends bj {
    public static final BdUniqueId cOi = BdUniqueId.gen();
    private boolean cOj = false;
    private boolean cOk = false;
    private boolean cOl = false;
    private int cOm;

    public boolean aAv() {
        return this.cOj;
    }

    public void fv(boolean z) {
        this.cOj = z;
    }

    public boolean aAw() {
        return this.cOk;
    }

    public void fw(boolean z) {
        this.cOk = z;
    }

    public boolean aAx() {
        return this.cOl;
    }

    public void fx(boolean z) {
        this.cOl = z;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cOi;
    }

    public void setFloorNum(int i) {
        this.cOm = i;
    }

    public int getFloorNum() {
        return this.cOm;
    }
}
