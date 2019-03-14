package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Tv;
    private boolean bzf;
    private String card;

    public void la(String str) {
        this.card = str;
    }

    public void Xt() {
        this.Tv = com.baidu.tieba.lego.card.b.xV(this.card);
        this.bzf = this.Tv != null;
    }

    public ICardInfo Xu() {
        return this.Tv;
    }

    public boolean isValid() {
        return this.bzf;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
