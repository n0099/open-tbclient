package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ac extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Pk;
    private boolean agu;
    private String card;

    public void dg(String str) {
        this.card = str;
    }

    public void uh() {
        this.Pk = com.baidu.tieba.lego.card.b.pk(this.card);
        this.agu = this.Pk != null;
    }

    public ICardInfo ui() {
        return this.Pk;
    }

    public boolean isValid() {
        return this.agu;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }
}
