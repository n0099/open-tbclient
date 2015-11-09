package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class l implements a.b {
    private final /* synthetic */ TbPageContext RY;
    private final /* synthetic */ String RZ;
    private final /* synthetic */ String Se;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbPageContext tbPageContext, String str, String str2) {
        this.RY = tbPageContext;
        this.RZ = str;
        this.Se = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        g.f(this.RY.getPageActivity(), this.RZ, this.Se);
    }
}
