package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Dy;
    private boolean cPC;
    private String card;

    public void sx(String str) {
        this.card = str;
    }

    public void aAO() {
        this.Dy = com.baidu.tieba.lego.card.b.DZ(this.card);
        this.cPC = this.Dy != null;
    }

    public ICardInfo aAP() {
        return this.Dy;
    }

    public boolean isValid() {
        return this.cPC;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
