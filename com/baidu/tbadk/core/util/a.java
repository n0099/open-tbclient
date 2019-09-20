package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a bRP = null;

    private a() {
    }

    public static synchronized a aia() {
        a aVar;
        synchronized (a.class) {
            if (bRP == null) {
                bRP = new a();
            }
            aVar = bRP;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void f(String str, long j) {
        TbadkSettings.getInst().saveLong(nf(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long aJ(String str) {
        return TbadkSettings.getInst().loadLong(nf(str), 0L);
    }

    private String nf(String str) {
        return "new_log_upload_time_" + str;
    }
}
