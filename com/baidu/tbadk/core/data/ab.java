package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean aMP;
    private ICardInfo aMQ;
    private String card;

    public void cU(String str) {
        this.card = str;
    }

    public void yg() {
        this.aMQ = com.baidu.tieba.lego.card.b.or(this.card);
        this.aMP = this.aMQ != null;
    }

    public ICardInfo yh() {
        return this.aMQ;
    }

    public boolean isValid() {
        return this.aMP;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }
}
