package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class ca extends BaseCardInfo {
    public bz eHK;
    public int eRV;
    public int eRW;
    public int eRX;
    public String stType;

    public ca(bz bzVar) {
        this.eHK = bzVar;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
