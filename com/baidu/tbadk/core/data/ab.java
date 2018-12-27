package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Se;
    private boolean arM;
    private String card;

    public void eh(String str) {
        this.card = str;
    }

    public void yx() {
        this.Se = com.baidu.tieba.lego.card.b.rc(this.card);
        this.arM = this.Se != null;
    }

    public ICardInfo yy() {
        return this.Se;
    }

    public boolean isValid() {
        return this.arM;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }
}
