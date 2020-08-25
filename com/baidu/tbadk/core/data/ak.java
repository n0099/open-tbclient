package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes2.dex */
public class ak extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Yn;
    private String card;
    private boolean dYK;

    public void zb(String str) {
        this.card = str;
    }

    public void bcU() {
        this.Yn = com.baidu.tieba.lego.card.b.LC(this.card);
        this.dYK = this.Yn != null;
    }

    public ICardInfo bcV() {
        return this.Yn;
    }

    public boolean isValid() {
        return this.dYK;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
