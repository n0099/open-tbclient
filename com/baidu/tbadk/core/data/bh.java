package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bh extends com.baidu.tieba.card.data.b {
    public int bDS;
    public int bDT;
    public int bDU;
    public String stType;
    public bg threadData;

    public bh(bg bgVar) {
        this.threadData = bgVar;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return null;
    }
}
