package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Df;
    private boolean cLk;
    private String card;

    public void sg(String str) {
        this.card = str;
    }

    public void ayv() {
        this.Df = com.baidu.tieba.lego.card.b.DI(this.card);
        this.cLk = this.Df != null;
    }

    public ICardInfo ayw() {
        return this.Df;
    }

    public boolean isValid() {
        return this.cLk;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
