package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean WK;
    private ICardInfo WL;
    private String card;

    public void co(String str) {
        this.card = str;
    }

    public void qZ() {
        this.WL = com.baidu.tieba.lego.card.b.lu(this.card);
        this.WK = this.WL != null;
    }

    public ICardInfo ra() {
        return this.WL;
    }

    public boolean isValid() {
        return this.WK;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
