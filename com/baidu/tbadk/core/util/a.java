package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a civ = null;

    private a() {
    }

    public static synchronized a alU() {
        a aVar;
        synchronized (a.class) {
            if (civ == null) {
                civ = new a();
            }
            aVar = civ;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void e(String str, long j) {
        TbadkSettings.getInst().saveLong(nB(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long an(String str) {
        return TbadkSettings.getInst().loadLong(nB(str), 0L);
    }

    private String nB(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
