package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a eZD = null;

    private a() {
    }

    public static synchronized a brW() {
        a aVar;
        synchronized (a.class) {
            if (eZD == null) {
                eZD = new a();
            }
            aVar = eZD;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void c(String str, long j) {
        TbadkSettings.getInst().saveLong(AL(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long bS(String str) {
        return TbadkSettings.getInst().loadLong(AL(str), 0L);
    }

    private String AL(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
