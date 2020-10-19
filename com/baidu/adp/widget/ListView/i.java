package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements q {
    private BdUniqueId Vv;
    private q Wy;

    public void g(BdUniqueId bdUniqueId) {
        this.Vv = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vv;
    }

    public void a(q qVar) {
        this.Wy = qVar;
    }

    public q qT() {
        return this.Wy;
    }
}
