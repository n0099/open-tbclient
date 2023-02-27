package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.lw3;
import com.baidu.tieba.nw3;
@Autowired
/* loaded from: classes3.dex */
public class SchemeRuntime {
    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return lw3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return nw3.a();
    }
}
