package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class am extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo aaa;
    private String card;
    private boolean eGJ;

    public void AS(String str) {
        this.card = str;
    }

    public void bnf() {
        this.aaa = com.baidu.tieba.lego.card.b.Oo(this.card);
        this.eGJ = this.aaa != null;
    }

    public ICardInfo bng() {
        return this.aaa;
    }

    public boolean isValid() {
        return this.eGJ;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
