package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bx extends com.baidu.tieba.card.data.b {
    public bw eji;
    public int esY;
    public int esZ;
    public int eta;
    public String stType;

    public bx(bw bwVar) {
        this.eji = bwVar;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
