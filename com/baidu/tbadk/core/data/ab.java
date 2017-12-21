package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean Xk;
    private ICardInfo Xl;
    private String card;

    public void cC(String str) {
        this.card = str;
    }

    public void pZ() {
        this.Xl = com.baidu.tieba.lego.card.b.nL(this.card);
        this.Xk = this.Xl != null;
    }

    public ICardInfo qa() {
        return this.Xl;
    }

    public boolean isValid() {
        return this.Xk;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
