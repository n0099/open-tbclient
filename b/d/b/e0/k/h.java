package b.d.b.e0.k;

import androidx.core.view.InputDeviceCompat;
import b.d.b.e0.k.b;
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
/* loaded from: classes6.dex */
public final class h implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final BufferedSink f30427e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f30428f;

    /* renamed from: g  reason: collision with root package name */
    public final Buffer f30429g;

    /* renamed from: h  reason: collision with root package name */
    public int f30430h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f30431i;
    public final b.C1449b j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-797001590, "Lb/d/b/e0/k/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-797001590, "Lb/d/b/e0/k/h;");
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
        this.f30427e = bufferedSink;
        this.f30428f = z;
        Buffer buffer = new Buffer();
        this.f30429g = buffer;
        this.j = new b.C1449b(buffer);
        this.f30430h = 16384;
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
                if (!this.f30431i) {
                    this.f30430h = kVar.f(this.f30430h);
                    if (kVar.c() != -1) {
                        this.j.e(kVar.c());
                    }
                    f(0, 0, (byte) 4, (byte) 1);
                    this.f30427e.flush();
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
                if (!this.f30431i) {
                    if (this.f30428f) {
                        if (k.isLoggable(Level.FINE)) {
                            k.fine(b.d.b.e0.e.q(">> CONNECTION %s", c.f30336a.hex()));
                        }
                        this.f30427e.write(c.f30336a.toByteArray());
                        this.f30427e.flush();
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
                this.f30431i = true;
                this.f30427e.close();
            }
        }
    }

    public synchronized void d(boolean z, int i2, Buffer buffer, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), buffer, Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                if (!this.f30431i) {
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
                this.f30427e.write(buffer, i3);
            }
        }
    }

    public void f(int i2, int i3, byte b2, byte b3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Byte.valueOf(b2), Byte.valueOf(b3)}) == null) {
            if (k.isLoggable(Level.FINE)) {
                k.fine(c.b(false, i2, i3, b2, b3));
            }
            int i4 = this.f30430h;
            if (i3 > i4) {
                c.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
                throw null;
            } else if ((Integer.MIN_VALUE & i2) != 0) {
                c.c("reserved bit set: %s", Integer.valueOf(i2));
                throw null;
            } else {
                r(this.f30427e, i3);
                this.f30427e.writeByte(b2 & 255);
                this.f30427e.writeByte(b3 & 255);
                this.f30427e.writeInt(i2 & Integer.MAX_VALUE);
            }
        }
    }

    public synchronized void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (!this.f30431i) {
                    this.f30427e.flush();
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
                if (!this.f30431i) {
                    if (errorCode.httpCode != -1) {
                        f(0, bArr.length + 8, (byte) 7, (byte) 0);
                        this.f30427e.writeInt(i2);
                        this.f30427e.writeInt(errorCode.httpCode);
                        if (bArr.length > 0) {
                            this.f30427e.write(bArr);
                        }
                        this.f30427e.flush();
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
            if (!this.f30431i) {
                this.j.g(list);
                long size = this.f30429g.size();
                int min = (int) Math.min(this.f30430h, size);
                long j = min;
                int i3 = (size > j ? 1 : (size == j ? 0 : -1));
                byte b2 = i3 == 0 ? (byte) 4 : (byte) 0;
                if (z) {
                    b2 = (byte) (b2 | 1);
                }
                f(i2, min, (byte) 1, b2);
                this.f30427e.write(this.f30429g, j);
                if (i3 > 0) {
                    q(i2, size - j);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f30430h : invokeV.intValue;
    }

    public synchronized void k(boolean z, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                if (!this.f30431i) {
                    f(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
                    this.f30427e.writeInt(i2);
                    this.f30427e.writeInt(i3);
                    this.f30427e.flush();
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
                if (!this.f30431i) {
                    this.j.g(list);
                    long size = this.f30429g.size();
                    int min = (int) Math.min(this.f30430h - 4, size);
                    long j = min;
                    int i4 = (size > j ? 1 : (size == j ? 0 : -1));
                    f(i2, min + 4, (byte) 5, i4 == 0 ? (byte) 4 : (byte) 0);
                    this.f30427e.writeInt(i3 & Integer.MAX_VALUE);
                    this.f30427e.write(this.f30429g, j);
                    if (i4 > 0) {
                        q(i2, size - j);
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
                if (!this.f30431i) {
                    if (errorCode.httpCode != -1) {
                        f(i2, 4, (byte) 3, (byte) 0);
                        this.f30427e.writeInt(errorCode.httpCode);
                        this.f30427e.flush();
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
                if (!this.f30431i) {
                    int i2 = 0;
                    f(0, kVar.j() * 6, (byte) 4, (byte) 0);
                    while (i2 < 10) {
                        if (kVar.g(i2)) {
                            this.f30427e.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                            this.f30427e.writeInt(kVar.b(i2));
                        }
                        i2++;
                    }
                    this.f30427e.flush();
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
                if (!this.f30431i) {
                    h(z, i2, list);
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void p(int i2, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            synchronized (this) {
                if (this.f30431i) {
                    throw new IOException("closed");
                }
                if (j != 0 && j <= 2147483647L) {
                    f(i2, 4, (byte) 8, (byte) 0);
                    this.f30427e.writeInt((int) j);
                    this.f30427e.flush();
                } else {
                    c.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
                    throw null;
                }
            }
        }
    }

    public final void q(int i2, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            while (j > 0) {
                int min = (int) Math.min(this.f30430h, j);
                long j2 = min;
                j -= j2;
                f(i2, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
                this.f30427e.write(this.f30429g, j2);
            }
        }
    }
}
