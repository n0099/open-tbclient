package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class n extends bw {
    public static final BdUniqueId dXf = BdUniqueId.gen();
    private boolean dXg = false;
    private boolean dXh = false;
    private boolean dXi = false;
    private int dXj;

    public boolean bcD() {
        return this.dXg;
    }

    public void hR(boolean z) {
        this.dXg = z;
    }

    public boolean bcE() {
        return this.dXh;
    }

    public void hS(boolean z) {
        this.dXh = z;
    }

    public boolean bcF() {
        return this.dXi;
    }

    public void hT(boolean z) {
        this.dXi = z;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dXf;
    }

    public void setFloorNum(int i) {
        this.dXj = i;
    }

    public int getFloorNum() {
        return this.dXj;
    }
}
