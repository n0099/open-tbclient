package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class l implements a.b {
    private final /* synthetic */ TbPageContext Sk;
    private final /* synthetic */ String Sl;
    private final /* synthetic */ String Sq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbPageContext tbPageContext, String str, String str2) {
        this.Sk = tbPageContext;
        this.Sl = str;
        this.Sq = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        g.f(this.Sk.getPageActivity(), this.Sl, this.Sq);
    }
}
