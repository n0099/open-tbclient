package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends cb {
    public static final BdUniqueId eNW = BdUniqueId.gen();
    private boolean eNX = false;
    private boolean eNY = false;
    private boolean eNZ = false;
    private int eOa;

    public boolean blO() {
        return this.eNX;
    }

    public void jq(boolean z) {
        this.eNX = z;
    }

    public boolean blP() {
        return this.eNY;
    }

    public void jr(boolean z) {
        this.eNY = z;
    }

    public boolean blQ() {
        return this.eNZ;
    }

    public void js(boolean z) {
        this.eNZ = z;
    }

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eNW;
    }

    public void setFloorNum(int i) {
        this.eOa = i;
    }

    public int getFloorNum() {
        return this.eOa;
    }
}
