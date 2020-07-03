package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ai extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo XP;
    private String card;
    private boolean dJg;

    public void vG(String str) {
        this.card = str;
    }

    public void aQF() {
        this.XP = com.baidu.tieba.lego.card.b.HV(this.card);
        this.dJg = this.XP != null;
    }

    public ICardInfo aQG() {
        return this.XP;
    }

    public boolean isValid() {
        return this.dJg;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
