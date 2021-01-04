package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class ca extends BaseCardInfo {
    public bz eMv;
    public int eWG;
    public int eWH;
    public int eWI;
    public String stType;

    public ca(bz bzVar) {
        this.eMv = bzVar;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
