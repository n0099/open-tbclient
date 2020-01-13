package com.baidu.swan.config;

import com.baidu.searchbox.config.QuickPersistConfig;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.d.e {
    private b() {
        super(QuickPersistConfig.SP_FILE_STARTUP);
    }

    /* loaded from: classes10.dex */
    private static final class a {
        private static final b cbk = new b();
    }

    public static b agF() {
        return a.cbk;
    }
}
