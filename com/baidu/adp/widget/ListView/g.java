package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class g extends BaseCardInfo {
    private BdUniqueId Wm;
    private n Xs;

    public void g(BdUniqueId bdUniqueId) {
        this.Wm = bdUniqueId;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.Wm;
    }

    public void a(n nVar) {
        this.Xs = nVar;
    }

    public n qv() {
        return this.Xs;
    }
}
