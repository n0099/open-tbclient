package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class o extends bz {
    public static final BdUniqueId eOU = BdUniqueId.gen();
    private boolean eOV = false;
    private boolean eOW = false;
    private boolean eOX = false;
    private int eOY;

    public boolean bpn() {
        return this.eOV;
    }

    public void js(boolean z) {
        this.eOV = z;
    }

    public boolean bpo() {
        return this.eOW;
    }

    public void jt(boolean z) {
        this.eOW = z;
    }

    public boolean bpp() {
        return this.eOX;
    }

    public void ju(boolean z) {
        this.eOX = z;
    }

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eOU;
    }

    public void setFloorNum(int i) {
        this.eOY = i;
    }

    public int getFloorNum() {
        return this.eOY;
    }
}
