package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.az3;
import com.baidu.tieba.iq9;
import com.baidu.tieba.j90;
import com.baidu.tieba.yy3;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return j90.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return iq9.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return yy3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return az3.a();
    }
}
