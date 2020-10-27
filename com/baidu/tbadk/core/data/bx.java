package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bx extends com.baidu.tieba.card.data.b {
    public int eBA;
    public int eBy;
    public int eBz;
    public bw erH;
    public String stType;

    public bx(bw bwVar) {
        this.erH = bwVar;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
