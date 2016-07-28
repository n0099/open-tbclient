package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class m implements a.b {
    private final /* synthetic */ TbPageContext Kp;
    private final /* synthetic */ String Kq;
    private final /* synthetic */ String Kv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbPageContext tbPageContext, String str, String str2) {
        this.Kp = tbPageContext;
        this.Kq = str;
        this.Kv = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.c(this.Kp.getPageActivity(), this.Kq, this.Kv);
    }
}
