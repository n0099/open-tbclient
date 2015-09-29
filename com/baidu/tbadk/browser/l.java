package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class l implements a.b {
    private final /* synthetic */ TbPageContext RW;
    private final /* synthetic */ String RX;
    private final /* synthetic */ String Sc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbPageContext tbPageContext, String str, String str2) {
        this.RW = tbPageContext;
        this.RX = str;
        this.Sc = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        g.f(this.RW.getPageActivity(), this.RX, this.Sc);
    }
}
