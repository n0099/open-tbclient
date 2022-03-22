package c.a.v0.i.d;

import androidx.core.view.InputDeviceCompat;
import c.a.v0.i.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f21601b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21602c;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.v0.i.h
    public int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) {
            float f2 = this.a;
            if (f2 != 1.0d) {
                if (bArr != null) {
                    this.f21601b = c(bArr, f2);
                }
                return i;
            }
            this.f21601b = bArr;
            this.f21602c = true;
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // c.a.v0.i.h
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            float f2 = this.a;
            return f2 >= 0.0f && f2 <= 1.0f;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.v0.i.h
    public boolean a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4)) == null) {
            return false;
        }
        return invokeIIII.booleanValue;
    }

    @Override // c.a.v0.i.h
    public byte[] a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (this.f21602c) {
                this.f21602c = false;
                return this.f21601b;
            }
            return null;
        }
        return (byte[]) invokeI.objValue;
    }

    public void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.a = f2;
        }
    }

    @Override // c.a.v0.i.h
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.v0.i.h
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f21602c = false;
            this.f21601b = null;
        }
    }

    public final byte[] c(byte[] bArr, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048583, this, bArr, f2)) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            int length = bArr.length / 2;
            short[] sArr = new short[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                sArr[i] = (short) (((short) (((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255))) * f2);
            }
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = i3 * 2;
                bArr[i4] = (byte) (sArr[i3] & 255);
                bArr[i4 + 1] = (byte) ((sArr[i3] & 65280) >> 8);
            }
            return bArr;
        }
        return (byte[]) invokeLF.objValue;
    }

    @Override // c.a.v0.i.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f21602c = false;
            this.f21601b = null;
        }
    }

    @Override // c.a.v0.i.h
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }
}
