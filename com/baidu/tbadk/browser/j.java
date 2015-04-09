package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ i No;
    private final /* synthetic */ TbPageContext Np;
    private final /* synthetic */ String Nq;
    private final /* synthetic */ String Nr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, TbPageContext tbPageContext, String str, String str2) {
        this.No = iVar;
        this.Np = tbPageContext;
        this.Nq = str;
        this.Nr = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.f(this.Np.getContext(), this.Nq, this.Nr);
    }
}
