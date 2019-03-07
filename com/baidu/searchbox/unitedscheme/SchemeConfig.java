package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.core.BuildConfig;
import com.baidu.searchbox.unitedscheme.ioc.ISchemeIoc;
/* loaded from: classes2.dex */
public class SchemeConfig {
    public static final String DEFAULT_SCHEME_HEAD = "baiduboxapp";
    private static final String SCHEME_HEAD;
    public static final boolean DEBUG = BuildConfig.DEBUG;
    private static final Context sAppContext = AppRuntime.getAppContext();

    static {
        ISchemeIoc schemeIoc = SchemeRuntime.getSchemeIoc();
        SCHEME_HEAD = schemeIoc == null ? DEFAULT_SCHEME_HEAD : schemeIoc.getSchemeHead();
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static String getSchemeHead() {
        return SCHEME_HEAD;
    }
}
