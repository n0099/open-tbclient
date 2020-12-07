package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class o extends by {
    public static final BdUniqueId eFe = BdUniqueId.gen();
    private boolean eFf = false;
    private boolean eFg = false;
    private boolean eFh = false;
    private int eFi;

    public boolean bmO() {
        return this.eFf;
    }

    public void iX(boolean z) {
        this.eFf = z;
    }

    public boolean bmP() {
        return this.eFg;
    }

    public void iY(boolean z) {
        this.eFg = z;
    }

    public boolean bmQ() {
        return this.eFh;
    }

    public void iZ(boolean z) {
        this.eFh = z;
    }

    @Override // com.baidu.tbadk.core.data.by, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eFe;
    }

    public void setFloorNum(int i) {
        this.eFi = i;
    }

    public int getFloorNum() {
        return this.eFi;
    }
}
