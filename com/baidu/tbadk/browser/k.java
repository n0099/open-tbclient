package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements bb.c {
    @Override // com.baidu.tbadk.core.util.bb.c
    public void a(TbPageContext<?> tbPageContext, String str, String str2, boolean z, bb.d dVar, boolean z2) {
        if (!z2) {
            i.a(tbPageContext, str2, str, z, true, true, true);
        } else {
            i.c(tbPageContext, str2, null, false, true, true, true);
        }
    }
}
