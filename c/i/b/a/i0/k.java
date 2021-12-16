package c.i.b.a.i0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f30599b;

    /* renamed from: c  reason: collision with root package name */
    public int f30600c;

    /* renamed from: d  reason: collision with root package name */
    public int f30601d;

    public k() {
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

    public final void a() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i3 = this.f30599b;
            a.f(i3 >= 0 && (i3 < (i2 = this.f30601d) || (i3 == i2 && this.f30600c == 0)));
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ((this.f30601d - this.f30599b) * 8) - this.f30600c : invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f30600c == 0) {
            return;
        }
        this.f30600c = 0;
        this.f30599b++;
        a();
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a.f(this.f30600c == 0);
            return this.f30599b;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.f30599b * 8) + this.f30600c : invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            boolean z = (this.a[this.f30599b] & (128 >> this.f30600c)) != 0;
            m();
            return z;
        }
        return invokeV.booleanValue;
    }

    public int g(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 == 0) {
                return 0;
            }
            this.f30600c += i2;
            int i4 = 0;
            while (true) {
                i3 = this.f30600c;
                if (i3 <= 8) {
                    break;
                }
                int i5 = i3 - 8;
                this.f30600c = i5;
                byte[] bArr = this.a;
                int i6 = this.f30599b;
                this.f30599b = i6 + 1;
                i4 |= (bArr[i6] & 255) << i5;
            }
            byte[] bArr2 = this.a;
            int i7 = this.f30599b;
            int i8 = ((-1) >>> (32 - i2)) & (i4 | ((bArr2[i7] & 255) >> (8 - i3)));
            if (i3 == 8) {
                this.f30600c = 0;
                this.f30599b = i7 + 1;
            }
            a();
            return i8;
        }
        return invokeI.intValue;
    }

    public void h(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, bArr, i2, i3) == null) {
            int i4 = (i3 >> 3) + i2;
            while (i2 < i4) {
                byte[] bArr2 = this.a;
                int i5 = this.f30599b;
                int i6 = i5 + 1;
                this.f30599b = i6;
                byte b2 = bArr2[i5];
                int i7 = this.f30600c;
                bArr[i2] = (byte) (b2 << i7);
                bArr[i2] = (byte) (((255 & bArr2[i6]) >> (8 - i7)) | bArr[i2]);
                i2++;
            }
            int i8 = i3 & 7;
            if (i8 == 0) {
                return;
            }
            bArr[i4] = (byte) (bArr[i4] & (255 >> i8));
            int i9 = this.f30600c;
            if (i9 + i8 > 8) {
                byte b3 = bArr[i4];
                byte[] bArr3 = this.a;
                int i10 = this.f30599b;
                this.f30599b = i10 + 1;
                bArr[i4] = (byte) (b3 | ((byte) ((bArr3[i10] & 255) << i9)));
                this.f30600c = i9 - 8;
            }
            int i11 = this.f30600c + i8;
            this.f30600c = i11;
            byte[] bArr4 = this.a;
            int i12 = this.f30599b;
            bArr[i4] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i8))) | bArr[i4]);
            if (i11 == 8) {
                this.f30600c = 0;
                this.f30599b = i12 + 1;
            }
            a();
        }
    }

    public void i(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3) == null) {
            a.f(this.f30600c == 0);
            System.arraycopy(this.a, this.f30599b, bArr, i2, i3);
            this.f30599b += i3;
            a();
        }
    }

    public void j(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bArr) == null) {
            k(bArr, bArr.length);
        }
    }

    public void k(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, bArr, i2) == null) {
            this.a = bArr;
            this.f30599b = 0;
            this.f30600c = 0;
            this.f30601d = i2;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            int i3 = i2 / 8;
            this.f30599b = i3;
            this.f30600c = i2 - (i3 * 8);
            a();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i2 = this.f30600c + 1;
            this.f30600c = i2;
            if (i2 == 8) {
                this.f30600c = 0;
                this.f30599b++;
            }
            a();
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            int i3 = i2 / 8;
            int i4 = this.f30599b + i3;
            this.f30599b = i4;
            int i5 = this.f30600c + (i2 - (i3 * 8));
            this.f30600c = i5;
            if (i5 > 7) {
                this.f30599b = i4 + 1;
                this.f30600c = i5 - 8;
            }
            a();
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            a.f(this.f30600c == 0);
            this.f30599b += i2;
            a();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(byte[] bArr) {
        this(bArr, bArr.length);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((byte[]) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public k(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = bArr;
        this.f30601d = i2;
    }
}
