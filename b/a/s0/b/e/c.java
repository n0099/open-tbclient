package b.a.s0.b.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public final class c extends f {
    public static /* synthetic */ Interceptable $ic = null;
    public static int m = 16384;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final g f28646h;

    /* renamed from: i  reason: collision with root package name */
    public final long f28647i;
    public final ByteBuffer j;
    public final UploadDataProvider k;
    public long l;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends UploadDataProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f28648e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28648e = cVar;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28648e.f28647i : invokeV.longValue;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void b(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataSink, byteBuffer) == null) {
                if (byteBuffer.remaining() >= this.f28648e.j.remaining()) {
                    byteBuffer.put(this.f28648e.j);
                    this.f28648e.j.clear();
                    uploadDataSink.c(false);
                    this.f28648e.f28646h.quit();
                    return;
                }
                int limit = this.f28648e.j.limit();
                this.f28648e.j.limit(this.f28648e.j.position() + byteBuffer.remaining());
                byteBuffer.put(this.f28648e.j);
                this.f28648e.j.limit(limit);
                uploadDataSink.c(false);
            }
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void c(UploadDataSink uploadDataSink) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uploadDataSink) == null) {
                uploadDataSink.b(new HttpRetryException("Cannot retry streamed Http body", -1));
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2130460858, "Lb/a/s0/b/e/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2130460858, "Lb/a/s0/b/e/c;");
        }
    }

    public c(d dVar, long j, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Long.valueOf(j), gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new b(this, null);
        if (dVar == null) {
            throw null;
        }
        if (j >= 0) {
            this.f28647i = j;
            this.j = ByteBuffer.allocate((int) Math.min(j, m));
            this.f28646h = gVar;
            this.l = 0L;
            return;
        }
        throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
    }

    @Override // b.a.s0.b.e.f
    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.l < this.f28647i) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    @Override // b.a.s0.b.e.f
    public UploadDataProvider f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (UploadDataProvider) invokeV.objValue;
    }

    @Override // b.a.s0.b.e.f
    public void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public final void l(int i2) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.l + i2 <= this.f28647i) {
            return;
        }
        throw new ProtocolException("expected " + (this.f28647i - this.l) + " bytes but received " + i2);
    }

    public final void m() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.j.hasRemaining()) {
            return;
        }
        n();
    }

    public final void n() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c();
            this.j.flip();
            this.f28646h.a();
            a();
        }
    }

    public final void o() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.l == this.f28647i) {
            n();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            c();
            l(1);
            m();
            this.j.put((byte) i2);
            this.l++;
            o();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3) == null) {
            c();
            if (bArr.length - i2 >= i3 && i2 >= 0 && i3 >= 0) {
                l(i3);
                int i4 = i3;
                while (i4 > 0) {
                    m();
                    int min = Math.min(i4, this.j.remaining());
                    this.j.put(bArr, (i2 + i3) - i4, min);
                    i4 -= min;
                }
                this.l += i3;
                o();
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
