package c.a.y0.o.f;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.MediaMuxerWrapper;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaMuxer a;

    /* renamed from: b  reason: collision with root package name */
    public int f26929b;

    /* renamed from: c  reason: collision with root package name */
    public int f26930c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26931d;

    public d(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26929b = 2;
        this.f26930c = 0;
        this.f26931d = false;
        this.a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        int addTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaFormat)) == null) {
            synchronized (this) {
                if (this.f26931d) {
                    throw new IllegalStateException("muxer already started");
                }
                addTrack = this.a.addTrack(mediaFormat);
                c.a.y0.r.c.j(MediaMuxerWrapper.TAG, "addTrack:trackNum=" + this.f26929b + ",trackIx=" + addTrack + ",format=" + mediaFormat);
            }
            return addTrack;
        }
        return invokeL.intValue;
    }

    public synchronized void b(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, byteBuffer, bufferInfo) == null) {
            synchronized (this) {
                if (this.f26930c > 0) {
                    this.a.writeSampleData(i2, byteBuffer, bufferInfo);
                }
            }
        }
    }

    public synchronized boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                c.a.y0.r.c.k(MediaMuxerWrapper.TAG, "start:");
                int i2 = this.f26930c + 1;
                this.f26930c = i2;
                if (this.f26929b > 0 && i2 == this.f26929b) {
                    this.a.start();
                    this.f26931d = true;
                    notifyAll();
                    c.a.y0.r.c.k(MediaMuxerWrapper.TAG, "MediaMuxer started:");
                }
                z = this.f26931d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                c.a.y0.r.c.k(MediaMuxerWrapper.TAG, "stop:mStatredCount=" + this.f26930c);
                int i2 = this.f26930c + (-1);
                this.f26930c = i2;
                if (this.f26929b > 0 && i2 <= 0) {
                    if (this.f26931d) {
                        this.a.stop();
                    }
                    this.a.release();
                    this.f26931d = false;
                    c.a.y0.r.c.k(MediaMuxerWrapper.TAG, "MediaMuxer stopped:");
                }
            }
        }
    }

    public synchronized boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                z = this.f26931d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
