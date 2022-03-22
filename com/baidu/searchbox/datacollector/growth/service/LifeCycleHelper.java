package com.baidu.searchbox.datacollector.growth.service;

import android.app.Activity;
import com.baidu.searchbox.appframework.SimpleActivityLifeCycle;
import com.baidu.searchbox.datacollector.growth.GrowthCollectManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LifeCycleHelper extends SimpleActivityLifeCycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LifeCycleHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onBackgroundToForeground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            GrowthCollectManager.statisticDeviceData(activity);
        }
    }
}
