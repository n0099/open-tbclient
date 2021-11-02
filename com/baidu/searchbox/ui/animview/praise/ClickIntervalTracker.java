package com.baidu.searchbox.ui.animview.praise;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ClickIntervalTracker {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "ClickIntervalTracker";
    public transient /* synthetic */ FieldHolder $fh;
    public long mInitialClickCounts;
    public long mLastClickTimeMs;
    public long mLastIntervalTimeMs;
    public long mTotalClickCounts;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class SpeedLevel {
        public static final /* synthetic */ SpeedLevel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SpeedLevel V0;
        public static final SpeedLevel V1;
        public static final SpeedLevel V2;
        public static final SpeedLevel V3;
        public transient /* synthetic */ FieldHolder $fh;
        public String mInfo;
        public long mInterval;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-182410368, "Lcom/baidu/searchbox/ui/animview/praise/ClickIntervalTracker$SpeedLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-182410368, "Lcom/baidu/searchbox/ui/animview/praise/ClickIntervalTracker$SpeedLevel;");
                    return;
                }
            }
            V0 = new SpeedLevel("V0", 0, -1L, "NONE");
            V1 = new SpeedLevel("V1", 1, 1000L, "V1");
            V2 = new SpeedLevel("V2", 2, 250L, "V2");
            SpeedLevel speedLevel = new SpeedLevel("V3", 3, 0L, "V3");
            V3 = speedLevel;
            $VALUES = new SpeedLevel[]{V0, V1, V2, speedLevel};
        }

        public SpeedLevel(String str, int i2, long j, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Long.valueOf(j), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mInterval = j;
            this.mInfo = str2;
        }

        public static SpeedLevel instantiate(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                if (j2 != 1 && j2 % 10 != 0) {
                    if (j < V2.getInterval()) {
                        return V2;
                    }
                    return V1;
                }
                return V3;
            }
            return (SpeedLevel) invokeCommon.objValue;
        }

        public static SpeedLevel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SpeedLevel) Enum.valueOf(SpeedLevel.class, str) : (SpeedLevel) invokeL.objValue;
        }

        public static SpeedLevel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SpeedLevel[]) $VALUES.clone() : (SpeedLevel[]) invokeV.objValue;
        }

        public long getInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mInterval : invokeV.longValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mInfo : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1295100437, "Lcom/baidu/searchbox/ui/animview/praise/ClickIntervalTracker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1295100437, "Lcom/baidu/searchbox/ui/animview/praise/ClickIntervalTracker;");
                return;
            }
        }
        DEBUG = DebugUtil.isApkInDebug();
    }

    public ClickIntervalTracker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLastIntervalTimeMs = 2147483647L;
    }

    public void addClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mLastIntervalTimeMs = System.currentTimeMillis() - this.mLastClickTimeMs;
            this.mTotalClickCounts++;
            this.mLastClickTimeMs = System.currentTimeMillis();
        }
    }

    public SpeedLevel getSpeedLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (DEBUG) {
                String str = "LastIntervalTimeMs:" + this.mLastIntervalTimeMs + ", TotalClickCounts" + (this.mInitialClickCounts + this.mTotalClickCounts);
            }
            return SpeedLevel.instantiate(this.mLastIntervalTimeMs, this.mInitialClickCounts + this.mTotalClickCounts);
        }
        return (SpeedLevel) invokeV.objValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mTotalClickCounts = 0L;
            this.mLastClickTimeMs = 0L;
            this.mInitialClickCounts = 0L;
            this.mLastIntervalTimeMs = 2147483647L;
        }
    }

    public void setInitialClickCounts(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.mInitialClickCounts = j;
        }
    }
}
