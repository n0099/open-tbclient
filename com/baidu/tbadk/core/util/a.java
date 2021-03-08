package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a fbc = null;

    private a() {
    }

    public static synchronized a brX() {
        a aVar;
        synchronized (a.class) {
            if (fbc == null) {
                fbc = new a();
            }
            aVar = fbc;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void c(String str, long j) {
        TbadkSettings.getInst().saveLong(AS(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long bW(String str) {
        return TbadkSettings.getInst().loadLong(AS(str), 0L);
    }

    private String AS(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
