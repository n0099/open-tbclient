package com.baidu.nps.interfa;
/* loaded from: classes3.dex */
public interface IStatisticManager {
    void recordDownloadResult(int i2, String str, int i3, String str2);

    void recordException(int i2, String str, String str2);

    void recordInstallResult(int i2, String str, int i3, String str2);

    void recordInvokeResult(int i2, String str, int i3, String str2);

    void recordPeriod(long j, long j2);

    void recordResult(long j, int i2, String str);
}
