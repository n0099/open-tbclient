package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class i extends BaseCardInfo {
    private BdUniqueId Wv;
    private q XA;

    public void g(BdUniqueId bdUniqueId) {
        this.Wv = bdUniqueId;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Wv;
    }

    public void a(q qVar) {
        this.XA = qVar;
    }

    public q qV() {
        return this.XA;
    }
}
