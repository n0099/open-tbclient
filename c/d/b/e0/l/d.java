package c.d.b.e0.l;

import c.d.b.a0;
import c.d.b.v;
import c.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okio.BufferedSink;
import okio.Timeout;
/* loaded from: classes9.dex */
public abstract class d extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Timeout a;

    /* renamed from: b  reason: collision with root package name */
    public long f27901b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f27902c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27903d;

    /* loaded from: classes9.dex */
    public class a extends OutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f27904e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f27905f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BufferedSink f27906g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f27907h;

        public a(d dVar, long j2, BufferedSink bufferedSink) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j2), bufferedSink};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27907h = dVar;
            this.f27905f = j2;
            this.f27906g = bufferedSink;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27907h.f27903d = true;
                long j2 = this.f27905f;
                if (j2 != -1 && this.f27904e < j2) {
                    throw new ProtocolException("expected " + this.f27905f + " bytes but received " + this.f27904e);
                }
                this.f27906g.close();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f27907h.f27903d) {
                return;
            }
            this.f27906g.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                write(new byte[]{(byte) i2}, 0, 1);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
                if (!this.f27907h.f27903d) {
                    long j2 = this.f27905f;
                    if (j2 != -1 && this.f27904e + i3 > j2) {
                        throw new ProtocolException("expected " + this.f27905f + " bytes but received " + this.f27904e + i3);
                    }
                    this.f27904e += i3;
                    try {
                        this.f27906g.write(bArr, i2, i3);
                        return;
                    } catch (InterruptedIOException e2) {
                        throw new SocketTimeoutException(e2.getMessage());
                    }
                }
                throw new IOException("closed");
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.d.b.a0
    public long a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27901b : invokeV.longValue;
    }

    @Override // c.d.b.a0
    public final v b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (v) invokeV.objValue;
    }

    public void f(BufferedSink bufferedSink, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, bufferedSink, j2) == null) {
            this.a = bufferedSink.timeout();
            this.f27901b = j2;
            this.f27902c = new a(this, j2, bufferedSink);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27903d : invokeV.booleanValue;
    }

    public final OutputStream h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27902c : (OutputStream) invokeV.objValue;
    }

    public z i(z zVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zVar)) == null) ? zVar : (z) invokeL.objValue;
    }

    public final Timeout j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (Timeout) invokeV.objValue;
    }
}
