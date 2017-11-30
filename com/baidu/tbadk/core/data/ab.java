package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean Xn;
    private ICardInfo Xo;
    private String card;

    public void cC(String str) {
        this.card = str;
    }

    public void qb() {
        this.Xo = com.baidu.tieba.lego.card.b.nL(this.card);
        this.Xn = this.Xo != null;
    }

    public ICardInfo qc() {
        return this.Xo;
    }

    public boolean isValid() {
        return this.Xn;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
