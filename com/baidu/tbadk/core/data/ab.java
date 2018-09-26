package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo RK;
    private boolean aiD;
    private String card;

    public void dz(String str) {
        this.card = str;
    }

    public void vc() {
        this.RK = com.baidu.tieba.lego.card.b.pU(this.card);
        this.aiD = this.RK != null;
    }

    public ICardInfo vd() {
        return this.RK;
    }

    public boolean isValid() {
        return this.aiD;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }
}
