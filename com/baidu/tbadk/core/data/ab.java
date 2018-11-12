package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Se;
    private boolean aol;
    private String card;

    public void dP(String str) {
        this.card = str;
    }

    public void xt() {
        this.Se = com.baidu.tieba.lego.card.b.qx(this.card);
        this.aol = this.Se != null;
    }

    public ICardInfo xu() {
        return this.Se;
    }

    public boolean isValid() {
        return this.aol;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }
}
