package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends cb {
    public static final BdUniqueId eMv = BdUniqueId.gen();
    private boolean eMw = false;
    private boolean eMx = false;
    private boolean eMy = false;
    private int eMz;

    public boolean blM() {
        return this.eMw;
    }

    public void jq(boolean z) {
        this.eMw = z;
    }

    public boolean blN() {
        return this.eMx;
    }

    public void jr(boolean z) {
        this.eMx = z;
    }

    public boolean blO() {
        return this.eMy;
    }

    public void js(boolean z) {
        this.eMy = z;
    }

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eMv;
    }

    public void setFloorNum(int i) {
        this.eMz = i;
    }

    public int getFloorNum() {
        return this.eMz;
    }
}
