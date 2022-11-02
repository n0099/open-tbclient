package com.baidu.rtc;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.RTCAudioSamples;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RemoteAudioSamplesInterceptor implements RTCAudioSamples.RTCRemoteSamplesReadyCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SuppressLint({"UseSparseArrays"})
    public final List<RTCAudioSamples.RTCRemoteSamplesReadyCallback> callbacks;

    public RemoteAudioSamplesInterceptor() {
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
        this.callbacks = new ArrayList();
    }

    public void detachCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.callbacks.clear();
        }
    }

    public void attachCallback(RTCAudioSamples.RTCRemoteSamplesReadyCallback rTCRemoteSamplesReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rTCRemoteSamplesReadyCallback) == null) {
            this.callbacks.add(rTCRemoteSamplesReadyCallback);
        }
    }

    @Override // com.baidu.rtc.RTCAudioSamples.RTCRemoteSamplesReadyCallback
    public void onRtcAudioRemoteSamplesReady(RTCAudioSamples rTCAudioSamples) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rTCAudioSamples) == null) {
            for (RTCAudioSamples.RTCRemoteSamplesReadyCallback rTCRemoteSamplesReadyCallback : this.callbacks) {
                rTCRemoteSamplesReadyCallback.onRtcAudioRemoteSamplesReady(rTCAudioSamples);
            }
        }
    }
}
