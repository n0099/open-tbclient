package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ i Nm;
    private final /* synthetic */ TbPageContext Nn;
    private final /* synthetic */ String No;
    private final /* synthetic */ String Np;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, TbPageContext tbPageContext, String str, String str2) {
        this.Nm = iVar;
        this.Nn = tbPageContext;
        this.No = str;
        this.Np = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.f(this.Nn.getContext(), this.No, this.Np);
    }
}
