package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean XD;
    private ICardInfo XE;
    private String card;

    public void cE(String str) {
        this.card = str;
    }

    public void qk() {
        this.XE = com.baidu.tieba.lego.card.b.nd(this.card);
        this.XD = this.XE != null;
    }

    public ICardInfo ql() {
        return this.XE;
    }

    public boolean isValid() {
        return this.XD;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
