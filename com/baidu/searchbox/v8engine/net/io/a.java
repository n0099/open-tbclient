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
/* loaded from: classes7.dex */
public final class a implements b, c, Cloneable, ByteChannel {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f43792c;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public e f43793a;

    /* renamed from: b  reason: collision with root package name */
    public long f43794b;

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
        f43792c = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f43794b == 0 : invokeV.booleanValue;
    }

    public byte b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long j = this.f43794b;
            if (j != 0) {
                e eVar = this.f43793a;
                int i2 = eVar.f43801b;
                int i3 = eVar.f43802c;
                int i4 = i2 + 1;
                byte b2 = eVar.f43800a[i2];
                this.f43794b = j - 1;
                if (i4 == i3) {
                    this.f43793a = eVar.b();
                    f.a(eVar);
                } else {
                    eVar.f43801b = i4;
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
                return a(this.f43794b, j.f43811a);
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
        if (this.f43794b == 0) {
            return aVar;
        }
        e a2 = this.f43793a.a();
        aVar.f43793a = a2;
        a2.f43806g = a2;
        a2.f43805f = a2;
        e eVar = this.f43793a;
        while (true) {
            eVar = eVar.f43805f;
            if (eVar != this.f43793a) {
                aVar.f43793a.f43806g.a(eVar.a());
            } else {
                aVar.f43794b = this.f43794b;
                return aVar;
            }
        }
    }

    public d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            long j = this.f43794b;
            if (j <= 2147483647L) {
                return d((int) j);
            }
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f43794b);
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
                long j = this.f43794b;
                if (j != aVar.f43794b) {
                    return false;
                }
                long j2 = 0;
                if (j == 0) {
                    return true;
                }
                e eVar = this.f43793a;
                e eVar2 = aVar.f43793a;
                int i2 = eVar.f43801b;
                int i3 = eVar2.f43801b;
                while (j2 < this.f43794b) {
                    long min = Math.min(eVar.f43802c - i2, eVar2.f43802c - i3);
                    int i4 = 0;
                    while (i4 < min) {
                        int i5 = i2 + 1;
                        int i6 = i3 + 1;
                        if (eVar.f43800a[i2] != eVar2.f43800a[i3]) {
                            return false;
                        }
                        i4++;
                        i2 = i5;
                        i3 = i6;
                    }
                    if (i2 == eVar.f43802c) {
                        eVar = eVar.f43805f;
                        i2 = eVar.f43801b;
                    }
                    if (i3 == eVar2.f43802c) {
                        eVar2 = eVar2.f43805f;
                        i3 = eVar2.f43801b;
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
            e eVar = this.f43793a;
            if (eVar == null) {
                return 0;
            }
            int i2 = 1;
            do {
                int i3 = eVar.f43802c;
                for (int i4 = eVar.f43801b; i4 < i3; i4++) {
                    i2 = (i2 * 31) + eVar.f43800a[i4];
                }
                eVar = eVar.f43805f;
            } while (eVar != this.f43793a);
            return i2;
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
            e eVar = this.f43793a;
            if (eVar == null) {
                return -1;
            }
            int min = Math.min(byteBuffer.remaining(), eVar.f43802c - eVar.f43801b);
            byteBuffer.put(eVar.f43800a, eVar.f43801b, min);
            int i2 = eVar.f43801b + min;
            eVar.f43801b = i2;
            this.f43794b -= min;
            if (i2 == eVar.f43802c) {
                this.f43793a = eVar.b();
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
                int i2 = remaining;
                while (i2 > 0) {
                    e c2 = c(1);
                    int min = Math.min(i2, 8192 - c2.f43802c);
                    byteBuffer.get(c2.f43800a, c2.f43802c, min);
                    i2 -= min;
                    c2.f43802c += min;
                }
                this.f43794b += remaining;
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
            com.baidu.searchbox.v8engine.net.b.a(this.f43794b, 0L, j);
            if (charset != null) {
                if (j > 2147483647L) {
                    throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
                } else if (j == 0) {
                    return "";
                } else {
                    e eVar = this.f43793a;
                    if (eVar.f43801b + j > eVar.f43802c) {
                        return new String(a(j), charset);
                    }
                    String str = new String(eVar.f43800a, eVar.f43801b, (int) j, charset);
                    int i2 = (int) (eVar.f43801b + j);
                    eVar.f43801b = i2;
                    this.f43794b -= j;
                    if (i2 == eVar.f43802c) {
                        this.f43793a = eVar.b();
                        f.a(eVar);
                    }
                    return str;
                }
            }
            throw new IllegalArgumentException("charset == null");
        }
        return (String) invokeJL.objValue;
    }

    public e c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (i2 >= 1 && i2 <= 8192) {
                e eVar = this.f43793a;
                if (eVar == null) {
                    e a2 = f.a();
                    this.f43793a = a2;
                    a2.f43806g = a2;
                    a2.f43805f = a2;
                    return a2;
                }
                e eVar2 = eVar.f43806g;
                return (eVar2.f43802c + i2 > 8192 || !eVar2.f43804e) ? eVar2.a(f.a()) : eVar2;
            }
            throw new IllegalArgumentException();
        }
        return (e) invokeI.objValue;
    }

    public d d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (i2 == 0) {
                return d.f43796b;
            }
            return new g(this, i2);
        }
        return (d) invokeI.objValue;
    }

    public a b(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048588, this, bArr, i2, i3)) == null) {
            if (bArr != null) {
                long j = i3;
                com.baidu.searchbox.v8engine.net.b.a(bArr.length, i2, j);
                int i4 = i3 + i2;
                while (i2 < i4) {
                    e c2 = c(1);
                    int min = Math.min(i4 - i2, 8192 - c2.f43802c);
                    System.arraycopy(bArr, i2, c2.f43800a, c2.f43802c, min);
                    i2 += min;
                    c2.f43802c += min;
                }
                this.f43794b += j;
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
            com.baidu.searchbox.v8engine.net.b.a(this.f43794b, 0L, j);
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
            int i2 = 0;
            while (i2 < bArr.length) {
                int a2 = a(bArr, i2, bArr.length - i2);
                if (a2 == -1) {
                    throw new EOFException();
                }
                i2 += a2;
            }
        }
    }

    public a b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            e c2 = c(1);
            byte[] bArr = c2.f43800a;
            int i3 = c2.f43802c;
            c2.f43802c = i3 + 1;
            bArr[i3] = (byte) i2;
            this.f43794b++;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public int a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            com.baidu.searchbox.v8engine.net.b.a(bArr.length, i2, i3);
            e eVar = this.f43793a;
            if (eVar == null) {
                return -1;
            }
            int min = Math.min(i3, eVar.f43802c - eVar.f43801b);
            System.arraycopy(eVar.f43800a, eVar.f43801b, bArr, i2, min);
            int i4 = eVar.f43801b + min;
            eVar.f43801b = i4;
            this.f43794b -= min;
            if (i4 == eVar.f43802c) {
                this.f43793a = eVar.b();
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
            byte[] bArr = c2.f43800a;
            int i2 = c2.f43802c;
            for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
                bArr[i3] = f43792c[(int) (15 & j)];
                j >>>= 4;
            }
            c2.f43802c += numberOfTrailingZeros;
            this.f43794b += numberOfTrailingZeros;
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? a(str, 0, str.length()) : (a) invokeL.objValue;
    }

    public a a(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, str, i2, i3)) == null) {
            if (str != null) {
                if (i2 < 0) {
                    throw new IllegalArgumentException("beginIndex < 0: " + i2);
                } else if (i3 >= i2) {
                    if (i3 > str.length()) {
                        throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
                    }
                    while (i2 < i3) {
                        char charAt = str.charAt(i2);
                        if (charAt < 128) {
                            e c2 = c(1);
                            byte[] bArr = c2.f43800a;
                            int i4 = c2.f43802c - i2;
                            int min = Math.min(i3, 8192 - i4);
                            int i5 = i2 + 1;
                            bArr[i2 + i4] = (byte) charAt;
                            while (i5 < min) {
                                char charAt2 = str.charAt(i5);
                                if (charAt2 >= 128) {
                                    break;
                                }
                                bArr[i5 + i4] = (byte) charAt2;
                                i5++;
                            }
                            int i6 = c2.f43802c;
                            int i7 = (i4 + i5) - i6;
                            c2.f43802c = i6 + i7;
                            this.f43794b += i7;
                            i2 = i5;
                        } else {
                            if (charAt < 2048) {
                                b((charAt >> 6) | 192);
                                b((charAt & '?') | 128);
                            } else if (charAt >= 55296 && charAt <= 57343) {
                                int i8 = i2 + 1;
                                char charAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                                if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                    int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                    b((i9 >> 18) | 240);
                                    b(((i9 >> 12) & 63) | 128);
                                    b(((i9 >> 6) & 63) | 128);
                                    b((i9 & 63) | 128);
                                    i2 += 2;
                                } else {
                                    b(63);
                                    i2 = i8;
                                }
                            } else {
                                b((charAt >> '\f') | 224);
                                b(((charAt >> 6) & 63) | 128);
                                b((charAt & '?') | 128);
                            }
                            i2++;
                        }
                    }
                    return this;
                } else {
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
                }
            }
            throw new IllegalArgumentException("string == null");
        }
        return (a) invokeLII.objValue;
    }

    public a a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 < 128) {
                b(i2);
            } else if (i2 < 2048) {
                b((i2 >> 6) | 192);
                b((i2 & 63) | 128);
            } else if (i2 < 65536) {
                if (i2 >= 55296 && i2 <= 57343) {
                    b(63);
                } else {
                    b((i2 >> 12) | 224);
                    b(((i2 >> 6) & 63) | 128);
                    b((i2 & 63) | 128);
                }
            } else if (i2 <= 1114111) {
                b((i2 >> 18) | 240);
                b(((i2 >> 12) & 63) | 128);
                b(((i2 >> 6) & 63) | 128);
                b((i2 & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
            }
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a a(String str, int i2, int i3, Charset charset) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), charset})) == null) {
            if (str != null) {
                if (i2 < 0) {
                    throw new IllegalAccessError("beginIndex < 0: " + i2);
                } else if (i3 >= i2) {
                    if (i3 <= str.length()) {
                        if (charset != null) {
                            if (charset.equals(j.f43811a)) {
                                return a(str, i2, i3);
                            }
                            byte[] bytes = str.substring(i2, i3).getBytes(charset);
                            return b(bytes, 0, bytes.length);
                        }
                        throw new IllegalArgumentException("charset == null");
                    }
                    throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
                } else {
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
                }
            }
            throw new IllegalArgumentException("string == null");
        }
        return (a) invokeCommon.objValue;
    }
}
