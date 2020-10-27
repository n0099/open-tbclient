package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a eFW = null;

    private a() {
    }

    public static synchronized a bnN() {
        a aVar;
        synchronized (a.class) {
            if (eFW == null) {
                eFW = new a();
            }
            aVar = eFW;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void c(String str, long j) {
        TbadkSettings.getInst().saveLong(Bn(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long bV(String str) {
        return TbadkSettings.getInst().loadLong(Bn(str), 0L);
    }

    private String Bn(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
