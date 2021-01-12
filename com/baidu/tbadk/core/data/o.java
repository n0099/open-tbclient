package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class o extends bz {
    public static final BdUniqueId eKj = BdUniqueId.gen();
    private boolean eKk = false;
    private boolean eKl = false;
    private boolean eKm = false;
    private int eKn;

    public boolean blu() {
        return this.eKk;
    }

    public void jo(boolean z) {
        this.eKk = z;
    }

    public boolean blv() {
        return this.eKl;
    }

    public void jp(boolean z) {
        this.eKl = z;
    }

    public boolean blw() {
        return this.eKm;
    }

    public void jq(boolean z) {
        this.eKm = z;
    }

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eKj;
    }

    public void setFloorNum(int i) {
        this.eKn = i;
    }

    public int getFloorNum() {
        return this.eKn;
    }
}
