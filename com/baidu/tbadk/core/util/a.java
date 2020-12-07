package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a eRW = null;

    private a() {
    }

    public static synchronized a bsU() {
        a aVar;
        synchronized (a.class) {
            if (eRW == null) {
                eRW = new a();
            }
            aVar = eRW;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void c(String str, long j) {
        TbadkSettings.getInst().saveLong(BH(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long bY(String str) {
        return TbadkSettings.getInst().loadLong(BH(str), 0L);
    }

    private String BH(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
