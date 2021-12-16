package c.i.b.a.i0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f30604b;

    /* renamed from: c  reason: collision with root package name */
    public int f30605c;

    /* renamed from: d  reason: collision with root package name */
    public int f30606d;

    public m(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        i(bArr, i2, i3);
    }

    public final void a() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i3 = this.f30605c;
            a.f(i3 >= 0 && (i3 < (i2 = this.f30604b) || (i3 == i2 && this.f30606d == 0)));
        }
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int i3 = this.f30605c;
            int i4 = i2 / 8;
            int i5 = i3 + i4;
            int i6 = (this.f30606d + i2) - (i4 * 8);
            if (i6 > 7) {
                i5++;
                i6 -= 8;
            }
            while (true) {
                i3++;
                if (i3 > i5 || i5 >= this.f30604b) {
                    break;
                } else if (j(i3)) {
                    i5++;
                    i3 += 2;
                }
            }
            int i7 = this.f30604b;
            if (i5 >= i7) {
                return i5 == i7 && i6 == 0;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f30605c;
            int i3 = this.f30606d;
            int i4 = 0;
            while (this.f30605c < this.f30604b && !d()) {
                i4++;
            }
            boolean z = this.f30605c == this.f30604b;
            this.f30605c = i2;
            this.f30606d = i3;
            return !z && b((i4 * 2) + 1);
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = (this.a[this.f30605c] & (128 >> this.f30606d)) != 0;
            k();
            return z;
        }
        return invokeV.booleanValue;
    }

    public int e(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f30606d += i2;
            int i4 = 0;
            while (true) {
                i3 = this.f30606d;
                if (i3 <= 8) {
                    break;
                }
                int i5 = i3 - 8;
                this.f30606d = i5;
                byte[] bArr = this.a;
                int i6 = this.f30605c;
                i4 |= (bArr[i6] & 255) << i5;
                if (!j(i6 + 1)) {
                    r3 = 1;
                }
                this.f30605c = i6 + r3;
            }
            byte[] bArr2 = this.a;
            int i7 = this.f30605c;
            int i8 = ((-1) >>> (32 - i2)) & (i4 | ((bArr2[i7] & 255) >> (8 - i3)));
            if (i3 == 8) {
                this.f30606d = 0;
                this.f30605c = i7 + (j(i7 + 1) ? 2 : 1);
            }
            a();
            return i8;
        }
        return invokeI.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = 0;
            while (!d()) {
                i2++;
            }
            return ((1 << i2) - 1) + (i2 > 0 ? e(i2) : 0);
        }
        return invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int f2 = f();
            return (f2 % 2 == 0 ? -1 : 1) * ((f2 + 1) / 2);
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f() : invokeV.intValue;
    }

    public void i(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3) == null) {
            this.a = bArr;
            this.f30605c = i2;
            this.f30604b = i3;
            this.f30606d = 0;
            a();
        }
    }

    public final boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (2 <= i2 && i2 < this.f30604b) {
                byte[] bArr = this.a;
                if (bArr[i2] == 3 && bArr[i2 - 2] == 0 && bArr[i2 - 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int i2 = this.f30606d + 1;
            this.f30606d = i2;
            if (i2 == 8) {
                this.f30606d = 0;
                int i3 = this.f30605c;
                this.f30605c = i3 + (j(i3 + 1) ? 2 : 1);
            }
            a();
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048587, this, i2) != null) {
            return;
        }
        int i3 = this.f30605c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        this.f30605c = i5;
        int i6 = this.f30606d + (i2 - (i4 * 8));
        this.f30606d = i6;
        if (i6 > 7) {
            this.f30605c = i5 + 1;
            this.f30606d = i6 - 8;
        }
        while (true) {
            i3++;
            if (i3 <= this.f30605c) {
                if (j(i3)) {
                    this.f30605c++;
                    i3 += 2;
                }
            } else {
                a();
                return;
            }
        }
    }
}
