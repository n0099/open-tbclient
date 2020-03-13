package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Dy;
    private boolean cPp;
    private String card;

    public void sx(String str) {
        this.card = str;
    }

    public void aAL() {
        this.Dy = com.baidu.tieba.lego.card.b.DZ(this.card);
        this.cPp = this.Dy != null;
    }

    public ICardInfo aAM() {
        return this.Dy;
    }

    public boolean isValid() {
        return this.cPp;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
