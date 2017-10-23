package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class af extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean WC;
    private ICardInfo WD;
    private String card;

    public void cw(String str) {
        this.card = str;
    }

    public void pT() {
        this.WD = com.baidu.tieba.lego.card.b.nf(this.card);
        this.WC = this.WD != null;
    }

    public ICardInfo pU() {
        return this.WD;
    }

    public boolean isValid() {
        return this.WC;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
