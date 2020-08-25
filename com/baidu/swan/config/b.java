package com.baidu.swan.config;

import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.swan.c.i;
/* loaded from: classes10.dex */
public class b extends i {
    private b() {
        super(QuickPersistConfig.SP_FILE_STARTUP);
    }

    /* loaded from: classes10.dex */
    private static final class a {
        private static final b dhp = new b();
    }

    public static b aGZ() {
        return a.dhp;
    }
}
