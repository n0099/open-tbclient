package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.ei9;
import com.baidu.tieba.fw3;
import com.baidu.tieba.hw3;
import com.baidu.tieba.z70;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return z70.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return ei9.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return fw3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return hw3.a();
    }
}
