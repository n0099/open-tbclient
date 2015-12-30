package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class k implements a.b {
    private final /* synthetic */ TbPageContext SL;
    private final /* synthetic */ String SM;
    private final /* synthetic */ String SR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbPageContext tbPageContext, String str, String str2) {
        this.SL = tbPageContext;
        this.SM = str;
        this.SR = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.f(this.SL.getPageActivity(), this.SM, this.SR);
    }
}
