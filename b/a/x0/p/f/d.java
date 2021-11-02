package b.a.x0.p.f;

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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final MediaMuxer f29882a;

    /* renamed from: b  reason: collision with root package name */
    public int f29883b;

    /* renamed from: c  reason: collision with root package name */
    public int f29884c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29885d;

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
        this.f29883b = 2;
        this.f29884c = 0;
        this.f29885d = false;
        this.f29882a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        int addTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaFormat)) == null) {
            synchronized (this) {
                if (this.f29885d) {
                    throw new IllegalStateException("muxer already started");
                }
                addTrack = this.f29882a.addTrack(mediaFormat);
                b.a.x0.t.c.j(MediaMuxerWrapper.TAG, "addTrack:trackNum=" + this.f29883b + ",trackIx=" + addTrack + ",format=" + mediaFormat);
            }
            return addTrack;
        }
        return invokeL.intValue;
    }

    public synchronized void b(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, byteBuffer, bufferInfo) == null) {
            synchronized (this) {
                if (this.f29884c > 0) {
                    this.f29882a.writeSampleData(i2, byteBuffer, bufferInfo);
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
                b.a.x0.t.c.k(MediaMuxerWrapper.TAG, "start:");
                int i2 = this.f29884c + 1;
                this.f29884c = i2;
                if (this.f29883b > 0 && i2 == this.f29883b) {
                    this.f29882a.start();
                    this.f29885d = true;
                    notifyAll();
                    b.a.x0.t.c.k(MediaMuxerWrapper.TAG, "MediaMuxer started:");
                }
                z = this.f29885d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                b.a.x0.t.c.k(MediaMuxerWrapper.TAG, "stop:mStatredCount=" + this.f29884c);
                int i2 = this.f29884c + (-1);
                this.f29884c = i2;
                if (this.f29883b > 0 && i2 <= 0) {
                    if (this.f29885d) {
                        this.f29882a.stop();
                    }
                    this.f29882a.release();
                    this.f29885d = false;
                    b.a.x0.t.c.k(MediaMuxerWrapper.TAG, "MediaMuxer stopped:");
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
                z = this.f29885d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
