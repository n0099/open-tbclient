package com.baidu.searchbox.track.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(26)
/* loaded from: classes7.dex */
public class TraceFragmentNativeCallback extends BaseTraceFragmentCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentManager.FragmentLifecycleCallbacks mFragmentCallbacks;

    public TraceFragmentNativeCallback() {
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

    private FragmentManager.FragmentLifecycleCallbacks getFragmentCallbacks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? new FragmentManager.FragmentLifecycleCallbacks(this) { // from class: com.baidu.searchbox.track.ui.TraceFragmentNativeCallback.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TraceFragmentNativeCallback this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, fragmentManager, fragment, bundle) == null) {
                    super.onFragmentCreated(fragmentManager, fragment, bundle);
                    if (fragment != null) {
                        this.this$0.doOnFragmentCreated(fragment, fragment.getUserVisibleHint(), fragment.getActivity());
                    }
                }
            }

            @Override // android.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragmentManager, fragment) == null) {
                    super.onFragmentResumed(fragmentManager, fragment);
                    if (fragment != null) {
                        this.this$0.doOnFragmentResumed(fragment, fragment.getUserVisibleHint(), fragment.getActivity());
                    }
                }
            }
        } : (FragmentManager.FragmentLifecycleCallbacks) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean register(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
            if (DeviceUtil.OSInfo.hasOreo()) {
                if (this.mFragmentCallbacks == null) {
                    this.mFragmentCallbacks = getFragmentCallbacks();
                }
                FragmentManager fragmentManager = activity.getFragmentManager();
                if (fragmentManager != null) {
                    fragmentManager.registerFragmentLifecycleCallbacks(this.mFragmentCallbacks, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean unregister(@NonNull Activity activity) {
        InterceptResult invokeL;
        FragmentManager fragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            if (DeviceUtil.OSInfo.hasOreo()) {
                if (this.mFragmentCallbacks == null || (fragmentManager = activity.getFragmentManager()) == null) {
                    return true;
                }
                fragmentManager.unregisterFragmentLifecycleCallbacks(this.mFragmentCallbacks);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
