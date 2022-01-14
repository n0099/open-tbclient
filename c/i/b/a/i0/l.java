package c.i.b.a.i0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
/* loaded from: classes9.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f29718b;

    /* renamed from: c  reason: collision with root package name */
    public int f29719c;

    public l() {
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

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            int i3 = i2 + 1;
            this.f29718b = i3;
            int i4 = i3 + 1;
            this.f29718b = i4;
            int i5 = ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
            this.f29718b = i4 + 1;
            return (bArr[i4] & 255) | i5;
        }
        return invokeV.intValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = i();
            if (i2 >= 0) {
                return i2;
            }
            throw new IllegalStateException("Top bit not zero: " + i2);
        }
        return invokeV.intValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long q = q();
            if (q >= 0) {
                return q;
            }
            throw new IllegalStateException("Top bit not zero: " + q);
        }
        return invokeV.longValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            int i3 = i2 + 1;
            this.f29718b = i3;
            this.f29718b = i3 + 1;
            return (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
        }
        return invokeV.intValue;
    }

    public long E() {
        InterceptResult invokeV;
        int i2;
        int i3;
        byte b2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long j2 = this.a[this.f29718b];
            int i5 = 7;
            while (true) {
                if (i5 < 0) {
                    break;
                }
                if (((1 << i5) & j2) != 0) {
                    i5--;
                } else if (i5 < 6) {
                    j2 &= i4 - 1;
                    i3 = 7 - i5;
                } else if (i5 == 7) {
                    i3 = 1;
                }
            }
            i3 = 0;
            if (i3 != 0) {
                for (i2 = 1; i2 < i3; i2++) {
                    if ((this.a[this.f29718b + i2] & 192) != 128) {
                        throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j2);
                    }
                    j2 = (j2 << 6) | (b2 & 63);
                }
                this.f29718b += i3;
                return j2;
            }
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j2);
        }
        return invokeV.longValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f29718b = 0;
            this.f29719c = 0;
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            H(b() < i2 ? new byte[i2] : this.a, i2);
        }
    }

    public void H(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, bArr, i2) == null) {
            this.a = bArr;
            this.f29719c = i2;
            this.f29718b = 0;
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            a.a(i2 >= 0 && i2 <= this.a.length);
            this.f29719c = i2;
        }
    }

    public void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            a.a(i2 >= 0 && i2 <= this.f29719c);
            this.f29718b = i2;
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            J(this.f29718b + i2);
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f29719c - this.f29718b : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            byte[] bArr = this.a;
            if (bArr == null) {
                return 0;
            }
            return bArr.length;
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f29718b : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f29719c : invokeV.intValue;
    }

    public char e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            return (char) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
        }
        return invokeV.charValue;
    }

    public void f(k kVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, kVar, i2) == null) {
            g(kVar.a, 0, i2);
            kVar.l(0);
        }
    }

    public void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048593, this, bArr, i2, i3) == null) {
            System.arraycopy(this.a, this.f29718b, bArr, i2, i3);
            this.f29718b += i3;
        }
    }

    public double h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? Double.longBitsToDouble(q()) : invokeV.doubleValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            int i3 = i2 + 1;
            this.f29718b = i3;
            int i4 = i3 + 1;
            this.f29718b = i4;
            int i5 = ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            this.f29718b = i6;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            this.f29718b = i6 + 1;
            return (bArr[i6] & 255) | i7;
        }
        return invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            int i3 = i2 + 1;
            this.f29718b = i3;
            int i4 = i3 + 1;
            this.f29718b = i4;
            int i5 = (((bArr[i2] & 255) << 24) >> 8) | ((bArr[i3] & 255) << 8);
            this.f29718b = i4 + 1;
            return (bArr[i4] & 255) | i5;
        }
        return invokeV.intValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (a() == 0) {
                return null;
            }
            int i2 = this.f29718b;
            while (i2 < this.f29719c && !v.z(this.a[i2])) {
                i2++;
            }
            int i3 = this.f29718b;
            if (i2 - i3 >= 3) {
                byte[] bArr = this.a;
                if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                    this.f29718b = i3 + 3;
                }
            }
            byte[] bArr2 = this.a;
            int i4 = this.f29718b;
            String str = new String(bArr2, i4, i2 - i4);
            this.f29718b = i2;
            int i5 = this.f29719c;
            if (i2 == i5) {
                return str;
            }
            if (this.a[i2] == 13) {
                int i6 = i2 + 1;
                this.f29718b = i6;
                if (i6 == i5) {
                    return str;
                }
            }
            byte[] bArr3 = this.a;
            int i7 = this.f29718b;
            if (bArr3[i7] == 10) {
                this.f29718b = i7 + 1;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            int i3 = i2 + 1;
            this.f29718b = i3;
            int i4 = i3 + 1;
            this.f29718b = i4;
            int i5 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
            int i6 = i4 + 1;
            this.f29718b = i6;
            int i7 = i5 | ((bArr[i4] & 255) << 16);
            this.f29718b = i6 + 1;
            return ((bArr[i6] & 255) << 24) | i7;
        }
        return invokeV.intValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            int i3 = i2 + 1;
            this.f29718b = i3;
            int i4 = i3 + 1;
            this.f29718b = i4;
            int i5 = i4 + 1;
            this.f29718b = i5;
            int i6 = i5 + 1;
            this.f29718b = i6;
            int i7 = i6 + 1;
            this.f29718b = i7;
            int i8 = i7 + 1;
            this.f29718b = i8;
            int i9 = i8 + 1;
            this.f29718b = i9;
            this.f29718b = i9 + 1;
            return (bArr[i2] & 255) | ((bArr[i3] & 255) << 8) | ((bArr[i4] & 255) << 16) | ((bArr[i5] & 255) << 24) | ((bArr[i6] & 255) << 32) | ((bArr[i7] & 255) << 40) | ((bArr[i8] & 255) << 48) | ((bArr[i9] & 255) << 56);
        }
        return invokeV.longValue;
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            int i3 = i2 + 1;
            this.f29718b = i3;
            int i4 = i3 + 1;
            this.f29718b = i4;
            int i5 = i4 + 1;
            this.f29718b = i5;
            this.f29718b = i5 + 1;
            return (bArr[i2] & 255) | ((bArr[i3] & 255) << 8) | ((bArr[i4] & 255) << 16) | ((bArr[i5] & 255) << 24);
        }
        return invokeV.longValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            int l = l();
            if (l >= 0) {
                return l;
            }
            throw new IllegalStateException("Top bit not zero: " + l);
        }
        return invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            int i3 = i2 + 1;
            this.f29718b = i3;
            this.f29718b = i3 + 1;
            return ((bArr[i3] & 255) << 8) | (bArr[i2] & 255);
        }
        return invokeV.intValue;
    }

    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            int i3 = i2 + 1;
            this.f29718b = i3;
            int i4 = i3 + 1;
            this.f29718b = i4;
            int i5 = i4 + 1;
            this.f29718b = i5;
            int i6 = i5 + 1;
            this.f29718b = i6;
            int i7 = i6 + 1;
            this.f29718b = i7;
            int i8 = i7 + 1;
            this.f29718b = i8;
            int i9 = i8 + 1;
            this.f29718b = i9;
            this.f29718b = i9 + 1;
            return ((bArr[i2] & 255) << 56) | ((bArr[i3] & 255) << 48) | ((bArr[i4] & 255) << 40) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 24) | ((bArr[i7] & 255) << 16) | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
        }
        return invokeV.longValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (a() == 0) {
                return null;
            }
            int i2 = this.f29718b;
            while (i2 < this.f29719c && this.a[i2] != 0) {
                i2++;
            }
            byte[] bArr = this.a;
            int i3 = this.f29718b;
            String str = new String(bArr, i3, i2 - i3);
            this.f29718b = i2;
            if (i2 < this.f29719c) {
                this.f29718b = i2 + 1;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            if (i2 == 0) {
                return "";
            }
            int i3 = (this.f29718b + i2) - 1;
            String str = new String(this.a, this.f29718b, (i3 >= this.f29719c || this.a[i3] != 0) ? i2 : i2 - 1);
            this.f29718b += i2;
            return str;
        }
        return (String) invokeI.objValue;
    }

    public short t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            int i3 = i2 + 1;
            this.f29718b = i3;
            this.f29718b = i3 + 1;
            return (short) ((bArr[i3] & 255) | ((bArr[i2] & 255) << 8));
        }
        return invokeV.shortValue;
    }

    public String u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) ? v(i2, Charset.forName("UTF-8")) : (String) invokeI.objValue;
    }

    public String v(int i2, Charset charset) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048608, this, i2, charset)) == null) {
            String str = new String(this.a, this.f29718b, i2, charset);
            this.f29718b += i2;
            return str;
        }
        return (String) invokeIL.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (x() << 21) | (x() << 14) | (x() << 7) | x() : invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            this.f29718b = i2 + 1;
            return bArr[i2] & 255;
        }
        return invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            int i3 = i2 + 1;
            this.f29718b = i3;
            int i4 = i3 + 1;
            this.f29718b = i4;
            int i5 = (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
            this.f29718b = i4 + 2;
            return i5;
        }
        return invokeV.intValue;
    }

    public long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            byte[] bArr = this.a;
            int i2 = this.f29718b;
            int i3 = i2 + 1;
            this.f29718b = i3;
            int i4 = i3 + 1;
            this.f29718b = i4;
            int i5 = i4 + 1;
            this.f29718b = i5;
            this.f29718b = i5 + 1;
            return ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
        }
        return invokeV.longValue;
    }

    public l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new byte[i2];
        this.f29719c = i2;
    }

    public l(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = bArr;
        this.f29719c = bArr.length;
    }

    public l(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = bArr;
        this.f29719c = i2;
    }
}
