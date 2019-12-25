package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Da;
    private boolean cKZ;
    private String card;

    public void sd(String str) {
        this.card = str;
    }

    public void ayc() {
        this.Da = com.baidu.tieba.lego.card.b.Dy(this.card);
        this.cKZ = this.Da != null;
    }

    public ICardInfo ayd() {
        return this.Da;
    }

    public boolean isValid() {
        return this.cKZ;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
