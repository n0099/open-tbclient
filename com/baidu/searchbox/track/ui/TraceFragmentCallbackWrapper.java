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
/* loaded from: classes5.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            if (activity == null) {
                return false;
            }
            TraceFragmentXCallback traceFragmentXCallback = this.mTraceFragmentXCallback;
            boolean register = traceFragmentXCallback != null ? traceFragmentXCallback.register(activity) : false;
            return (register || (traceFragmentNativeCallback = this.mTraceFragmentNativeCallback) == null) ? register : traceFragmentNativeCallback.register(activity);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean unregister(@Nullable Activity activity) {
        InterceptResult invokeL;
        TraceFragmentNativeCallback traceFragmentNativeCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            if (activity == null) {
                return false;
            }
            TraceFragmentXCallback traceFragmentXCallback = this.mTraceFragmentXCallback;
            boolean unregister = traceFragmentXCallback != null ? traceFragmentXCallback.unregister(activity) : false;
            return (unregister || (traceFragmentNativeCallback = this.mTraceFragmentNativeCallback) == null) ? unregister : traceFragmentNativeCallback.unregister(activity);
        }
        return invokeL.booleanValue;
    }
}
