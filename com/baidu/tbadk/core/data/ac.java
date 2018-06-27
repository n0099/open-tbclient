package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ac extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Pm;
    private boolean agJ;
    private String card;

    public void dj(String str) {
        this.card = str;
    }

    public void un() {
        this.Pm = com.baidu.tieba.lego.card.b.pl(this.card);
        this.agJ = this.Pm != null;
    }

    public ICardInfo uo() {
        return this.Pm;
    }

    public boolean isValid() {
        return this.agJ;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }
}
