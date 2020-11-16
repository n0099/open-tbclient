package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a eKK = null;

    private a() {
    }

    public static synchronized a bpA() {
        a aVar;
        synchronized (a.class) {
            if (eKK == null) {
                eKK = new a();
            }
            aVar = eKK;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void c(String str, long j) {
        TbadkSettings.getInst().saveLong(Ba(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long bV(String str) {
        return TbadkSettings.getInst().loadLong(Ba(str), 0L);
    }

    private String Ba(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
