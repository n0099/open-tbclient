package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.fy3;
import com.baidu.tieba.hy3;
import com.baidu.tieba.m80;
import com.baidu.tieba.v9a;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return m80.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return v9a.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return fy3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return hy3.a();
    }
}
