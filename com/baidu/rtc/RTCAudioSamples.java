package com.baidu.rtc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.audio.JavaAudioDeviceModule;
/* loaded from: classes3.dex */
public class RTCAudioSamples extends JavaAudioDeviceModule.AudioSamples {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long captureTime;

    /* loaded from: classes3.dex */
    public interface RTCExternalSamplesReadyCallback {
        void onRtcAudioExternalSamplesReady(RTCAudioSamples rTCAudioSamples);
    }

    /* loaded from: classes3.dex */
    public interface RTCMixedSamplesReadyCallback {
        void onRtcAudioMixedSamplesReady(RTCAudioSamples rTCAudioSamples);
    }

    /* loaded from: classes3.dex */
    public interface RTCRemoteSamplesReadyCallback {
        void onRtcAudioRemoteSamplesReady(RTCAudioSamples rTCAudioSamples);
    }

    /* loaded from: classes3.dex */
    public interface RTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(RTCAudioSamples rTCAudioSamples);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RTCAudioSamples(int i2, int i3, int i4, byte[] bArr) {
        super(i2, i3, i4, bArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (byte[]) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.captureTime = 0L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RTCAudioSamples(int i2, int i3, int i4, byte[] bArr, long j) {
        super(i2, i3, i4, bArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bArr, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (byte[]) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.captureTime = 0L;
        this.captureTime = j;
    }

    public long getCaptureTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.captureTime : invokeV.longValue;
    }
}
