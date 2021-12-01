package c.a.x0.p.f;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.faceunity.encoder.AudioEncoderCore;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f27153b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f27154c;

    /* renamed from: d  reason: collision with root package name */
    public int f27155d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27156e;

    /* renamed from: f  reason: collision with root package name */
    public long f27157f;

    public b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27157f = 0L;
        this.f27154c = new MediaCodec.BufferInfo();
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", RecordConstants.AUDIO_ENCODE_SAMPLE_RATE, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger("bitrate", RecordConstants.AUDIO_ENCODE_BIT_RATE);
        createAudioFormat.setInteger("max-input-size", 163840);
        try {
            this.f27153b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f27153b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f27153b.start();
        this.f27155d = -1;
        this.f27156e = false;
        this.a = dVar;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void b(ByteBuffer byteBuffer, int i2, int i3, long j2) throws Exception {
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            ByteBuffer[] inputBuffers = this.f27153b.getInputBuffers();
            while (true) {
                dequeueInputBuffer = this.f27153b.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    break;
                } else if (dequeueInputBuffer == -1) {
                    c.a.x0.t.c.b("wait for MediaCodec encoder");
                }
            }
            ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
            byteBuffer2.clear();
            if (byteBuffer != null) {
                byteBuffer2.put(byteBuffer);
            }
            this.f27153b.queueInputBuffer(dequeueInputBuffer, i2, i3, j2, i3 <= 0 ? 4 : 0);
        }
    }

    public void c() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.f27153b.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.f27153b.dequeueOutputBuffer(this.f27154c, 10000L);
                if (dequeueOutputBuffer == -1) {
                    return;
                }
                if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f27156e) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.f27153b.getOutputFormat();
                    c.a.x0.t.c.c(AudioEncoderCore.TAG, "encoder output format changed: " + outputFormat);
                    this.f27155d = this.a.a(outputFormat);
                    if (!this.a.c()) {
                        synchronized (this.a) {
                            while (!this.a.e()) {
                                try {
                                    this.a.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f27156e = true;
                } else if (dequeueOutputBuffer < 0) {
                    c.a.x0.t.c.l(AudioEncoderCore.TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.f27154c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f27154c;
                    if (bufferInfo2.size != 0) {
                        if (!this.f27156e) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        long j2 = this.f27157f;
                        if (j2 != 0 && j2 > bufferInfo2.presentationTimeUs) {
                            bufferInfo2.presentationTimeUs = j2 + 20000;
                        }
                        byteBuffer.position(this.f27154c.offset);
                        MediaCodec.BufferInfo bufferInfo3 = this.f27154c;
                        byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                        this.a.b(this.f27155d, byteBuffer, this.f27154c);
                        this.f27157f = this.f27154c.presentationTimeUs;
                    }
                    this.f27153b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f27154c.flags & 4) != 0) {
                        return;
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.f27153b != null) {
                    this.f27153b.stop();
                    this.f27153b.release();
                    this.f27153b = null;
                }
                if (this.a != null) {
                    this.a.d();
                    this.a = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
