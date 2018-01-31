package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean aLH;
    private ICardInfo aLI;
    private String card;

    public void cJ(String str) {
        this.card = str;
    }

    public void xA() {
        this.aLI = com.baidu.tieba.lego.card.b.oe(this.card);
        this.aLH = this.aLI != null;
    }

    public ICardInfo xB() {
        return this.aLI;
    }

    public boolean isValid() {
        return this.aLH;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }
}
