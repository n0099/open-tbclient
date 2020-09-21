package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ak extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo YH;
    private String card;
    private boolean eaY;

    public void zx(String str) {
        this.card = str;
    }

    public void bdO() {
        this.YH = com.baidu.tieba.lego.card.b.Mf(this.card);
        this.eaY = this.YH != null;
    }

    public ICardInfo bdP() {
        return this.YH;
    }

    public boolean isValid() {
        return this.eaY;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
