package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements q {
    private BdUniqueId UM;
    private q VP;

    public void g(BdUniqueId bdUniqueId) {
        this.UM = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.UM;
    }

    public void a(q qVar) {
        this.VP = qVar;
    }

    public q qO() {
        return this.VP;
    }
}
