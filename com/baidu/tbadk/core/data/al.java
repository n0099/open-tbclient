package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class al extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Ze;
    private String card;
    private boolean ezK;

    public void Al(String str) {
        this.card = str;
    }

    public void bjS() {
        this.Ze = com.baidu.tieba.lego.card.b.Nh(this.card);
        this.ezK = this.Ze != null;
    }

    public ICardInfo bjT() {
        return this.Ze;
    }

    public boolean isValid() {
        return this.ezK;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
