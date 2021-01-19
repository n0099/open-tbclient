package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class am extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo aaH;
    private String card;
    private boolean eLO;

    public void zE(String str) {
        this.card = str;
    }

    public void blL() {
        this.aaH = com.baidu.tieba.lego.card.b.MO(this.card);
        this.eLO = this.aaH != null;
    }

    public ICardInfo blM() {
        return this.aaH;
    }

    public boolean isValid() {
        return this.eLO;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
