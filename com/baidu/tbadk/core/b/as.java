package com.baidu.tbadk.core.b;

import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class as extends com.baidu.tbadk.core.frameworkData.a {
    @Override // com.baidu.tbadk.core.frameworkData.a
    public final boolean a() {
        if (UtilHelper.h(c())) {
            com.baidu.adp.lib.util.i.a(c(), c().getString(com.baidu.tbadk.l.web_view_corrupted));
            return false;
        }
        return true;
    }
}
