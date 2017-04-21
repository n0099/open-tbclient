package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class m implements a.b {
    private final /* synthetic */ TbPageContext Rl;
    private final /* synthetic */ String Rm;
    private final /* synthetic */ String Rn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbPageContext tbPageContext, String str, String str2) {
        this.Rl = tbPageContext;
        this.Rm = str;
        this.Rn = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        f.e(this.Rl.getPageActivity(), this.Rm, this.Rn);
    }
}
