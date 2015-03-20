package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.util.bo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements bn {
    @Override // com.baidu.tbadk.core.util.bn
    public void a(TbPageContext<?> tbPageContext, String str, String str2, boolean z, bo boVar) {
        String bG;
        bG = Static.bG(str2);
        if (z) {
            com.baidu.tbadk.coreExtra.util.a.a(tbPageContext, new j(this, tbPageContext, str, bG), new k(this), bG);
        } else {
            f.f(tbPageContext.getContext(), str, bG);
        }
    }
}
