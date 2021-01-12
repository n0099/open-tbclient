package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class g extends BaseCardInfo {
    private BdUniqueId Wq;
    private n Xw;

    public void g(BdUniqueId bdUniqueId) {
        this.Wq = bdUniqueId;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.Wq;
    }

    public void a(n nVar) {
        this.Xw = nVar;
    }

    public n qx() {
        return this.Xw;
    }
}
