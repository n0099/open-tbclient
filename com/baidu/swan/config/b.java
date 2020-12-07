package com.baidu.swan.config;

import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.swan.c.i;
/* loaded from: classes17.dex */
public class b extends i {
    private b() {
        super(QuickPersistConfig.SP_FILE_STARTUP);
    }

    /* loaded from: classes17.dex */
    private static final class a {
        private static final b dPh = new b();
    }

    public static b aRj() {
        return a.dPh;
    }
}
