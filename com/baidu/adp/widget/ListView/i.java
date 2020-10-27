package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements q {
    private BdUniqueId Vw;
    private q Wz;

    public void g(BdUniqueId bdUniqueId) {
        this.Vw = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vw;
    }

    public void a(q qVar) {
        this.Wz = qVar;
    }

    public q qT() {
        return this.Wz;
    }
}
