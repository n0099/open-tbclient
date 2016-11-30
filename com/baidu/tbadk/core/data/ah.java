package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId RQ = BdUniqueId.gen();
    private boolean Se;
    private ICardInfo Sf;
    private String card;

    public void cp(String str) {
        this.card = str;
    }

    public void qq() {
        this.Sf = com.baidu.tieba.lego.card.b.nk(this.card);
        this.Se = this.Sf != null;
    }

    public ICardInfo qr() {
        return this.Sf;
    }

    public boolean isValid() {
        return this.Se;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return RQ;
    }
}
