package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a eLL = null;

    private a() {
    }

    public static synchronized a bqn() {
        a aVar;
        synchronized (a.class) {
            if (eLL == null) {
                eLL = new a();
            }
            aVar = eLL;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void c(String str, long j) {
        TbadkSettings.getInst().saveLong(BB(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long bV(String str) {
        return TbadkSettings.getInst().loadLong(BB(str), 0L);
    }

    private String BB(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
