package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.i90;
import com.baidu.tieba.lo9;
import com.baidu.tieba.xy3;
import com.baidu.tieba.zy3;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return i90.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return lo9.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return xy3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return zy3.a();
    }
}
