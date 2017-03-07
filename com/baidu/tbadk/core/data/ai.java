package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ai extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private boolean Wu;
    private ICardInfo Wv;
    private String card;

    public void ch(String str) {
        this.card = str;
    }

    public void qC() {
        this.Wv = com.baidu.tieba.lego.card.b.ln(this.card);
        this.Wu = this.Wv != null;
    }

    public ICardInfo qD() {
        return this.Wv;
    }

    public boolean isValid() {
        return this.Wu;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
