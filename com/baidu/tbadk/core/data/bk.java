package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bk extends com.baidu.tieba.card.data.b {
    public bj cNb;
    public int cQx;
    public int cQy;
    public int cQz;
    public String stType;

    public bk(bj bjVar) {
        this.cNb = bjVar;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return null;
    }
}
