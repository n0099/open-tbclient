package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Tv;
    private boolean bzi;
    private String card;

    public void lb(String str) {
        this.card = str;
    }

    public void Xq() {
        this.Tv = com.baidu.tieba.lego.card.b.xU(this.card);
        this.bzi = this.Tv != null;
    }

    public ICardInfo Xr() {
        return this.Tv;
    }

    public boolean isValid() {
        return this.bzi;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
