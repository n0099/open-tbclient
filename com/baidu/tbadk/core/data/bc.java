package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bc extends com.baidu.tieba.card.data.b {
    public int awm;
    public int awn;
    public int awo;
    public int awp;
    public String stType;
    public bb threadData;

    public bc(bb bbVar) {
        this.threadData = bbVar;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return null;
    }
}
