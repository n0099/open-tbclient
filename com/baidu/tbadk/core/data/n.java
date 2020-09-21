package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n extends bw {
    public static final BdUniqueId dZt = BdUniqueId.gen();
    private boolean dZu = false;
    private boolean dZv = false;
    private boolean dZw = false;
    private int dZx;

    public boolean bdx() {
        return this.dZu;
    }

    public void hP(boolean z) {
        this.dZu = z;
    }

    public boolean bdy() {
        return this.dZv;
    }

    public void hQ(boolean z) {
        this.dZv = z;
    }

    public boolean bdz() {
        return this.dZw;
    }

    public void hR(boolean z) {
        this.dZw = z;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dZt;
    }

    public void setFloorNum(int i) {
        this.dZx = i;
    }

    public int getFloorNum() {
        return this.dZx;
    }
}
