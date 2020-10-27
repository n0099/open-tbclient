package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ak extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo YY;
    private String card;
    private boolean evA;

    public void AC(String str) {
        this.card = str;
    }

    public void biq() {
        this.YY = com.baidu.tieba.lego.card.b.Ns(this.card);
        this.evA = this.YY != null;
    }

    public ICardInfo bir() {
        return this.YY;
    }

    public boolean isValid() {
        return this.evA;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
