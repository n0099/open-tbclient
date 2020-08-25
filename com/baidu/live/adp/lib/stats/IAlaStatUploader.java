package com.baidu.live.adp.lib.stats;
/* loaded from: classes7.dex */
public interface IAlaStatUploader {
    void addLog(String str, String str2, long j, String str3, AlaStatsItem alaStatsItem);

    void forceUpload();
}
