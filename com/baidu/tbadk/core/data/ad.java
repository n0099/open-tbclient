package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Xl;
    private String card;
    private boolean dCL;

    public void vt(String str) {
        this.card = str;
    }

    public void aOU() {
        this.Xl = com.baidu.tieba.lego.card.b.Ht(this.card);
        this.dCL = this.Xl != null;
    }

    public ICardInfo aOV() {
        return this.Xl;
    }

    public boolean isValid() {
        return this.dCL;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return TYPE;
    }
}
