package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean Wb;
    private ICardInfo Wc;
    private String card;

    public void co(String str) {
        this.card = str;
    }

    public void qj() {
        this.Wc = com.baidu.tieba.lego.card.b.ly(this.card);
        this.Wb = this.Wc != null;
    }

    public ICardInfo qk() {
        return this.Wc;
    }

    public boolean isValid() {
        return this.Wb;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
