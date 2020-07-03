package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements q {
    private BdUniqueId Un;
    private q Vt;

    public void g(BdUniqueId bdUniqueId) {
        this.Un = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Un;
    }

    public void a(q qVar) {
        this.Vt = qVar;
    }

    public q po() {
        return this.Vt;
    }
}
