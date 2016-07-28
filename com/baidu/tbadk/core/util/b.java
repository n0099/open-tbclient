package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.e {
    private static b Wx = null;

    private b() {
    }

    public static synchronized b sR() {
        b bVar;
        synchronized (b.class) {
            if (Wx == null) {
                Wx = new b();
            }
            bVar = Wx;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cK(str), j);
    }

    @Override // com.baidu.adp.lib.stats.e
    public long ap(String str) {
        return TbadkSettings.getInst().loadLong(cK(str), 0L);
    }

    private String cK(String str) {
        return "new_log_upload_time_" + str;
    }
}
