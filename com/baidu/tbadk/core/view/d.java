package com.baidu.tbadk.core.view;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class d extends com.baidu.tbadk.core.flow.a.b {
    private final /* synthetic */ TbPageContext Np;
    final /* synthetic */ b Xk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, TbPageContext tbPageContext) {
        this.Xk = bVar;
        this.Np = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e rm() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(this.Np.getPageActivity().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds330));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c rl() {
        com.baidu.tbadk.core.flow.a.c rl = super.rl();
        if (rl != null) {
            rl.setGravity(85);
            rl.bJ(com.baidu.tieba.t.ds20);
            rl.bK(com.baidu.tieba.t.ds30);
        }
        return rl;
    }
}
