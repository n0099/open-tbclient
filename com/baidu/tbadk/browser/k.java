package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class k implements a.b {
    private final /* synthetic */ TbPageContext Sn;
    private final /* synthetic */ String So;
    private final /* synthetic */ String St;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbPageContext tbPageContext, String str, String str2) {
        this.Sn = tbPageContext;
        this.So = str;
        this.St = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.f(this.Sn.getPageActivity(), this.So, this.St);
    }
}
