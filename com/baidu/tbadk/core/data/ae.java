package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo WW;
    private String card;
    private boolean doM;

    public void tN(String str) {
        this.card = str;
    }

    public void aIZ() {
        this.WW = com.baidu.tieba.lego.card.b.FK(this.card);
        this.doM = this.WW != null;
    }

    public ICardInfo aJa() {
        return this.WW;
    }

    public boolean isValid() {
        return this.doM;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
