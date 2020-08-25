package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
/* loaded from: classes9.dex */
public class SchemeConfig {
    public static final boolean DEBUG = false;
    private static final String SCHEME_HEAD;
    private static final Context sAppContext = AppRuntime.getAppContext();

    static {
        ISchemeHeadIoc schemeHeadIoc = SchemeRuntime.getSchemeHeadIoc();
        SCHEME_HEAD = schemeHeadIoc == null ? "" : schemeHeadIoc.getSchemeHead();
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static String getSchemeHead() {
        return SCHEME_HEAD;
    }
}
