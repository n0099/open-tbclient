package com.baidu.tbadk.core.view;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d extends com.baidu.tbadk.core.flow.a.b {
    private final /* synthetic */ TbPageContext Sk;
    final /* synthetic */ b adf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, TbPageContext tbPageContext) {
        this.adf = bVar;
        this.Sk = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e th() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(this.Sk.getPageActivity().getResources().getDimensionPixelSize(i.d.ds330));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c tg() {
        com.baidu.tbadk.core.flow.a.c tg = super.tg();
        if (tg != null) {
            tg.setGravity(85);
            tg.bY(i.d.ds20);
            tg.bZ(i.d.ds30);
        }
        return tg;
    }
}
