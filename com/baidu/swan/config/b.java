package com.baidu.swan.config;

import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.swan.e.j;
/* loaded from: classes11.dex */
public class b extends j {
    private b() {
        super(QuickPersistConfig.SP_FILE_STARTUP);
    }

    /* loaded from: classes11.dex */
    private static final class a {
        private static final b cTE = new b();
    }

    public static b awc() {
        return a.cTE;
    }
}
