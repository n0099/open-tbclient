package aegon.chrome.net;

import aegon.chrome.base.annotations.CalledByNative;
import android.net.TrafficStats;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AndroidTrafficStats {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AndroidTrafficStats() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @CalledByNative
    public static long getCurrentUidRxBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            long uidRxBytes = TrafficStats.getUidRxBytes(Process.myUid());
            if (uidRxBytes != -1) {
                return uidRxBytes;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @CalledByNative
    public static long getCurrentUidTxBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long uidTxBytes = TrafficStats.getUidTxBytes(Process.myUid());
            if (uidTxBytes != -1) {
                return uidTxBytes;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @CalledByNative
    public static long getTotalRxBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            if (totalRxBytes != -1) {
                return totalRxBytes;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @CalledByNative
    public static long getTotalTxBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            long totalTxBytes = TrafficStats.getTotalTxBytes();
            if (totalTxBytes != -1) {
                return totalTxBytes;
            }
            return 0L;
        }
        return invokeV.longValue;
    }
}
