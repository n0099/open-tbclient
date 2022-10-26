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
/* loaded from: classes.dex */
public class DuDelayProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    private native int nativeAvailableBytes(long j);

    private native boolean nativeDelayPutBytes(long j, byte[] bArr, int i);

    private native int nativeDelayReceiveBytes(long j, byte[] bArr, int i);

    private native void nativeDestroyDelay(long j);

    private native void nativeFlushBuffer(long j);

    private native long nativeInitDelay(int i, int i2);

    private native void nativeSetDelayDecrease(long j, float f);

    private native void nativeSetDelayInterval(long j, int i, int[] iArr);

    private native void nativeSetDelayMode(long j, int i);

    private native void nativeSetDelayNewPosition(long j, int i);

    private native void nativeSetDelayTime(long j, int i);

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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return nativeAvailableBytes(this.a);
        }
        return invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long j = this.a;
            if (j != 0) {
                nativeDestroyDelay(j);
                this.a = 0L;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            nativeFlushBuffer(this.a);
        }
    }

    public DuDelayProcess(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.a = nativeInitDelay(i, i2);
    }

    public boolean d(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bArr, i)) == null) {
            return nativeDelayPutBytes(this.a, bArr, i);
        }
        return invokeLI.booleanValue;
    }

    public int e(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, bArr, i)) == null) {
            return nativeDelayReceiveBytes(this.a, bArr, i);
        }
        return invokeLI.intValue;
    }

    public void g(int i, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, iArr) == null) {
            nativeSetDelayInterval(this.a, i, iArr);
        }
    }

    public void f(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            nativeSetDelayDecrease(this.a, f);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            nativeSetDelayMode(this.a, i);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            nativeSetDelayNewPosition(this.a, i);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            nativeSetDelayTime(this.a, i);
        }
    }
}
