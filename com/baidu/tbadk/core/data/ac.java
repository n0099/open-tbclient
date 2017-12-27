package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ac extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean aLI;
    private ICardInfo aLJ;
    private String card;

    public void cJ(String str) {
        this.card = str;
    }

    public void xC() {
        this.aLJ = com.baidu.tieba.lego.card.b.nU(this.card);
        this.aLI = this.aLJ != null;
    }

    public ICardInfo xD() {
        return this.aLJ;
    }

    public boolean isValid() {
        return this.aLI;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }
}
