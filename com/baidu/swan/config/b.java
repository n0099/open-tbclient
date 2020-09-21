package com.baidu.swan.config;

import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.swan.c.i;
/* loaded from: classes14.dex */
public class b extends i {
    private b() {
        super(QuickPersistConfig.SP_FILE_STARTUP);
    }

    /* loaded from: classes14.dex */
    private static final class a {
        private static final b djw = new b();
    }

    public static b aHJ() {
        return a.djw;
    }
}
