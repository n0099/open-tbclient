package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class aj extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo XH;
    private String card;
    private boolean dPr;

    public void wN(String str) {
        this.card = str;
    }

    public void aUB() {
        this.XH = com.baidu.tieba.lego.card.b.IK(this.card);
        this.dPr = this.XH != null;
    }

    public ICardInfo aUC() {
        return this.XH;
    }

    public boolean isValid() {
        return this.dPr;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
