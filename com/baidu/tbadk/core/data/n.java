package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n extends bw {
    public static final BdUniqueId ezO = BdUniqueId.gen();
    private boolean ezP = false;
    private boolean ezQ = false;
    private boolean ezR = false;
    private int ezS;

    public boolean bkz() {
        return this.ezP;
    }

    public void iH(boolean z) {
        this.ezP = z;
    }

    public boolean bkA() {
        return this.ezQ;
    }

    public void iI(boolean z) {
        this.ezQ = z;
    }

    public boolean bkB() {
        return this.ezR;
    }

    public void iJ(boolean z) {
        this.ezR = z;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ezO;
    }

    public void setFloorNum(int i) {
        this.ezS = i;
    }

    public int getFloorNum() {
        return this.ezS;
    }
}
