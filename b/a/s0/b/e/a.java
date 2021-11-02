package b.a.s0.b.e;

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
/* loaded from: classes6.dex */
public final class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final int f28640h;

    /* renamed from: i  reason: collision with root package name */
    public final UploadDataProvider f28641i;
    public ByteBuffer j;
    public boolean k;

    /* renamed from: b.a.s0.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C1392a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends UploadDataProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28642e;

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
            this.f28642e = aVar;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f28642e.f28640h == -1) {
                    return this.f28642e.k ? this.f28642e.j.limit() : this.f28642e.j.position();
                }
                return this.f28642e.f28640h;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void b(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataSink, byteBuffer) == null) {
                int remaining = byteBuffer.remaining();
                if (remaining < this.f28642e.j.remaining()) {
                    byteBuffer.put(this.f28642e.j.array(), this.f28642e.j.position(), remaining);
                    this.f28642e.j.position(this.f28642e.j.position() + remaining);
                } else {
                    byteBuffer.put(this.f28642e.j);
                }
                uploadDataSink.c(false);
            }
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void c(UploadDataSink uploadDataSink) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uploadDataSink) == null) {
                this.f28642e.j.position(0);
                uploadDataSink.a();
            }
        }

        public /* synthetic */ b(a aVar, C1392a c1392a) {
            this(aVar);
        }
    }

    public a(d dVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28641i = new b(this, null);
        this.k = false;
        if (dVar == null) {
            throw new NullPointerException("Argument connection cannot be null.");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
        }
        if (j >= 0) {
            int i4 = (int) j;
            this.f28640h = i4;
            this.j = ByteBuffer.allocate(i4);
            return;
        }
        throw new IllegalArgumentException("Content length < 0.");
    }

    @Override // b.a.s0.b.e.f
    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // b.a.s0.b.e.f
    public UploadDataProvider f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28641i : (UploadDataProvider) invokeV.objValue;
    }

    @Override // b.a.s0.b.e.f
    public void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k = true;
            if (this.j.position() >= this.f28640h) {
                this.j.flip();
                return;
            }
            throw new ProtocolException("Content received is less than Content-Length");
        }
    }

    public final void l(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (this.f28640h != -1 && this.j.position() + i2 > this.f28640h) {
                throw new ProtocolException("exceeded content-length limit of " + this.f28640h + " bytes");
            } else if (!this.k) {
                if (this.f28640h == -1 && this.j.limit() - this.j.position() <= i2) {
                    ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.j.capacity() * 2, this.j.capacity() + i2));
                    this.j.flip();
                    allocate.put(this.j);
                    this.j = allocate;
                }
            } else {
                throw new IllegalStateException("Cannot write after being connected.");
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            c();
            l(1);
            this.j.put((byte) i2);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) {
            c();
            l(i3);
            this.j.put(bArr, i2, i3);
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
        this.f28641i = new b(this, null);
        this.k = false;
        if (dVar != null) {
            this.f28640h = -1;
            this.j = ByteBuffer.allocate(16384);
            return;
        }
        throw null;
    }
}
