package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.unitedscheme.ioc.ISchemeIoc;
/* loaded from: classes2.dex */
public class SchemeRuntime {
    static ISchemeContext sSchemeContext;
    static ISchemeIoc sSchemeIoc;

    public static ISchemeContext getSchemeContext() {
        return sSchemeContext;
    }

    public static ISchemeIoc getSchemeIoc() {
        return sSchemeIoc;
    }
}
