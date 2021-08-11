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
public class DuDelayProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f38195a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1524241445, "Lcom/baidu/audioprocesswrapper/DuDelayProcess;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1524241445, "Lcom/baidu/audioprocesswrapper/DuDelayProcess;");
                return;
            }
        }
        System.loadLibrary("DuDelayProcess");
    }

    public DuDelayProcess(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38195a = 0L;
        this.f38195a = nativeInitDelay(i2, i3);
    }

    private native int nativeAvailableBytes(long j2);

    private native boolean nativeDelayPutBytes(long j2, byte[] bArr, int i2);

    private native int nativeDelayReceiveBytes(long j2, byte[] bArr, int i2);

    private native void nativeDestroyDelay(long j2);

    private native void nativeFlushBuffer(long j2);

    private native long nativeInitDelay(int i2, int i3);

    private native void nativeSetDelayDecrease(long j2, float f2);

    private native void nativeSetDelayInterval(long j2, int i2, int[] iArr);

    private native void nativeSetDelayMode(long j2, int i2);

    private native void nativeSetDelayNewPosition(long j2, int i2);

    private native void nativeSetDelayTime(long j2, int i2);

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? nativeAvailableBytes(this.f38195a) : invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long j2 = this.f38195a;
            if (j2 != 0) {
                nativeDestroyDelay(j2);
                this.f38195a = 0L;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            nativeFlushBuffer(this.f38195a);
        }
    }

    public boolean d(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bArr, i2)) == null) ? nativeDelayPutBytes(this.f38195a, bArr, i2) : invokeLI.booleanValue;
    }

    public int e(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, bArr, i2)) == null) ? nativeDelayReceiveBytes(this.f38195a, bArr, i2) : invokeLI.intValue;
    }

    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            nativeSetDelayDecrease(this.f38195a, f2);
        }
    }

    public void g(int i2, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, iArr) == null) {
            nativeSetDelayInterval(this.f38195a, i2, iArr);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            nativeSetDelayMode(this.f38195a, i2);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            nativeSetDelayNewPosition(this.f38195a, i2);
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            nativeSetDelayTime(this.f38195a, i2);
        }
    }
}
