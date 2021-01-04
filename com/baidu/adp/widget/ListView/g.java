package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class g extends BaseCardInfo {
    private BdUniqueId Ws;
    private n Xy;

    public void g(BdUniqueId bdUniqueId) {
        this.Ws = bdUniqueId;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.Ws;
    }

    public void a(n nVar) {
        this.Xy = nVar;
    }

    public n qx() {
        return this.Xy;
    }
}
