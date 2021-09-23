package com.baidu.audioprocesswrapper;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DuAudioProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f38470a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2060399826, "Lcom/baidu/audioprocesswrapper/DuAudioProcess;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2060399826, "Lcom/baidu/audioprocesswrapper/DuAudioProcess;");
                return;
            }
        }
        System.loadLibrary("DuAudioProcess");
    }

    public DuAudioProcess() {
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
        this.f38470a = 0L;
    }

    private native int nativeAvailableBytes(long j2);

    private native void nativeChangeAirType(long j2, int i2);

    private native void nativeChangeEqualizerType(long j2, int i2, int[] iArr);

    private native void nativeChangeHarmonyType(long j2, int i2);

    private native void nativeChangePitchType(long j2, int i2);

    private native void nativeChangeReverbType(long j2, int i2, double[] dArr);

    private native void nativeClearQueues(long j2);

    private native void nativeClose(long j2);

    private native void nativeFlushStream(long j2);

    private native long nativeInit(int i2, int i3, long j2);

    private native boolean nativePutBytes(long j2, byte[] bArr, int i2);

    private native int nativeReceiveBytes(long j2, byte[] bArr, int i2);

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? nativeAvailableBytes(this.f38470a) : invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nativeClearQueues(this.f38470a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j2 = this.f38470a;
            if (j2 != 0) {
                nativeClose(j2);
                this.f38470a = 0L;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            nativeFlushStream(this.f38470a);
        }
    }

    public boolean e(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, bArr, i2)) == null) ? nativePutBytes(this.f38470a, bArr, i2) : invokeLI.booleanValue;
    }

    public int f(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, bArr, i2)) == null) ? nativeReceiveBytes(this.f38470a, bArr, i2) : invokeLI.intValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            nativeChangeAirType(this.f38470a, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            nativeChangeEqualizerType(this.f38470a, i2, null);
        }
    }

    public void i(int i2, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, iArr) == null) {
            nativeChangeEqualizerType(this.f38470a, i2, iArr);
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            nativeChangeHarmonyType(this.f38470a, i2);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            nativeChangePitchType(this.f38470a, i2);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            nativeChangeReverbType(this.f38470a, i2, null);
        }
    }

    public void m(int i2, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, dArr) == null) {
            nativeChangeReverbType(this.f38470a, i2, dArr);
        }
    }

    public DuAudioProcess(int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f38470a = 0L;
        this.f38470a = nativeInit(i2, i3, j2);
    }
}
