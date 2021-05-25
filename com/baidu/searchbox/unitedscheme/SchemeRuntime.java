package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import d.a.l0.e.p.b;
import d.a.l0.e.p.d;
@Autowired
/* loaded from: classes2.dex */
public class SchemeRuntime {
    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return b.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return d.a();
    }
}
