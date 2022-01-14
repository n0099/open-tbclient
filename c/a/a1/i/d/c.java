package c.a.a1.i.d;

import androidx.core.view.InputDeviceCompat;
import c.a.a1.i.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f1190b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1191c;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.a1.i.h
    public int a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i2)) == null) {
            float f2 = this.a;
            if (f2 != 1.0d) {
                if (bArr != null) {
                    this.f1190b = c(bArr, f2);
                }
                return i2;
            }
            this.f1190b = bArr;
            this.f1191c = true;
            return i2;
        }
        return invokeLI.intValue;
    }

    @Override // c.a.a1.i.h
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            float f2 = this.a;
            return f2 >= 0.0f && f2 <= 1.0f;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.a1.i.h
    public boolean a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5)) == null) {
            return false;
        }
        return invokeIIII.booleanValue;
    }

    @Override // c.a.a1.i.h
    public byte[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.f1191c) {
                this.f1191c = false;
                return this.f1190b;
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

    @Override // c.a.a1.i.h
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.a1.i.h
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f1191c = false;
            this.f1190b = null;
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
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                sArr[i2] = (short) (((short) (((bArr[i3 + 1] & 255) << 8) | (bArr[i3] & 255))) * f2);
            }
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = i4 * 2;
                bArr[i5] = (byte) (sArr[i4] & 255);
                bArr[i5 + 1] = (byte) ((sArr[i4] & 65280) >> 8);
            }
            return bArr;
        }
        return (byte[]) invokeLF.objValue;
    }

    @Override // c.a.a1.i.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f1191c = false;
            this.f1190b = null;
        }
    }

    @Override // c.a.a1.i.h
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }
}
