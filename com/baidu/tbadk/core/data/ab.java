package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean aNa;
    private ICardInfo aNb;
    private String card;

    public void cU(String str) {
        this.card = str;
    }

    public void yg() {
        this.aNb = com.baidu.tieba.lego.card.b.or(this.card);
        this.aNa = this.aNb != null;
    }

    public ICardInfo yh() {
        return this.aNb;
    }

    public boolean isValid() {
        return this.aNa;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }
}
