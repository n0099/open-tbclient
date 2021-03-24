package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
/* loaded from: classes3.dex */
public class SchemeConfig {
    public static final boolean DEBUG = false;
    public static final String SCHEME_HEAD;
    public static final Context sAppContext = AppRuntime.getAppContext();

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
