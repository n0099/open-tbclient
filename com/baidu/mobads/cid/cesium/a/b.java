package com.baidu.mobads.cid.cesium.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes5.dex */
public class b implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f42609a;

    /* renamed from: b  reason: collision with root package name */
    public static final ObjectStreamField[] f42610b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public long[] f42611c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f42612d;

    /* renamed from: e  reason: collision with root package name */
    public transient boolean f42613e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-480698684, "Lcom/baidu/mobads/cid/cesium/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-480698684, "Lcom/baidu/mobads/cid/cesium/a/b;");
                return;
            }
        }
        f42609a = !b.class.desiredAssertionStatus();
        f42610b = new ObjectStreamField[]{new ObjectStreamField("bits", long[].class)};
    }

    public b() {
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
        this.f42612d = 0;
        this.f42613e = false;
        g(64);
        this.f42613e = false;
    }

    public b(int i2) {
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
        this.f42612d = 0;
        this.f42613e = false;
        if (i2 >= 0) {
            g(i2);
            this.f42613e = true;
            return;
        }
        throw new NegativeArraySizeException("nbits < 0: " + i2);
    }

    public b(long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f42612d = 0;
        this.f42613e = false;
        this.f42611c = jArr;
        this.f42612d = jArr.length;
        d();
    }

    public static b a(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jArr)) == null) {
            int length = jArr.length;
            while (length > 0 && jArr[length - 1] == 0) {
                length--;
            }
            return new b(Arrays.copyOf(jArr, length));
        }
        return (b) invokeL.objValue;
    }

    private void d() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            if (!f42609a && (i3 = this.f42612d) != 0 && this.f42611c[i3 - 1] == 0) {
                throw new AssertionError();
            }
            if (!f42609a && ((i2 = this.f42612d) < 0 || i2 > this.f42611c.length)) {
                throw new AssertionError();
            }
            if (f42609a) {
                return;
            }
            int i4 = this.f42612d;
            long[] jArr = this.f42611c;
            if (i4 != jArr.length && jArr[i4] != 0) {
                throw new AssertionError();
            }
        }
    }

    public static void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
            } else if (i3 < 0) {
                throw new IndexOutOfBoundsException("toIndex < 0: " + i3);
            } else if (i2 <= i3) {
            } else {
                throw new IndexOutOfBoundsException("fromIndex: " + i2 + " > toIndex: " + i3);
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            int i2 = this.f42612d - 1;
            while (i2 >= 0 && this.f42611c[i2] == 0) {
                i2--;
            }
            this.f42612d = i2 + 1;
        }
    }

    public static int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? i2 >> 6 : invokeI.intValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            int i2 = this.f42612d;
            long[] jArr = this.f42611c;
            if (i2 != jArr.length) {
                this.f42611c = Arrays.copyOf(jArr, i2);
                d();
            }
        }
    }

    private void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, this, i2) == null) {
            this.f42611c = new long[f(i2 - 1) + 1];
        }
    }

    private void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
            long[] jArr = this.f42611c;
            if (jArr.length < i2) {
                this.f42611c = Arrays.copyOf(this.f42611c, Math.max(jArr.length * 2, i2));
                this.f42613e = false;
            }
        }
    }

    private void i(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65548, this, i2) == null) || this.f42612d >= (i3 = i2 + 1)) {
            return;
        }
        h(i3);
        this.f42612d = i3;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
            }
            int f2 = f(i2);
            i(f2);
            long[] jArr = this.f42611c;
            jArr[f2] = jArr[f2] | (1 << i2);
            d();
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            d(i2, i3);
            if (i2 == i3) {
                return;
            }
            int f2 = f(i2);
            int f3 = f(i3 - 1);
            i(f3);
            long j2 = (-1) << i2;
            long j3 = (-1) >>> (-i3);
            if (f2 == f3) {
                long[] jArr = this.f42611c;
                jArr[f2] = (j3 & j2) | jArr[f2];
            } else {
                long[] jArr2 = this.f42611c;
                jArr2[f2] = j2 | jArr2[f2];
                while (true) {
                    f2++;
                    if (f2 >= f3) {
                        break;
                    }
                    this.f42611c[f2] = -1;
                }
                long[] jArr3 = this.f42611c;
                jArr3[f3] = j3 | jArr3[f3];
            }
            d();
        }
    }

    public void a(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (z) {
                a(i2, i3);
            } else {
                b(i2, i3);
            }
        }
    }

    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                a(i2);
            } else {
                b(i2);
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || this == bVar) {
            return;
        }
        while (true) {
            int i2 = this.f42612d;
            if (i2 <= bVar.f42612d) {
                break;
            }
            long[] jArr = this.f42611c;
            int i3 = i2 - 1;
            this.f42612d = i3;
            jArr[i3] = 0;
        }
        for (int i4 = 0; i4 < this.f42612d; i4++) {
            long[] jArr2 = this.f42611c;
            jArr2[i4] = jArr2[i4] & bVar.f42611c[i4];
        }
        e();
        d();
    }

    public byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.f42612d;
            if (i2 == 0) {
                return new byte[0];
            }
            int i3 = i2 - 1;
            int i4 = i3 * 8;
            for (long j2 = this.f42611c[i3]; j2 != 0; j2 >>>= 8) {
                i4++;
            }
            byte[] bArr = new byte[i4];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            for (int i5 = 0; i5 < i3; i5++) {
                order.putLong(this.f42611c[i5]);
            }
            for (long j3 = this.f42611c[i3]; j3 != 0; j3 >>>= 8) {
                order.put((byte) (255 & j3));
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.f42612d;
            if (i2 == 0) {
                return 0;
            }
            return ((i2 - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.f42611c[i2 - 1]));
        }
        return invokeV.intValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
            }
            int f2 = f(i2);
            if (f2 >= this.f42612d) {
                return;
            }
            long[] jArr = this.f42611c;
            jArr[f2] = jArr[f2] & (~(1 << i2));
            e();
            d();
        }
    }

    public void b(int i2, int i3) {
        int f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            d(i2, i3);
            if (i2 != i3 && (f2 = f(i2)) < this.f42612d) {
                int f3 = f(i3 - 1);
                if (f3 >= this.f42612d) {
                    i3 = b();
                    f3 = this.f42612d - 1;
                }
                long j2 = (-1) << i2;
                long j3 = (-1) >>> (-i3);
                if (f2 == f3) {
                    long[] jArr = this.f42611c;
                    jArr[f2] = (~(j3 & j2)) & jArr[f2];
                } else {
                    long[] jArr2 = this.f42611c;
                    jArr2[f2] = (~j2) & jArr2[f2];
                    while (true) {
                        f2++;
                        if (f2 >= f3) {
                            break;
                        }
                        this.f42611c[f2] = 0;
                    }
                    long[] jArr3 = this.f42611c;
                    jArr3[f3] = (~j3) & jArr3[f3];
                }
                e();
                d();
            }
        }
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || this == bVar) {
            return;
        }
        int min = Math.min(this.f42612d, bVar.f42612d);
        int i2 = this.f42612d;
        int i3 = bVar.f42612d;
        if (i2 < i3) {
            h(i3);
            this.f42612d = bVar.f42612d;
        }
        for (int i4 = 0; i4 < min; i4++) {
            long[] jArr = this.f42611c;
            jArr[i4] = jArr[i4] | bVar.f42611c[i4];
        }
        if (min < bVar.f42612d) {
            System.arraycopy(bVar.f42611c, min, this.f42611c, min, this.f42612d - min);
        }
        d();
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f42612d; i3++) {
                i2 += Long.bitCount(this.f42611c[i3]);
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public b c(int i2, int i3) {
        InterceptResult invokeII;
        int i4;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            d(i2, i3);
            d();
            int b2 = b();
            int i5 = 0;
            if (b2 <= i2 || i2 == i3) {
                return new b(0);
            }
            if (i3 > b2) {
                i3 = b2;
            }
            int i6 = i3 - i2;
            b bVar = new b(i6);
            int f2 = f(i6 - 1) + 1;
            int f3 = f(i2);
            int i7 = i2 & 63;
            boolean z = i7 == 0;
            while (true) {
                i4 = f2 - 1;
                if (i5 >= i4) {
                    break;
                }
                long[] jArr = bVar.f42611c;
                long[] jArr2 = this.f42611c;
                jArr[i5] = z ? jArr2[f3] : (jArr2[f3] >>> i2) | (jArr2[f3 + 1] << (-i2));
                i5++;
                f3++;
            }
            long j3 = (-1) >>> (-i3);
            long[] jArr3 = bVar.f42611c;
            if (((i3 - 1) & 63) < i7) {
                long[] jArr4 = this.f42611c;
                j2 = ((jArr4[f3 + 1] & j3) << (-i2)) | (jArr4[f3] >>> i2);
            } else {
                j2 = (this.f42611c[f3] & j3) >>> i2;
            }
            jArr3[i4] = j2;
            bVar.f42612d = f2;
            bVar.e();
            bVar.d();
            return bVar;
        }
        return (b) invokeII.objValue;
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            int min = Math.min(this.f42612d, bVar.f42612d);
            int i2 = this.f42612d;
            int i3 = bVar.f42612d;
            if (i2 < i3) {
                h(i3);
                this.f42612d = bVar.f42612d;
            }
            for (int i4 = 0; i4 < min; i4++) {
                long[] jArr = this.f42611c;
                jArr[i4] = jArr[i4] ^ bVar.f42611c[i4];
            }
            int i5 = bVar.f42612d;
            if (min < i5) {
                System.arraycopy(bVar.f42611c, min, this.f42611c, min, i5 - min);
            }
            e();
            d();
        }
    }

    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (i2 >= 0) {
                d();
                int f2 = f(i2);
                return f2 < this.f42612d && (this.f42611c[f2] & (1 << i2)) != 0;
            }
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
        }
        return invokeI.booleanValue;
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!this.f42613e) {
                f();
            }
            try {
                b bVar = (b) super.clone();
                bVar.f42611c = (long[]) this.f42611c.clone();
                bVar.d();
                return bVar;
            } catch (CloneNotSupportedException unused) {
                throw new InternalError();
            }
        }
        return invokeV.objValue;
    }

    public int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
            }
            d();
            int f2 = f(i2);
            if (f2 >= this.f42612d) {
                return -1;
            }
            long j2 = this.f42611c[f2] & ((-1) << i2);
            while (j2 == 0) {
                f2++;
                if (f2 == this.f42612d) {
                    return -1;
                }
                j2 = this.f42611c[f2];
            }
            return (f2 * 64) + Long.numberOfTrailingZeros(j2);
        }
        return invokeI.intValue;
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            for (int min = Math.min(this.f42612d, bVar.f42612d) - 1; min >= 0; min--) {
                long[] jArr = this.f42611c;
                jArr[min] = jArr[min] & (~bVar.f42611c[min]);
            }
            e();
            d();
        }
    }

    public int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
            }
            d();
            int f2 = f(i2);
            if (f2 >= this.f42612d) {
                return i2;
            }
            long j2 = (~this.f42611c[f2]) & ((-1) << i2);
            while (j2 == 0) {
                f2++;
                int i3 = this.f42612d;
                if (f2 == i3) {
                    return i3 * 64;
                }
                j2 = ~this.f42611c[f2];
            }
            return (f2 * 64) + Long.numberOfTrailingZeros(j2);
        }
        return invokeI.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj instanceof b) {
                if (this == obj) {
                    return true;
                }
                b bVar = (b) obj;
                d();
                bVar.d();
                if (this.f42612d != bVar.f42612d) {
                    return false;
                }
                for (int i2 = 0; i2 < this.f42612d; i2++) {
                    if (this.f42611c[i2] != bVar.f42611c[i2]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048595, this)) != null) {
            return invokeV.intValue;
        }
        int i2 = this.f42612d;
        long j2 = 1234;
        while (true) {
            i2--;
            if (i2 < 0) {
                return (int) ((j2 >> 32) ^ j2);
            }
            j2 ^= this.f42611c[i2] * (i2 + 1);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            d();
            int i2 = this.f42612d;
            StringBuilder sb = new StringBuilder(((i2 > 128 ? c() : i2 * 64) * 6) + 2);
            sb.append(ExtendedMessageFormat.START_FE);
            int d2 = d(0);
            if (d2 != -1) {
                sb.append(d2);
                while (true) {
                    d2 = d(d2 + 1);
                    if (d2 < 0) {
                        break;
                    }
                    int e2 = e(d2);
                    do {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        sb.append(d2);
                        d2++;
                    } while (d2 < e2);
                }
            }
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
