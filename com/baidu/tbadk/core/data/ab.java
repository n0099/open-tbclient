package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Sc;
    private boolean any;
    private String card;

    public void dP(String str) {
        this.card = str;
    }

    public void xl() {
        this.Sc = com.baidu.tieba.lego.card.b.qw(this.card);
        this.any = this.Sc != null;
    }

    public ICardInfo xm() {
        return this.Sc;
    }

    public boolean isValid() {
        return this.any;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }
}
