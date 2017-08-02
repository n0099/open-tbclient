package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean Wf;
    private ICardInfo Wg;
    private String card;

    public void cy(String str) {
        this.card = str;
    }

    public void qa() {
        this.Wg = com.baidu.tieba.lego.card.b.mV(this.card);
        this.Wf = this.Wg != null;
    }

    public ICardInfo qb() {
        return this.Wg;
    }

    public boolean isValid() {
        return this.Wf;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
