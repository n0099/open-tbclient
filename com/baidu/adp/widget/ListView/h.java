package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h implements o {
    private BdUniqueId TK;
    private o UO;

    public void g(BdUniqueId bdUniqueId) {
        this.TK = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return this.TK;
    }

    public void a(o oVar) {
        this.UO = oVar;
    }

    public o oX() {
        return this.UO;
    }
}
