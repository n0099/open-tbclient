package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class z extends com.baidu.tieba.card.a.b {
    public static final BdUniqueId Op = BdUniqueId.gen();
    private boolean OC;
    private ICardInfo OD;
    private String card;

    public void cm(String str) {
        this.card = str;
    }

    public void pr() {
        this.OD = com.baidu.tieba.lego.card.a.lV(this.card);
        this.OC = this.OD != null;
    }

    public ICardInfo ps() {
        return this.OD;
    }

    public boolean isValid() {
        return this.OC;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Op;
    }
}
