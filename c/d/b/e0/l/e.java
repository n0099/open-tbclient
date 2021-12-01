package c.d.b.e0.l;

import c.d.b.e0.i.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;
/* loaded from: classes7.dex */
public final class e extends d implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Pipe f28342e;

    public e(long j2) {
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
        Pipe pipe = new Pipe(8192L);
        this.f28342e = pipe;
        f(Okio.buffer(pipe.sink()), j2);
    }

    @Override // c.d.b.a0
    public void e(BufferedSink bufferedSink) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bufferedSink) == null) {
            Buffer buffer = new Buffer();
            while (this.f28342e.source().read(buffer, 8192L) != -1) {
                bufferedSink.write(buffer, buffer.size());
            }
        }
    }
}
