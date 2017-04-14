package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class m implements a.b {
    private final /* synthetic */ TbPageContext Rj;
    private final /* synthetic */ String Rk;
    private final /* synthetic */ String Rl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbPageContext tbPageContext, String str, String str2) {
        this.Rj = tbPageContext;
        this.Rk = str;
        this.Rl = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.e(this.Rj.getPageActivity(), this.Rk, this.Rl);
    }
}
