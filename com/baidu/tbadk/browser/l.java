package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements be.c {
    @Override // com.baidu.tbadk.core.util.be.c
    public void a(TbPageContext<?> tbPageContext, String str, String str2, boolean z, be.d dVar, boolean z2) {
        if (!z2) {
            j.a(tbPageContext, str2, str, z, true, true, true);
        } else {
            j.c(tbPageContext, str2, null, false, true, true, true);
        }
    }
}
