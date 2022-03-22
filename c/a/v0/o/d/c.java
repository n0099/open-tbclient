package c.a.v0.o.d;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaMuxer a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f21745b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f21746c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21747d;

    /* renamed from: e  reason: collision with root package name */
    public long f21748e;

    /* renamed from: f  reason: collision with root package name */
    public long f21749f;

    /* renamed from: g  reason: collision with root package name */
    public int f21750g;

    /* renamed from: h  reason: collision with root package name */
    public int f21751h;
    public volatile boolean i;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21747d = false;
    }

    public static MediaCodecInfo b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                if (codecInfoAt.isEncoder()) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            return codecInfoAt;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (MediaCodecInfo) invokeL.objValue;
    }

    public final int a(MediaCodec mediaCodec) {
        InterceptResult invokeL;
        int addTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaCodec)) == null) {
            synchronized (this) {
                MediaFormat outputFormat = mediaCodec.getOutputFormat();
                if (c.a.v0.l.d.f.g(outputFormat) == 1) {
                    outputFormat.setString("qlc", "123adb");
                    outputFormat.setString("adc", "123adb");
                    addTrack = this.a.addTrack(outputFormat);
                    this.f21750g = addTrack;
                } else {
                    addTrack = this.a.addTrack(outputFormat);
                    this.f21751h = addTrack;
                }
                if (this.f21750g != -1) {
                    this.a.start();
                    this.i = true;
                    notifyAll();
                    Log.i("HWRecorder", "MediaMuxer has added all track, notifyAll");
                }
            }
            return addTrack;
        }
        return invokeL.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                h();
            } catch (Exception e2) {
                Log.e("HWRecorder", "stop exception occur: " + e2.getLocalizedMessage());
            }
            if (this.f21747d) {
                Log.i("HWRecorder", "Recorder released");
            }
            this.f21747d = false;
        }
    }

    public void d(int i, int i2, int i3, int i4, int i5, int i6, String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str}) == null) {
            if (b("video/avc") == null || b("audio/mp4a-latm") == null) {
                throw new Exception("cannot find suitable codec");
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
            createVideoFormat.setInteger("bitrate", i4);
            createVideoFormat.setInteger("frame-rate", 30);
            createVideoFormat.setInteger("i-frame-interval", 5);
            createVideoFormat.setInteger("color-format", i3);
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
            this.f21745b = createEncoderByType;
            createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.f21745b.start();
            File file = new File(str);
            if (file.exists() && !file.delete()) {
                Log.w("HWRecorder", "delete file failed");
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            this.a = new MediaMuxer(str, 0);
            this.i = false;
            this.f21750g = -1;
            this.f21751h = -1;
            this.f21748e = -1L;
            this.f21749f = -1L;
            this.f21746c = new MediaCodec.BufferInfo();
            new MediaCodec.BufferInfo();
            this.f21747d = true;
            Log.i("HWRecorder", "Recorder initialized");
        }
    }

    public final void e(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048579, this, mediaCodec, bufferInfo) != null) {
            return;
        }
        int i = mediaCodec == this.f21745b ? this.f21750g : this.f21751h;
        while (true) {
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    i = a(mediaCodec);
                } else if (dequeueOutputBuffer == -1) {
                    return;
                } else {
                    if (dequeueOutputBuffer < 0) {
                        Log.w("HWRecorder", "drainEncoder unexpected result: " + dequeueOutputBuffer);
                    } else if ((bufferInfo.flags & 2) == 0) {
                        if (bufferInfo.size != 0) {
                            ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                            if (byteBuffer == null) {
                                throw new RuntimeException("drainEncoder get outputBuffer " + dequeueOutputBuffer + " was null");
                            }
                            synchronized (this) {
                                if (!this.i) {
                                    wait();
                                }
                            }
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            this.a.writeSampleData(i, byteBuffer, bufferInfo);
                        }
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    public final void f(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, byte[] bArr, long j) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{mediaCodec, bufferInfo, bArr, Long.valueOf(j)}) == null) {
            if (!this.f21747d) {
                Log.e("HWRecorder", "Recorder must be initialized!");
                return;
            }
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
            ByteBuffer byteBuffer = mediaCodec.getInputBuffers()[dequeueInputBuffer];
            if (dequeueInputBuffer >= 0) {
                byteBuffer.clear();
                byteBuffer.put(bArr);
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
            }
            e(mediaCodec, bufferInfo);
        }
    }

    public void g(byte[] bArr) throws Exception {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
            int i = (this.f21748e > (-1L) ? 1 : (this.f21748e == (-1L) ? 0 : -1));
            long nanoTime = System.nanoTime();
            if (i == 0) {
                this.f21748e = nanoTime;
                j = 0;
            } else {
                j = (nanoTime - this.f21748e) / 1000;
            }
            long j2 = this.f21749f;
            if (j <= j2) {
                j += (j2 - j) + 1000;
            }
            long j3 = j;
            this.f21749f = j3;
            f(this.f21745b, this.f21746c, bArr, j3);
        }
    }

    public final void h() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MediaCodec mediaCodec = this.f21745b;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.f21745b.release();
                this.f21745b = null;
            }
            MediaMuxer mediaMuxer = this.a;
            if (mediaMuxer != null) {
                mediaMuxer.stop();
                this.a.release();
                this.a = null;
            }
        }
    }
}
