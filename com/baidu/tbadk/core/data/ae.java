package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo WT;
    private String card;
    private boolean doI;

    public void tK(String str) {
        this.card = str;
    }

    public void aJb() {
        this.WT = com.baidu.tieba.lego.card.b.FH(this.card);
        this.doI = this.WT != null;
    }

    public ICardInfo aJc() {
        return this.WT;
    }

    public boolean isValid() {
        return this.doI;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
