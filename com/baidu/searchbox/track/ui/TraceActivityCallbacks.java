package com.baidu.searchbox.track.ui;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.appframework.SimpleActivityLifeCycle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TraceActivityCallbacks extends SimpleActivityLifeCycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TraceFragmentCallbackWrapper mTraceFragmentCallbackWrapper;
    public TraceManager mTraceManager;

    public TraceActivityCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTraceManager = TraceManager.getInstance();
        this.mTraceFragmentCallbackWrapper = new TraceFragmentCallbackWrapper();
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onActivityCreated(Activity activity, Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, activity, bundle) != null) || !this.mTraceManager.isRegistered()) {
            return;
        }
        this.mTraceFragmentCallbackWrapper.register(activity);
        if (TraceManager.checkAPSActivity(activity) && bundle != null) {
            str = bundle.getString("ActivityName");
        } else {
            str = null;
        }
        this.mTraceManager.saveTraceInfo(activity, str, null, "onCreated");
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) != null) || !this.mTraceManager.isRegistered()) {
            return;
        }
        this.mTraceFragmentCallbackWrapper.unregister(activity);
        this.mTraceManager.saveTraceInfo(activity, null, null, "onDestroyed");
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) != null) || !this.mTraceManager.isRegistered()) {
            return;
        }
        this.mTraceManager.saveTraceInfo(activity, null, null, "onResumed");
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onBackgroundToForeground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            super.onBackgroundToForeground(activity);
            if (this.mTraceManager.isRegistered()) {
                this.mTraceManager.saveTraceInfo(activity, true);
            }
        }
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onForegroundToBackground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            super.onForegroundToBackground(activity);
            if (this.mTraceManager.isRegistered()) {
                this.mTraceManager.saveTraceInfo(activity, false);
            }
        }
    }

    public void registerTraceFragment(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            this.mTraceFragmentCallbackWrapper.register(activity);
        }
    }
}
