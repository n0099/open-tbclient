package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean WN;
    private ICardInfo WO;
    private String card;

    public void cx(String str) {
        this.card = str;
    }

    public void qg() {
        this.WO = com.baidu.tieba.lego.card.b.nA(this.card);
        this.WN = this.WO != null;
    }

    public ICardInfo qh() {
        return this.WO;
    }

    public boolean isValid() {
        return this.WN;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
