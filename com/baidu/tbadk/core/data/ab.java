package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean Xh;
    private ICardInfo Xi;
    private String card;

    public void cC(String str) {
        this.card = str;
    }

    public void pZ() {
        this.Xi = com.baidu.tieba.lego.card.b.nL(this.card);
        this.Xh = this.Xi != null;
    }

    public ICardInfo qa() {
        return this.Xi;
    }

    public boolean isValid() {
        return this.Xh;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
