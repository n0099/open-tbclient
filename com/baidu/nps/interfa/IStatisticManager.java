package com.baidu.nps.interfa;
/* loaded from: classes4.dex */
public interface IStatisticManager {
    void recordDownloadResult(int i, String str, int i2, String str2);

    void recordException(int i, String str, String str2);

    void recordInstallResult(int i, String str, int i2, String str2);

    void recordInvokeResult(int i, String str, int i2, String str2);

    void recordPeriod(long j, long j2);

    void recordResult(long j, int i, String str);
}
