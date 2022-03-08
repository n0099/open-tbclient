package com.baidu.mobstat.dxmpay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.ActivityLifeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AutoTrack {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int JOB_TYPE_BGSEND = 2;
    public static final int JOB_TYPE_SESSIONTIME = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class MyActivityLifeCallback implements ActivityLifeObserver.IActivityLifeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public MyActivityLifeCallback(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }

        @Override // com.baidu.mobstat.dxmpay.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            }
        }

        @Override // com.baidu.mobstat.dxmpay.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            }
        }

        @Override // com.baidu.mobstat.dxmpay.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                Context applicationContext = activity.getApplicationContext();
                int i2 = this.a;
                if (i2 == 1) {
                    BDStatCore.instance().autoTrackSessionEndTime(applicationContext);
                } else if (i2 == 2) {
                    BDStatCore.instance().doSendLogCheck(applicationContext);
                }
            }
        }

        @Override // com.baidu.mobstat.dxmpay.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
                Context applicationContext = activity.getApplicationContext();
                int i2 = this.a;
                if (i2 == 1) {
                    BDStatCore.instance().autoTrackSessionStartTime(applicationContext);
                } else if (i2 == 2) {
                    BDStatCore.instance().cancelSendLogCheck();
                }
            }
        }

        @Override // com.baidu.mobstat.dxmpay.ActivityLifeObserver.IActivityLifeCallback
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // com.baidu.mobstat.dxmpay.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            }
        }

        @Override // com.baidu.mobstat.dxmpay.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            }
        }
    }

    public AutoTrack() {
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
