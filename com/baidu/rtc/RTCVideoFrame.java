package com.baidu.rtc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.VideoFrame;
/* loaded from: classes7.dex */
public class RTCVideoFrame extends VideoFrame {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RTCVideoFrame(VideoFrame.Buffer buffer, int i2, long j) {
        super(buffer, i2, j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buffer, Integer.valueOf(i2), Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((VideoFrame.Buffer) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static RTCVideoFrame newfromVideoFrame(VideoFrame videoFrame) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, videoFrame)) == null) ? new RTCVideoFrame(videoFrame.getBuffer(), videoFrame.getRotation(), videoFrame.getTimestampNs()) : (RTCVideoFrame) invokeL.objValue;
    }
}
