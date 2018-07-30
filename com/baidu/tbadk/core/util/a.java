package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a aol = null;

    private a() {
    }

    public static synchronized a yc() {
        a aVar;
        synchronized (a.class) {
            if (aol == null) {
                aol = new a();
            }
            aVar = aol;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(dM(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long aH(String str) {
        return TbadkSettings.getInst().loadLong(dM(str), 0L);
    }

    private String dM(String str) {
        return "new_log_upload_time_" + str;
    }
}
