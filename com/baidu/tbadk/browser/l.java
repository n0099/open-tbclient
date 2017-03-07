package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class l implements a.b {
    private final /* synthetic */ TbPageContext QR;
    private final /* synthetic */ String QS;
    private final /* synthetic */ String QT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbPageContext tbPageContext, String str, String str2) {
        this.QR = tbPageContext;
        this.QS = str;
        this.QT = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.e(this.QR.getPageActivity(), this.QS, this.QT);
    }
}
