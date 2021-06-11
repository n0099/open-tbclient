package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public final class a implements b, c, Cloneable, ByteChannel {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f10091c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public e f10092a;

    /* renamed from: b  reason: collision with root package name */
    public long f10093b;

    public boolean a() {
        return this.f10093b == 0;
    }

    public byte b() {
        long j = this.f10093b;
        if (j != 0) {
            e eVar = this.f10092a;
            int i2 = eVar.f10100b;
            int i3 = eVar.f10101c;
            int i4 = i2 + 1;
            byte b2 = eVar.f10099a[i2];
            this.f10093b = j - 1;
            if (i4 == i3) {
                this.f10092a = eVar.b();
                f.a(eVar);
            } else {
                eVar.f10100b = i4;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public String c() {
        try {
            return a(this.f10093b, j.f10110a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public a clone() {
        a aVar = new a();
        if (this.f10093b == 0) {
            return aVar;
        }
        e a2 = this.f10092a.a();
        aVar.f10092a = a2;
        a2.f10105g = a2;
        a2.f10104f = a2;
        e eVar = this.f10092a;
        while (true) {
            eVar = eVar.f10104f;
            if (eVar != this.f10092a) {
                aVar.f10092a.f10105g.a(eVar.a());
            } else {
                aVar.f10093b = this.f10093b;
                return aVar;
            }
        }
    }

    public d e() {
        long j = this.f10093b;
        if (j <= 2147483647L) {
            return d((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f10093b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            long j = this.f10093b;
            if (j != aVar.f10093b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            e eVar = this.f10092a;
            e eVar2 = aVar.f10092a;
            int i2 = eVar.f10100b;
            int i3 = eVar2.f10100b;
            while (j2 < this.f10093b) {
                long min = Math.min(eVar.f10101c - i2, eVar2.f10101c - i3);
                int i4 = 0;
                while (i4 < min) {
                    int i5 = i2 + 1;
                    int i6 = i3 + 1;
                    if (eVar.f10099a[i2] != eVar2.f10099a[i3]) {
                        return false;
                    }
                    i4++;
                    i2 = i5;
                    i3 = i6;
                }
                if (i2 == eVar.f10101c) {
                    eVar = eVar.f10104f;
                    i2 = eVar.f10100b;
                }
                if (i3 == eVar2.f10101c) {
                    eVar2 = eVar2.f10104f;
                    i3 = eVar2.f10100b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        e eVar = this.f10092a;
        if (eVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = eVar.f10101c;
            for (int i4 = eVar.f10100b; i4 < i3; i4++) {
                i2 = (i2 * 31) + eVar.f10099a[i4];
            }
            eVar = eVar.f10104f;
        } while (eVar != this.f10092a);
        return i2;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        e eVar = this.f10092a;
        if (eVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), eVar.f10101c - eVar.f10100b);
        byteBuffer.put(eVar.f10099a, eVar.f10100b, min);
        int i2 = eVar.f10100b + min;
        eVar.f10100b = i2;
        this.f10093b -= min;
        if (i2 == eVar.f10101c) {
            this.f10092a = eVar.b();
            f.a(eVar);
        }
        return min;
    }

    public String toString() {
        return e().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                e c2 = c(1);
                int min = Math.min(i2, 8192 - c2.f10101c);
                byteBuffer.get(c2.f10099a, c2.f10101c, min);
                i2 -= min;
                c2.f10101c += min;
            }
            this.f10093b += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public String a(long j, Charset charset) {
        com.baidu.searchbox.v8engine.net.b.a(this.f10093b, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                e eVar = this.f10092a;
                if (eVar.f10100b + j > eVar.f10101c) {
                    return new String(a(j), charset);
                }
                String str = new String(eVar.f10099a, eVar.f10100b, (int) j, charset);
                int i2 = (int) (eVar.f10100b + j);
                eVar.f10100b = i2;
                this.f10093b -= j;
                if (i2 == eVar.f10101c) {
                    this.f10092a = eVar.b();
                    f.a(eVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    public e c(int i2) {
        if (i2 >= 1 && i2 <= 8192) {
            e eVar = this.f10092a;
            if (eVar == null) {
                e a2 = f.a();
                this.f10092a = a2;
                a2.f10105g = a2;
                a2.f10104f = a2;
                return a2;
            }
            e eVar2 = eVar.f10105g;
            return (eVar2.f10101c + i2 > 8192 || !eVar2.f10103e) ? eVar2.a(f.a()) : eVar2;
        }
        throw new IllegalArgumentException();
    }

    public d d(int i2) {
        if (i2 == 0) {
            return d.f10095b;
        }
        return new g(this, i2);
    }

    public a b(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j = i3;
            com.baidu.searchbox.v8engine.net.b.a(bArr.length, i2, j);
            int i4 = i3 + i2;
            while (i2 < i4) {
                e c2 = c(1);
                int min = Math.min(i4 - i2, 8192 - c2.f10101c);
                System.arraycopy(bArr, i2, c2.f10099a, c2.f10101c, min);
                i2 += min;
                c2.f10101c += min;
            }
            this.f10093b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public byte[] a(long j) {
        com.baidu.searchbox.v8engine.net.b.a(this.f10093b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public void a(byte[] bArr) {
        int i2 = 0;
        while (i2 < bArr.length) {
            int a2 = a(bArr, i2, bArr.length - i2);
            if (a2 == -1) {
                throw new EOFException();
            }
            i2 += a2;
        }
    }

    public a b(int i2) {
        e c2 = c(1);
        byte[] bArr = c2.f10099a;
        int i3 = c2.f10101c;
        c2.f10101c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f10093b++;
        return this;
    }

    public int a(byte[] bArr, int i2, int i3) {
        com.baidu.searchbox.v8engine.net.b.a(bArr.length, i2, i3);
        e eVar = this.f10092a;
        if (eVar == null) {
            return -1;
        }
        int min = Math.min(i3, eVar.f10101c - eVar.f10100b);
        System.arraycopy(eVar.f10099a, eVar.f10100b, bArr, i2, min);
        int i4 = eVar.f10100b + min;
        eVar.f10100b = i4;
        this.f10093b -= min;
        if (i4 == eVar.f10101c) {
            this.f10092a = eVar.b();
            f.a(eVar);
        }
        return min;
    }

    public a b(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        e c2 = c(numberOfTrailingZeros);
        byte[] bArr = c2.f10099a;
        int i2 = c2.f10101c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f10091c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.f10101c += numberOfTrailingZeros;
        this.f10093b += numberOfTrailingZeros;
        return this;
    }

    public a a(String str) {
        return a(str, 0, str.length());
    }

    public a a(String str, int i2, int i3) {
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
                        byte[] bArr = c2.f10099a;
                        int i4 = c2.f10101c - i2;
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
                        int i6 = c2.f10101c;
                        int i7 = (i4 + i5) - i6;
                        c2.f10101c = i6 + i7;
                        this.f10093b += i7;
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

    public a a(int i2) {
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

    public a a(String str, int i2, int i3, Charset charset) {
        if (str != null) {
            if (i2 < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i2);
            } else if (i3 >= i2) {
                if (i3 <= str.length()) {
                    if (charset != null) {
                        if (charset.equals(j.f10110a)) {
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
}
