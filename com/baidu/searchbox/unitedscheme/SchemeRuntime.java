package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.swan.apps.scheme.b;
import com.baidu.swan.apps.scheme.d;
/* loaded from: classes14.dex */
public class SchemeRuntime {
    public static ISchemeIoc getSchemeIoc() {
        return d.asC();
    }

    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return b.asB();
    }
}
