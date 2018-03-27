package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean aMQ;
    private ICardInfo aMR;
    private String card;

    public void cU(String str) {
        this.card = str;
    }

    public void yg() {
        this.aMR = com.baidu.tieba.lego.card.b.or(this.card);
        this.aMQ = this.aMR != null;
    }

    public ICardInfo yh() {
        return this.aMR;
    }

    public boolean isValid() {
        return this.aMQ;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }
}
