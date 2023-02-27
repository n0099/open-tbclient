package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
/* loaded from: classes3.dex */
public class SchemeConfig {
    public static final String SCHEME_HEAD;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final Context sAppContext = AppRuntime.getAppContext();

    static {
        String schemeHead;
        ISchemeHeadIoc schemeHeadIoc = SchemeRuntime.getSchemeHeadIoc();
        if (schemeHeadIoc == null) {
            schemeHead = "";
        } else {
            schemeHead = schemeHeadIoc.getSchemeHead();
        }
        SCHEME_HEAD = schemeHead;
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static String getSchemeHead() {
        return SCHEME_HEAD;
    }
}
