package c.d.b.e0.k;

import androidx.core.view.InputDeviceCompat;
import c.d.b.e0.k.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
/* loaded from: classes9.dex */
public final class h implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final BufferedSink f28120e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f28121f;

    /* renamed from: g  reason: collision with root package name */
    public final Buffer f28122g;

    /* renamed from: h  reason: collision with root package name */
    public int f28123h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28124i;

    /* renamed from: j  reason: collision with root package name */
    public final b.C1637b f28125j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1090404597, "Lc/d/b/e0/k/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1090404597, "Lc/d/b/e0/k/h;");
                return;
            }
        }
        k = Logger.getLogger(c.class.getName());
    }

    public h(BufferedSink bufferedSink, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedSink, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28120e = bufferedSink;
        this.f28121f = z;
        Buffer buffer = new Buffer();
        this.f28122g = buffer;
        this.f28125j = new b.C1637b(buffer);
        this.f28123h = 16384;
    }

    public static void r(BufferedSink bufferedSink, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, bufferedSink, i2) == null) {
            bufferedSink.writeByte((i2 >>> 16) & 255);
            bufferedSink.writeByte((i2 >>> 8) & 255);
            bufferedSink.writeByte(i2 & 255);
        }
    }

    public synchronized void a(k kVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            synchronized (this) {
                if (!this.f28124i) {
                    this.f28123h = kVar.f(this.f28123h);
                    if (kVar.c() != -1) {
                        this.f28125j.e(kVar.c());
                    }
                    f(0, 0, (byte) 4, (byte) 1);
                    this.f28120e.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void c() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (!this.f28124i) {
                    if (this.f28121f) {
                        if (k.isLoggable(Level.FINE)) {
                            k.fine(c.d.b.e0.e.q(">> CONNECTION %s", c.a.hex()));
                        }
                        this.f28120e.write(c.a.toByteArray());
                        this.f28120e.flush();
                        return;
                    }
                    return;
                }
                throw new IOException("closed");
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f28124i = true;
                this.f28120e.close();
            }
        }
    }

    public synchronized void d(boolean z, int i2, Buffer buffer, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), buffer, Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                if (!this.f28124i) {
                    e(i2, z ? (byte) 1 : (byte) 0, buffer, i3);
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public void e(int i2, byte b2, Buffer buffer, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Byte.valueOf(b2), buffer, Integer.valueOf(i3)}) == null) {
            f(i2, i3, (byte) 0, b2);
            if (i3 > 0) {
                this.f28120e.write(buffer, i3);
            }
        }
    }

    public void f(int i2, int i3, byte b2, byte b3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Byte.valueOf(b2), Byte.valueOf(b3)}) == null) {
            if (k.isLoggable(Level.FINE)) {
                k.fine(c.b(false, i2, i3, b2, b3));
            }
            int i4 = this.f28123h;
            if (i3 > i4) {
                c.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
                throw null;
            } else if ((Integer.MIN_VALUE & i2) != 0) {
                c.c("reserved bit set: %s", Integer.valueOf(i2));
                throw null;
            } else {
                r(this.f28120e, i3);
                this.f28120e.writeByte(b2 & 255);
                this.f28120e.writeByte(b3 & 255);
                this.f28120e.writeInt(i2 & Integer.MAX_VALUE);
            }
        }
    }

    public synchronized void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (!this.f28124i) {
                    this.f28120e.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void g(int i2, ErrorCode errorCode, byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i2, errorCode, bArr) == null) {
            synchronized (this) {
                if (!this.f28124i) {
                    if (errorCode.httpCode != -1) {
                        f(0, bArr.length + 8, (byte) 7, (byte) 0);
                        this.f28120e.writeInt(i2);
                        this.f28120e.writeInt(errorCode.httpCode);
                        if (bArr.length > 0) {
                            this.f28120e.write(bArr);
                        }
                        this.f28120e.flush();
                    } else {
                        c.c("errorCode.httpCode == -1", new Object[0]);
                        throw null;
                    }
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public void h(boolean z, int i2, List<a> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), list}) == null) {
            if (!this.f28124i) {
                this.f28125j.g(list);
                long size = this.f28122g.size();
                int min = (int) Math.min(this.f28123h, size);
                long j2 = min;
                int i3 = (size > j2 ? 1 : (size == j2 ? 0 : -1));
                byte b2 = i3 == 0 ? (byte) 4 : (byte) 0;
                if (z) {
                    b2 = (byte) (b2 | 1);
                }
                f(i2, min, (byte) 1, b2);
                this.f28120e.write(this.f28122g, j2);
                if (i3 > 0) {
                    q(i2, size - j2);
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28123h : invokeV.intValue;
    }

    public synchronized void k(boolean z, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                if (!this.f28124i) {
                    f(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
                    this.f28120e.writeInt(i2);
                    this.f28120e.writeInt(i3);
                    this.f28120e.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void l(int i2, int i3, List<a> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, list) == null) {
            synchronized (this) {
                if (!this.f28124i) {
                    this.f28125j.g(list);
                    long size = this.f28122g.size();
                    int min = (int) Math.min(this.f28123h - 4, size);
                    long j2 = min;
                    int i4 = (size > j2 ? 1 : (size == j2 ? 0 : -1));
                    f(i2, min + 4, (byte) 5, i4 == 0 ? (byte) 4 : (byte) 0);
                    this.f28120e.writeInt(i3 & Integer.MAX_VALUE);
                    this.f28120e.write(this.f28122g, j2);
                    if (i4 > 0) {
                        q(i2, size - j2);
                    }
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void m(int i2, ErrorCode errorCode) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, errorCode) == null) {
            synchronized (this) {
                if (!this.f28124i) {
                    if (errorCode.httpCode != -1) {
                        f(i2, 4, (byte) 3, (byte) 0);
                        this.f28120e.writeInt(errorCode.httpCode);
                        this.f28120e.flush();
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void n(k kVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, kVar) == null) {
            synchronized (this) {
                if (!this.f28124i) {
                    int i2 = 0;
                    f(0, kVar.j() * 6, (byte) 4, (byte) 0);
                    while (i2 < 10) {
                        if (kVar.g(i2)) {
                            this.f28120e.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                            this.f28120e.writeInt(kVar.b(i2));
                        }
                        i2++;
                    }
                    this.f28120e.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void o(boolean z, int i2, int i3, List<a> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), list}) == null) {
            synchronized (this) {
                if (!this.f28124i) {
                    h(z, i2, list);
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void p(int i2, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            synchronized (this) {
                if (this.f28124i) {
                    throw new IOException("closed");
                }
                if (j2 != 0 && j2 <= 2147483647L) {
                    f(i2, 4, (byte) 8, (byte) 0);
                    this.f28120e.writeInt((int) j2);
                    this.f28120e.flush();
                } else {
                    c.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
                    throw null;
                }
            }
        }
    }

    public final void q(int i2, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            while (j2 > 0) {
                int min = (int) Math.min(this.f28123h, j2);
                long j3 = min;
                j2 -= j3;
                f(i2, min, (byte) 9, j2 == 0 ? (byte) 4 : (byte) 0);
                this.f28120e.write(this.f28122g, j3);
            }
        }
    }
}
