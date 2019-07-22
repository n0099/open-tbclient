package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Ry;
    private boolean bHv;
    private String card;

    public void mq(String str) {
        this.card = str;
    }

    public void acZ() {
        this.Ry = com.baidu.tieba.lego.card.b.zX(this.card);
        this.bHv = this.Ry != null;
    }

    public ICardInfo ada() {
        return this.Ry;
    }

    public boolean isValid() {
        return this.bHv;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
