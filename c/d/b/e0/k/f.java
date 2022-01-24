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
import kotlin.UShort;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
/* loaded from: classes9.dex */
public final class f implements Closeable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final Logger f27884i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final BufferedSource f27885e;

    /* renamed from: f  reason: collision with root package name */
    public final a f27886f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f27887g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a f27888h;

    /* loaded from: classes9.dex */
    public static final class a implements Source {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final BufferedSource f27889e;

        /* renamed from: f  reason: collision with root package name */
        public int f27890f;

        /* renamed from: g  reason: collision with root package name */
        public byte f27891g;

        /* renamed from: h  reason: collision with root package name */
        public int f27892h;

        /* renamed from: i  reason: collision with root package name */
        public int f27893i;

        /* renamed from: j  reason: collision with root package name */
        public short f27894j;

        public a(BufferedSource bufferedSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bufferedSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27889e = bufferedSource;
        }

        public final void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f27892h;
                int h2 = f.h(this.f27889e);
                this.f27893i = h2;
                this.f27890f = h2;
                byte readByte = (byte) (this.f27889e.readByte() & 255);
                this.f27891g = (byte) (this.f27889e.readByte() & 255);
                if (f.f27884i.isLoggable(Level.FINE)) {
                    f.f27884i.fine(c.b(true, this.f27892h, this.f27890f, readByte, this.f27891g));
                }
                int readInt = this.f27889e.readInt() & Integer.MAX_VALUE;
                this.f27892h = readInt;
                if (readByte != 9) {
                    c.d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                    throw null;
                } else if (readInt == i2) {
                } else {
                    c.d("TYPE_CONTINUATION streamId changed", new Object[0]);
                    throw null;
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, buffer, j2)) != null) {
                return invokeLJ.longValue;
            }
            while (true) {
                int i2 = this.f27893i;
                if (i2 == 0) {
                    this.f27889e.skip(this.f27894j);
                    this.f27894j = (short) 0;
                    if ((this.f27891g & 4) != 0) {
                        return -1L;
                    }
                    a();
                } else {
                    long read = this.f27889e.read(buffer, Math.min(j2, i2));
                    if (read == -1) {
                        return -1L;
                    }
                    this.f27893i = (int) (this.f27893i - read);
                    return read;
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27889e.timeout() : (Timeout) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(int i2, ErrorCode errorCode);

        void ackSettings();

        void b(int i2, ErrorCode errorCode, ByteString byteString);

        void c(boolean z, k kVar);

        void data(boolean z, int i2, BufferedSource bufferedSource, int i3) throws IOException;

        void headers(boolean z, int i2, int i3, List<c.d.b.e0.k.a> list);

        void ping(boolean z, int i2, int i3);

        void priority(int i2, int i3, int i4, boolean z);

        void pushPromise(int i2, int i3, List<c.d.b.e0.k.a> list) throws IOException;

        void windowUpdate(int i2, long j2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1090404659, "Lc/d/b/e0/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1090404659, "Lc/d/b/e0/k/f;");
                return;
            }
        }
        f27884i = Logger.getLogger(c.class.getName());
    }

    public f(BufferedSource bufferedSource, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedSource, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27885e = bufferedSource;
        this.f27887g = z;
        a aVar = new a(bufferedSource);
        this.f27886f = aVar;
        this.f27888h = new b.a(4096, aVar);
    }

    public static int a(int i2, byte b2, short s) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Byte.valueOf(b2), Short.valueOf(s)})) == null) {
            if ((b2 & 8) != 0) {
                i2--;
            }
            if (s <= i2) {
                return (short) (i2 - s);
            }
            c.d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
            throw null;
        }
        return invokeCommon.intValue;
    }

    public static int h(BufferedSource bufferedSource) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bufferedSource)) == null) ? (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8) : invokeL.intValue;
    }

    public boolean b(boolean z, b bVar) throws IOException {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, bVar)) == null) {
            try {
                this.f27885e.require(9L);
                int h2 = h(this.f27885e);
                if (h2 < 0 || h2 > 16384) {
                    c.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(h2));
                    throw null;
                }
                byte readByte = (byte) (this.f27885e.readByte() & 255);
                if (z && readByte != 4) {
                    c.d("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                    throw null;
                }
                byte readByte2 = (byte) (this.f27885e.readByte() & 255);
                int readInt = this.f27885e.readInt() & Integer.MAX_VALUE;
                if (f27884i.isLoggable(Level.FINE)) {
                    f27884i.fine(c.b(true, readInt, h2, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        d(bVar, h2, readByte2, readInt);
                        break;
                    case 1:
                        g(bVar, h2, readByte2, readInt);
                        break;
                    case 2:
                        k(bVar, h2, readByte2, readInt);
                        break;
                    case 3:
                        m(bVar, h2, readByte2, readInt);
                        break;
                    case 4:
                        n(bVar, h2, readByte2, readInt);
                        break;
                    case 5:
                        l(bVar, h2, readByte2, readInt);
                        break;
                    case 6:
                        i(bVar, h2, readByte2, readInt);
                        break;
                    case 7:
                        e(bVar, h2, readByte2, readInt);
                        break;
                    case 8:
                        o(bVar, h2, readByte2, readInt);
                        break;
                    default:
                        this.f27885e.skip(h2);
                        break;
                }
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeZL.booleanValue;
    }

    public void c(b bVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            if (this.f27887g) {
                if (b(true, bVar)) {
                    return;
                }
                c.d("Required SETTINGS preface not received", new Object[0]);
                throw null;
            }
            ByteString readByteString = this.f27885e.readByteString(c.a.size());
            if (f27884i.isLoggable(Level.FINE)) {
                f27884i.fine(c.d.b.e0.e.q("<< CONNECTION %s", readByteString.hex()));
            }
            if (c.a.equals(readByteString)) {
                return;
            }
            c.d("Expected a connection header but was %s", readByteString.utf8());
            throw null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f27885e.close();
        }
    }

    public final void d(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i3 == 0) {
                c.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
                throw null;
            }
            boolean z = (b2 & 1) != 0;
            if (!((b2 & 32) != 0)) {
                short readByte = (b2 & 8) != 0 ? (short) (this.f27885e.readByte() & 255) : (short) 0;
                bVar.data(z, i3, this.f27885e, a(i2, b2, readByte));
                this.f27885e.skip(readByte);
                return;
            }
            c.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
    }

    public final void e(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 < 8) {
                c.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
                throw null;
            } else if (i3 == 0) {
                int readInt = this.f27885e.readInt();
                int readInt2 = this.f27885e.readInt();
                int i4 = i2 - 8;
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
                if (fromHttp2 == null) {
                    c.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
                    throw null;
                }
                ByteString byteString = ByteString.EMPTY;
                if (i4 > 0) {
                    byteString = this.f27885e.readByteString(i4);
                }
                bVar.b(readInt, fromHttp2, byteString);
            } else {
                c.d("TYPE_GOAWAY streamId != 0", new Object[0]);
                throw null;
            }
        }
    }

    public final List<c.d.b.e0.k.a> f(int i2, short s, byte b2, int i3) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Short.valueOf(s), Byte.valueOf(b2), Integer.valueOf(i3)})) == null) {
            a aVar = this.f27886f;
            aVar.f27893i = i2;
            aVar.f27890f = i2;
            aVar.f27894j = s;
            aVar.f27891g = b2;
            aVar.f27892h = i3;
            this.f27888h.k();
            return this.f27888h.e();
        }
        return (List) invokeCommon.objValue;
    }

    public final void g(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i3 != 0) {
                boolean z = (b2 & 1) != 0;
                short readByte = (b2 & 8) != 0 ? (short) (this.f27885e.readByte() & 255) : (short) 0;
                if ((b2 & 32) != 0) {
                    j(bVar, i3);
                    i2 -= 5;
                }
                bVar.headers(z, i3, -1, f(a(i2, b2, readByte), readByte, b2, i3));
                return;
            }
            c.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
    }

    public final void i(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 != 8) {
                c.d("TYPE_PING length != 8: %s", Integer.valueOf(i2));
                throw null;
            } else if (i3 == 0) {
                bVar.ping((b2 & 1) != 0, this.f27885e.readInt(), this.f27885e.readInt());
            } else {
                c.d("TYPE_PING streamId != 0", new Object[0]);
                throw null;
            }
        }
    }

    public final void j(b bVar, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, i2) == null) {
            int readInt = this.f27885e.readInt();
            bVar.priority(i2, readInt & Integer.MAX_VALUE, (this.f27885e.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
        }
    }

    public final void k(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 != 5) {
                c.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
                throw null;
            } else if (i3 != 0) {
                j(bVar, i3);
            } else {
                c.d("TYPE_PRIORITY streamId == 0", new Object[0]);
                throw null;
            }
        }
    }

    public final void l(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i3 != 0) {
                short readByte = (b2 & 8) != 0 ? (short) (this.f27885e.readByte() & 255) : (short) 0;
                bVar.pushPromise(i3, this.f27885e.readInt() & Integer.MAX_VALUE, f(a(i2 - 4, b2, readByte), readByte, b2, i3));
                return;
            }
            c.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
    }

    public final void m(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 != 4) {
                c.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
                throw null;
            } else if (i3 != 0) {
                int readInt = this.f27885e.readInt();
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
                if (fromHttp2 != null) {
                    bVar.a(i3, fromHttp2);
                } else {
                    c.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                    throw null;
                }
            } else {
                c.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
                throw null;
            }
        }
    }

    public final void n(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i3 != 0) {
                c.d("TYPE_SETTINGS streamId != 0", new Object[0]);
                throw null;
            } else if ((b2 & 1) != 0) {
                if (i2 == 0) {
                    bVar.ackSettings();
                } else {
                    c.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                    throw null;
                }
            } else if (i2 % 6 != 0) {
                c.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
                throw null;
            } else {
                k kVar = new k();
                for (int i4 = 0; i4 < i2; i4 += 6) {
                    int readShort = this.f27885e.readShort() & UShort.MAX_VALUE;
                    int readInt = this.f27885e.readInt();
                    if (readShort != 2) {
                        if (readShort == 3) {
                            readShort = 4;
                        } else if (readShort == 4) {
                            readShort = 7;
                            if (readInt < 0) {
                                c.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                throw null;
                            }
                        } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                            c.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                            throw null;
                        }
                    } else if (readInt != 0 && readInt != 1) {
                        c.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        throw null;
                    }
                    kVar.i(readShort, readInt);
                }
                bVar.c(false, kVar);
            }
        }
    }

    public final void o(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 != 4) {
                c.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
                throw null;
            }
            long readInt = this.f27885e.readInt() & 2147483647L;
            if (readInt != 0) {
                bVar.windowUpdate(i3, readInt);
            } else {
                c.d("windowSizeIncrement was 0", Long.valueOf(readInt));
                throw null;
            }
        }
    }
}
