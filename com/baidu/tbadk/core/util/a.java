package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a bRo = null;

    private a() {
    }

    public static synchronized a ahW() {
        a aVar;
        synchronized (a.class) {
            if (bRo == null) {
                bRo = new a();
            }
            aVar = bRo;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(nd(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long aJ(String str) {
        return TbadkSettings.getInst().loadLong(nd(str), 0L);
    }

    private String nd(String str) {
        return "new_log_upload_time_" + str;
    }
}
