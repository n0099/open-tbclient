package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class l implements a.b {
    private final /* synthetic */ TbPageContext MB;
    private final /* synthetic */ String MC;
    private final /* synthetic */ String MD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbPageContext tbPageContext, String str, String str2) {
        this.MB = tbPageContext;
        this.MC = str;
        this.MD = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.c(this.MB.getPageActivity(), this.MC, this.MD);
    }
}
