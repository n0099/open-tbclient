package com.baidu.searchbox.http.okurlconnection;

import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.internal.http.UnrepeatableRequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;
/* loaded from: classes2.dex */
public final class StreamedRequestBody extends OutputStreamRequestBody implements UnrepeatableRequestBody {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Pipe pipe;

    public StreamedRequestBody(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Pipe pipe = new Pipe(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        this.pipe = pipe;
        initOutputStream(Okio.buffer(pipe.sink()), j);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bufferedSink) == null) {
            Buffer buffer = new Buffer();
            while (this.pipe.source().read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                bufferedSink.write(buffer, buffer.size());
                if (this.needFlush) {
                    bufferedSink.flush();
                    this.needFlush = false;
                }
            }
        }
    }
}
