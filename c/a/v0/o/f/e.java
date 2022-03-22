package c.a.v0.o.f;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import c.a.v0.r.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.VideoEncoderCore;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface a;

    /* renamed from: b  reason: collision with root package name */
    public d f21815b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec f21816c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f21817d;

    /* renamed from: e  reason: collision with root package name */
    public int f21818e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21819f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f21820g;

    /* renamed from: h  reason: collision with root package name */
    public long f21821h;
    public int i;

    @TargetApi(18)
    public e(int i, int i2, int i3, boolean z, d dVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21820g = new Bundle();
        this.f21821h = 0L;
        this.i = 10000;
        String str = MimeTypes.VIDEO_H265;
        str = (!z || m.m(MimeTypes.VIDEO_H265) == null) ? "video/avc" : "video/avc";
        this.f21817d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", i3);
        createVideoFormat.setInteger("frame-rate", 30);
        createVideoFormat.setInteger("i-frame-interval", 5);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
        this.f21816c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.a = this.f21816c.createInputSurface();
        this.f21816c.start();
        this.f21820g.putInt("request-sync", 0);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f21816c.setParameters(this.f21820g);
        }
        this.f21818e = -1;
        this.f21819f = false;
        this.f21815b = dVar;
    }

    public Surface a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (Surface) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.i = i;
        }
    }

    @RequiresApi(api = 18)
    public void c(boolean z) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
            return;
        }
        if (z) {
            this.f21816c.signalEndOfInputStream();
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.f21816c.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.f21816c.dequeueOutputBuffer(this.f21817d, this.i);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f21819f) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.f21816c.getOutputFormat();
                    c.a.v0.r.c.c(VideoEncoderCore.TAG, "encoder output format changed: " + outputFormat);
                    this.f21818e = this.f21815b.a(outputFormat);
                    if (!this.f21815b.c()) {
                        synchronized (this.f21815b) {
                            while (!this.f21815b.e()) {
                                try {
                                    this.f21815b.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f21819f = true;
                } else if (dequeueOutputBuffer < 0) {
                    c.a.v0.r.c.l(VideoEncoderCore.TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.f21817d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f21817d;
                    if (bufferInfo2.size != 0) {
                        if (!this.f21819f) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        byteBuffer.position(bufferInfo2.offset);
                        MediaCodec.BufferInfo bufferInfo3 = this.f21817d;
                        byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                        this.f21815b.b(this.f21818e, byteBuffer, this.f21817d);
                    }
                    this.f21816c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.f21821h >= 500) {
                        this.f21816c.setParameters(this.f21820g);
                        this.f21821h = System.currentTimeMillis();
                    }
                    if ((this.f21817d.flags & 4) != 0) {
                        if (z) {
                            return;
                        }
                        c.a.v0.r.c.l(VideoEncoderCore.TAG, "reached end of stream unexpectedly");
                        return;
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec mediaCodec = this.f21816c;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.f21816c.release();
                this.f21816c = null;
            }
            d dVar = this.f21815b;
            if (dVar != null) {
                try {
                    dVar.d();
                } catch (IllegalStateException e2) {
                    c.a.v0.r.c.g(e2);
                }
                this.f21815b = null;
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
            }
        }
    }
}
