package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a aww = null;

    private a() {
    }

    public static synchronized a Bx() {
        a aVar;
        synchronized (a.class) {
            if (aww == null) {
                aww = new a();
            }
            aVar = aww;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void e(String str, long j) {
        TbadkSettings.getInst().saveLong(eu(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long aX(String str) {
        return TbadkSettings.getInst().loadLong(eu(str), 0L);
    }

    private String eu(String str) {
        return "new_log_upload_time_" + str;
    }
}
