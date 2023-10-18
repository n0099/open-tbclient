package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.i4a;
import com.baidu.tieba.j30;
import com.baidu.tieba.os3;
import com.baidu.tieba.qs3;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return j30.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return i4a.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return os3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return qs3.a();
    }
}
