package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class m implements a.b {
    private final /* synthetic */ TbPageContext Kq;
    private final /* synthetic */ String Kr;
    private final /* synthetic */ String Kw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbPageContext tbPageContext, String str, String str2) {
        this.Kq = tbPageContext;
        this.Kr = str;
        this.Kw = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.c(this.Kq.getPageActivity(), this.Kr, this.Kw);
    }
}
