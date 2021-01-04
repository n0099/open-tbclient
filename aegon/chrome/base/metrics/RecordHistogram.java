package aegon.chrome.base.metrics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class RecordHistogram {
    public static Map<String, Long> sCache;
    public static Throwable sDisabledBy;

    static {
        RecordHistogram.class.desiredAssertionStatus();
        sCache = Collections.synchronizedMap(new HashMap());
    }

    public static native int nativeGetHistogramTotalCountForTesting(String str);

    public static native int nativeGetHistogramValueCountForTesting(String str, int i);

    public static native long nativeRecordBooleanHistogram(String str, long j, boolean z);

    public static native long nativeRecordCustomCountHistogram(String str, long j, int i, int i2, int i3, int i4);

    public static native long nativeRecordCustomTimesHistogramMilliseconds(String str, long j, int i, int i2, int i3, int i4);

    public static native long nativeRecordEnumeratedHistogram(String str, long j, int i, int i2);

    public static native long nativeRecordLinearCountHistogram(String str, long j, int i, int i2, int i3, int i4);

    public static native long nativeRecordSparseHistogram(String str, long j, int i);

    public static void recordBooleanHistogram(String str, boolean z) {
        if (sDisabledBy != null) {
            return;
        }
        Long l = sCache.get(str);
        long longValue = l == null ? 0L : l.longValue();
        long nativeRecordBooleanHistogram = nativeRecordBooleanHistogram(str, longValue, z);
        if (nativeRecordBooleanHistogram != longValue) {
            sCache.put(str, Long.valueOf(nativeRecordBooleanHistogram));
        }
    }
}
