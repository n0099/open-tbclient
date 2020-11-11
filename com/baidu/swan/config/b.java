package com.baidu.swan.config;

import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.swan.c.i;
/* loaded from: classes9.dex */
public class b extends i {
    private b() {
        super(QuickPersistConfig.SP_FILE_STARTUP);
    }

    /* loaded from: classes9.dex */
    private static final class a {
        private static final b dJR = new b();
    }

    public static b aOM() {
        return a.dJR;
    }
}
