package aegon.chrome.base.metrics;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class RecordHistogram {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Long> sCache;
    public static Throwable sDisabledBy;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1821359222, "Laegon/chrome/base/metrics/RecordHistogram;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1821359222, "Laegon/chrome/base/metrics/RecordHistogram;");
                return;
            }
        }
        RecordHistogram.class.desiredAssertionStatus();
        sCache = Collections.synchronizedMap(new HashMap());
    }

    public RecordHistogram() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static native int nativeGetHistogramTotalCountForTesting(String str);

    public static native int nativeGetHistogramValueCountForTesting(String str, int i2);

    public static native long nativeRecordBooleanHistogram(String str, long j, boolean z);

    public static native long nativeRecordCustomCountHistogram(String str, long j, int i2, int i3, int i4, int i5);

    public static native long nativeRecordCustomTimesHistogramMilliseconds(String str, long j, int i2, int i3, int i4, int i5);

    public static native long nativeRecordEnumeratedHistogram(String str, long j, int i2, int i3);

    public static native long nativeRecordLinearCountHistogram(String str, long j, int i2, int i3, int i4, int i5);

    public static native long nativeRecordSparseHistogram(String str, long j, int i2);

    public static void recordBooleanHistogram(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65546, null, str, z) == null) && sDisabledBy == null) {
            Long l = sCache.get(str);
            long longValue = l == null ? 0L : l.longValue();
            long nativeRecordBooleanHistogram = nativeRecordBooleanHistogram(str, longValue, z);
            if (nativeRecordBooleanHistogram != longValue) {
                sCache.put(str, Long.valueOf(nativeRecordBooleanHistogram));
            }
        }
    }
}
