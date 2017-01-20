package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class l implements a.b {
    private final /* synthetic */ TbPageContext LO;
    private final /* synthetic */ String LP;
    private final /* synthetic */ String LQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbPageContext tbPageContext, String str, String str2) {
        this.LO = tbPageContext;
        this.LP = str;
        this.LQ = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.c(this.LO.getPageActivity(), this.LP, this.LQ);
    }
}
