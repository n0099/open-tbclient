package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class an extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo aaD;
    private String card;
    private boolean isValid;

    public void zV(String str) {
        this.card = str;
    }

    public void bmd() {
        this.aaD = com.baidu.tieba.lego.card.b.NC(this.card);
        this.isValid = this.aaD != null;
    }

    public ICardInfo bme() {
        return this.aaD;
    }

    public boolean isValid() {
        return this.isValid;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
