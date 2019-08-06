package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ICardInfo Ry;
    private boolean bHw;
    private String card;

    public void mq(String str) {
        this.card = str;
    }

    public void ada() {
        this.Ry = com.baidu.tieba.lego.card.b.zY(this.card);
        this.bHw = this.Ry != null;
    }

    public ICardInfo adb() {
        return this.Ry;
    }

    public boolean isValid() {
        return this.bHw;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
