package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements q {
    private BdUniqueId Uh;
    private q Vm;

    public void g(BdUniqueId bdUniqueId) {
        this.Uh = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Uh;
    }

    public void a(q qVar) {
        this.Vm = qVar;
    }

    public q pp() {
        return this.Vm;
    }
}
