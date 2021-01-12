package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a eXn = null;

    private a() {
    }

    public static synchronized a brD() {
        a aVar;
        synchronized (a.class) {
            if (eXn == null) {
                eXn = new a();
            }
            aVar = eXn;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void c(String str, long j) {
        TbadkSettings.getInst().saveLong(Au(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long bS(String str) {
        return TbadkSettings.getInst().loadLong(Au(str), 0L);
    }

    private String Au(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
