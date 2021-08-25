package c.d.b.e0.l;

import c.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
/* loaded from: classes4.dex */
public final class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Buffer f31907e;

    /* renamed from: f  reason: collision with root package name */
    public long f31908f;

    public a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Buffer buffer = new Buffer();
        this.f31907e = buffer;
        this.f31908f = -1L;
        f(buffer, j2);
    }

    @Override // c.d.b.e0.l.d, c.d.b.a0
    public long a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31908f : invokeV.longValue;
    }

    @Override // c.d.b.a0
    public void e(BufferedSink bufferedSink) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bufferedSink) == null) {
            this.f31907e.copyTo(bufferedSink.buffer(), 0L, this.f31907e.size());
        }
    }

    @Override // c.d.b.e0.l.d
    public z i(z zVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zVar)) == null) {
            if (zVar.c("Content-Length") != null) {
                return zVar;
            }
            h().close();
            this.f31908f = this.f31907e.size();
            z.a g2 = zVar.g();
            g2.f("Transfer-Encoding");
            g2.c("Content-Length", Long.toString(this.f31907e.size()));
            return g2.b();
        }
        return (z) invokeL.objValue;
    }
}
