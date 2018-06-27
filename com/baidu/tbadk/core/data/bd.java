package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bd extends com.baidu.tieba.card.data.b {
    public int akx;
    public int aky;
    public int akz;
    public String stType;
    public bc threadData;

    public bd(bc bcVar) {
        this.threadData = bcVar;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return null;
    }
}
