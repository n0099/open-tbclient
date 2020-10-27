package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n extends bw {
    public static final BdUniqueId etV = BdUniqueId.gen();
    private boolean etW = false;
    private boolean etX = false;
    private boolean etY = false;
    private int etZ;

    public boolean bhZ() {
        return this.etW;
    }

    public void iy(boolean z) {
        this.etW = z;
    }

    public boolean bia() {
        return this.etX;
    }

    public void iz(boolean z) {
        this.etX = z;
    }

    public boolean bib() {
        return this.etY;
    }

    public void iA(boolean z) {
        this.etY = z;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return etV;
    }

    public void setFloorNum(int i) {
        this.etZ = i;
    }

    public int getFloorNum() {
        return this.etZ;
    }
}
