package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean XB;
    private ICardInfo XC;
    private String card;

    public void cE(String str) {
        this.card = str;
    }

    public void qk() {
        this.XC = com.baidu.tieba.lego.card.b.mZ(this.card);
        this.XB = this.XC != null;
    }

    public ICardInfo ql() {
        return this.XC;
    }

    public boolean isValid() {
        return this.XB;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
