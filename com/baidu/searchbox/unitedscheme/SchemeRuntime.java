package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.cy3;
import com.baidu.tieba.ey3;
import com.baidu.tieba.m80;
import com.baidu.tieba.v5a;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return m80.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return v5a.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return cy3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return ey3.a();
    }
}
