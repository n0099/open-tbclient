package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.j80;
import com.baidu.tieba.p1a;
import com.baidu.tieba.xx3;
import com.baidu.tieba.zx3;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return j80.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return p1a.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return xx3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return zx3.a();
    }
}
