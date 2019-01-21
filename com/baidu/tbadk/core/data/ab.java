package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Sn;
    private boolean asp;
    private String card;

    public void eq(String str) {
        this.card = str;
    }

    public void yK() {
        this.Sn = com.baidu.tieba.lego.card.b.rs(this.card);
        this.asp = this.Sn != null;
    }

    public ICardInfo yL() {
        return this.Sn;
    }

    public boolean isValid() {
        return this.asp;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }
}
