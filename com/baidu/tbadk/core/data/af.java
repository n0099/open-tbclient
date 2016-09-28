package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class af extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId Ru = BdUniqueId.gen();
    private boolean RH;
    private ICardInfo RI;
    private String card;

    public void cn(String str) {
        this.card = str;
    }

    public void qo() {
        this.RI = com.baidu.tieba.lego.card.b.mY(this.card);
        this.RH = this.RI != null;
    }

    public ICardInfo qp() {
        return this.RI;
    }

    public boolean isValid() {
        return this.RH;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ru;
    }
}
