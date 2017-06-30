package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class n implements a.b {
    private final /* synthetic */ TbPageContext Qj;
    private final /* synthetic */ String Qk;
    private final /* synthetic */ String Ql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbPageContext tbPageContext, String str, String str2) {
        this.Qj = tbPageContext;
        this.Qk = str;
        this.Ql = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        g.e(this.Qj.getPageActivity(), this.Qk, this.Ql);
    }
}
