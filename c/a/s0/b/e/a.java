package c.a.s0.b.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public final class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final int f29886h;

    /* renamed from: i  reason: collision with root package name */
    public final UploadDataProvider f29887i;

    /* renamed from: j  reason: collision with root package name */
    public ByteBuffer f29888j;
    public boolean k;

    /* renamed from: c.a.s0.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1390a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b extends UploadDataProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f29889e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29889e = aVar;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f29889e.f29886h == -1) {
                    return this.f29889e.k ? this.f29889e.f29888j.limit() : this.f29889e.f29888j.position();
                }
                return this.f29889e.f29886h;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void h(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataSink, byteBuffer) == null) {
                int remaining = byteBuffer.remaining();
                if (remaining < this.f29889e.f29888j.remaining()) {
                    byteBuffer.put(this.f29889e.f29888j.array(), this.f29889e.f29888j.position(), remaining);
                    this.f29889e.f29888j.position(this.f29889e.f29888j.position() + remaining);
                } else {
                    byteBuffer.put(this.f29889e.f29888j);
                }
                uploadDataSink.c(false);
            }
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void i(UploadDataSink uploadDataSink) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uploadDataSink) == null) {
                this.f29889e.f29888j.position(0);
                uploadDataSink.a();
            }
        }

        public /* synthetic */ b(a aVar, C1390a c1390a) {
            this(aVar);
        }
    }

    public a(d dVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29887i = new b(this, null);
        this.k = false;
        if (dVar == null) {
            throw new NullPointerException("Argument connection cannot be null.");
        }
        if (j2 > 2147483647L) {
            throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
        }
        if (j2 >= 0) {
            int i4 = (int) j2;
            this.f29886h = i4;
            this.f29888j = ByteBuffer.allocate(i4);
            return;
        }
        throw new IllegalArgumentException("Content length < 0.");
    }

    @Override // c.a.s0.b.e.f
    public void o() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // c.a.s0.b.e.f
    public UploadDataProvider r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29887i : (UploadDataProvider) invokeV.objValue;
    }

    @Override // c.a.s0.b.e.f
    public void s() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k = true;
            if (this.f29888j.position() >= this.f29886h) {
                this.f29888j.flip();
                return;
            }
            throw new ProtocolException("Content received is less than Content-Length");
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            n();
            x(1);
            this.f29888j.put((byte) i2);
        }
    }

    public final void x(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (this.f29886h != -1 && this.f29888j.position() + i2 > this.f29886h) {
                throw new ProtocolException("exceeded content-length limit of " + this.f29886h + " bytes");
            } else if (!this.k) {
                if (this.f29886h == -1 && this.f29888j.limit() - this.f29888j.position() <= i2) {
                    ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.f29888j.capacity() * 2, this.f29888j.capacity() + i2));
                    this.f29888j.flip();
                    allocate.put(this.f29888j);
                    this.f29888j = allocate;
                }
            } else {
                throw new IllegalStateException("Cannot write after being connected.");
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, bArr, i2, i3) == null) {
            n();
            x(i3);
            this.f29888j.put(bArr, i2, i3);
        }
    }

    public a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29887i = new b(this, null);
        this.k = false;
        if (dVar != null) {
            this.f29886h = -1;
            this.f29888j = ByteBuffer.allocate(16384);
            return;
        }
        throw null;
    }
}
