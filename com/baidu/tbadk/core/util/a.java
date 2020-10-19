package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a exy = null;

    private a() {
    }

    public static synchronized a blU() {
        a aVar;
        synchronized (a.class) {
            if (exy == null) {
                exy = new a();
            }
            aVar = exy;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void c(String str, long j) {
        TbadkSettings.getInst().saveLong(AU(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long bV(String str) {
        return TbadkSettings.getInst().loadLong(AU(str), 0L);
    }

    private String AU(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
