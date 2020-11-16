package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class by extends BaseCardInfo {
    public int eFF;
    public int eFG;
    public int eFH;
    public bx evQ;
    public String stType;

    public by(bx bxVar) {
        this.evQ = bxVar;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
