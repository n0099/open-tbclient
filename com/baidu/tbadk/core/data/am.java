package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class am extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo aaJ;
    private String card;
    private boolean eQz;

    public void AQ(String str) {
        this.card = str;
    }

    public void bpE() {
        this.aaJ = com.baidu.tieba.lego.card.b.NW(this.card);
        this.eQz = this.aaJ != null;
    }

    public ICardInfo bpF() {
        return this.aaJ;
    }

    public boolean isValid() {
        return this.eQz;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
