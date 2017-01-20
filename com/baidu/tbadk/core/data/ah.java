package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean Ri;
    private ICardInfo Rj;
    private String card;

    public void co(String str) {
        this.card = str;
    }

    public void qk() {
        this.Rj = com.baidu.tieba.lego.card.b.lM(this.card);
        this.Ri = this.Rj != null;
    }

    public ICardInfo ql() {
        return this.Rj;
    }

    public boolean isValid() {
        return this.Ri;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
