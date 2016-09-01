package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId Ro = BdUniqueId.gen();
    private boolean RB;
    private ICardInfo RC;
    private String card;

    public void cn(String str) {
        this.card = str;
    }

    public void qd() {
        this.RC = com.baidu.tieba.lego.card.b.mL(this.card);
        this.RB = this.RC != null;
    }

    public ICardInfo qe() {
        return this.RC;
    }

    public boolean isValid() {
        return this.RB;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ro;
    }
}
