package com.baidu.searchbox.datacollector.growth;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.datacollector.growth.model.ActiveData;
import com.baidu.searchbox.datacollector.growth.model.ChannelData;
import com.baidu.searchbox.datacollector.growth.model.ClipBoardData;
import com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor;
import com.baidu.searchbox.datacollector.growth.service.LifeCycleHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class GrowthCollectManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean hasInit;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1462160593, "Lcom/baidu/searchbox/datacollector/growth/GrowthCollectManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1462160593, "Lcom/baidu/searchbox/datacollector/growth/GrowthCollectManager;");
        }
    }

    public GrowthCollectManager() {
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

    public static void init() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || hasInit) {
            return;
        }
        synchronized (GrowthCollectManager.class) {
            if (!hasInit) {
                BdBoxActivityManager.registerGlobalLifeCycle(new LifeCycleHelper());
                hasInit = true;
            }
        }
    }

    public static void statisticActiveData(ActiveData activeData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activeData, context) == null) {
            GrowthCollectProcessor.getInstance().statisticActiveData(activeData, context);
        }
    }

    public static void statisticChannelData(ChannelData channelData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, channelData) == null) {
            GrowthCollectProcessor.getInstance().statisticChannelData(channelData);
        }
    }

    public static void statisticClipBoardData(ClipBoardData clipBoardData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, clipBoardData) == null) {
            GrowthCollectProcessor.getInstance().statisticClipBoardData(clipBoardData);
        }
    }

    public static void statisticDeviceData(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            GrowthCollectProcessor.getInstance().statisticDeviceData(context);
        }
    }
}
