package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class af extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean WU;
    private ICardInfo WV;
    private String card;

    public void cC(String str) {
        this.card = str;
    }

    public void pY() {
        this.WV = com.baidu.tieba.lego.card.b.nC(this.card);
        this.WU = this.WV != null;
    }

    public ICardInfo pZ() {
        return this.WV;
    }

    public boolean isValid() {
        return this.WU;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
