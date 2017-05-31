package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements a.b {
    private final /* synthetic */ TbPageContext Qp;
    private final /* synthetic */ String Qq;
    private final /* synthetic */ String Qr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbPageContext tbPageContext, String str, String str2) {
        this.Qp = tbPageContext;
        this.Qq = str;
        this.Qr = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.e(this.Qp.getPageActivity(), this.Qq, this.Qr);
    }
}
