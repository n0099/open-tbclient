package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ak extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo YX;
    private String card;
    private boolean ena;

    public void Aj(String str) {
        this.card = str;
    }

    public void bgx() {
        this.YX = com.baidu.tieba.lego.card.b.MU(this.card);
        this.ena = this.YX != null;
    }

    public ICardInfo bgy() {
        return this.YX;
    }

    public boolean isValid() {
        return this.ena;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
