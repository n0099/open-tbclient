package com.baidu.swan.config;

import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.swan.c.i;
/* loaded from: classes6.dex */
public class b extends i {
    private b() {
        super(QuickPersistConfig.SP_FILE_STARTUP);
    }

    /* loaded from: classes6.dex */
    private static final class a {
        private static final b dTr = new b();
    }

    public static b aPL() {
        return a.dTr;
    }
}
