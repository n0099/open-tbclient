package com.baidu.helios.common.cc;

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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class a implements Cloneable, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final /* synthetic */ boolean a;
    public static final int b = 6;
    public static final int c = 64;
    public static final int d = 63;
    public static final long e = -1;
    public static final ObjectStreamField[] f;
    public static final long j = 7997698588986878753L;
    public transient /* synthetic */ FieldHolder $fh;
    public long[] g;
    public transient int h;
    public transient boolean i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1463593192, "Lcom/baidu/helios/common/cc/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1463593192, "Lcom/baidu/helios/common/cc/a;");
                return;
            }
        }
        a = !a.class.desiredAssertionStatus();
        f = new ObjectStreamField[]{new ObjectStreamField("bits", long[].class)};
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = 0;
        this.i = false;
        j(64);
        this.i = false;
    }

    public a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = 0;
        this.i = false;
        if (i >= 0) {
            j(i);
            this.i = true;
            return;
        }
        throw new NegativeArraySizeException("nbits < 0: " + i);
    }

    public a(long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.h = 0;
        this.i = false;
        this.g = jArr;
        this.h = jArr.length;
        h();
    }

    public static a a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer)) == null) {
            ByteBuffer order = byteBuffer.slice().order(ByteOrder.LITTLE_ENDIAN);
            int remaining = order.remaining();
            while (remaining > 0 && order.get(remaining - 1) == 0) {
                remaining--;
            }
            long[] jArr = new long[(remaining + 7) / 8];
            order.limit(remaining);
            int i = 0;
            while (order.remaining() >= 8) {
                jArr[i] = order.getLong();
                i++;
            }
            int remaining2 = order.remaining();
            for (int i2 = 0; i2 < remaining2; i2++) {
                jArr[i] = jArr[i] | ((order.get() & 255) << (i2 * 8));
            }
            return new a(jArr);
        }
        return (a) invokeL.objValue;
    }

    public static a a(LongBuffer longBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, longBuffer)) == null) {
            LongBuffer slice = longBuffer.slice();
            int remaining = slice.remaining();
            while (remaining > 0 && slice.get(remaining - 1) == 0) {
                remaining--;
            }
            long[] jArr = new long[remaining];
            slice.get(jArr);
            return new a(jArr);
        }
        return (a) invokeL.objValue;
    }

    public static a a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) ? a(ByteBuffer.wrap(bArr)) : (a) invokeL.objValue;
    }

    public static a a(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jArr)) == null) {
            int length = jArr.length;
            while (length > 0 && jArr[length - 1] == 0) {
                length--;
            }
            return new a(Arrays.copyOf(jArr, length));
        }
        return (a) invokeL.objValue;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, objectInputStream) == null) {
            long[] jArr = (long[]) objectInputStream.readFields().get("bits", (Object) null);
            this.g = jArr;
            this.h = jArr.length;
            i();
            long[] jArr2 = this.g;
            boolean z = true;
            this.i = (jArr2.length <= 0 || jArr2[jArr2.length - 1] != 0) ? false : false;
            h();
        }
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, objectOutputStream) == null) {
            h();
            if (!this.i) {
                j();
            }
            objectOutputStream.putFields().put("bits", this.g);
            objectOutputStream.writeFields();
        }
    }

    public static void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65546, null, i, i2) == null) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
            } else if (i2 < 0) {
                throw new IndexOutOfBoundsException("toIndex < 0: " + i2);
            } else if (i <= i2) {
            } else {
                throw new IndexOutOfBoundsException("fromIndex: " + i + " > toIndex: " + i2);
            }
        }
    }

    private void h() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (!a && (i2 = this.h) != 0 && this.g[i2 - 1] == 0) {
                throw new AssertionError();
            }
            if (!a && ((i = this.h) < 0 || i > this.g.length)) {
                throw new AssertionError();
            }
            if (a) {
                return;
            }
            int i3 = this.h;
            long[] jArr = this.g;
            if (i3 != jArr.length && jArr[i3] != 0) {
                throw new AssertionError();
            }
        }
    }

    public static int i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) ? i >> 6 : invokeI.intValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            int i = this.h - 1;
            while (i >= 0 && this.g[i] == 0) {
                i--;
            }
            this.h = i + 1;
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            int i = this.h;
            long[] jArr = this.g;
            if (i != jArr.length) {
                this.g = Arrays.copyOf(jArr, i);
                h();
            }
        }
    }

    private void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, this, i) == null) {
            this.g = new long[i(i - 1) + 1];
        }
    }

    private void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i) == null) {
            long[] jArr = this.g;
            if (jArr.length < i) {
                this.g = Arrays.copyOf(this.g, Math.max(jArr.length * 2, i));
                this.i = false;
            }
        }
    }

    private void l(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65553, this, i) == null) || this.h >= (i2 = i + 1)) {
            return;
        }
        k(i2);
        this.h = i2;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
            }
            int i2 = i(i);
            l(i2);
            long[] jArr = this.g;
            jArr[i2] = jArr[i2] ^ (1 << i);
            i();
            h();
        }
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            e(i, i2);
            if (i == i2) {
                return;
            }
            int i3 = i(i);
            int i4 = i(i2 - 1);
            l(i4);
            long j2 = (-1) << i;
            long j3 = (-1) >>> (-i2);
            if (i3 == i4) {
                long[] jArr = this.g;
                jArr[i3] = (j3 & j2) ^ jArr[i3];
            } else {
                long[] jArr2 = this.g;
                jArr2[i3] = jArr2[i3] ^ j2;
                while (true) {
                    i3++;
                    if (i3 >= i4) {
                        break;
                    }
                    long[] jArr3 = this.g;
                    jArr3[i3] = ~jArr3[i3];
                }
                long[] jArr4 = this.g;
                jArr4[i4] = j3 ^ jArr4[i4];
            }
            i();
            h();
        }
    }

    public void a(int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                b(i, i2);
            } else {
                c(i, i2);
            }
        }
    }

    public void a(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                b(i);
            } else {
                c(i);
            }
        }
    }

    public boolean a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            for (int min = Math.min(this.h, aVar.h) - 1; min >= 0; min--) {
                if ((this.g[min] & aVar.g[min]) != 0) {
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
            int i = this.h;
            if (i == 0) {
                return new byte[0];
            }
            int i2 = i - 1;
            int i3 = i2 * 8;
            for (long j2 = this.g[i2]; j2 != 0; j2 >>>= 8) {
                i3++;
            }
            byte[] bArr = new byte[i3];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            for (int i4 = 0; i4 < i2; i4++) {
                order.putLong(this.g[i4]);
            }
            for (long j3 = this.g[i2]; j3 != 0; j3 >>>= 8) {
                order.put((byte) (255 & j3));
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
            }
            int i2 = i(i);
            l(i2);
            long[] jArr = this.g;
            jArr[i2] = jArr[i2] | (1 << i);
            h();
        }
    }

    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            e(i, i2);
            if (i == i2) {
                return;
            }
            int i3 = i(i);
            int i4 = i(i2 - 1);
            l(i4);
            long j2 = (-1) << i;
            long j3 = (-1) >>> (-i2);
            if (i3 == i4) {
                long[] jArr = this.g;
                jArr[i3] = (j3 & j2) | jArr[i3];
            } else {
                long[] jArr2 = this.g;
                jArr2[i3] = j2 | jArr2[i3];
                while (true) {
                    i3++;
                    if (i3 >= i4) {
                        break;
                    }
                    this.g[i3] = -1;
                }
                long[] jArr3 = this.g;
                jArr3[i4] = j3 | jArr3[i4];
            }
            h();
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || this == aVar) {
            return;
        }
        while (true) {
            int i = this.h;
            if (i <= aVar.h) {
                break;
            }
            long[] jArr = this.g;
            int i2 = i - 1;
            this.h = i2;
            jArr[i2] = 0;
        }
        for (int i3 = 0; i3 < this.h; i3++) {
            long[] jArr2 = this.g;
            jArr2[i3] = jArr2[i3] & aVar.g[i3];
        }
        i();
        h();
    }

    public long[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Arrays.copyOf(this.g, this.h) : (long[]) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048586, this) != null) {
            return;
        }
        while (true) {
            int i = this.h;
            if (i <= 0) {
                return;
            }
            long[] jArr = this.g;
            int i2 = i - 1;
            this.h = i2;
            jArr[i2] = 0;
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
            }
            int i2 = i(i);
            if (i2 >= this.h) {
                return;
            }
            long[] jArr = this.g;
            jArr[i2] = jArr[i2] & (~(1 << i));
            i();
            h();
        }
    }

    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            e(i, i2);
            if (i != i2 && (i3 = i(i)) < this.h) {
                int i4 = i(i2 - 1);
                if (i4 >= this.h) {
                    i2 = d();
                    i4 = this.h - 1;
                }
                long j2 = (-1) << i;
                long j3 = (-1) >>> (-i2);
                if (i3 == i4) {
                    long[] jArr = this.g;
                    jArr[i3] = (~(j3 & j2)) & jArr[i3];
                } else {
                    long[] jArr2 = this.g;
                    jArr2[i3] = (~j2) & jArr2[i3];
                    while (true) {
                        i3++;
                        if (i3 >= i4) {
                            break;
                        }
                        this.g[i3] = 0;
                    }
                    long[] jArr3 = this.g;
                    jArr3[i4] = (~j3) & jArr3[i4];
                }
                i();
                h();
            }
        }
    }

    public void c(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || this == aVar) {
            return;
        }
        int min = Math.min(this.h, aVar.h);
        int i = this.h;
        int i2 = aVar.h;
        if (i < i2) {
            k(i2);
            this.h = aVar.h;
        }
        for (int i3 = 0; i3 < min; i3++) {
            long[] jArr = this.g;
            jArr[i3] = jArr[i3] | aVar.g[i3];
        }
        if (min < aVar.h) {
            System.arraycopy(aVar.g, min, this.g, min, this.h - min);
        }
        h();
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!this.i) {
                j();
            }
            try {
                a aVar = (a) super.clone();
                aVar.g = (long[]) this.g.clone();
                aVar.h();
                return aVar;
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
            int i = this.h;
            if (i == 0) {
                return 0;
            }
            int i2 = i - 1;
            return (i2 * 64) + (64 - Long.numberOfLeadingZeros(this.g[i2]));
        }
        return invokeV.intValue;
    }

    public a d(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i, i2)) == null) {
            e(i, i2);
            h();
            int d2 = d();
            int i4 = 0;
            if (d2 <= i || i == i2) {
                return new a(0);
            }
            if (i2 > d2) {
                i2 = d2;
            }
            int i5 = i2 - i;
            a aVar = new a(i5);
            int i6 = i(i5 - 1) + 1;
            int i7 = i(i);
            int i8 = i & 63;
            boolean z = i8 == 0;
            while (true) {
                i3 = i6 - 1;
                if (i4 >= i3) {
                    break;
                }
                long[] jArr = aVar.g;
                long[] jArr2 = this.g;
                jArr[i4] = z ? jArr2[i7] : (jArr2[i7] >>> i) | (jArr2[i7 + 1] << (-i));
                i4++;
                i7++;
            }
            long j3 = (-1) >>> (-i2);
            long[] jArr3 = aVar.g;
            if (((i2 - 1) & 63) < i8) {
                long[] jArr4 = this.g;
                j2 = ((jArr4[i7 + 1] & j3) << (-i)) | (jArr4[i7] >>> i);
            } else {
                j2 = (this.g[i7] & j3) >>> i;
            }
            jArr3[i3] = j2;
            aVar.h = i6;
            aVar.i();
            aVar.h();
            return aVar;
        }
        return (a) invokeII.objValue;
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            int min = Math.min(this.h, aVar.h);
            int i = this.h;
            int i2 = aVar.h;
            if (i < i2) {
                k(i2);
                this.h = aVar.h;
            }
            for (int i3 = 0; i3 < min; i3++) {
                long[] jArr = this.g;
                jArr[i3] = jArr[i3] ^ aVar.g[i3];
            }
            int i4 = aVar.h;
            if (min < i4) {
                System.arraycopy(aVar.g, min, this.g, min, i4 - min);
            }
            i();
            h();
        }
    }

    public boolean d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (i >= 0) {
                h();
                int i2 = i(i);
                return i2 < this.h && (this.g[i2] & (1 << i)) != 0;
            }
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        return invokeI.booleanValue;
    }

    public int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
            }
            h();
            int i2 = i(i);
            if (i2 >= this.h) {
                return -1;
            }
            long j2 = this.g[i2] & ((-1) << i);
            while (j2 == 0) {
                i2++;
                if (i2 == this.h) {
                    return -1;
                }
                j2 = this.g[i2];
            }
            return (i2 * 64) + Long.numberOfTrailingZeros(j2);
        }
        return invokeI.intValue;
    }

    public void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            for (int min = Math.min(this.h, aVar.h) - 1; min >= 0; min--) {
                long[] jArr = this.g;
                jArr[min] = jArr[min] & (~aVar.g[min]);
            }
            i();
            h();
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.h == 0 : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (obj instanceof a) {
                if (this == obj) {
                    return true;
                }
                a aVar = (a) obj;
                h();
                aVar.h();
                if (this.h != aVar.h) {
                    return false;
                }
                for (int i = 0; i < this.h; i++) {
                    if (this.g[i] != aVar.g[i]) {
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
            int i = 0;
            for (int i2 = 0; i2 < this.h; i2++) {
                i += Long.bitCount(this.g[i2]);
            }
            return i;
        }
        return invokeV.intValue;
    }

    public int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
            }
            h();
            int i2 = i(i);
            if (i2 >= this.h) {
                return i;
            }
            long j2 = (~this.g[i2]) & ((-1) << i);
            while (j2 == 0) {
                i2++;
                int i3 = this.h;
                if (i2 == i3) {
                    return i3 * 64;
                }
                j2 = ~this.g[i2];
            }
            return (i2 * 64) + Long.numberOfTrailingZeros(j2);
        }
        return invokeI.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.g.length * 64 : invokeV.intValue;
    }

    public int g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            if (i < 0) {
                if (i == -1) {
                    return -1;
                }
                throw new IndexOutOfBoundsException("fromIndex < -1: " + i);
            }
            h();
            int i2 = i(i);
            if (i2 >= this.h) {
                return d() - 1;
            }
            long j2 = this.g[i2] & ((-1) >>> (-(i + 1)));
            while (j2 == 0) {
                int i3 = i2 - 1;
                if (i2 == 0) {
                    return -1;
                }
                j2 = this.g[i3];
                i2 = i3;
            }
            return (((i2 + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
        }
        return invokeI.intValue;
    }

    public int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            if (i < 0) {
                if (i == -1) {
                    return -1;
                }
                throw new IndexOutOfBoundsException("fromIndex < -1: " + i);
            }
            h();
            int i2 = i(i);
            if (i2 >= this.h) {
                return i;
            }
            long j2 = (~this.g[i2]) & ((-1) >>> (-(i + 1)));
            while (j2 == 0) {
                int i3 = i2 - 1;
                if (i2 == 0) {
                    return -1;
                }
                j2 = ~this.g[i3];
                i2 = i3;
            }
            return (((i2 + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
        }
        return invokeI.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048604, this)) != null) {
            return invokeV.intValue;
        }
        int i = this.h;
        long j2 = 1234;
        while (true) {
            i--;
            if (i < 0) {
                return (int) ((j2 >> 32) ^ j2);
            }
            j2 ^= this.g[i] * (i + 1);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            h();
            int i = this.h;
            StringBuilder sb = new StringBuilder(((i > 128 ? f() : i * 64) * 6) + 2);
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
