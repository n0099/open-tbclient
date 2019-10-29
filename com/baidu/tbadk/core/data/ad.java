package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo AW;
    private boolean bZF;
    private String card;

    public void mP(String str) {
        this.card = str;
    }

    public void ahk() {
        this.AW = com.baidu.tieba.lego.card.b.yP(this.card);
        this.bZF = this.AW != null;
    }

    public ICardInfo ahl() {
        return this.AW;
    }

    public boolean isValid() {
        return this.bZF;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
