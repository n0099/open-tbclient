package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a azW = null;

    private a() {
    }

    public static synchronized a CB() {
        a aVar;
        synchronized (a.class) {
            if (azW == null) {
                azW = new a();
            }
            aVar = azW;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void e(String str, long j) {
        TbadkSettings.getInst().saveLong(eM(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long aX(String str) {
        return TbadkSettings.getInst().loadLong(eM(str), 0L);
    }

    private String eM(String str) {
        return "new_log_upload_time_" + str;
    }
}
