package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AutoTrack {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int JOB_TYPE_BGSEND = 2;
    public static final int JOB_TYPE_SESSIONTIME = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class MyActivityLifeCallback implements ActivityLifeObserver.IActivityLifeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            }
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            }
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            }
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            }
        }

        public MyActivityLifeCallback(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                Context applicationContext = activity.getApplicationContext();
                int i = this.a;
                if (i == 1) {
                    if (!CooperService.instance().isCloseTrace()) {
                        BDStatCore.instance().autoTrackSessionEndTime(applicationContext);
                    }
                } else if (i == 2) {
                    try {
                        if (CooperService.instance().isCloseTrace()) {
                            ActivityLifeObserver.instance().clearObservers();
                            ActivityLifeObserver.instance().unRegister(activity);
                        } else {
                            BDStatCore.instance().doSendLogCheck(applicationContext);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
                Context applicationContext = activity.getApplicationContext();
                int i = this.a;
                if (i == 1) {
                    BDStatCore.instance().autoTrackSessionStartTime(applicationContext);
                } else if (i == 2) {
                    BDStatCore.instance().cancelSendLogCheck();
                }
            }
        }
    }

    public AutoTrack() {
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
}
