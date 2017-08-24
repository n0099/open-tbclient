package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean XE;
    private ICardInfo XF;
    private String card;

    public void cH(String str) {
        this.card = str;
    }

    public void ql() {
        this.XF = com.baidu.tieba.lego.card.b.ni(this.card);
        this.XE = this.XF != null;
    }

    public ICardInfo qm() {
        return this.XF;
    }

    public boolean isValid() {
        return this.XE;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
