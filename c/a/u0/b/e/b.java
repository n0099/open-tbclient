package c.a.u0.b.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public final class b extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final d f26340h;

    /* renamed from: i  reason: collision with root package name */
    public final g f26341i;

    /* renamed from: j  reason: collision with root package name */
    public final ByteBuffer f26342j;
    public final UploadDataProvider k;
    public boolean l;
    public boolean m;
    public boolean n;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.u0.b.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1588b extends UploadDataProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26343e;

        public C1588b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26343e = bVar;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return -1L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void b(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataSink, byteBuffer) == null) {
                if (byteBuffer.remaining() >= this.f26343e.f26342j.remaining()) {
                    byteBuffer.put(this.f26343e.f26342j);
                    this.f26343e.f26342j.clear();
                    uploadDataSink.c(this.f26343e.l);
                    if (!this.f26343e.l) {
                        this.f26343e.f26341i.quit();
                        return;
                    } else if (this.f26343e.m) {
                        this.f26343e.f26341i.quit();
                        return;
                    } else {
                        return;
                    }
                }
                int limit = this.f26343e.f26342j.limit();
                this.f26343e.f26342j.limit(this.f26343e.f26342j.position() + byteBuffer.remaining());
                byteBuffer.put(this.f26343e.f26342j);
                this.f26343e.f26342j.limit(limit);
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

        public /* synthetic */ C1588b(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b(d dVar, int i2, g gVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Integer.valueOf(i2), gVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new C1588b(this, null);
        this.l = false;
        this.m = false;
        this.n = false;
        if (dVar == null) {
            throw null;
        }
        if (i2 > 0) {
            this.f26342j = ByteBuffer.allocate(i2);
            this.f26340h = dVar;
            this.f26341i = gVar;
            this.m = z;
            this.n = z2;
            return;
        }
        throw new IllegalArgumentException("chunkLength should be greater than 0");
    }

    @Override // c.a.u0.b.e.f, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.close();
            if (this.l) {
                return;
            }
            this.l = true;
            this.f26342j.flip();
            if (this.m) {
                this.f26341i.b(this.f26340h.getReadTimeout());
            }
        }
    }

    @Override // c.a.u0.b.e.f
    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // c.a.u0.b.e.f
    public UploadDataProvider f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (UploadDataProvider) invokeV.objValue;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.n && this.f26342j.position() > 0) {
            n();
        }
    }

    @Override // c.a.u0.b.e.f
    public void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final void m() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f26342j.hasRemaining()) {
            return;
        }
        n();
    }

    public final void n() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c();
            this.f26342j.flip();
            this.f26341i.b(this.f26340h.getReadTimeout());
            a();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            m();
            this.f26342j.put((byte) i2);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3) == null) {
            c();
            if (bArr.length - i2 < i3 || i2 < 0 || i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            int i4 = i3;
            while (i4 > 0) {
                int min = Math.min(i4, this.f26342j.remaining());
                this.f26342j.put(bArr, (i2 + i3) - i4, min);
                i4 -= min;
                m();
            }
        }
    }
}
