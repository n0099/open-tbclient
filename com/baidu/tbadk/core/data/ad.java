package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Tu;
    private boolean bzd;
    private String card;

    public void la(String str) {
        this.card = str;
    }

    public void Xt() {
        this.Tu = com.baidu.tieba.lego.card.b.xX(this.card);
        this.bzd = this.Tu != null;
    }

    public ICardInfo Xu() {
        return this.Tu;
    }

    public boolean isValid() {
        return this.bzd;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
