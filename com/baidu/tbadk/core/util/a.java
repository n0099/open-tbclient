package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes2.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a eiW = null;

    private a() {
    }

    public static synchronized a biq() {
        a aVar;
        synchronized (a.class) {
            if (eiW == null) {
                eiW = new a();
            }
            aVar = eiW;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void c(String str, long j) {
        TbadkSettings.getInst().saveLong(generateKey(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long bT(String str) {
        return TbadkSettings.getInst().loadLong(generateKey(str), 0L);
    }

    private String generateKey(String str) {
        return SharedPrefConfig.NEW_LOG_UPLOAD_TIME_PREFIX + str;
    }
}
