package c.a.v0.p.f;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import c.a.v0.t.m;
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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Surface f30549a;

    /* renamed from: b  reason: collision with root package name */
    public d f30550b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec f30551c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f30552d;

    /* renamed from: e  reason: collision with root package name */
    public int f30553e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30554f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f30555g;

    /* renamed from: h  reason: collision with root package name */
    public long f30556h;

    /* renamed from: i  reason: collision with root package name */
    public int f30557i;

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
        this.f30555g = new Bundle();
        this.f30556h = 0L;
        this.f30557i = 10000;
        String str = "video/hevc";
        str = (!z || m.m("video/hevc") == null) ? "video/avc" : "video/avc";
        this.f30552d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i2, i3);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", i4);
        createVideoFormat.setInteger("frame-rate", 30);
        createVideoFormat.setInteger("i-frame-interval", 5);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
        this.f30551c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f30549a = this.f30551c.createInputSurface();
        this.f30551c.start();
        this.f30555g.putInt("request-sync", 0);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f30551c.setParameters(this.f30555g);
        }
        this.f30553e = -1;
        this.f30554f = false;
        this.f30550b = dVar;
    }

    public Surface a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30549a : (Surface) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f30557i = i2;
        }
    }

    @RequiresApi(api = 18)
    public void c(boolean z) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
            return;
        }
        if (z) {
            this.f30551c.signalEndOfInputStream();
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.f30551c.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.f30551c.dequeueOutputBuffer(this.f30552d, this.f30557i);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f30554f) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.f30551c.getOutputFormat();
                    c.a.v0.t.c.c(VideoEncoderCore.TAG, "encoder output format changed: " + outputFormat);
                    this.f30553e = this.f30550b.a(outputFormat);
                    if (!this.f30550b.c()) {
                        synchronized (this.f30550b) {
                            while (!this.f30550b.e()) {
                                try {
                                    this.f30550b.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f30554f = true;
                } else if (dequeueOutputBuffer < 0) {
                    c.a.v0.t.c.l(VideoEncoderCore.TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.f30552d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f30552d;
                    if (bufferInfo2.size != 0) {
                        if (!this.f30554f) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        byteBuffer.position(bufferInfo2.offset);
                        MediaCodec.BufferInfo bufferInfo3 = this.f30552d;
                        byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                        this.f30550b.b(this.f30553e, byteBuffer, this.f30552d);
                    }
                    this.f30551c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.f30556h >= 500) {
                        this.f30551c.setParameters(this.f30555g);
                        this.f30556h = System.currentTimeMillis();
                    }
                    if ((this.f30552d.flags & 4) != 0) {
                        if (z) {
                            return;
                        }
                        c.a.v0.t.c.l(VideoEncoderCore.TAG, "reached end of stream unexpectedly");
                        return;
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec mediaCodec = this.f30551c;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.f30551c.release();
                this.f30551c = null;
            }
            d dVar = this.f30550b;
            if (dVar != null) {
                try {
                    dVar.d();
                } catch (IllegalStateException e2) {
                    c.a.v0.t.c.g(e2);
                }
                this.f30550b = null;
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
