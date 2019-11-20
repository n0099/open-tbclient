package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Au;
    private boolean bYO;
    private String card;

    public void mP(String str) {
        this.card = str;
    }

    public void ahi() {
        this.Au = com.baidu.tieba.lego.card.b.yP(this.card);
        this.bYO = this.Au != null;
    }

    public ICardInfo ahj() {
        return this.Au;
    }

    public boolean isValid() {
        return this.bYO;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
