package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Rg;
    private boolean bGv;
    private String card;

    public void mf(String str) {
        this.card = str;
    }

    public void abX() {
        this.Rg = com.baidu.tieba.lego.card.b.zm(this.card);
        this.bGv = this.Rg != null;
    }

    public ICardInfo abY() {
        return this.Rg;
    }

    public boolean isValid() {
        return this.bGv;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
