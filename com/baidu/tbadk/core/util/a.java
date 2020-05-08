package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a dyd = null;

    private a() {
    }

    public static synchronized a aNZ() {
        a aVar;
        synchronized (a.class) {
            if (dyd == null) {
                dyd = new a();
            }
            aVar = dyd;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(generateKey(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long bO(String str) {
        return TbadkSettings.getInst().loadLong(generateKey(str), 0L);
    }

    private String generateKey(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
