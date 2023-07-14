package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.l90;
import com.baidu.tieba.uy3;
import com.baidu.tieba.v2a;
import com.baidu.tieba.wy3;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return l90.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return v2a.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return uy3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return wy3.a();
    }
}
