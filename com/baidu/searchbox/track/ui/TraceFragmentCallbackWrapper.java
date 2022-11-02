package com.baidu.searchbox.track.ui;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class TraceFragmentCallbackWrapper implements ITraceFragmentCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TraceFragmentNativeCallback mTraceFragmentNativeCallback;
    public TraceFragmentXCallback mTraceFragmentXCallback;

    public TraceFragmentCallbackWrapper() {
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
        if (DeviceUtil.OSInfo.hasOreo()) {
            this.mTraceFragmentNativeCallback = new TraceFragmentNativeCallback();
        }
        try {
            if (Class.forName("androidx.fragment.app.FragmentActivity") != null) {
                this.mTraceFragmentXCallback = new TraceFragmentXCallback();
            }
        } catch (ClassNotFoundException unused) {
        }
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean register(@Nullable Activity activity) {
        InterceptResult invokeL;
        TraceFragmentNativeCallback traceFragmentNativeCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
            boolean z = false;
            if (activity == null) {
                return false;
            }
            TraceFragmentXCallback traceFragmentXCallback = this.mTraceFragmentXCallback;
            if (traceFragmentXCallback != null) {
                z = traceFragmentXCallback.register(activity);
            }
            if (!z && (traceFragmentNativeCallback = this.mTraceFragmentNativeCallback) != null) {
                return traceFragmentNativeCallback.register(activity);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean unregister(@Nullable Activity activity) {
        InterceptResult invokeL;
        TraceFragmentNativeCallback traceFragmentNativeCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            boolean z = false;
            if (activity == null) {
                return false;
            }
            TraceFragmentXCallback traceFragmentXCallback = this.mTraceFragmentXCallback;
            if (traceFragmentXCallback != null) {
                z = traceFragmentXCallback.unregister(activity);
            }
            if (!z && (traceFragmentNativeCallback = this.mTraceFragmentNativeCallback) != null) {
                return traceFragmentNativeCallback.unregister(activity);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
