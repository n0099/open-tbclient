package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ TbPageContext NC;
    private final /* synthetic */ String ND;
    private final /* synthetic */ String NI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbPageContext tbPageContext, String str, String str2) {
        this.NC = tbPageContext;
        this.ND = str;
        this.NI = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.f(this.NC.getPageActivity(), this.ND, this.NI);
    }
}
