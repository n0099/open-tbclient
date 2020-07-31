package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n extends bv {
    public static final BdUniqueId dNW = BdUniqueId.gen();
    private boolean dNX = false;
    private boolean dNY = false;
    private boolean dNZ = false;
    private int dOa;

    public boolean aUk() {
        return this.dNX;
    }

    public void hv(boolean z) {
        this.dNX = z;
    }

    public boolean aUl() {
        return this.dNY;
    }

    public void hw(boolean z) {
        this.dNY = z;
    }

    public boolean aUm() {
        return this.dNZ;
    }

    public void hx(boolean z) {
        this.dNZ = z;
    }

    @Override // com.baidu.tbadk.core.data.bv, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dNW;
    }

    public void setFloorNum(int i) {
        this.dOa = i;
    }

    public int getFloorNum() {
        return this.dOa;
    }
}
