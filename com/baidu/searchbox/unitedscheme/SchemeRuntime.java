package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.bz3;
import com.baidu.tieba.dz3;
import com.baidu.tieba.k90;
import com.baidu.tieba.uu9;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return k90.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return uu9.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return bz3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return dz3.a();
    }
}
