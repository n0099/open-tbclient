package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n extends bu {
    public static final BdUniqueId dHL = BdUniqueId.gen();
    private boolean dHM = false;
    private boolean dHN = false;
    private boolean dHO = false;
    private int dHP;

    public boolean aQo() {
        return this.dHM;
    }

    public void gR(boolean z) {
        this.dHM = z;
    }

    public boolean aQp() {
        return this.dHN;
    }

    public void gS(boolean z) {
        this.dHN = z;
    }

    public boolean aQq() {
        return this.dHO;
    }

    public void gT(boolean z) {
        this.dHO = z;
    }

    @Override // com.baidu.tbadk.core.data.bu, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dHL;
    }

    public void setFloorNum(int i) {
        this.dHP = i;
    }

    public int getFloorNum() {
        return this.dHP;
    }
}
