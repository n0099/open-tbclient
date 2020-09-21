package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a elp = null;

    private a() {
    }

    public static synchronized a bjl() {
        a aVar;
        synchronized (a.class) {
            if (elp == null) {
                elp = new a();
            }
            aVar = elp;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void c(String str, long j) {
        TbadkSettings.getInst().saveLong(Ai(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long bV(String str) {
        return TbadkSettings.getInst().loadLong(Ai(str), 0L);
    }

    private String Ai(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
