package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class an extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo abX;
    private String card;
    private boolean isValid;

    public void Ac(String str) {
        this.card = str;
    }

    public void bmf() {
        this.abX = com.baidu.tieba.lego.card.b.NJ(this.card);
        this.isValid = this.abX != null;
    }

    public ICardInfo bmg() {
        return this.abX;
    }

    public boolean isValid() {
        return this.isValid;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
