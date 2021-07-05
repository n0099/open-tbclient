package com.baidu.ad.magic.flute.a.a;

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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.util.Arrays;
/* loaded from: classes.dex */
public class c implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f2125a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2126b = 6;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2127c = 64;

    /* renamed from: d  reason: collision with root package name */
    public static final int f2128d = 63;

    /* renamed from: e  reason: collision with root package name */
    public static final long f2129e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static final ObjectStreamField[] f2130f;
    public static final long j = 7997698588986878753L;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public long[] f2131g;

    /* renamed from: h  reason: collision with root package name */
    public transient int f2132h;

    /* renamed from: i  reason: collision with root package name */
    public transient boolean f2133i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1706275933, "Lcom/baidu/ad/magic/flute/a/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1706275933, "Lcom/baidu/ad/magic/flute/a/a/c;");
                return;
            }
        }
        f2125a = !c.class.desiredAssertionStatus();
        f2130f = new ObjectStreamField[]{new ObjectStreamField("bits", long[].class)};
    }

    public c() {
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
        this.f2132h = 0;
        this.f2133i = false;
        j(64);
        this.f2133i = false;
    }

    public c(int i2) {
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
        this.f2132h = 0;
        this.f2133i = false;
        if (i2 >= 0) {
            j(i2);
            this.f2133i = true;
            return;
        }
        throw new NegativeArraySizeException("nbits < 0: " + i2);
    }

    public c(long[] jArr) {
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
        this.f2132h = 0;
        this.f2133i = false;
        this.f2131g = jArr;
        this.f2132h = jArr.length;
        h();
    }

    public static c a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, byteBuffer)) == null) {
            ByteBuffer order = byteBuffer.slice().order(ByteOrder.LITTLE_ENDIAN);
            int remaining = order.remaining();
            while (remaining > 0 && order.get(remaining - 1) == 0) {
                remaining--;
            }
            long[] jArr = new long[(remaining + 7) / 8];
            order.limit(remaining);
            int i2 = 0;
            while (order.remaining() >= 8) {
                jArr[i2] = order.getLong();
                i2++;
            }
            int remaining2 = order.remaining();
            for (int i3 = 0; i3 < remaining2; i3++) {
                jArr[i2] = jArr[i2] | ((order.get() & 255) << (i3 * 8));
            }
            return new c(jArr);
        }
        return (c) invokeL.objValue;
    }

    public static c a(LongBuffer longBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, longBuffer)) == null) {
            LongBuffer slice = longBuffer.slice();
            int remaining = slice.remaining();
            while (remaining > 0 && slice.get(remaining - 1) == 0) {
                remaining--;
            }
            long[] jArr = new long[remaining];
            slice.get(jArr);
            return new c(jArr);
        }
        return (c) invokeL.objValue;
    }

    public static c a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bArr)) == null) ? a(ByteBuffer.wrap(bArr)) : (c) invokeL.objValue;
    }

    public static c a(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jArr)) == null) {
            int length = jArr.length;
            while (length > 0 && jArr[length - 1] == 0) {
                length--;
            }
            return new c(Arrays.copyOf(jArr, length));
        }
        return (c) invokeL.objValue;
    }

    private void a(ObjectInputStream objectInputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, objectInputStream) == null) {
            long[] jArr = (long[]) objectInputStream.readFields().get("bits", (Object) null);
            this.f2131g = jArr;
            this.f2132h = jArr.length;
            i();
            long[] jArr2 = this.f2131g;
            boolean z = true;
            this.f2133i = (jArr2.length <= 0 || jArr2[jArr2.length - 1] != 0) ? false : false;
            h();
        }
    }

    private void a(ObjectOutputStream objectOutputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, objectOutputStream) == null) {
            h();
            if (!this.f2133i) {
                j();
            }
            objectOutputStream.putFields().put("bits", this.f2131g);
            objectOutputStream.writeFields();
        }
    }

    public static void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65546, null, i2, i3) == null) {
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

    private void h() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (!f2125a && (i3 = this.f2132h) != 0 && this.f2131g[i3 - 1] == 0) {
                throw new AssertionError();
            }
            if (!f2125a && ((i2 = this.f2132h) < 0 || i2 > this.f2131g.length)) {
                throw new AssertionError();
            }
            if (f2125a) {
                return;
            }
            int i4 = this.f2132h;
            long[] jArr = this.f2131g;
            if (i4 != jArr.length && jArr[i4] != 0) {
                throw new AssertionError();
            }
        }
    }

    public static int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) ? i2 >> 6 : invokeI.intValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            int i2 = this.f2132h - 1;
            while (i2 >= 0 && this.f2131g[i2] == 0) {
                i2--;
            }
            this.f2132h = i2 + 1;
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            int i2 = this.f2132h;
            long[] jArr = this.f2131g;
            if (i2 != jArr.length) {
                this.f2131g = Arrays.copyOf(jArr, i2);
                h();
            }
        }
    }

    private void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, this, i2) == null) {
            this.f2131g = new long[i(i2 - 1) + 1];
        }
    }

    private void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i2) == null) {
            long[] jArr = this.f2131g;
            if (jArr.length < i2) {
                this.f2131g = Arrays.copyOf(this.f2131g, Math.max(jArr.length * 2, i2));
                this.f2133i = false;
            }
        }
    }

    private void l(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65553, this, i2) == null) || this.f2132h >= (i3 = i2 + 1)) {
            return;
        }
        k(i3);
        this.f2132h = i3;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
            }
            int i3 = i(i2);
            l(i3);
            long[] jArr = this.f2131g;
            jArr[i3] = jArr[i3] ^ (1 << i2);
            i();
            h();
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            e(i2, i3);
            if (i2 == i3) {
                return;
            }
            int i4 = i(i2);
            int i5 = i(i3 - 1);
            l(i5);
            long j2 = (-1) << i2;
            long j3 = (-1) >>> (-i3);
            if (i4 == i5) {
                long[] jArr = this.f2131g;
                jArr[i4] = (j3 & j2) ^ jArr[i4];
            } else {
                long[] jArr2 = this.f2131g;
                jArr2[i4] = jArr2[i4] ^ j2;
                while (true) {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                    long[] jArr3 = this.f2131g;
                    jArr3[i4] = ~jArr3[i4];
                }
                long[] jArr4 = this.f2131g;
                jArr4[i5] = j3 ^ jArr4[i5];
            }
            i();
            h();
        }
    }

    public void a(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (z) {
                b(i2, i3);
            } else {
                c(i2, i3);
            }
        }
    }

    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                b(i2);
            } else {
                c(i2);
            }
        }
    }

    public boolean a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            for (int min = Math.min(this.f2132h, cVar.f2132h) - 1; min >= 0; min--) {
                if ((this.f2131g[min] & cVar.f2131g[min]) != 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.f2132h;
            if (i2 == 0) {
                return new byte[0];
            }
            int i3 = i2 - 1;
            int i4 = i3 * 8;
            for (long j2 = this.f2131g[i3]; j2 != 0; j2 >>>= 8) {
                i4++;
            }
            byte[] bArr = new byte[i4];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            for (int i5 = 0; i5 < i3; i5++) {
                order.putLong(this.f2131g[i5]);
            }
            for (long j3 = this.f2131g[i3]; j3 != 0; j3 >>>= 8) {
                order.put((byte) (255 & j3));
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
            }
            int i3 = i(i2);
            l(i3);
            long[] jArr = this.f2131g;
            jArr[i3] = jArr[i3] | (1 << i2);
            h();
        }
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            e(i2, i3);
            if (i2 == i3) {
                return;
            }
            int i4 = i(i2);
            int i5 = i(i3 - 1);
            l(i5);
            long j2 = (-1) << i2;
            long j3 = (-1) >>> (-i3);
            if (i4 == i5) {
                long[] jArr = this.f2131g;
                jArr[i4] = (j3 & j2) | jArr[i4];
            } else {
                long[] jArr2 = this.f2131g;
                jArr2[i4] = j2 | jArr2[i4];
                while (true) {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                    this.f2131g[i4] = -1;
                }
                long[] jArr3 = this.f2131g;
                jArr3[i5] = j3 | jArr3[i5];
            }
            h();
        }
    }

    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || this == cVar) {
            return;
        }
        while (true) {
            int i2 = this.f2132h;
            if (i2 <= cVar.f2132h) {
                break;
            }
            long[] jArr = this.f2131g;
            int i3 = i2 - 1;
            this.f2132h = i3;
            jArr[i3] = 0;
        }
        for (int i4 = 0; i4 < this.f2132h; i4++) {
            long[] jArr2 = this.f2131g;
            jArr2[i4] = jArr2[i4] & cVar.f2131g[i4];
        }
        i();
        h();
    }

    public long[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Arrays.copyOf(this.f2131g, this.f2132h) : (long[]) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048586, this) != null) {
            return;
        }
        while (true) {
            int i2 = this.f2132h;
            if (i2 <= 0) {
                return;
            }
            long[] jArr = this.f2131g;
            int i3 = i2 - 1;
            this.f2132h = i3;
            jArr[i3] = 0;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
            }
            int i3 = i(i2);
            if (i3 >= this.f2132h) {
                return;
            }
            long[] jArr = this.f2131g;
            jArr[i3] = jArr[i3] & (~(1 << i2));
            i();
            h();
        }
    }

    public void c(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            e(i2, i3);
            if (i2 != i3 && (i4 = i(i2)) < this.f2132h) {
                int i5 = i(i3 - 1);
                if (i5 >= this.f2132h) {
                    i3 = d();
                    i5 = this.f2132h - 1;
                }
                long j2 = (-1) << i2;
                long j3 = (-1) >>> (-i3);
                if (i4 == i5) {
                    long[] jArr = this.f2131g;
                    jArr[i4] = (~(j3 & j2)) & jArr[i4];
                } else {
                    long[] jArr2 = this.f2131g;
                    jArr2[i4] = (~j2) & jArr2[i4];
                    while (true) {
                        i4++;
                        if (i4 >= i5) {
                            break;
                        }
                        this.f2131g[i4] = 0;
                    }
                    long[] jArr3 = this.f2131g;
                    jArr3[i5] = (~j3) & jArr3[i5];
                }
                i();
                h();
            }
        }
    }

    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) || this == cVar) {
            return;
        }
        int min = Math.min(this.f2132h, cVar.f2132h);
        int i2 = this.f2132h;
        int i3 = cVar.f2132h;
        if (i2 < i3) {
            k(i3);
            this.f2132h = cVar.f2132h;
        }
        for (int i4 = 0; i4 < min; i4++) {
            long[] jArr = this.f2131g;
            jArr[i4] = jArr[i4] | cVar.f2131g[i4];
        }
        if (min < cVar.f2132h) {
            System.arraycopy(cVar.f2131g, min, this.f2131g, min, this.f2132h - min);
        }
        h();
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!this.f2133i) {
                j();
            }
            try {
                c cVar = (c) super.clone();
                cVar.f2131g = (long[]) this.f2131g.clone();
                cVar.h();
                return cVar;
            } catch (CloneNotSupportedException unused) {
                throw new InternalError();
            }
        }
        return invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.f2132h;
            if (i2 == 0) {
                return 0;
            }
            return ((i2 - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.f2131g[i2 - 1]));
        }
        return invokeV.intValue;
    }

    public c d(int i2, int i3) {
        InterceptResult invokeII;
        int i4;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i2, i3)) == null) {
            e(i2, i3);
            h();
            int d2 = d();
            int i5 = 0;
            if (d2 <= i2 || i2 == i3) {
                return new c(0);
            }
            if (i3 > d2) {
                i3 = d2;
            }
            int i6 = i3 - i2;
            c cVar = new c(i6);
            int i7 = i(i6 - 1) + 1;
            int i8 = i(i2);
            int i9 = i2 & 63;
            boolean z = i9 == 0;
            while (true) {
                i4 = i7 - 1;
                if (i5 >= i4) {
                    break;
                }
                long[] jArr = cVar.f2131g;
                long[] jArr2 = this.f2131g;
                jArr[i5] = z ? jArr2[i8] : (jArr2[i8] >>> i2) | (jArr2[i8 + 1] << (-i2));
                i5++;
                i8++;
            }
            long j3 = (-1) >>> (-i3);
            long[] jArr3 = cVar.f2131g;
            if (((i3 - 1) & 63) < i9) {
                long[] jArr4 = this.f2131g;
                j2 = ((jArr4[i8 + 1] & j3) << (-i2)) | (jArr4[i8] >>> i2);
            } else {
                j2 = (this.f2131g[i8] & j3) >>> i2;
            }
            jArr3[i4] = j2;
            cVar.f2132h = i7;
            cVar.i();
            cVar.h();
            return cVar;
        }
        return (c) invokeII.objValue;
    }

    public void d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            int min = Math.min(this.f2132h, cVar.f2132h);
            int i2 = this.f2132h;
            int i3 = cVar.f2132h;
            if (i2 < i3) {
                k(i3);
                this.f2132h = cVar.f2132h;
            }
            for (int i4 = 0; i4 < min; i4++) {
                long[] jArr = this.f2131g;
                jArr[i4] = jArr[i4] ^ cVar.f2131g[i4];
            }
            int i5 = cVar.f2132h;
            if (min < i5) {
                System.arraycopy(cVar.f2131g, min, this.f2131g, min, i5 - min);
            }
            i();
            h();
        }
    }

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (i2 >= 0) {
                h();
                int i3 = i(i2);
                return i3 < this.f2132h && (this.f2131g[i3] & (1 << i2)) != 0;
            }
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
        }
        return invokeI.booleanValue;
    }

    public int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
            }
            h();
            int i3 = i(i2);
            if (i3 >= this.f2132h) {
                return -1;
            }
            long j2 = this.f2131g[i3] & ((-1) << i2);
            while (j2 == 0) {
                i3++;
                if (i3 == this.f2132h) {
                    return -1;
                }
                j2 = this.f2131g[i3];
            }
            return (i3 * 64) + Long.numberOfTrailingZeros(j2);
        }
        return invokeI.intValue;
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) {
            for (int min = Math.min(this.f2132h, cVar.f2132h) - 1; min >= 0; min--) {
                long[] jArr = this.f2131g;
                jArr[min] = jArr[min] & (~cVar.f2131g[min]);
            }
            i();
            h();
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f2132h == 0 : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (obj instanceof c) {
                if (this == obj) {
                    return true;
                }
                c cVar = (c) obj;
                h();
                cVar.h();
                if (this.f2132h != cVar.f2132h) {
                    return false;
                }
                for (int i2 = 0; i2 < this.f2132h; i2++) {
                    if (this.f2131g[i2] != cVar.f2131g[i2]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f2132h; i3++) {
                i2 += Long.bitCount(this.f2131g[i3]);
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
            }
            h();
            int i3 = i(i2);
            if (i3 >= this.f2132h) {
                return i2;
            }
            long j2 = (~this.f2131g[i3]) & ((-1) << i2);
            while (j2 == 0) {
                i3++;
                int i4 = this.f2132h;
                if (i3 == i4) {
                    return i4 * 64;
                }
                j2 = ~this.f2131g[i3];
            }
            return (i3 * 64) + Long.numberOfTrailingZeros(j2);
        }
        return invokeI.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f2131g.length * 64 : invokeV.intValue;
    }

    public int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            if (i2 < 0) {
                if (i2 == -1) {
                    return -1;
                }
                throw new IndexOutOfBoundsException("fromIndex < -1: " + i2);
            }
            h();
            int i3 = i(i2);
            if (i3 >= this.f2132h) {
                return d() - 1;
            }
            long j2 = this.f2131g[i3] & ((-1) >>> (-(i2 + 1)));
            while (j2 == 0) {
                int i4 = i3 - 1;
                if (i3 == 0) {
                    return -1;
                }
                j2 = this.f2131g[i4];
                i3 = i4;
            }
            return (((i3 + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
        }
        return invokeI.intValue;
    }

    public int h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            if (i2 < 0) {
                if (i2 == -1) {
                    return -1;
                }
                throw new IndexOutOfBoundsException("fromIndex < -1: " + i2);
            }
            h();
            int i3 = i(i2);
            if (i3 >= this.f2132h) {
                return i2;
            }
            long j2 = (~this.f2131g[i3]) & ((-1) >>> (-(i2 + 1)));
            while (j2 == 0) {
                int i4 = i3 - 1;
                if (i3 == 0) {
                    return -1;
                }
                j2 = ~this.f2131g[i4];
                i3 = i4;
            }
            return (((i3 + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
        }
        return invokeI.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048604, this)) != null) {
            return invokeV.intValue;
        }
        int i2 = this.f2132h;
        long j2 = 1234;
        while (true) {
            i2--;
            if (i2 < 0) {
                return (int) ((j2 >> 32) ^ j2);
            }
            j2 ^= this.f2131g[i2] * (i2 + 1);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            h();
            int i2 = this.f2132h;
            StringBuilder sb = new StringBuilder(((i2 > 128 ? f() : i2 * 64) * 6) + 2);
            sb.append('{');
            int e2 = e(0);
            if (e2 != -1) {
                sb.append(e2);
                while (true) {
                    e2 = e(e2 + 1);
                    if (e2 < 0) {
                        break;
                    }
                    int f2 = f(e2);
                    do {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        sb.append(e2);
                        e2++;
                    } while (e2 < f2);
                }
            }
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
