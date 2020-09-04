package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n extends bw {
    public static final BdUniqueId dXj = BdUniqueId.gen();
    private boolean dXk = false;
    private boolean dXl = false;
    private boolean dXm = false;
    private int dXn;

    public boolean bcD() {
        return this.dXk;
    }

    public void hS(boolean z) {
        this.dXk = z;
    }

    public boolean bcE() {
        return this.dXl;
    }

    public void hT(boolean z) {
        this.dXl = z;
    }

    public boolean bcF() {
        return this.dXm;
    }

    public void hU(boolean z) {
        this.dXm = z;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dXj;
    }

    public void setFloorNum(int i) {
        this.dXn = i;
    }

    public int getFloorNum() {
        return this.dXn;
    }
}
