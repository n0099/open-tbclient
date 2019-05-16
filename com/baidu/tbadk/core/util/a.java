package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a bQh = null;

    private a() {
    }

    public static synchronized a agS() {
        a aVar;
        synchronized (a.class) {
            if (bQh == null) {
                bQh = new a();
            }
            aVar = bQh;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(mS(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long aI(String str) {
        return TbadkSettings.getInst().loadLong(mS(str), 0L);
    }

    private String mS(String str) {
        return "new_log_upload_time_" + str;
    }
}
