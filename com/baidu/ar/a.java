package com.baidu.ar;

import com.baidu.ar.audio.IEasyAudio;
import com.baidu.ar.h.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.baidu.ar.imu.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? (com.baidu.ar.imu.c) n.aV("com.baidu.ar.imu.IMUController") : (com.baidu.ar.imu.c) invokeV.objValue;
    }

    public static com.baidu.ar.record.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? (com.baidu.ar.record.b) n.m("com.baidu.ar.recorder.MovieRecorder", "getInstance") : (com.baidu.ar.record.b) invokeV.objValue;
    }

    public static IEasyAudio c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (IEasyAudio) n.m("com.baidu.ar.audio.EasyAudio", "getInstance") : (IEasyAudio) invokeV.objValue;
    }
}
