package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ac extends com.baidu.tieba.card.a.b {
    public static final BdUniqueId OB = BdUniqueId.gen();
    private boolean OQ;
    private ICardInfo OR;
    private String card;

    public void cm(String str) {
        this.card = str;
    }

    public void pa() {
        this.OR = com.baidu.tieba.lego.card.a.mc(this.card);
        this.OQ = this.OR != null;
    }

    public ICardInfo pb() {
        return this.OR;
    }

    public boolean isValid() {
        return this.OQ;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return OB;
    }
}
