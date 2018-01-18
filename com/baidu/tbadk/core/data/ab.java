package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean aLE;
    private ICardInfo aLF;
    private String card;

    public void cJ(String str) {
        this.card = str;
    }

    public void xz() {
        this.aLF = com.baidu.tieba.lego.card.b.nX(this.card);
        this.aLE = this.aLF != null;
    }

    public ICardInfo xA() {
        return this.aLF;
    }

    public boolean isValid() {
        return this.aLE;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }
}
