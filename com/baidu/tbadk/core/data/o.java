package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class o extends bx {
    public static final BdUniqueId eyd = BdUniqueId.gen();
    private boolean eyf = false;
    private boolean eyg = false;
    private boolean eyh = false;
    private int eyi;

    public boolean bjB() {
        return this.eyf;
    }

    public void iI(boolean z) {
        this.eyf = z;
    }

    public boolean bjC() {
        return this.eyg;
    }

    public void iJ(boolean z) {
        this.eyg = z;
    }

    public boolean bjD() {
        return this.eyh;
    }

    public void iK(boolean z) {
        this.eyh = z;
    }

    @Override // com.baidu.tbadk.core.data.bx, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eyd;
    }

    public void setFloorNum(int i) {
        this.eyi = i;
    }

    public int getFloorNum() {
        return this.eyi;
    }
}
