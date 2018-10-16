package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.unitedscheme.ioc.ISchemeIoc;
/* loaded from: classes2.dex */
public class SchemeRuntimeInit {
    public static void setSchemeContextImpl(ISchemeContext iSchemeContext) {
        SchemeRuntime.sSchemeContext = iSchemeContext;
    }

    public static void setSchemeImpl(ISchemeIoc iSchemeIoc) {
        SchemeRuntime.sSchemeIoc = iSchemeIoc;
    }
}
