package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k extends bk {
    public static final BdUniqueId dBs = BdUniqueId.gen();
    private boolean dBt = false;
    private boolean dBu = false;
    private boolean dBv = false;
    private int dBw;

    public boolean aOB() {
        return this.dBt;
    }

    public void gK(boolean z) {
        this.dBt = z;
    }

    public boolean aOC() {
        return this.dBu;
    }

    public void gL(boolean z) {
        this.dBu = z;
    }

    public boolean aOD() {
        return this.dBv;
    }

    public void gM(boolean z) {
        this.dBv = z;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return dBs;
    }

    public void setFloorNum(int i) {
        this.dBw = i;
    }

    public int getFloorNum() {
        return this.dBw;
    }
}
