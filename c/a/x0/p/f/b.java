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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f31126a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f31127b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f31128c;

    /* renamed from: d  reason: collision with root package name */
    public int f31129d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31130e;

    /* renamed from: f  reason: collision with root package name */
    public long f31131f;

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
        this.f31131f = 0L;
        this.f31128c = new MediaCodec.BufferInfo();
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", RecordConstants.AUDIO_ENCODE_SAMPLE_RATE, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger("bitrate", RecordConstants.AUDIO_ENCODE_BIT_RATE);
        createAudioFormat.setInteger("max-input-size", 163840);
        try {
            this.f31127b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f31127b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f31127b.start();
        this.f31129d = -1;
        this.f31130e = false;
        this.f31126a = dVar;
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
            ByteBuffer[] inputBuffers = this.f31127b.getInputBuffers();
            while (true) {
                dequeueInputBuffer = this.f31127b.dequeueInputBuffer(10000L);
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
            this.f31127b.queueInputBuffer(dequeueInputBuffer, i2, i3, j2, i3 <= 0 ? 4 : 0);
        }
    }

    public void c() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.f31127b.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.f31127b.dequeueOutputBuffer(this.f31128c, 10000L);
                if (dequeueOutputBuffer == -1) {
                    return;
                }
                if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f31130e) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.f31127b.getOutputFormat();
                    c.a.x0.t.c.c(AudioEncoderCore.TAG, "encoder output format changed: " + outputFormat);
                    this.f31129d = this.f31126a.a(outputFormat);
                    if (!this.f31126a.c()) {
                        synchronized (this.f31126a) {
                            while (!this.f31126a.e()) {
                                try {
                                    this.f31126a.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f31130e = true;
                } else if (dequeueOutputBuffer < 0) {
                    c.a.x0.t.c.l(AudioEncoderCore.TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.f31128c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f31128c;
                    if (bufferInfo2.size != 0) {
                        if (!this.f31130e) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        long j2 = this.f31131f;
                        if (j2 != 0 && j2 > bufferInfo2.presentationTimeUs) {
                            bufferInfo2.presentationTimeUs = j2 + 20000;
                        }
                        byteBuffer.position(this.f31128c.offset);
                        MediaCodec.BufferInfo bufferInfo3 = this.f31128c;
                        byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                        this.f31126a.b(this.f31129d, byteBuffer, this.f31128c);
                        this.f31131f = this.f31128c.presentationTimeUs;
                    }
                    this.f31127b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f31128c.flags & 4) != 0) {
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
                if (this.f31127b != null) {
                    this.f31127b.stop();
                    this.f31127b.release();
                    this.f31127b = null;
                }
                if (this.f31126a != null) {
                    this.f31126a.d();
                    this.f31126a = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
