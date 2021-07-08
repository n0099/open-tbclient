package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class NetWorkState {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicInteger mErrorNums;
    public static ArrayList<StatisticsData> mStatisticsDatas;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class StatisticsData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mMethod;
        public int mMode;
        public long mSize;
        public long mTime;
        public int mTimesNum;

        public StatisticsData() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-502993192, "Lcom/baidu/tbadk/core/util/NetWorkState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-502993192, "Lcom/baidu/tbadk/core/util/NetWorkState;");
                return;
            }
        }
        mStatisticsDatas = new ArrayList<>();
        mErrorNums = new AtomicInteger(0);
    }

    public NetWorkState() {
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

    public static int addErrorNumsAndGet(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? mErrorNums.addAndGet(i2) : invokeI.intValue;
    }

    public static synchronized void addStatisticsData(StatisticsData statisticsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, statisticsData) == null) {
            synchronized (NetWorkState.class) {
                if (statisticsData == null) {
                    return;
                }
                if (mStatisticsDatas.size() > 20) {
                    return;
                }
                mStatisticsDatas.add(statisticsData);
            }
        }
    }

    public static synchronized StatisticsData delStatisticsData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (NetWorkState.class) {
                int size = mStatisticsDatas.size();
                if (size > 0) {
                    return mStatisticsDatas.remove(size - 1);
                }
                return null;
            }
        }
        return (StatisticsData) invokeV.objValue;
    }

    public static int getErrorNumsAndSet(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? mErrorNums.getAndSet(i2) : invokeI.intValue;
    }
}
