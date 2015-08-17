package com.baidu.tbadk.core.view;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d extends com.baidu.tbadk.core.flow.a.b {
    private final /* synthetic */ TbPageContext Sn;
    final /* synthetic */ b acU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, TbPageContext tbPageContext) {
        this.acU = bVar;
        this.Sn = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e tc() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(this.Sn.getPageActivity().getResources().getDimensionPixelSize(i.d.ds330));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c tb() {
        com.baidu.tbadk.core.flow.a.c tb = super.tb();
        if (tb != null) {
            tb.setGravity(85);
            tb.bV(i.d.ds20);
            tb.bW(i.d.ds30);
        }
        return tb;
    }
}
