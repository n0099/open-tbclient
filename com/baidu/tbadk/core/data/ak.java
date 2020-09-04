package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ak extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Yp;
    private String card;
    private boolean dYO;

    public void zc(String str) {
        this.card = str;
    }

    public void bcU() {
        this.Yp = com.baidu.tieba.lego.card.b.LD(this.card);
        this.dYO = this.Yp != null;
    }

    public ICardInfo bcV() {
        return this.Yp;
    }

    public boolean isValid() {
        return this.dYO;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
