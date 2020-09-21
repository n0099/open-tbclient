package com.baidu.live.adp.lib.stats;
/* loaded from: classes4.dex */
public interface IAlaStatUploader {
    void addLog(String str, String str2, long j, String str3, AlaStatsItem alaStatsItem);

    void forceUpload();
}
