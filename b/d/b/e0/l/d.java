package b.d.b.e0.l;

import b.d.b.a0;
import b.d.b.v;
import b.d.b.z;
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
/* loaded from: classes6.dex */
public abstract class d extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Timeout f30446a;

    /* renamed from: b  reason: collision with root package name */
    public long f30447b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f30448c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30449d;

    /* loaded from: classes6.dex */
    public class a extends OutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f30450e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f30451f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BufferedSink f30452g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f30453h;

        public a(d dVar, long j, BufferedSink bufferedSink) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j), bufferedSink};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30453h = dVar;
            this.f30451f = j;
            this.f30452g = bufferedSink;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30453h.f30449d = true;
                long j = this.f30451f;
                if (j != -1 && this.f30450e < j) {
                    throw new ProtocolException("expected " + this.f30451f + " bytes but received " + this.f30450e);
                }
                this.f30452g.close();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f30453h.f30449d) {
                return;
            }
            this.f30452g.flush();
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
                if (!this.f30453h.f30449d) {
                    long j = this.f30451f;
                    if (j != -1 && this.f30450e + i3 > j) {
                        throw new ProtocolException("expected " + this.f30451f + " bytes but received " + this.f30450e + i3);
                    }
                    this.f30450e += i3;
                    try {
                        this.f30452g.write(bArr, i2, i3);
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

    @Override // b.d.b.a0
    public long a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30447b : invokeV.longValue;
    }

    @Override // b.d.b.a0
    public final v b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (v) invokeV.objValue;
    }

    public void f(BufferedSink bufferedSink, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, bufferedSink, j) == null) {
            this.f30446a = bufferedSink.timeout();
            this.f30447b = j;
            this.f30448c = new a(this, j, bufferedSink);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30449d : invokeV.booleanValue;
    }

    public final OutputStream h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30448c : (OutputStream) invokeV.objValue;
    }

    public z i(z zVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zVar)) == null) ? zVar : (z) invokeL.objValue;
    }

    public final Timeout j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30446a : (Timeout) invokeV.objValue;
    }
}
