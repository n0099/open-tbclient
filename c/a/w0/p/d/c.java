package c.a.w0.p.d;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MediaMuxer f30781a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f30782b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f30783c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30784d;

    /* renamed from: e  reason: collision with root package name */
    public long f30785e;

    /* renamed from: f  reason: collision with root package name */
    public long f30786f;

    /* renamed from: g  reason: collision with root package name */
    public int f30787g;

    /* renamed from: h  reason: collision with root package name */
    public int f30788h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f30789i;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30784d = false;
    }

    public static MediaCodecInfo b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i2 = 0; i2 < codecCount; i2++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
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
                if (c.a.w0.l.d.f.g(outputFormat) == 1) {
                    outputFormat.setString("qlc", "123adb");
                    outputFormat.setString("adc", "123adb");
                    addTrack = this.f30781a.addTrack(outputFormat);
                    this.f30787g = addTrack;
                } else {
                    addTrack = this.f30781a.addTrack(outputFormat);
                    this.f30788h = addTrack;
                }
                if (this.f30787g != -1) {
                    this.f30781a.start();
                    this.f30789i = true;
                    notifyAll();
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
                String str = "stop exception occur: " + e2.getLocalizedMessage();
            }
            boolean z = this.f30784d;
            this.f30784d = false;
        }
    }

    public void d(int i2, int i3, int i4, int i5, int i6, int i7, String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str}) == null) {
            if (b("video/avc") == null || b("audio/mp4a-latm") == null) {
                throw new Exception("cannot find suitable codec");
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
            createVideoFormat.setInteger("bitrate", i5);
            createVideoFormat.setInteger("frame-rate", 30);
            createVideoFormat.setInteger("i-frame-interval", 5);
            createVideoFormat.setInteger("color-format", i4);
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
            this.f30782b = createEncoderByType;
            createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.f30782b.start();
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            this.f30781a = new MediaMuxer(str, 0);
            this.f30789i = false;
            this.f30787g = -1;
            this.f30788h = -1;
            this.f30785e = -1L;
            this.f30786f = -1L;
            this.f30783c = new MediaCodec.BufferInfo();
            new MediaCodec.BufferInfo();
            this.f30784d = true;
        }
    }

    public final void e(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048579, this, mediaCodec, bufferInfo) != null) {
            return;
        }
        int i2 = mediaCodec == this.f30782b ? this.f30787g : this.f30788h;
        while (true) {
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    i2 = a(mediaCodec);
                } else if (dequeueOutputBuffer == -1) {
                    return;
                } else {
                    if (dequeueOutputBuffer < 0) {
                        String str = "drainEncoder unexpected result: " + dequeueOutputBuffer;
                    } else if ((bufferInfo.flags & 2) == 0) {
                        if (bufferInfo.size != 0) {
                            ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                            if (byteBuffer == null) {
                                throw new RuntimeException("drainEncoder get outputBuffer " + dequeueOutputBuffer + " was null");
                            }
                            synchronized (this) {
                                if (!this.f30789i) {
                                    wait();
                                }
                            }
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            this.f30781a.writeSampleData(i2, byteBuffer, bufferInfo);
                        }
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    public final void f(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, byte[] bArr, long j2) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{mediaCodec, bufferInfo, bArr, Long.valueOf(j2)}) == null) && this.f30784d) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
            ByteBuffer byteBuffer = mediaCodec.getInputBuffers()[dequeueInputBuffer];
            if (dequeueInputBuffer >= 0) {
                byteBuffer.clear();
                byteBuffer.put(bArr);
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j2, 0);
            }
            e(mediaCodec, bufferInfo);
        }
    }

    public void g(byte[] bArr) throws Exception {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
            int i2 = (this.f30785e > (-1L) ? 1 : (this.f30785e == (-1L) ? 0 : -1));
            long nanoTime = System.nanoTime();
            if (i2 == 0) {
                this.f30785e = nanoTime;
                j2 = 0;
            } else {
                j2 = (nanoTime - this.f30785e) / 1000;
            }
            long j3 = this.f30786f;
            if (j2 <= j3) {
                j2 += (j3 - j2) + 1000;
            }
            long j4 = j2;
            this.f30786f = j4;
            f(this.f30782b, this.f30783c, bArr, j4);
        }
    }

    public final void h() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MediaCodec mediaCodec = this.f30782b;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.f30782b.release();
                this.f30782b = null;
            }
            MediaMuxer mediaMuxer = this.f30781a;
            if (mediaMuxer != null) {
                mediaMuxer.stop();
                this.f30781a.release();
                this.f30781a = null;
            }
        }
    }
}
