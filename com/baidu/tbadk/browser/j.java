package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
class j implements ay.b {
    @Override // com.baidu.tbadk.core.util.ay.b
    public void a(TbPageContext<?> tbPageContext, String str, String str2, boolean z, ay.c cVar, boolean z2) {
        if (!z2) {
            Static.a(tbPageContext, str2, str, z, true, true, true);
        } else {
            Static.c(tbPageContext, str2, null, false, true, true, true);
        }
    }
}
