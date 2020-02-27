package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Dy;
    private boolean cPn;
    private String card;

    public void sx(String str) {
        this.card = str;
    }

    public void aAJ() {
        this.Dy = com.baidu.tieba.lego.card.b.DY(this.card);
        this.cPn = this.Dy != null;
    }

    public ICardInfo aAK() {
        return this.Dy;
    }

    public boolean isValid() {
        return this.cPn;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
