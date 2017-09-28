package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a aeA = null;

    private a() {
    }

    public static synchronized a ud() {
        a aVar;
        synchronized (a.class) {
            if (aeA == null) {
                aeA = new a();
            }
            aVar = aeA;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cW(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long an(String str) {
        return TbadkSettings.getInst().loadLong(cW(str), 0L);
    }

    private String cW(String str) {
        return "new_log_upload_time_" + str;
    }
}
