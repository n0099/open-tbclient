package aegon.chrome.net.impl;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes.dex */
public final class CronetMetrics extends RequestFinishedInfo.Metrics {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    public CronetMetrics(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15) {
        int i2 = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
        if (i2 != 0) {
            int i3 = (j12 > (-1L) ? 1 : (j12 == (-1L) ? 0 : -1));
        }
        if (i2 != 0) {
            int i4 = (j13 > (-1L) ? 1 : (j13 == (-1L) ? 0 : -1));
        }
    }

    public static boolean checkOrder(long j, long j2) {
        return (j2 >= j && j != -1) || j2 == -1;
    }
}
