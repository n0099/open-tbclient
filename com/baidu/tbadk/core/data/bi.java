package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bi extends com.baidu.tieba.card.data.b {
    public int bMx;
    public int bMy;
    public int bMz;
    public String stType;
    public bh threadData;

    public bi(bh bhVar) {
        this.threadData = bhVar;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return null;
    }
}
