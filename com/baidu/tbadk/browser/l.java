package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class l implements a.b {
    private final /* synthetic */ String PA;
    private final /* synthetic */ String PG;
    private final /* synthetic */ TbPageContext Pz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbPageContext tbPageContext, String str, String str2) {
        this.Pz = tbPageContext;
        this.PA = str;
        this.PG = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.c(this.Pz.getPageActivity(), this.PA, this.PG);
    }
}
