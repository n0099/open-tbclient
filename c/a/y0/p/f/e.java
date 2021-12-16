package c.a.y0.p.f;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import c.a.y0.t.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.VideoEncoderCore;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface a;

    /* renamed from: b  reason: collision with root package name */
    public d f27560b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec f27561c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f27562d;

    /* renamed from: e  reason: collision with root package name */
    public int f27563e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27564f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f27565g;

    /* renamed from: h  reason: collision with root package name */
    public long f27566h;

    /* renamed from: i  reason: collision with root package name */
    public int f27567i;

    @TargetApi(18)
    public e(int i2, int i3, int i4, boolean z, d dVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27565g = new Bundle();
        this.f27566h = 0L;
        this.f27567i = 10000;
        String str = "video/hevc";
        str = (!z || m.m("video/hevc") == null) ? "video/avc" : "video/avc";
        this.f27562d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i2, i3);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", i4);
        createVideoFormat.setInteger("frame-rate", 30);
        createVideoFormat.setInteger("i-frame-interval", 5);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
        this.f27561c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.a = this.f27561c.createInputSurface();
        this.f27561c.start();
        this.f27565g.putInt("request-sync", 0);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f27561c.setParameters(this.f27565g);
        }
        this.f27563e = -1;
        this.f27564f = false;
        this.f27560b = dVar;
    }

    public Surface a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (Surface) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f27567i = i2;
        }
    }

    @RequiresApi(api = 18)
    public void c(boolean z) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
            return;
        }
        if (z) {
            this.f27561c.signalEndOfInputStream();
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.f27561c.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.f27561c.dequeueOutputBuffer(this.f27562d, this.f27567i);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f27564f) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.f27561c.getOutputFormat();
                    c.a.y0.t.c.c(VideoEncoderCore.TAG, "encoder output format changed: " + outputFormat);
                    this.f27563e = this.f27560b.a(outputFormat);
                    if (!this.f27560b.c()) {
                        synchronized (this.f27560b) {
                            while (!this.f27560b.e()) {
                                try {
                                    this.f27560b.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f27564f = true;
                } else if (dequeueOutputBuffer < 0) {
                    c.a.y0.t.c.l(VideoEncoderCore.TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.f27562d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f27562d;
                    if (bufferInfo2.size != 0) {
                        if (!this.f27564f) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        byteBuffer.position(bufferInfo2.offset);
                        MediaCodec.BufferInfo bufferInfo3 = this.f27562d;
                        byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                        this.f27560b.b(this.f27563e, byteBuffer, this.f27562d);
                    }
                    this.f27561c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.f27566h >= 500) {
                        this.f27561c.setParameters(this.f27565g);
                        this.f27566h = System.currentTimeMillis();
                    }
                    if ((this.f27562d.flags & 4) != 0) {
                        if (z) {
                            return;
                        }
                        c.a.y0.t.c.l(VideoEncoderCore.TAG, "reached end of stream unexpectedly");
                        return;
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec mediaCodec = this.f27561c;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.f27561c.release();
                this.f27561c = null;
            }
            d dVar = this.f27560b;
            if (dVar != null) {
                try {
                    dVar.d();
                } catch (IllegalStateException e2) {
                    c.a.y0.t.c.g(e2);
                }
                this.f27560b = null;
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
