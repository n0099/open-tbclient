package aegon.chrome.net.impl;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes5.dex */
public final class CronetMetrics extends RequestFinishedInfo.Metrics {
    public static final /* synthetic */ boolean $assertionsDisabled = !CronetMetrics.class.desiredAssertionStatus();

    public CronetMetrics(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15) {
        if (!$assertionsDisabled && !checkOrder(j2, j3)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !checkOrder(j4, j5)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !checkOrder(j6, j7)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !checkOrder(j8, j9)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !checkOrder(j10, j11)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && j13 < j12) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && j2 < j && j2 != -1) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && j8 < j && j8 != -1) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && j6 < j4 && j6 != -1) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && j12 < j8 && j12 != -1) {
            throw new AssertionError();
        }
        Long.valueOf(j14);
        Long.valueOf(j15);
        int i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
        if (i != 0 && j12 != -1) {
            Long.valueOf(j12 - j);
        }
        if (i == 0 || j13 == -1) {
            return;
        }
        Long.valueOf(j13 - j);
    }

    public static boolean checkOrder(long j, long j2) {
        return (j2 >= j && j != -1) || j2 == -1;
    }
}
