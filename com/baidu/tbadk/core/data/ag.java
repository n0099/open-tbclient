package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ag extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean RZ;
    private ICardInfo Sa;
    private String card;

    public void cq(String str) {
        this.card = str;
    }

    public void qr() {
        this.Sa = com.baidu.tieba.lego.card.b.ly(this.card);
        this.RZ = this.Sa != null;
    }

    public ICardInfo qs() {
        return this.Sa;
    }

    public boolean isValid() {
        return this.RZ;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
