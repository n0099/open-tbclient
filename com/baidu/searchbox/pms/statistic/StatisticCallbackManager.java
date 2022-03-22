package com.baidu.searchbox.pms.statistic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.baidu.searchbox.pms.IPmsContext;
import com.baidu.searchbox.pms.PmsRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class StatisticCallbackManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ApplicationInfo sAppInfo;
    public static StatisticCallbackManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;
    public StatisticCallback mStatisticCallback;

    public StatisticCallbackManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAppContext = context.getApplicationContext();
    }

    public static synchronized StatisticCallbackManager getInstance(Context context) {
        InterceptResult invokeL;
        StatisticCallbackManager statisticCallbackManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (StatisticCallbackManager.class) {
                if (sInstance == null) {
                    sInstance = new StatisticCallbackManager(context);
                }
                statisticCallbackManager = sInstance;
            }
            return statisticCallbackManager;
        }
        return (StatisticCallbackManager) invokeL.objValue;
    }

    public synchronized StatisticCallback getStatisticCallback() {
        InterceptResult invokeV;
        StatisticCallback statisticCallback;
        IPmsContext pmsContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.mStatisticCallback == null && (pmsContext = PmsRuntime.getPmsContext()) != null) {
                    this.mStatisticCallback = pmsContext.getStatisticCallback();
                }
                if (this.mStatisticCallback == null) {
                    this.mStatisticCallback = new StatisticCallbackImpl();
                }
                statisticCallback = this.mStatisticCallback;
            }
            return statisticCallback;
        }
        return (StatisticCallback) invokeV.objValue;
    }
}
