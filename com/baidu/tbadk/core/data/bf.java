package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends com.baidu.tieba.card.data.b {
    public int aPe;
    public int aPf;
    public String stType;
    public be threadData;

    public bf(be beVar) {
        this.threadData = beVar;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return null;
    }
}
