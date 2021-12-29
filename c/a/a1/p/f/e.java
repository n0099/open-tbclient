package c.a.a1.p.f;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import c.a.a1.t.m;
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
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface a;

    /* renamed from: b  reason: collision with root package name */
    public d f1457b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec f1458c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f1459d;

    /* renamed from: e  reason: collision with root package name */
    public int f1460e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1461f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f1462g;

    /* renamed from: h  reason: collision with root package name */
    public long f1463h;

    /* renamed from: i  reason: collision with root package name */
    public int f1464i;

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
        this.f1462g = new Bundle();
        this.f1463h = 0L;
        this.f1464i = 10000;
        String str = "video/hevc";
        str = (!z || m.m("video/hevc") == null) ? "video/avc" : "video/avc";
        this.f1459d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i2, i3);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", i4);
        createVideoFormat.setInteger("frame-rate", 30);
        createVideoFormat.setInteger("i-frame-interval", 5);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
        this.f1458c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.a = this.f1458c.createInputSurface();
        this.f1458c.start();
        this.f1462g.putInt("request-sync", 0);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1458c.setParameters(this.f1462g);
        }
        this.f1460e = -1;
        this.f1461f = false;
        this.f1457b = dVar;
    }

    public Surface a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (Surface) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f1464i = i2;
        }
    }

    @RequiresApi(api = 18)
    public void c(boolean z) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
            return;
        }
        if (z) {
            this.f1458c.signalEndOfInputStream();
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.f1458c.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.f1458c.dequeueOutputBuffer(this.f1459d, this.f1464i);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f1461f) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.f1458c.getOutputFormat();
                    c.a.a1.t.c.c(VideoEncoderCore.TAG, "encoder output format changed: " + outputFormat);
                    this.f1460e = this.f1457b.a(outputFormat);
                    if (!this.f1457b.c()) {
                        synchronized (this.f1457b) {
                            while (!this.f1457b.e()) {
                                try {
                                    this.f1457b.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f1461f = true;
                } else if (dequeueOutputBuffer < 0) {
                    c.a.a1.t.c.l(VideoEncoderCore.TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.f1459d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f1459d;
                    if (bufferInfo2.size != 0) {
                        if (!this.f1461f) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        byteBuffer.position(bufferInfo2.offset);
                        MediaCodec.BufferInfo bufferInfo3 = this.f1459d;
                        byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                        this.f1457b.b(this.f1460e, byteBuffer, this.f1459d);
                    }
                    this.f1458c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.f1463h >= 500) {
                        this.f1458c.setParameters(this.f1462g);
                        this.f1463h = System.currentTimeMillis();
                    }
                    if ((this.f1459d.flags & 4) != 0) {
                        if (z) {
                            return;
                        }
                        c.a.a1.t.c.l(VideoEncoderCore.TAG, "reached end of stream unexpectedly");
                        return;
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec mediaCodec = this.f1458c;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.f1458c.release();
                this.f1458c = null;
            }
            d dVar = this.f1457b;
            if (dVar != null) {
                try {
                    dVar.d();
                } catch (IllegalStateException e2) {
                    c.a.a1.t.c.g(e2);
                }
                this.f1457b = null;
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
