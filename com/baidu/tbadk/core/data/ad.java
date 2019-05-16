package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Rh;
    private boolean bGu;
    private String card;

    public void mg(String str) {
        this.card = str;
    }

    public void abX() {
        this.Rh = com.baidu.tieba.lego.card.b.zk(this.card);
        this.bGu = this.Rh != null;
    }

    public ICardInfo abY() {
        return this.Rh;
    }

    public boolean isValid() {
        return this.bGu;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
