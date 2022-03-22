package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
public final class a implements b, c, Cloneable, ByteChannel {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f28685c;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public long f28686b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-351173120, "Lcom/baidu/searchbox/v8engine/net/io/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-351173120, "Lcom/baidu/searchbox/v8engine/net/io/a;");
                return;
            }
        }
        f28685c = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};
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
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28686b == 0 : invokeV.booleanValue;
    }

    public byte b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long j = this.f28686b;
            if (j != 0) {
                e eVar = this.a;
                int i = eVar.f28691b;
                int i2 = eVar.f28692c;
                int i3 = i + 1;
                byte b2 = eVar.a[i];
                this.f28686b = j - 1;
                if (i3 == i2) {
                    this.a = eVar.b();
                    f.a(eVar);
                } else {
                    eVar.f28691b = i3;
                }
                return b2;
            }
            throw new IllegalStateException("size == 0");
        }
        return invokeV.byteValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            try {
                return a(this.f28686b, j.a);
            } catch (EOFException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public a clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048593, this)) != null) {
            return (a) invokeV.objValue;
        }
        a aVar = new a();
        if (this.f28686b == 0) {
            return aVar;
        }
        e a = this.a.a();
        aVar.a = a;
        a.f28696g = a;
        a.f28695f = a;
        e eVar = this.a;
        while (true) {
            eVar = eVar.f28695f;
            if (eVar != this.a) {
                aVar.a.f28696g.a(eVar.a());
            } else {
                aVar.f28686b = this.f28686b;
                return aVar;
            }
        }
    }

    public d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            long j = this.f28686b;
            if (j <= 2147483647L) {
                return d((int) j);
            }
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f28686b);
        }
        return (d) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                long j = this.f28686b;
                if (j != aVar.f28686b) {
                    return false;
                }
                long j2 = 0;
                if (j == 0) {
                    return true;
                }
                e eVar = this.a;
                e eVar2 = aVar.a;
                int i = eVar.f28691b;
                int i2 = eVar2.f28691b;
                while (j2 < this.f28686b) {
                    long min = Math.min(eVar.f28692c - i, eVar2.f28692c - i2);
                    int i3 = 0;
                    while (i3 < min) {
                        int i4 = i + 1;
                        int i5 = i2 + 1;
                        if (eVar.a[i] != eVar2.a[i2]) {
                            return false;
                        }
                        i3++;
                        i = i4;
                        i2 = i5;
                    }
                    if (i == eVar.f28692c) {
                        eVar = eVar.f28695f;
                        i = eVar.f28691b;
                    }
                    if (i2 == eVar2.f28692c) {
                        eVar2 = eVar2.f28695f;
                        i2 = eVar2.f28691b;
                    }
                    j2 += min;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.io.Flushable
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            e eVar = this.a;
            if (eVar == null) {
                return 0;
            }
            int i = 1;
            do {
                int i2 = eVar.f28692c;
                for (int i3 = eVar.f28691b; i3 < i2; i3++) {
                    i = (i * 31) + eVar.a[i3];
                }
                eVar = eVar.f28695f;
            } while (eVar != this.a);
            return i;
        }
        return invokeV.intValue;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, byteBuffer)) == null) {
            e eVar = this.a;
            if (eVar == null) {
                return -1;
            }
            int min = Math.min(byteBuffer.remaining(), eVar.f28692c - eVar.f28691b);
            byteBuffer.put(eVar.a, eVar.f28691b, min);
            int i = eVar.f28691b + min;
            eVar.f28691b = i;
            this.f28686b -= min;
            if (i == eVar.f28692c) {
                this.a = eVar.b();
                f.a(eVar);
            }
            return min;
        }
        return invokeL.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? e().toString() : (String) invokeV.objValue;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, byteBuffer)) == null) {
            if (byteBuffer != null) {
                int remaining = byteBuffer.remaining();
                int i = remaining;
                while (i > 0) {
                    e c2 = c(1);
                    int min = Math.min(i, 8192 - c2.f28692c);
                    byteBuffer.get(c2.a, c2.f28692c, min);
                    i -= min;
                    c2.f28692c += min;
                }
                this.f28686b += remaining;
                return remaining;
            }
            throw new IllegalArgumentException("source == null");
        }
        return invokeL.intValue;
    }

    public String a(long j, Charset charset) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048581, this, j, charset)) == null) {
            com.baidu.searchbox.v8engine.net.b.a(this.f28686b, 0L, j);
            if (charset != null) {
                if (j > 2147483647L) {
                    throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
                } else if (j == 0) {
                    return "";
                } else {
                    e eVar = this.a;
                    if (eVar.f28691b + j > eVar.f28692c) {
                        return new String(a(j), charset);
                    }
                    String str = new String(eVar.a, eVar.f28691b, (int) j, charset);
                    int i = (int) (eVar.f28691b + j);
                    eVar.f28691b = i;
                    this.f28686b -= j;
                    if (i == eVar.f28692c) {
                        this.a = eVar.b();
                        f.a(eVar);
                    }
                    return str;
                }
            }
            throw new IllegalArgumentException("charset == null");
        }
        return (String) invokeJL.objValue;
    }

    public e c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            if (i >= 1 && i <= 8192) {
                e eVar = this.a;
                if (eVar == null) {
                    e a = f.a();
                    this.a = a;
                    a.f28696g = a;
                    a.f28695f = a;
                    return a;
                }
                e eVar2 = eVar.f28696g;
                return (eVar2.f28692c + i > 8192 || !eVar2.f28694e) ? eVar2.a(f.a()) : eVar2;
            }
            throw new IllegalArgumentException();
        }
        return (e) invokeI.objValue;
    }

    public d d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (i == 0) {
                return d.f28687b;
            }
            return new g(this, i);
        }
        return (d) invokeI.objValue;
    }

    public a b(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048588, this, bArr, i, i2)) == null) {
            if (bArr != null) {
                long j = i2;
                com.baidu.searchbox.v8engine.net.b.a(bArr.length, i, j);
                int i3 = i2 + i;
                while (i < i3) {
                    e c2 = c(1);
                    int min = Math.min(i3 - i, 8192 - c2.f28692c);
                    System.arraycopy(bArr, i, c2.a, c2.f28692c, min);
                    i += min;
                    c2.f28692c += min;
                }
                this.f28686b += j;
                return this;
            }
            throw new IllegalArgumentException("source == null");
        }
        return (a) invokeLII.objValue;
    }

    public byte[] a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
            com.baidu.searchbox.v8engine.net.b.a(this.f28686b, 0L, j);
            if (j <= 2147483647L) {
                byte[] bArr = new byte[(int) j];
                a(bArr);
                return bArr;
            }
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        return (byte[]) invokeJ.objValue;
    }

    public void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bArr) == null) {
            int i = 0;
            while (i < bArr.length) {
                int a = a(bArr, i, bArr.length - i);
                if (a == -1) {
                    throw new EOFException();
                }
                i += a;
            }
        }
    }

    public a b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            e c2 = c(1);
            byte[] bArr = c2.a;
            int i2 = c2.f28692c;
            c2.f28692c = i2 + 1;
            bArr[i2] = (byte) i;
            this.f28686b++;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public int a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
            com.baidu.searchbox.v8engine.net.b.a(bArr.length, i, i2);
            e eVar = this.a;
            if (eVar == null) {
                return -1;
            }
            int min = Math.min(i2, eVar.f28692c - eVar.f28691b);
            System.arraycopy(eVar.a, eVar.f28691b, bArr, i, min);
            int i3 = eVar.f28691b + min;
            eVar.f28691b = i3;
            this.f28686b -= min;
            if (i3 == eVar.f28692c) {
                this.a = eVar.b();
                f.a(eVar);
            }
            return min;
        }
        return invokeLII.intValue;
    }

    public a b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            if (j == 0) {
                return b(48);
            }
            int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
            e c2 = c(numberOfTrailingZeros);
            byte[] bArr = c2.a;
            int i = c2.f28692c;
            for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
                bArr[i2] = f28685c[(int) (15 & j)];
                j >>>= 4;
            }
            c2.f28692c += numberOfTrailingZeros;
            this.f28686b += numberOfTrailingZeros;
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? a(str, 0, str.length()) : (a) invokeL.objValue;
    }

    public a a(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, str, i, i2)) == null) {
            if (str != null) {
                if (i < 0) {
                    throw new IllegalArgumentException("beginIndex < 0: " + i);
                } else if (i2 >= i) {
                    if (i2 > str.length()) {
                        throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                    }
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        if (charAt < 128) {
                            e c2 = c(1);
                            byte[] bArr = c2.a;
                            int i3 = c2.f28692c - i;
                            int min = Math.min(i2, 8192 - i3);
                            int i4 = i + 1;
                            bArr[i + i3] = (byte) charAt;
                            while (i4 < min) {
                                char charAt2 = str.charAt(i4);
                                if (charAt2 >= 128) {
                                    break;
                                }
                                bArr[i4 + i3] = (byte) charAt2;
                                i4++;
                            }
                            int i5 = c2.f28692c;
                            int i6 = (i3 + i4) - i5;
                            c2.f28692c = i5 + i6;
                            this.f28686b += i6;
                            i = i4;
                        } else {
                            if (charAt < 2048) {
                                b((charAt >> 6) | 192);
                                b((charAt & '?') | 128);
                            } else if (charAt >= 55296 && charAt <= 57343) {
                                int i7 = i + 1;
                                char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                                if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                    int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                    b((i8 >> 18) | 240);
                                    b(((i8 >> 12) & 63) | 128);
                                    b(((i8 >> 6) & 63) | 128);
                                    b((i8 & 63) | 128);
                                    i += 2;
                                } else {
                                    b(63);
                                    i = i7;
                                }
                            } else {
                                b((charAt >> '\f') | 224);
                                b(((charAt >> 6) & 63) | 128);
                                b((charAt & '?') | 128);
                            }
                            i++;
                        }
                    }
                    return this;
                } else {
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
                }
            }
            throw new IllegalArgumentException("string == null");
        }
        return (a) invokeLII.objValue;
    }

    public a a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 128) {
                b(i);
            } else if (i < 2048) {
                b((i >> 6) | 192);
                b((i & 63) | 128);
            } else if (i < 65536) {
                if (i >= 55296 && i <= 57343) {
                    b(63);
                } else {
                    b((i >> 12) | 224);
                    b(((i >> 6) & 63) | 128);
                    b((i & 63) | 128);
                }
            } else if (i <= 1114111) {
                b((i >> 18) | 240);
                b(((i >> 12) & 63) | 128);
                b(((i >> 6) & 63) | 128);
                b((i & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a a(String str, int i, int i2, Charset charset) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), charset})) == null) {
            if (str != null) {
                if (i < 0) {
                    throw new IllegalAccessError("beginIndex < 0: " + i);
                } else if (i2 >= i) {
                    if (i2 <= str.length()) {
                        if (charset != null) {
                            if (charset.equals(j.a)) {
                                return a(str, i, i2);
                            }
                            byte[] bytes = str.substring(i, i2).getBytes(charset);
                            return b(bytes, 0, bytes.length);
                        }
                        throw new IllegalArgumentException("charset == null");
                    }
                    throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                } else {
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
                }
            }
            throw new IllegalArgumentException("string == null");
        }
        return (a) invokeCommon.objValue;
    }
}
