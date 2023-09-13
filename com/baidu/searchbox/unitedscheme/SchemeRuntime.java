package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.gy3;
import com.baidu.tieba.iy3;
import com.baidu.tieba.n80;
import com.baidu.tieba.p7a;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return n80.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return p7a.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return gy3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return iy3.a();
    }
}
