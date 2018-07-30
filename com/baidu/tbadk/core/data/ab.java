package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Pj;
    private boolean agc;
    private String card;

    public void dg(String str) {
        this.card = str;
    }

    public void ua() {
        this.Pj = com.baidu.tieba.lego.card.b.pn(this.card);
        this.agc = this.Pj != null;
    }

    public ICardInfo ub() {
        return this.Pj;
    }

    public boolean isValid() {
        return this.agc;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }
}
