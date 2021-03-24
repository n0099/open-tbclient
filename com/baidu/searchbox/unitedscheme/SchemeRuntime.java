package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import d.b.g0.a.t1.b;
import d.b.g0.a.t1.d;
@Autowired
/* loaded from: classes3.dex */
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
