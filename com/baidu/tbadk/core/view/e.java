package com.baidu.tbadk.core.view;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.core.flow.a.b {
    private final /* synthetic */ TbPageContext NC;
    final /* synthetic */ c XX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, TbPageContext tbPageContext) {
        this.XX = cVar;
        this.NC = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e rW() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(this.NC.getPageActivity().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds330));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c rV() {
        com.baidu.tbadk.core.flow.a.c rV = super.rV();
        if (rV != null) {
            rV.setGravity(85);
            rV.bN(com.baidu.tieba.o.ds20);
            rV.bO(com.baidu.tieba.o.ds30);
        }
        return rV;
    }
}
