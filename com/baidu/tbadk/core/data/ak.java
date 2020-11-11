package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ak extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo YY;
    private String card;
    private boolean eBt;

    public void AQ(String str) {
        this.card = str;
    }

    public void bkQ() {
        this.YY = com.baidu.tieba.lego.card.b.NJ(this.card);
        this.eBt = this.YY != null;
    }

    public ICardInfo bkR() {
        return this.YY;
    }

    public boolean isValid() {
        return this.eBt;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
