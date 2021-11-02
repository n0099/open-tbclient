package b.a.x0.p.f;

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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f29869a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f29870b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f29871c;

    /* renamed from: d  reason: collision with root package name */
    public int f29872d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29873e;

    /* renamed from: f  reason: collision with root package name */
    public long f29874f;

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
        this.f29874f = 0L;
        this.f29871c = new MediaCodec.BufferInfo();
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", RecordConstants.AUDIO_ENCODE_SAMPLE_RATE, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger("bitrate", RecordConstants.AUDIO_ENCODE_BIT_RATE);
        createAudioFormat.setInteger("max-input-size", 163840);
        try {
            this.f29870b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f29870b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f29870b.start();
        this.f29872d = -1;
        this.f29873e = false;
        this.f29869a = dVar;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void b(ByteBuffer byteBuffer, int i2, int i3, long j) throws Exception {
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            ByteBuffer[] inputBuffers = this.f29870b.getInputBuffers();
            while (true) {
                dequeueInputBuffer = this.f29870b.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    break;
                } else if (dequeueInputBuffer == -1) {
                    b.a.x0.t.c.b("wait for MediaCodec encoder");
                }
            }
            ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
            byteBuffer2.clear();
            if (byteBuffer != null) {
                byteBuffer2.put(byteBuffer);
            }
            this.f29870b.queueInputBuffer(dequeueInputBuffer, i2, i3, j, i3 <= 0 ? 4 : 0);
        }
    }

    public void c() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.f29870b.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.f29870b.dequeueOutputBuffer(this.f29871c, 10000L);
                if (dequeueOutputBuffer == -1) {
                    return;
                }
                if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f29873e) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.f29870b.getOutputFormat();
                    b.a.x0.t.c.c(AudioEncoderCore.TAG, "encoder output format changed: " + outputFormat);
                    this.f29872d = this.f29869a.a(outputFormat);
                    if (!this.f29869a.c()) {
                        synchronized (this.f29869a) {
                            while (!this.f29869a.e()) {
                                try {
                                    this.f29869a.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f29873e = true;
                } else if (dequeueOutputBuffer < 0) {
                    b.a.x0.t.c.l(AudioEncoderCore.TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.f29871c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f29871c;
                    if (bufferInfo2.size != 0) {
                        if (!this.f29873e) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        long j = this.f29874f;
                        if (j != 0 && j > bufferInfo2.presentationTimeUs) {
                            bufferInfo2.presentationTimeUs = j + 20000;
                        }
                        byteBuffer.position(this.f29871c.offset);
                        MediaCodec.BufferInfo bufferInfo3 = this.f29871c;
                        byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                        this.f29869a.b(this.f29872d, byteBuffer, this.f29871c);
                        this.f29874f = this.f29871c.presentationTimeUs;
                    }
                    this.f29870b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f29871c.flags & 4) != 0) {
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
                if (this.f29870b != null) {
                    this.f29870b.stop();
                    this.f29870b.release();
                    this.f29870b = null;
                }
                if (this.f29869a != null) {
                    this.f29869a.d();
                    this.f29869a = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
