package com.baidu.audioprocesswrapper;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DuAudioProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f4261a;

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

    public DuAudioProcess(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4261a = 0L;
        c();
        this.f4261a = nativeInit(i2, i3, i4);
    }

    private native int nativeAvailableBytes(long j);

    private native void nativeChangePitchType(long j, int i2);

    private native void nativeChangeReverbType(long j, int i2);

    private native void nativeClearQueues(long j);

    private native void nativeClose(long j);

    private native void nativeFlushStream(long j);

    private native long nativeInit(int i2, int i3, int i4);

    private native boolean nativePutBytes(long j, byte[] bArr, int i2);

    private native int nativeReceiveBytes(long j, byte[] bArr, int i2);

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? nativeAvailableBytes(this.f4261a) : invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nativeClearQueues(this.f4261a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j = this.f4261a;
            if (j != 0) {
                nativeClose(j);
                this.f4261a = 0L;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            nativeFlushStream(this.f4261a);
        }
    }

    public boolean e(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, bArr, i2)) == null) ? nativePutBytes(this.f4261a, bArr, i2) : invokeLI.booleanValue;
    }

    public int f(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, bArr, i2)) == null) ? nativeReceiveBytes(this.f4261a, bArr, i2) : invokeLI.intValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            nativeChangePitchType(this.f4261a, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            nativeChangeReverbType(this.f4261a, i2);
        }
    }
}
