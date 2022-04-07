package com.baidu.searchbox.track.ui;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class TraceFragmentXCallback extends BaseTraceFragmentCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentManager.FragmentLifecycleCallbacks mSupportFragmentCallbacks;

    public TraceFragmentXCallback() {
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

    private FragmentManager.FragmentLifecycleCallbacks getSupportFragmentCallbacks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? new FragmentManager.FragmentLifecycleCallbacks(this) { // from class: com.baidu.searchbox.track.ui.TraceFragmentXCallback.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TraceFragmentXCallback this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, fragmentManager, fragment, bundle) == null) {
                    super.onFragmentCreated(fragmentManager, fragment, bundle);
                    if (fragment != null) {
                        this.this$0.doOnFragmentCreated(fragment, fragment.getUserVisibleHint(), fragment.getActivity());
                    }
                }
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
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
            if (activity instanceof FragmentActivity) {
                if (this.mSupportFragmentCallbacks == null) {
                    this.mSupportFragmentCallbacks = getSupportFragmentCallbacks();
                }
                FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                if (supportFragmentManager != null) {
                    supportFragmentManager.registerFragmentLifecycleCallbacks(this.mSupportFragmentCallbacks, true);
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
        FragmentManager supportFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            if (activity instanceof FragmentActivity) {
                if (this.mSupportFragmentCallbacks == null || (supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager()) == null) {
                    return true;
                }
                supportFragmentManager.unregisterFragmentLifecycleCallbacks(this.mSupportFragmentCallbacks);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
