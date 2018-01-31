package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class be extends com.baidu.tieba.card.data.b {
    public int aPg;
    public int aPh;
    public String stType;
    public bd threadData;

    public be(bd bdVar) {
        this.threadData = bdVar;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return null;
    }
}
