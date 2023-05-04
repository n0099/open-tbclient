package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.wu3;
import com.baidu.tieba.yu3;
@Autowired
/* loaded from: classes2.dex */
public class SchemeRuntime {
    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return wu3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return yu3.a();
    }
}
