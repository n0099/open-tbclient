package c.a.v0.o.f;

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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f21801b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f21802c;

    /* renamed from: d  reason: collision with root package name */
    public int f21803d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21804e;

    /* renamed from: f  reason: collision with root package name */
    public long f21805f;

    public b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21805f = 0L;
        this.f21802c = new MediaCodec.BufferInfo();
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", RecordConstants.AUDIO_ENCODE_SAMPLE_RATE, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger("bitrate", RecordConstants.AUDIO_ENCODE_BIT_RATE);
        createAudioFormat.setInteger("max-input-size", 163840);
        try {
            this.f21801b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f21801b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f21801b.start();
        this.f21803d = -1;
        this.f21804e = false;
        this.a = dVar;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void b(ByteBuffer byteBuffer, int i, int i2, long j) throws Exception {
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            ByteBuffer[] inputBuffers = this.f21801b.getInputBuffers();
            while (true) {
                dequeueInputBuffer = this.f21801b.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    break;
                } else if (dequeueInputBuffer == -1) {
                    c.a.v0.r.c.b("wait for MediaCodec encoder");
                }
            }
            ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
            byteBuffer2.clear();
            if (byteBuffer != null) {
                byteBuffer2.put(byteBuffer);
            }
            this.f21801b.queueInputBuffer(dequeueInputBuffer, i, i2, j, i2 <= 0 ? 4 : 0);
        }
    }

    public void c() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.f21801b.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.f21801b.dequeueOutputBuffer(this.f21802c, 10000L);
                if (dequeueOutputBuffer == -1) {
                    return;
                }
                if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f21804e) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.f21801b.getOutputFormat();
                    c.a.v0.r.c.c(AudioEncoderCore.TAG, "encoder output format changed: " + outputFormat);
                    this.f21803d = this.a.a(outputFormat);
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
                    this.f21804e = true;
                } else if (dequeueOutputBuffer < 0) {
                    c.a.v0.r.c.l(AudioEncoderCore.TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.f21802c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f21802c;
                    if (bufferInfo2.size != 0) {
                        if (!this.f21804e) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        long j = this.f21805f;
                        if (j != 0 && j > bufferInfo2.presentationTimeUs) {
                            bufferInfo2.presentationTimeUs = j + 20000;
                        }
                        byteBuffer.position(this.f21802c.offset);
                        MediaCodec.BufferInfo bufferInfo3 = this.f21802c;
                        byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                        this.a.b(this.f21803d, byteBuffer, this.f21802c);
                        this.f21805f = this.f21802c.presentationTimeUs;
                    }
                    this.f21801b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f21802c.flags & 4) != 0) {
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
                if (this.f21801b != null) {
                    this.f21801b.stop();
                    this.f21801b.release();
                    this.f21801b = null;
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
