package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.slider.BasicLabelFormatter;
import java.io.IOException;
import java.util.Arrays;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes9.dex */
public class j0 implements Appendable, CharSequence {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final char[] f27653g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public char[] f27654e;

    /* renamed from: f  reason: collision with root package name */
    public int f27655f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(567901765, "Lc/b/b/q/j0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(567901765, "Lc/b/b/q/j0;");
                return;
            }
        }
        f27653g = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public j0() {
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
        this.f27654e = new char[16];
    }

    public static int E(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) != null) {
            return invokeII.intValue;
        }
        int i4 = i2 < 0 ? 2 : 1;
        while (true) {
            i2 /= i3;
            if (i2 == 0) {
                return i4;
            }
            i4++;
        }
    }

    public static int F(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) != null) {
            return invokeCommon.intValue;
        }
        int i3 = j2 < 0 ? 2 : 1;
        while (true) {
            j2 /= i2;
            if (j2 == 0) {
                return i3;
            }
            i3++;
        }
    }

    public final void A(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            if (i2 >= 0 && i2 <= this.f27655f) {
                if (str == null) {
                    str = StringUtil.NULL_STRING;
                }
                int length = str.length();
                if (length != 0) {
                    D(length, i2);
                    str.getChars(0, length, this.f27654e, i2);
                    this.f27655f += length;
                    return;
                }
                return;
            }
            throw new StringIndexOutOfBoundsException(i2);
        }
    }

    public final void B(int i2, char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, cArr) == null) {
            if (i2 >= 0 && i2 <= this.f27655f) {
                if (cArr.length != 0) {
                    D(cArr.length, i2);
                    System.arraycopy(cArr, 0, cArr, i2, cArr.length);
                    this.f27655f += cArr.length;
                    return;
                }
                return;
            }
            throw new StringIndexOutOfBoundsException(i2);
        }
    }

    public final void C(int i2, char[] cArr, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), cArr, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (i2 >= 0 && i2 <= i4) {
                if (i3 >= 0 && i4 >= 0 && i4 <= cArr.length - i3) {
                    if (i4 != 0) {
                        D(i4, i2);
                        System.arraycopy(cArr, i3, this.f27654e, i2, i4);
                        this.f27655f += i4;
                        return;
                    }
                    return;
                }
                throw new StringIndexOutOfBoundsException("offset " + i3 + ", length " + i4 + ", char[].length " + cArr.length);
            }
            throw new StringIndexOutOfBoundsException(i2);
        }
    }

    public final void D(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            char[] cArr = this.f27654e;
            int length = cArr.length;
            int i4 = this.f27655f;
            if (length - i4 >= i2) {
                System.arraycopy(cArr, i3, cArr, i2 + i3, i4 - i3);
                return;
            }
            int i5 = i4 + i2;
            int length2 = (cArr.length << 1) + 2;
            if (i5 <= length2) {
                i5 = length2;
            }
            char[] cArr2 = new char[i5];
            System.arraycopy(this.f27654e, 0, cArr2, 0, i3);
            System.arraycopy(this.f27654e, i3, cArr2, i2 + i3, this.f27655f - i3);
            this.f27654e = cArr2;
        }
    }

    public j0 G(char c2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Character.valueOf(c2), str})) == null) {
            int length = str.length();
            int i2 = 0;
            while (i2 != this.f27655f) {
                if (this.f27654e[i2] == c2) {
                    H(i2, i2 + 1, str);
                    i2 += length;
                } else {
                    i2++;
                }
            }
            return this;
        }
        return (j0) invokeCommon.objValue;
    }

    public final void H(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) {
            if (i2 >= 0) {
                int i4 = this.f27655f;
                if (i3 > i4) {
                    i3 = i4;
                }
                if (i3 > i2) {
                    int length = str.length();
                    int i5 = (i3 - i2) - length;
                    if (i5 > 0) {
                        char[] cArr = this.f27654e;
                        System.arraycopy(cArr, i3, cArr, i2 + length, this.f27655f - i3);
                    } else if (i5 < 0) {
                        D(-i5, i3);
                    }
                    str.getChars(0, length, this.f27654e, i2);
                    this.f27655f -= i5;
                    return;
                } else if (i2 == i3) {
                    if (str != null) {
                        A(i2, str);
                        return;
                    }
                    throw null;
                }
            }
            throw new StringIndexOutOfBoundsException();
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 >= 0) {
                char[] cArr = this.f27654e;
                if (i2 > cArr.length) {
                    x(i2);
                } else {
                    int i3 = this.f27655f;
                    if (i3 < i2) {
                        Arrays.fill(cArr, i3, i2, (char) 0);
                    }
                }
                this.f27655f = i2;
                return;
            }
            throw new StringIndexOutOfBoundsException(i2);
        }
    }

    public String J(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) {
            if (i2 < 0 || i2 > i3 || i3 > this.f27655f) {
                throw new StringIndexOutOfBoundsException();
            }
            return i2 == i3 ? "" : new String(this.f27654e, i2, i3 - i2);
        }
        return (String) invokeII.objValue;
    }

    public j0 a(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Character.valueOf(c2)})) == null) {
            q(c2);
            return this;
        }
        return (j0) invokeCommon.objValue;
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char c2) throws IOException {
        a(c2);
        return this;
    }

    public j0 b(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Double.valueOf(d2)})) == null) {
            s(Double.toString(d2));
            return this;
        }
        return (j0) invokeCommon.objValue;
    }

    public j0 c(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048589, this, f2)) == null) {
            s(Float.toString(f2));
            return this;
        }
        return (j0) invokeF.objValue;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            if (i2 >= 0 && i2 < this.f27655f) {
                return this.f27654e[i2];
            }
            throw new StringIndexOutOfBoundsException(i2);
        }
        return invokeI.charValue;
    }

    public j0 d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            e(i2, 0);
            return this;
        }
        return (j0) invokeI.objValue;
    }

    public j0 delete(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i2, i3)) == null) {
            w(i2, i3);
            return this;
        }
        return (j0) invokeII.objValue;
    }

    public j0 e(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i2, i3)) == null) {
            f(i2, i3, '0');
            return this;
        }
        return (j0) invokeII.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && j0.class == obj.getClass()) {
                j0 j0Var = (j0) obj;
                int i2 = this.f27655f;
                if (i2 != j0Var.f27655f) {
                    return false;
                }
                char[] cArr = this.f27654e;
                char[] cArr2 = j0Var.f27654e;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (cArr[i3] != cArr2[i3]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public j0 f(int i2, int i3, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(c2)})) == null) {
            if (i2 == Integer.MIN_VALUE) {
                s("-2147483648");
                return this;
            }
            if (i2 < 0) {
                q(SignatureImpl.SEP);
                i2 = -i2;
            }
            if (i3 > 1) {
                for (int E = i3 - E(i2, 10); E > 0; E--) {
                    a(c2);
                }
            }
            if (i2 >= 10000) {
                if (i2 >= 1000000000) {
                    q(f27653g[(int) ((i2 % 10000000000L) / 1000000000)]);
                }
                if (i2 >= 100000000) {
                    q(f27653g[(i2 % 1000000000) / 100000000]);
                }
                if (i2 >= 10000000) {
                    q(f27653g[(i2 % 100000000) / 10000000]);
                }
                if (i2 >= 1000000) {
                    q(f27653g[(i2 % 10000000) / 1000000]);
                }
                if (i2 >= 100000) {
                    q(f27653g[(i2 % 1000000) / 100000]);
                }
                q(f27653g[(i2 % 100000) / 10000]);
            }
            if (i2 >= 1000) {
                q(f27653g[(i2 % 10000) / 1000]);
            }
            if (i2 >= 100) {
                q(f27653g[(i2 % 1000) / 100]);
            }
            if (i2 >= 10) {
                q(f27653g[(i2 % 100) / 10]);
            }
            q(f27653g[i2 % 10]);
            return this;
        }
        return (j0) invokeCommon.objValue;
    }

    public j0 g(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j2)) == null) {
            h(j2, 0);
            return this;
        }
        return (j0) invokeJ.objValue;
    }

    public j0 h(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            i(j2, i2, '0');
            return this;
        }
        return (j0) invokeCommon.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int i2 = this.f27655f + 31;
            for (int i3 = 0; i3 < this.f27655f; i3++) {
                i2 = (i2 * 31) + this.f27654e[i3];
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public j0 i(long j2, int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            if (j2 == Long.MIN_VALUE) {
                s("-9223372036854775808");
                return this;
            }
            if (j2 < 0) {
                q(SignatureImpl.SEP);
                j2 = -j2;
            }
            if (i2 > 1) {
                for (int F = i2 - F(j2, 10); F > 0; F--) {
                    a(c2);
                }
            }
            if (j2 >= 10000) {
                if (j2 >= 1000000000000000000L) {
                    q(f27653g[(int) ((j2 % 1.0E19d) / 1.0E18d)]);
                }
                if (j2 >= 100000000000000000L) {
                    q(f27653g[(int) ((j2 % 1000000000000000000L) / 100000000000000000L)]);
                }
                if (j2 >= 10000000000000000L) {
                    q(f27653g[(int) ((j2 % 100000000000000000L) / 10000000000000000L)]);
                }
                if (j2 >= 1000000000000000L) {
                    q(f27653g[(int) ((j2 % 10000000000000000L) / 1000000000000000L)]);
                }
                if (j2 >= 100000000000000L) {
                    q(f27653g[(int) ((j2 % 1000000000000000L) / 100000000000000L)]);
                }
                if (j2 >= 10000000000000L) {
                    q(f27653g[(int) ((j2 % 100000000000000L) / 10000000000000L)]);
                }
                if (j2 >= BasicLabelFormatter.TRILLION) {
                    q(f27653g[(int) ((j2 % 10000000000000L) / BasicLabelFormatter.TRILLION)]);
                }
                if (j2 >= 100000000000L) {
                    q(f27653g[(int) ((j2 % BasicLabelFormatter.TRILLION) / 100000000000L)]);
                }
                if (j2 >= 10000000000L) {
                    q(f27653g[(int) ((j2 % 100000000000L) / 10000000000L)]);
                }
                if (j2 >= 1000000000) {
                    q(f27653g[(int) ((j2 % 10000000000L) / 1000000000)]);
                }
                if (j2 >= 100000000) {
                    q(f27653g[(int) ((j2 % 1000000000) / 100000000)]);
                }
                if (j2 >= 10000000) {
                    q(f27653g[(int) ((j2 % 100000000) / 10000000)]);
                }
                if (j2 >= 1000000) {
                    q(f27653g[(int) ((j2 % 10000000) / 1000000)]);
                }
                if (j2 >= 100000) {
                    q(f27653g[(int) ((j2 % 1000000) / 100000)]);
                }
                q(f27653g[(int) ((j2 % 100000) / 10000)]);
            }
            if (j2 >= 1000) {
                q(f27653g[(int) ((j2 % 10000) / 1000)]);
            }
            if (j2 >= 100) {
                q(f27653g[(int) ((j2 % 1000) / 100)]);
            }
            if (j2 >= 10) {
                q(f27653g[(int) ((j2 % 100) / 10)]);
            }
            q(f27653g[(int) (j2 % 10)]);
            return this;
        }
        return (j0) invokeCommon.objValue;
    }

    public j0 insert(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            A(i2, z ? "true" : "false");
            return this;
        }
        return (j0) invokeCommon.objValue;
    }

    public j0 j(j0 j0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, j0Var)) == null) {
            if (j0Var == null) {
                v();
            } else {
                u(j0Var.f27654e, 0, j0Var.f27655f);
            }
            return this;
        }
        return (j0) invokeL.objValue;
    }

    public j0 k(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, charSequence)) == null) {
            if (charSequence == null) {
                v();
            } else if (charSequence instanceof j0) {
                j0 j0Var = (j0) charSequence;
                u(j0Var.f27654e, 0, j0Var.f27655f);
            } else {
                s(charSequence.toString());
            }
            return this;
        }
        return (j0) invokeL.objValue;
    }

    public j0 l(CharSequence charSequence, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048614, this, charSequence, i2, i3)) == null) {
            r(charSequence, i2, i3);
            return this;
        }
        return (j0) invokeLII.objValue;
    }

    @Override // java.lang.CharSequence
    public int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f27655f : invokeV.intValue;
    }

    public j0 m(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, obj)) == null) {
            if (obj == null) {
                v();
            } else {
                s(obj.toString());
            }
            return this;
        }
        return (j0) invokeL.objValue;
    }

    public j0 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            s(str);
            return this;
        }
        return (j0) invokeL.objValue;
    }

    public j0 o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
            s(z ? "true" : "false");
            return this;
        }
        return (j0) invokeZ.objValue;
    }

    public j0 p(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, cArr)) == null) {
            t(cArr);
            return this;
        }
        return (j0) invokeL.objValue;
    }

    public final void q(char c2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Character.valueOf(c2)}) == null) {
            int i2 = this.f27655f;
            if (i2 == this.f27654e.length) {
                x(i2 + 1);
            }
            char[] cArr = this.f27654e;
            int i3 = this.f27655f;
            this.f27655f = i3 + 1;
            cArr[i3] = c2;
        }
    }

    public final void r(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048621, this, charSequence, i2, i3) == null) {
            if (charSequence == null) {
                charSequence = StringUtil.NULL_STRING;
            }
            if (i2 >= 0 && i3 >= 0 && i2 <= i3 && i3 <= charSequence.length()) {
                s(charSequence.subSequence(i2, i3).toString());
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            if (str == null) {
                v();
                return;
            }
            int length = str.length();
            int i2 = this.f27655f + length;
            if (i2 > this.f27654e.length) {
                x(i2);
            }
            str.getChars(0, length, this.f27654e, this.f27655f);
            this.f27655f = i2;
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048623, this, i2, i3)) == null) ? J(i2, i3) : (CharSequence) invokeII.objValue;
    }

    public final void t(char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, cArr) == null) {
            int length = this.f27655f + cArr.length;
            if (length > this.f27654e.length) {
                x(length);
            }
            System.arraycopy(cArr, 0, this.f27654e, this.f27655f, cArr.length);
            this.f27655f = length;
        }
    }

    @Override // java.lang.CharSequence
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f27655f == 0 ? "" : new String(this.f27654e, 0, this.f27655f) : (String) invokeV.objValue;
    }

    public final void u(char[] cArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048626, this, cArr, i2, i3) == null) {
            if (i2 <= cArr.length && i2 >= 0) {
                if (i3 >= 0 && cArr.length - i2 >= i3) {
                    int i4 = this.f27655f + i3;
                    if (i4 > this.f27654e.length) {
                        x(i4);
                    }
                    System.arraycopy(cArr, i2, this.f27654e, this.f27655f, i3);
                    this.f27655f = i4;
                    return;
                }
                throw new ArrayIndexOutOfBoundsException("Length out of bounds: " + i3);
            }
            throw new ArrayIndexOutOfBoundsException("Offset out of bounds: " + i2);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            int i2 = this.f27655f + 4;
            if (i2 > this.f27654e.length) {
                x(i2);
            }
            char[] cArr = this.f27654e;
            int i3 = this.f27655f;
            int i4 = i3 + 1;
            this.f27655f = i4;
            cArr[i3] = 'n';
            int i5 = i4 + 1;
            this.f27655f = i5;
            cArr[i4] = 'u';
            int i6 = i5 + 1;
            this.f27655f = i6;
            cArr[i5] = 'l';
            this.f27655f = i6 + 1;
            cArr[i6] = 'l';
        }
    }

    public final void w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048628, this, i2, i3) == null) {
            if (i2 >= 0) {
                int i4 = this.f27655f;
                if (i3 > i4) {
                    i3 = i4;
                }
                if (i3 == i2) {
                    return;
                }
                if (i3 > i2) {
                    int i5 = this.f27655f - i3;
                    if (i5 >= 0) {
                        char[] cArr = this.f27654e;
                        System.arraycopy(cArr, i3, cArr, i2, i5);
                    }
                    this.f27655f -= i3 - i2;
                    return;
                }
            }
            throw new StringIndexOutOfBoundsException();
        }
    }

    public final void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            char[] cArr = this.f27654e;
            int length = (cArr.length >> 1) + cArr.length + 2;
            if (i2 <= length) {
                i2 = length;
            }
            char[] cArr2 = new char[i2];
            System.arraycopy(this.f27654e, 0, cArr2, 0, this.f27655f);
            this.f27654e = cArr2;
        }
    }

    public final void y(int i2, char c2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i2), Character.valueOf(c2)}) == null) {
            if (i2 >= 0 && i2 <= this.f27655f) {
                D(1, i2);
                this.f27654e[i2] = c2;
                this.f27655f++;
                return;
            }
            throw new ArrayIndexOutOfBoundsException(i2);
        }
    }

    public final void z(int i2, CharSequence charSequence, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i2), charSequence, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (charSequence == null) {
                charSequence = StringUtil.NULL_STRING;
            }
            if (i2 >= 0 && i2 <= this.f27655f && i3 >= 0 && i4 >= 0 && i3 <= i4 && i4 <= charSequence.length()) {
                A(i2, charSequence.subSequence(i3, i4).toString());
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) throws IOException {
        k(charSequence);
        return this;
    }

    public j0 insert(int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            y(i2, c2);
            return this;
        }
        return (j0) invokeCommon.objValue;
    }

    public j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (i2 >= 0) {
            this.f27654e = new char[i2];
            return;
        }
        throw new NegativeArraySizeException();
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
        l(charSequence, i2, i3);
        return this;
    }

    public j0 insert(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048603, this, i2, i3)) == null) {
            A(i2, Integer.toString(i3));
            return this;
        }
        return (j0) invokeII.objValue;
    }

    public j0 insert(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            A(i2, Long.toString(j2));
            return this;
        }
        return (j0) invokeCommon.objValue;
    }

    public j0 insert(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            A(i2, Float.toString(f2));
            return this;
        }
        return (j0) invokeCommon.objValue;
    }

    public j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        int length = str.length();
        this.f27655f = length;
        char[] cArr = new char[length + 16];
        this.f27654e = cArr;
        str.getChars(0, length, cArr, 0);
    }

    public j0 insert(int i2, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)})) == null) {
            A(i2, Double.toString(d2));
            return this;
        }
        return (j0) invokeCommon.objValue;
    }

    public j0 insert(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048607, this, i2, obj)) == null) {
            A(i2, obj == null ? StringUtil.NULL_STRING : obj.toString());
            return this;
        }
        return (j0) invokeIL.objValue;
    }

    public j0 insert(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048608, this, i2, str)) == null) {
            A(i2, str);
            return this;
        }
        return (j0) invokeIL.objValue;
    }

    public j0 insert(int i2, char[] cArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048610, this, i2, cArr)) == null) {
            B(i2, cArr);
            return this;
        }
        return (j0) invokeIL.objValue;
    }

    public j0 insert(int i2, char[] cArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i2), cArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            C(i2, cArr, i3, i4);
            return this;
        }
        return (j0) invokeCommon.objValue;
    }

    public j0 insert(int i2, CharSequence charSequence) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048605, this, i2, charSequence)) == null) {
            A(i2, charSequence == null ? StringUtil.NULL_STRING : charSequence.toString());
            return this;
        }
        return (j0) invokeIL.objValue;
    }

    public j0 insert(int i2, CharSequence charSequence, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), charSequence, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            z(i2, charSequence, i3, i4);
            return this;
        }
        return (j0) invokeCommon.objValue;
    }
}
