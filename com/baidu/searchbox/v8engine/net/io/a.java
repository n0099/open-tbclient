package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes3.dex */
public final class a implements b, c, Cloneable, ByteChannel {
    public static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};
    @Nullable
    public e a;
    public long b;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public boolean a() {
        if (this.b == 0) {
            return true;
        }
        return false;
    }

    public byte b() {
        long j = this.b;
        if (j != 0) {
            e eVar = this.a;
            int i = eVar.b;
            int i2 = eVar.c;
            int i3 = i + 1;
            byte b = eVar.a[i];
            this.b = j - 1;
            if (i3 == i2) {
                this.a = eVar.b();
                f.a(eVar);
            } else {
                eVar.b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    public String c() {
        try {
            return a(this.b, j.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public d e() {
        long j = this.b;
        if (j <= 2147483647L) {
            return d((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    public int hashCode() {
        e eVar = this.a;
        if (eVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = eVar.c;
            for (int i3 = eVar.b; i3 < i2; i3++) {
                i = (i * 31) + eVar.a[i3];
            }
            eVar = eVar.f;
        } while (eVar != this.a);
        return i;
    }

    public String toString() {
        return e().toString();
    }

    public int a(byte[] bArr, int i, int i2) {
        com.baidu.searchbox.v8engine.net.b.a(bArr.length, i, i2);
        e eVar = this.a;
        if (eVar == null) {
            return -1;
        }
        int min = Math.min(i2, eVar.c - eVar.b);
        System.arraycopy(eVar.a, eVar.b, bArr, i, min);
        int i3 = eVar.b + min;
        eVar.b = i3;
        this.b -= min;
        if (i3 == eVar.c) {
            this.a = eVar.b();
            f.a(eVar);
        }
        return min;
    }

    public a b(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            com.baidu.searchbox.v8engine.net.b.a(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                e c2 = c(1);
                int min = Math.min(i3 - i, 8192 - c2.c);
                System.arraycopy(bArr, i, c2.a, c2.c, min);
                i += min;
                c2.c += min;
            }
            this.b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public a a(int i) {
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

    public a a(String str) {
        return a(str, 0, str.length());
    }

    public a b(int i) {
        e c2 = c(1);
        byte[] bArr = c2.a;
        int i2 = c2.c;
        c2.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    public e c(int i) {
        if (i >= 1 && i <= 8192) {
            e eVar = this.a;
            if (eVar == null) {
                e a = f.a();
                this.a = a;
                a.g = a;
                a.f = a;
                return a;
            }
            e eVar2 = eVar.g;
            if (eVar2.c + i > 8192 || !eVar2.e) {
                return eVar2.a(f.a());
            }
            return eVar2;
        }
        throw new IllegalArgumentException();
    }

    public d d(int i) {
        if (i == 0) {
            return d.b;
        }
        return new g(this, i);
    }

    public a a(String str, int i, int i2) {
        char c2;
        if (str != null) {
            if (i >= 0) {
                if (i2 >= i) {
                    if (i2 <= str.length()) {
                        while (i < i2) {
                            char charAt = str.charAt(i);
                            if (charAt < 128) {
                                e c3 = c(1);
                                byte[] bArr = c3.a;
                                int i3 = c3.c - i;
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
                                int i5 = c3.c;
                                int i6 = (i3 + i4) - i5;
                                c3.c = i5 + i6;
                                this.b += i6;
                                i = i4;
                            } else {
                                if (charAt < 2048) {
                                    b((charAt >> 6) | 192);
                                    b((charAt & RFC1522Codec.SEP) | 128);
                                } else if (charAt >= 55296 && charAt <= 57343) {
                                    int i7 = i + 1;
                                    if (i7 < i2) {
                                        c2 = str.charAt(i7);
                                    } else {
                                        c2 = 0;
                                    }
                                    if (charAt <= 56319 && c2 >= 56320 && c2 <= 57343) {
                                        int i8 = (((charAt & 10239) << 10) | (9215 & c2)) + 65536;
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
                                    b((charAt & RFC1522Codec.SEP) | 128);
                                }
                                i++;
                            }
                        }
                        return this;
                    }
                    throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                }
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            }
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        throw new IllegalArgumentException("string == null");
    }

    public a a(String str, int i, int i2, Charset charset) {
        if (str != null) {
            if (i >= 0) {
                if (i2 >= i) {
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
                }
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            }
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        throw new IllegalArgumentException("string == null");
    }

    public String a(long j, Charset charset) {
        com.baidu.searchbox.v8engine.net.b.a(this.b, 0L, j);
        if (charset != null) {
            if (j <= 2147483647L) {
                if (j == 0) {
                    return "";
                }
                e eVar = this.a;
                if (eVar.b + j > eVar.c) {
                    return new String(a(j), charset);
                }
                String str = new String(eVar.a, eVar.b, (int) j, charset);
                int i = (int) (eVar.b + j);
                eVar.b = i;
                this.b -= j;
                if (i == eVar.c) {
                    this.a = eVar.b();
                    f.a(eVar);
                }
                return str;
            }
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public void a(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int a = a(bArr, i, bArr.length - i);
            if (a != -1) {
                i += a;
            } else {
                throw new EOFException();
            }
        }
    }

    public byte[] a(long j) {
        com.baidu.searchbox.v8engine.net.b.a(this.b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public a b(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        e c2 = c(numberOfTrailingZeros);
        byte[] bArr = c2.a;
        int i = c2.c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.c += numberOfTrailingZeros;
        this.b += numberOfTrailingZeros;
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        e eVar = this.a;
        if (eVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), eVar.c - eVar.b);
        byteBuffer.put(eVar.a, eVar.b, min);
        int i = eVar.b + min;
        eVar.b = i;
        this.b -= min;
        if (i == eVar.c) {
            this.a = eVar.b();
            f.a(eVar);
        }
        return min;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                e c2 = c(1);
                int min = Math.min(i, 8192 - c2.c);
                byteBuffer.get(c2.a, c2.c, min);
                i -= min;
                c2.c += min;
            }
            this.b += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public a clone() {
        a aVar = new a();
        if (this.b == 0) {
            return aVar;
        }
        e a = this.a.a();
        aVar.a = a;
        a.g = a;
        a.f = a;
        e eVar = this.a;
        while (true) {
            eVar = eVar.f;
            if (eVar != this.a) {
                aVar.a.g.a(eVar.a());
            } else {
                aVar.b = this.b;
                return aVar;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        long j = this.b;
        if (j != aVar.b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        e eVar = this.a;
        e eVar2 = aVar.a;
        int i = eVar.b;
        int i2 = eVar2.b;
        while (j2 < this.b) {
            long min = Math.min(eVar.c - i, eVar2.c - i2);
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
            if (i == eVar.c) {
                eVar = eVar.f;
                i = eVar.b;
            }
            if (i2 == eVar2.c) {
                eVar2 = eVar2.f;
                i2 = eVar2.b;
            }
            j2 += min;
        }
        return true;
    }
}
