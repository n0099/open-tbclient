package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
import com.baidu.tieba.a40;
import com.baidu.tieba.ft3;
import com.baidu.tieba.ht3;
import com.baidu.tieba.oha;
@Autowired
/* loaded from: classes4.dex */
public class SchemeRuntime {
    @Inject(force = false)
    public static IExternalTransferIoc getExternalTransferIoc() {
        return a40.a();
    }

    @Inject
    public static IFlyingScheduleIoc getFlyingScheduleIoc() {
        return oha.a();
    }

    @Inject
    public static ISchemeHeadIoc getSchemeHeadIoc() {
        return ft3.a();
    }

    @Inject
    public static ISchemeIoc getSchemeIoc() {
        return ht3.a();
    }
}
