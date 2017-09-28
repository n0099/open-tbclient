package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class af extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean WO;
    private ICardInfo WP;
    private String card;

    public void cx(String str) {
        this.card = str;
    }

    public void qa() {
        this.WP = com.baidu.tieba.lego.card.b.ng(this.card);
        this.WO = this.WP != null;
    }

    public ICardInfo qb() {
        return this.WP;
    }

    public boolean isValid() {
        return this.WO;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
