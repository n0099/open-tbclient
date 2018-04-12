package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ac extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Jd;
    private boolean Ys;
    private String card;

    public void cI(String str) {
        this.card = str;
    }

    public void qM() {
        this.Jd = com.baidu.tieba.lego.card.b.ov(this.card);
        this.Ys = this.Jd != null;
    }

    public ICardInfo qN() {
        return this.Jd;
    }

    public boolean isValid() {
        return this.Ys;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }
}
