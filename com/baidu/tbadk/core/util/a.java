package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a bIx = null;

    private a() {
    }

    public static synchronized a abV() {
        a aVar;
        synchronized (a.class) {
            if (bIx == null) {
                bIx = new a();
            }
            aVar = bIx;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void e(String str, long j) {
        TbadkSettings.getInst().saveLong(lK(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long aY(String str) {
        return TbadkSettings.getInst().loadLong(lK(str), 0L);
    }

    private String lK(String str) {
        return "new_log_upload_time_" + str;
    }
}
