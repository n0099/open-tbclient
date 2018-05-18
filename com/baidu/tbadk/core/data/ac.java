package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ac extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo IZ;
    private boolean Ys;
    private String card;

    public void cI(String str) {
        this.card = str;
    }

    public void qL() {
        this.IZ = com.baidu.tieba.lego.card.b.oy(this.card);
        this.Ys = this.IZ != null;
    }

    public ICardInfo qM() {
        return this.IZ;
    }

    public boolean isValid() {
        return this.Ys;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }
}
