package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements q {
    private BdUniqueId Vf;
    private q Wi;

    public void g(BdUniqueId bdUniqueId) {
        this.Vf = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vf;
    }

    public void a(q qVar) {
        this.Wi = qVar;
    }

    public q qT() {
        return this.Wi;
    }
}
