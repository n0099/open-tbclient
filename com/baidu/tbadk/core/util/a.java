package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a fbV = null;

    private a() {
    }

    public static synchronized a bvw() {
        a aVar;
        synchronized (a.class) {
            if (fbV == null) {
                fbV = new a();
            }
            aVar = fbV;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void c(String str, long j) {
        TbadkSettings.getInst().saveLong(BG(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long bS(String str) {
        return TbadkSettings.getInst().loadLong(BG(str), 0L);
    }

    private String BG(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
