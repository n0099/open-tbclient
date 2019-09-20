package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Rx;
    private boolean bHU;
    private String card;

    public void ms(String str) {
        this.card = str;
    }

    public void ade() {
        this.Rx = com.baidu.tieba.lego.card.b.Ax(this.card);
        this.bHU = this.Rx != null;
    }

    public ICardInfo adf() {
        return this.Rx;
    }

    public boolean isValid() {
        return this.bHU;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
