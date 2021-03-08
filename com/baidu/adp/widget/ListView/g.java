package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class g extends BaseCardInfo {
    private BdUniqueId XG;
    private n YL;

    public void g(BdUniqueId bdUniqueId) {
        this.XG = bdUniqueId;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.XG;
    }

    public void a(n nVar) {
        this.YL = nVar;
    }

    public n qv() {
        return this.YL;
    }
}
