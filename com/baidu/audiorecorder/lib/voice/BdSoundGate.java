package com.baidu.audiorecorder.lib.voice;

import c.a.i.a.a.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BdSoundGate {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static BdSoundGate f38476c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f38477a;

    /* renamed from: b  reason: collision with root package name */
    public int f38478b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1673790861, "Lcom/baidu/audiorecorder/lib/voice/BdSoundGate;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1673790861, "Lcom/baidu/audiorecorder/lib/voice/BdSoundGate;");
                return;
            }
        }
        System.loadLibrary("sound_gate");
    }

    public BdSoundGate() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38477a = -1;
    }

    public static BdSoundGate b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f38476c == null) {
                f38476c = new BdSoundGate();
            }
            return f38476c;
        }
        return (BdSoundGate) invokeV.objValue;
    }

    private native void close(int i2);

    private native int getChanger(int i2, float f2, float f3, float f4);

    private native int through(int i2, short[] sArr, short[] sArr2);

    private native int throughMono(int i2, short[] sArr, short[] sArr2);

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38478b : invokeV.intValue;
    }

    public void c(int i2, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.f38478b = i2;
            this.f38477a = getChanger(i2, f2, f3, f4);
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            b().c(i2, 0.0f, d.a(i3), 0.0f);
        }
    }

    public void e() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (i2 = this.f38477a) <= 0) {
            return;
        }
        close(i2);
        this.f38477a = -1;
    }

    public void f(short[] sArr, short[] sArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, sArr, sArr2) == null) {
            throughMono(this.f38477a, sArr, sArr2);
        }
    }
}
