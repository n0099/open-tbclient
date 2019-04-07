package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.unitedscheme.ioc.ISchemeIoc;
import com.baidu.swan.apps.scheme.b;
import com.baidu.swan.apps.scheme.d;
/* loaded from: classes2.dex */
public class SchemeRuntime {
    public static ISchemeContext getSchemeContext() {
        return b.JD();
    }

    public static ISchemeIoc getSchemeIoc() {
        return d.JE();
    }
}
