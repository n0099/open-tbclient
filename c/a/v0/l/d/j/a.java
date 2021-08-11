package c.a.v0.l.d.j;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.l.d.d;
import c.a.v0.t.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.record.EncoderParams;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.webrtc.HardwareVideoEncoder;
@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MediaCodec f30408a;

    /* renamed from: b  reason: collision with root package name */
    public MediaFormat f30409b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer[] f30410c;

    /* renamed from: d  reason: collision with root package name */
    public ByteBuffer[] f30411d;

    /* renamed from: e  reason: collision with root package name */
    public BufferedOutputStream f30412e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30413f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f30414g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f30415h;

    /* renamed from: i  reason: collision with root package name */
    public int f30416i;

    /* renamed from: j  reason: collision with root package name */
    public int f30417j;
    public int k;
    public int l;
    public c.a.v0.l.d.j.c.a m;

    public a(int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = i3;
        this.l = g(i2);
        MediaCodecInfo h2 = h("audio/mp4a-latm");
        if (h2 == null) {
            c.a.v0.l.d.j.c.a aVar = this.m;
            if (aVar != null) {
                aVar.onExceptionThrown("not suport aac encoder");
                return;
            }
            return;
        }
        this.f30408a = MediaCodec.createByCodecName(h2.getName());
        MediaFormat mediaFormat = new MediaFormat();
        this.f30409b = mediaFormat;
        mediaFormat.setString("mime", "audio/mp4a-latm");
        this.f30409b.setInteger("aac-profile", 2);
        this.f30409b.setInteger("sample-rate", i2);
        this.f30409b.setInteger("channel-count", i3);
        this.f30409b.setInteger("bitrate", EncoderParams.AUDIO_BIT_RATE);
        this.f30409b.setInteger("max-input-size", 8192);
        this.f30409b.setInteger(HardwareVideoEncoder.KEY_BITRATE_MODE, 16);
        this.f30408a.configure(this.f30409b, (Surface) null, (MediaCrypto) null, 1);
        this.f30408a.start();
        this.f30410c = this.f30408a.getInputBuffers();
        this.f30411d = this.f30408a.getOutputBuffers();
        this.f30414g = ByteBuffer.allocateDirect(8192);
        this.f30415h = new byte[4096];
    }

    @Override // c.a.v0.l.d.d
    public void a() throws IOException {
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.j("VideoMuxer: ", "----set BUFFER_FLAG_END_OF_STREAM to encoder-----");
            do {
                dequeueInputBuffer = this.f30408a.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    c.j("VideoMuxer: ", "----MediaCodec.BUFFER_FLAG_END_OF_STREAM-----");
                    this.f30408a.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                }
                i();
            } while (dequeueInputBuffer < 0);
            while (!this.f30413f) {
                i();
            }
        }
    }

    @Override // c.a.v0.l.d.d
    public void b(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f30412e = new BufferedOutputStream(new FileOutputStream(str));
        }
    }

    @Override // c.a.v0.l.d.d
    public int c(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3)) == null) {
            if (this.f30414g.capacity() < i3) {
                this.f30414g = ByteBuffer.allocateDirect(i3);
            }
            this.f30414g.clear();
            this.f30414g.put(bArr, i2, i3);
            this.f30414g.flip();
            while (this.f30414g.hasRemaining()) {
                int dequeueInputBuffer = this.f30408a.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer = this.f30410c[dequeueInputBuffer];
                    int min = Math.min(byteBuffer.capacity(), this.f30414g.remaining());
                    if (min != this.f30415h.length) {
                        this.f30415h = new byte[min];
                    }
                    this.f30414g.get(this.f30415h, 0, min);
                    byteBuffer.clear();
                    byteBuffer.put(this.f30415h);
                    this.f30408a.queueInputBuffer(dequeueInputBuffer, 0, min, 0L, 0);
                    this.f30416i += min;
                }
                i();
            }
            return 0;
        }
        return invokeLII.intValue;
    }

    @Override // c.a.v0.l.d.d
    public void d(c.a.v0.l.d.j.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public final void e(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, bArr, i2) == null) {
            int i3 = this.l;
            int i4 = this.k;
            bArr[0] = -1;
            bArr[1] = -7;
            bArr[2] = (byte) (64 + (i3 << 2) + (i4 >> 2));
            bArr[3] = (byte) (((i4 & 3) << 6) + (i2 >> 11));
            bArr[4] = (byte) ((i2 & 2047) >> 3);
            bArr[5] = (byte) (((i2 & 7) << 5) + 31);
            bArr[6] = -4;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                this.f30408a.stop();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                this.f30408a.release();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f30408a = null;
            try {
                this.f30412e.flush();
                this.f30412e.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    public final int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            switch (i2) {
                case 7350:
                    return 12;
                case 8000:
                    return 11;
                case 11025:
                    return 10;
                case 12000:
                    return 9;
                case 16000:
                    return 8;
                case 22050:
                    return 7;
                case 24000:
                    return 6;
                case 32000:
                    return 5;
                case MediaEncodeParams.AUDIO_SAMPLE_RATE /* 48000 */:
                    return 3;
                case 64000:
                    return 2;
                case 88200:
                    return 1;
                case 96000:
                    return 0;
                default:
                    return 4;
            }
        }
        return invokeI.intValue;
    }

    public final MediaCodecInfo h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
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

    public final void i() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.f30408a.dequeueOutputBuffer(bufferInfo, 10000L);
            if (dequeueOutputBuffer == -2) {
                this.f30409b = this.f30408a.getOutputFormat();
            } else if (dequeueOutputBuffer == -3) {
                this.f30411d = this.f30408a.getOutputBuffers();
            } else if (dequeueOutputBuffer == -1) {
                c.j("VideoMuxer", "writeOutput INFO_TRY_AGAIN_LATER");
            } else if (dequeueOutputBuffer >= 0) {
                if ((bufferInfo.flags & 2) != 0) {
                    this.f30408a.releaseOutputBuffer(dequeueOutputBuffer, false);
                    return;
                }
                int i2 = bufferInfo.size;
                if (i2 > 0) {
                    int i3 = i2 + 7;
                    ByteBuffer byteBuffer = this.f30411d[dequeueOutputBuffer];
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + i2);
                    byte[] bArr = new byte[i3];
                    e(bArr, i3);
                    byteBuffer.get(bArr, 7, i2);
                    byteBuffer.position(bufferInfo.offset);
                    this.f30412e.write(bArr, 0, i3);
                    this.f30417j += bufferInfo.size;
                    byteBuffer.clear();
                }
                this.f30408a.releaseOutputBuffer(dequeueOutputBuffer, false);
                if ((bufferInfo.flags & 4) != 0) {
                    this.f30413f = true;
                    try {
                        f();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (this.m != null) {
                        c.j("VideoMuxer: ", "----Encode done-----,numBytesSubmitted:" + this.f30416i + ",numBytesDequeued:" + this.f30417j);
                        this.m.onFinishedWriting(true);
                    }
                }
            }
        }
    }
}
