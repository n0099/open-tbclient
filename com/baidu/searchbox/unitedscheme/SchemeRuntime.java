package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.b40;
import com.baidu.tieba.jt3;
import com.baidu.tieba.lma;
import com.baidu.tieba.lt3;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return b40.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return lma.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return jt3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return lt3.a();
    }
}
