package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Tw;
    private boolean bzj;
    private String card;

    public void lb(String str) {
        this.card = str;
    }

    public void Xq() {
        this.Tw = com.baidu.tieba.lego.card.b.xU(this.card);
        this.bzj = this.Tw != null;
    }

    public ICardInfo Xr() {
        return this.Tw;
    }

    public boolean isValid() {
        return this.bzj;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
