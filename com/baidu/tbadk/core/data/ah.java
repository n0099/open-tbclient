package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean VP;
    private ICardInfo VQ;
    private String card;

    public void cn(String str) {
        this.card = str;
    }

    public void qa() {
        this.VQ = com.baidu.tieba.lego.card.b.lI(this.card);
        this.VP = this.VQ != null;
    }

    public ICardInfo qb() {
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
