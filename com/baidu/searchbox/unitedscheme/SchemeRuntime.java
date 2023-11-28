package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.b40;
import com.baidu.tieba.gt3;
import com.baidu.tieba.hma;
import com.baidu.tieba.it3;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return b40.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return hma.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return gt3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return it3.a();
    }
}
