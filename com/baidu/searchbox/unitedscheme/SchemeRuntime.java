package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.tu3;
import com.baidu.tieba.vu3;
@Autowired
/* loaded from: classes2.dex */
public class SchemeRuntime {
    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return tu3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return vu3.a();
    }
}
