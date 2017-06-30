package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ai extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean VP;
    private ICardInfo VQ;
    private String card;

    public void ct(String str) {
        this.card = str;
    }

    public void pX() {
        this.VQ = com.baidu.tieba.lego.card.b.mF(this.card);
        this.VP = this.VQ != null;
    }

    public ICardInfo pY() {
        return this.VQ;
    }

    public boolean isValid() {
        return this.VP;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
