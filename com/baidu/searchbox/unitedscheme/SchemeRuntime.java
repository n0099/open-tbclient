package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.su3;
import com.baidu.tieba.uu3;
@Autowired
/* loaded from: classes2.dex */
public class SchemeRuntime {
    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return su3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return uu3.a();
    }
}
