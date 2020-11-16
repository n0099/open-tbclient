package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class i extends BaseCardInfo {
    private BdUniqueId Vx;
    private q WD;

    public void g(BdUniqueId bdUniqueId) {
        this.Vx = bdUniqueId;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vx;
    }

    public void a(q qVar) {
        this.WD = qVar;
    }

    public q qT() {
        return this.WD;
    }
}
