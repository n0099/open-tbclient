package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean WJ;
    private ICardInfo WK;
    private String card;

    public void co(String str) {
        this.card = str;
    }

    public void qZ() {
        this.WK = com.baidu.tieba.lego.card.b.lt(this.card);
        this.WJ = this.WK != null;
    }

    public ICardInfo ra() {
        return this.WK;
    }

    public boolean isValid() {
        return this.WJ;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
