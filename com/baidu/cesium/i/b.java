package com.baidu.cesium.i;

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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes7.dex */
public class b implements Cloneable, Serializable {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final int f37682d = 6;

    /* renamed from: e  reason: collision with root package name */
    public static final int f37683e = 64;

    /* renamed from: f  reason: collision with root package name */
    public static final int f37684f = 63;

    /* renamed from: g  reason: collision with root package name */
    public static final long f37685g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static final ObjectStreamField[] f37686h;

    /* renamed from: i  reason: collision with root package name */
    public static final long f37687i = 7997698588986878753L;
    public static final /* synthetic */ boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long[] f37688a;

    /* renamed from: b  reason: collision with root package name */
    public transient int f37689b;

    /* renamed from: c  reason: collision with root package name */
    public transient boolean f37690c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-699709552, "Lcom/baidu/cesium/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-699709552, "Lcom/baidu/cesium/i/b;");
                return;
            }
        }
        j = !b.class.desiredAssertionStatus();
        f37686h = new ObjectStreamField[]{new ObjectStreamField("bits", long[].class)};
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
        this.f37689b = 0;
        this.f37690c = false;
        f(64);
        this.f37690c = false;
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
        this.f37689b = 0;
        this.f37690c = false;
        if (i2 >= 0) {
            f(i2);
            this.f37690c = true;
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
        this.f37689b = 0;
        this.f37690c = false;
        this.f37688a = jArr;
        this.f37689b = jArr.length;
        b();
    }

    public static b a(ByteBuffer byteBuffer) {
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
            int i2 = 0;
            while (order.remaining() >= 8) {
                jArr[i2] = order.getLong();
                i2++;
            }
            int remaining2 = order.remaining();
            for (int i3 = 0; i3 < remaining2; i3++) {
                jArr[i2] = jArr[i2] | ((order.get() & 255) << (i3 * 8));
            }
            return new b(jArr);
        }
        return (b) invokeL.objValue;
    }

    public static b a(LongBuffer longBuffer) {
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
            return new b(jArr);
        }
        return (b) invokeL.objValue;
    }

    public static b a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bArr)) == null) ? a(ByteBuffer.wrap(bArr)) : (b) invokeL.objValue;
    }

    public static b a(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jArr)) == null) {
            int length = jArr.length;
            while (length > 0 && jArr[length - 1] == 0) {
                length--;
            }
            return new b(Arrays.copyOf(jArr, length));
        }
        return (b) invokeL.objValue;
    }

    public static void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65544, null, i2, i3) == null) {
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

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, objectInputStream) == null) {
            long[] jArr = (long[]) objectInputStream.readFields().get("bits", (Object) null);
            this.f37688a = jArr;
            this.f37689b = jArr.length;
            f();
            long[] jArr2 = this.f37688a;
            boolean z = true;
            this.f37690c = (jArr2.length <= 0 || jArr2[jArr2.length - 1] != 0) ? false : false;
            b();
        }
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, objectOutputStream) == null) {
            b();
            if (!this.f37690c) {
                j();
            }
            objectOutputStream.putFields().put("bits", this.f37688a);
            objectOutputStream.writeFields();
        }
    }

    private void b() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (!j && (i3 = this.f37689b) != 0 && this.f37688a[i3 - 1] == 0) {
                throw new AssertionError();
            }
            if (!j && ((i2 = this.f37689b) < 0 || i2 > this.f37688a.length)) {
                throw new AssertionError();
            }
            if (j) {
                return;
            }
            int i4 = this.f37689b;
            long[] jArr = this.f37688a;
            if (i4 != jArr.length && jArr[i4] != 0) {
                throw new AssertionError();
            }
        }
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i2) == null) {
            long[] jArr = this.f37688a;
            if (jArr.length < i2) {
                this.f37688a = Arrays.copyOf(this.f37688a, Math.max(jArr.length * 2, i2));
                this.f37690c = false;
            }
        }
    }

    private void c(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65549, this, i2) == null) || this.f37689b >= (i3 = i2 + 1)) {
            return;
        }
        b(i3);
        this.f37689b = i3;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            int i2 = this.f37689b - 1;
            while (i2 >= 0 && this.f37688a[i2] == 0) {
                i2--;
            }
            this.f37689b = i2 + 1;
        }
    }

    private void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, this, i2) == null) {
            this.f37688a = new long[l(i2 - 1) + 1];
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            int i2 = this.f37689b;
            long[] jArr = this.f37688a;
            if (i2 != jArr.length) {
                this.f37688a = Arrays.copyOf(jArr, i2);
                b();
            }
        }
    }

    public static int l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i2)) == null) ? i2 >> 6 : invokeI.intValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f37689b; i3++) {
                i2 += Long.bitCount(this.f37688a[i3]);
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
            }
            int l = l(i2);
            if (l >= this.f37689b) {
                return;
            }
            long[] jArr = this.f37688a;
            jArr[l] = jArr[l] & (~(1 << i2));
            f();
            b();
        }
    }

    public void a(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (z) {
                e(i2, i3);
            } else {
                b(i2, i3);
            }
        }
    }

    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                k(i2);
            } else {
                a(i2);
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || this == bVar) {
            return;
        }
        while (true) {
            int i2 = this.f37689b;
            if (i2 <= bVar.f37689b) {
                break;
            }
            long[] jArr = this.f37688a;
            int i3 = i2 - 1;
            this.f37689b = i3;
            jArr[i3] = 0;
        }
        for (int i4 = 0; i4 < this.f37689b; i4++) {
            long[] jArr2 = this.f37688a;
            jArr2[i4] = jArr2[i4] & bVar.f37688a[i4];
        }
        f();
        b();
    }

    public void b(int i2, int i3) {
        int l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            a(i2, i3);
            if (i2 != i3 && (l = l(i2)) < this.f37689b) {
                int l2 = l(i3 - 1);
                if (l2 >= this.f37689b) {
                    i3 = e();
                    l2 = this.f37689b - 1;
                }
                long j2 = (-1) << i2;
                long j3 = (-1) >>> (-i3);
                if (l == l2) {
                    long[] jArr = this.f37688a;
                    jArr[l] = (~(j3 & j2)) & jArr[l];
                } else {
                    long[] jArr2 = this.f37688a;
                    jArr2[l] = (~j2) & jArr2[l];
                    while (true) {
                        l++;
                        if (l >= l2) {
                            break;
                        }
                        this.f37688a[l] = 0;
                    }
                    long[] jArr3 = this.f37688a;
                    jArr3[l2] = (~j3) & jArr3[l2];
                }
                f();
                b();
            }
        }
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            for (int min = Math.min(this.f37689b, bVar.f37689b) - 1; min >= 0; min--) {
                long[] jArr = this.f37688a;
                jArr[min] = jArr[min] & (~bVar.f37688a[min]);
            }
            f();
            b();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
            return;
        }
        while (true) {
            int i2 = this.f37689b;
            if (i2 <= 0) {
                return;
            }
            long[] jArr = this.f37688a;
            int i3 = i2 - 1;
            this.f37689b = i3;
            jArr[i3] = 0;
        }
    }

    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            a(i2, i3);
            if (i2 == i3) {
                return;
            }
            int l = l(i2);
            int l2 = l(i3 - 1);
            c(l2);
            long j2 = (-1) << i2;
            long j3 = (-1) >>> (-i3);
            if (l == l2) {
                long[] jArr = this.f37688a;
                jArr[l] = (j3 & j2) ^ jArr[l];
            } else {
                long[] jArr2 = this.f37688a;
                jArr2[l] = jArr2[l] ^ j2;
                while (true) {
                    l++;
                    if (l >= l2) {
                        break;
                    }
                    long[] jArr3 = this.f37688a;
                    jArr3[l] = ~jArr3[l];
                }
                long[] jArr4 = this.f37688a;
                jArr4[l2] = j3 ^ jArr4[l2];
            }
            f();
            b();
        }
    }

    public boolean c(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            for (int min = Math.min(this.f37689b, bVar.f37689b) - 1; min >= 0; min--) {
                if ((this.f37688a[min] & bVar.f37688a[min]) != 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!this.f37690c) {
                j();
            }
            try {
                b bVar = (b) super.clone();
                bVar.f37688a = (long[]) this.f37688a.clone();
                bVar.b();
                return bVar;
            } catch (CloneNotSupportedException unused) {
                throw new InternalError();
            }
        }
        return invokeV.objValue;
    }

    public b d(int i2, int i3) {
        InterceptResult invokeII;
        int i4;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            a(i2, i3);
            b();
            int e2 = e();
            int i5 = 0;
            if (e2 <= i2 || i2 == i3) {
                return new b(0);
            }
            if (i3 > e2) {
                i3 = e2;
            }
            int i6 = i3 - i2;
            b bVar = new b(i6);
            int l = l(i6 - 1) + 1;
            int l2 = l(i2);
            int i7 = i2 & 63;
            boolean z = i7 == 0;
            while (true) {
                i4 = l - 1;
                if (i5 >= i4) {
                    break;
                }
                long[] jArr = bVar.f37688a;
                long[] jArr2 = this.f37688a;
                jArr[i5] = z ? jArr2[l2] : (jArr2[l2] >>> i2) | (jArr2[l2 + 1] << (-i2));
                i5++;
                l2++;
            }
            long j3 = (-1) >>> (-i3);
            long[] jArr3 = bVar.f37688a;
            if (((i3 - 1) & 63) < i7) {
                long[] jArr4 = this.f37688a;
                j2 = ((jArr4[l2 + 1] & j3) << (-i2)) | (jArr4[l2] >>> i2);
            } else {
                j2 = (this.f37688a[l2] & j3) >>> i2;
            }
            jArr3[i4] = j2;
            bVar.f37689b = l;
            bVar.f();
            bVar.b();
            return bVar;
        }
        return (b) invokeII.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
            }
            int l = l(i2);
            c(l);
            long[] jArr = this.f37688a;
            jArr[l] = jArr[l] ^ (1 << i2);
            f();
            b();
        }
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) || this == bVar) {
            return;
        }
        int min = Math.min(this.f37689b, bVar.f37689b);
        int i2 = this.f37689b;
        int i3 = bVar.f37689b;
        if (i2 < i3) {
            b(i3);
            this.f37689b = bVar.f37689b;
        }
        for (int i4 = 0; i4 < min; i4++) {
            long[] jArr = this.f37688a;
            jArr[i4] = jArr[i4] | bVar.f37688a[i4];
        }
        if (min < bVar.f37689b) {
            System.arraycopy(bVar.f37688a, min, this.f37688a, min, this.f37689b - min);
        }
        b();
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37689b == 0 : invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.f37689b;
            if (i2 == 0) {
                return 0;
            }
            int i3 = i2 - 1;
            return (i3 * 64) + (64 - Long.numberOfLeadingZeros(this.f37688a[i3]));
        }
        return invokeV.intValue;
    }

    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            a(i2, i3);
            if (i2 == i3) {
                return;
            }
            int l = l(i2);
            int l2 = l(i3 - 1);
            c(l2);
            long j2 = (-1) << i2;
            long j3 = (-1) >>> (-i3);
            if (l == l2) {
                long[] jArr = this.f37688a;
                jArr[l] = (j3 & j2) | jArr[l];
            } else {
                long[] jArr2 = this.f37688a;
                jArr2[l] = j2 | jArr2[l];
                while (true) {
                    l++;
                    if (l >= l2) {
                        break;
                    }
                    this.f37688a[l] = -1;
                }
                long[] jArr3 = this.f37688a;
                jArr3[l2] = j3 | jArr3[l2];
            }
            b();
        }
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            int min = Math.min(this.f37689b, bVar.f37689b);
            int i2 = this.f37689b;
            int i3 = bVar.f37689b;
            if (i2 < i3) {
                b(i3);
                this.f37689b = bVar.f37689b;
            }
            for (int i4 = 0; i4 < min; i4++) {
                long[] jArr = this.f37688a;
                jArr[i4] = jArr[i4] ^ bVar.f37688a[i4];
            }
            int i5 = bVar.f37689b;
            if (min < i5) {
                System.arraycopy(bVar.f37688a, min, this.f37688a, min, i5 - min);
            }
            f();
            b();
        }
    }

    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (i2 >= 0) {
                b();
                int l = l(i2);
                return l < this.f37689b && (this.f37688a[l] & (1 << i2)) != 0;
            }
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
        }
        return invokeI.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (obj instanceof b) {
                if (this == obj) {
                    return true;
                }
                b bVar = (b) obj;
                b();
                bVar.b();
                if (this.f37689b != bVar.f37689b) {
                    return false;
                }
                for (int i2 = 0; i2 < this.f37689b; i2++) {
                    if (this.f37688a[i2] != bVar.f37688a[i2]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f37688a.length * 64 : invokeV.intValue;
    }

    public int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
            }
            b();
            int l = l(i2);
            if (l >= this.f37689b) {
                return i2;
            }
            long j2 = (~this.f37688a[l]) & ((-1) << i2);
            while (j2 == 0) {
                l++;
                int i3 = this.f37689b;
                if (l == i3) {
                    return i3 * 64;
                }
                j2 = ~this.f37688a[l];
            }
            return (l * 64) + Long.numberOfTrailingZeros(j2);
        }
        return invokeI.intValue;
    }

    public int h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
            }
            b();
            int l = l(i2);
            if (l >= this.f37689b) {
                return -1;
            }
            long j2 = this.f37688a[l] & ((-1) << i2);
            while (j2 == 0) {
                l++;
                if (l == this.f37689b) {
                    return -1;
                }
                j2 = this.f37688a[l];
            }
            return (l * 64) + Long.numberOfTrailingZeros(j2);
        }
        return invokeI.intValue;
    }

    public byte[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int i2 = this.f37689b;
            if (i2 == 0) {
                return new byte[0];
            }
            int i3 = i2 - 1;
            int i4 = i3 * 8;
            for (long j2 = this.f37688a[i3]; j2 != 0; j2 >>>= 8) {
                i4++;
            }
            byte[] bArr = new byte[i4];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            for (int i5 = 0; i5 < i3; i5++) {
                order.putLong(this.f37688a[i5]);
            }
            for (long j3 = this.f37688a[i3]; j3 != 0; j3 >>>= 8) {
                order.put((byte) (255 & j3));
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048600, this)) != null) {
            return invokeV.intValue;
        }
        int i2 = this.f37689b;
        long j2 = 1234;
        while (true) {
            i2--;
            if (i2 < 0) {
                return (int) ((j2 >> 32) ^ j2);
            }
            j2 ^= this.f37688a[i2] * (i2 + 1);
        }
    }

    public int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            if (i2 < 0) {
                if (i2 == -1) {
                    return -1;
                }
                throw new IndexOutOfBoundsException("fromIndex < -1: " + i2);
            }
            b();
            int l = l(i2);
            if (l >= this.f37689b) {
                return i2;
            }
            long j2 = (~this.f37688a[l]) & ((-1) >>> (-(i2 + 1)));
            while (j2 == 0) {
                int i3 = l - 1;
                if (l == 0) {
                    return -1;
                }
                j2 = ~this.f37688a[i3];
                l = i3;
            }
            return (((l + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
        }
        return invokeI.intValue;
    }

    public long[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? Arrays.copyOf(this.f37688a, this.f37689b) : (long[]) invokeV.objValue;
    }

    public int j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            if (i2 < 0) {
                if (i2 == -1) {
                    return -1;
                }
                throw new IndexOutOfBoundsException("fromIndex < -1: " + i2);
            }
            b();
            int l = l(i2);
            if (l >= this.f37689b) {
                return e() - 1;
            }
            long j2 = this.f37688a[l] & ((-1) >>> (-(i2 + 1)));
            while (j2 == 0) {
                int i3 = l - 1;
                if (l == 0) {
                    return -1;
                }
                j2 = this.f37688a[i3];
                l = i3;
            }
            return (((l + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
        }
        return invokeI.intValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
            }
            int l = l(i2);
            c(l);
            long[] jArr = this.f37688a;
            jArr[l] = jArr[l] | (1 << i2);
            b();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            b();
            int i2 = this.f37689b;
            StringBuilder sb = new StringBuilder(((i2 > 128 ? a() : i2 * 64) * 6) + 2);
            sb.append(ExtendedMessageFormat.START_FE);
            int h2 = h(0);
            if (h2 != -1) {
                sb.append(h2);
                while (true) {
                    h2 = h(h2 + 1);
                    if (h2 < 0) {
                        break;
                    }
                    int g2 = g(h2);
                    do {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        sb.append(h2);
                        h2++;
                    } while (h2 < g2);
                }
            }
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
