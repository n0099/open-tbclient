package c.a.x0.i;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class i implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f26919b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f26920c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f26921d;

    /* renamed from: e  reason: collision with root package name */
    public MediaExtractor f26922e;

    /* renamed from: f  reason: collision with root package name */
    public MediaFormat f26923f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer[] f26924g;

    /* renamed from: h  reason: collision with root package name */
    public ByteBuffer[] f26925h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f26926i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f26927j;

    /* renamed from: k  reason: collision with root package name */
    public long f26928k;
    public volatile boolean l;
    public j m;

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0073 A[EDGE_INSN: B:46:0x0073->B:28:0x0073 ?: BREAK  , SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i(String str) throws Exception {
        int i2;
        MediaFormat mediaFormat;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26928k = -1L;
        this.f26922e = new MediaExtractor();
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f26922e = mediaExtractor;
            mediaExtractor.setDataSource(str);
        } catch (IOException unused) {
            try {
                Thread.sleep(25L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            try {
                try {
                    MediaExtractor mediaExtractor2 = new MediaExtractor();
                    this.f26922e = mediaExtractor2;
                    mediaExtractor2.setDataSource(str);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                    MediaExtractor mediaExtractor3 = new MediaExtractor();
                    this.f26922e = mediaExtractor3;
                    mediaExtractor3.setDataSource(str);
                    i2 = 0;
                    while (true) {
                        if (i2 >= this.f26922e.getTrackCount()) {
                        }
                        i2++;
                    }
                    mediaFormat = this.f26923f;
                    if (mediaFormat == null) {
                    }
                }
            } catch (IOException unused2) {
                Thread.sleep(25L);
                MediaExtractor mediaExtractor32 = new MediaExtractor();
                this.f26922e = mediaExtractor32;
                mediaExtractor32.setDataSource(str);
                i2 = 0;
                while (true) {
                    if (i2 >= this.f26922e.getTrackCount()) {
                    }
                    i2++;
                }
                mediaFormat = this.f26923f;
                if (mediaFormat == null) {
                }
            }
        }
        i2 = 0;
        while (true) {
            if (i2 >= this.f26922e.getTrackCount()) {
                break;
            }
            MediaFormat trackFormat = this.f26922e.getTrackFormat(i2);
            String string = trackFormat.getString("mime");
            if (!TextUtils.isEmpty(string) && string.startsWith("audio/")) {
                this.f26922e.selectTrack(i2);
                this.f26923f = trackFormat;
                break;
            }
            i2++;
        }
        mediaFormat = this.f26923f;
        if (mediaFormat == null) {
            throw new NullPointerException("format is null");
        }
        String string2 = mediaFormat.getString("mime");
        this.a = this.f26923f.getLong("durationUs");
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string2);
        this.f26921d = createDecoderByType;
        createDecoderByType.configure(this.f26923f, (Surface) null, (MediaCrypto) null, 0);
        this.f26921d.start();
        this.f26924g = this.f26921d.getInputBuffers();
        this.f26925h = this.f26921d.getOutputBuffers();
        this.f26920c = new MediaCodec.BufferInfo();
    }

    @Override // c.a.x0.i.a
    public int a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (this.f26923f.containsKey("bit-width") ? this.f26923f.getInteger("bit-width") : 16) / 8;
        }
        return invokeV.intValue;
    }

    @Override // c.a.x0.i.a
    public int b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f26923f.containsKey("sample-rate")) {
                return this.f26923f.getInteger("sample-rate");
            }
            throw new IOException("Not a valid audio file");
        }
        return invokeV.intValue;
    }

    @Override // c.a.x0.i.a
    public boolean c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            i();
            int dequeueOutputBuffer = this.f26921d.dequeueOutputBuffer(this.f26920c, 10000L);
            if (dequeueOutputBuffer < 0) {
                if (dequeueOutputBuffer != -1) {
                    if (dequeueOutputBuffer == -2) {
                        MediaFormat outputFormat = this.f26921d.getOutputFormat();
                        this.f26923f = outputFormat;
                        j jVar = this.m;
                        if (jVar != null) {
                            jVar.a(outputFormat);
                        }
                    } else if (dequeueOutputBuffer == -3) {
                        this.f26925h = this.f26921d.getOutputBuffers();
                    } else {
                        str = "decodeChunk,res=" + dequeueOutputBuffer;
                    }
                    return false;
                }
                str = "decodeChunk:INFO_TRY_AGAIN_LATER";
                c.a.x0.t.c.j("VideoMuxer", str);
                return false;
            }
            MediaCodec.BufferInfo bufferInfo = this.f26920c;
            if ((bufferInfo.flags & 2) != 0) {
                this.f26921d.releaseOutputBuffer(dequeueOutputBuffer, false);
                return false;
            }
            int i2 = bufferInfo.size;
            if (i2 - bufferInfo.offset < 0) {
                ByteBuffer byteBuffer = this.f26925h[dequeueOutputBuffer];
                byte[] bArr = this.f26926i;
                if (bArr == null || bArr.length != i2) {
                    this.f26926i = new byte[this.f26920c.size];
                }
                byteBuffer.get(this.f26926i);
                byteBuffer.clear();
                this.f26921d.releaseOutputBuffer(dequeueOutputBuffer, false);
            } else {
                j(dequeueOutputBuffer);
            }
            if ((this.f26920c.flags & 4) != 0) {
                long j2 = this.f26928k;
                if (j2 <= 0) {
                    j2 = this.a;
                }
                this.f26919b = j2;
                this.f26927j = true;
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.x0.i.a
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                this.f26921d.stop();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                this.f26921d.release();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f26921d = null;
            try {
                this.f26922e.release();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.f26922e = null;
        }
    }

    @Override // c.a.x0.i.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l = false;
            this.f26927j = false;
            this.f26920c.flags = 0;
        }
    }

    @Override // c.a.x0.i.a
    public int e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f26923f.containsKey("channel-count")) {
                return this.f26923f.getInteger("channel-count");
            }
            throw new IOException("Not a valid audio file");
        }
        return invokeV.intValue;
    }

    @Override // c.a.x0.i.a
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26927j : invokeV.booleanValue;
    }

    @Override // c.a.x0.i.a
    public byte[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f26926i : (byte[]) invokeV.objValue;
    }

    @Override // c.a.x0.i.a
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f26919b : invokeV.longValue;
    }

    @Override // c.a.x0.i.a
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : invokeV.longValue;
    }

    @Override // c.a.x0.i.a
    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.f26928k = j2;
        }
    }

    public final void i() {
        int dequeueInputBuffer;
        long sampleTime;
        int sampleFlags;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.l || (dequeueInputBuffer = this.f26921d.dequeueInputBuffer(10000L)) < 0) {
            return;
        }
        int readSampleData = this.f26922e.readSampleData(this.f26924g[dequeueInputBuffer], 0);
        if (readSampleData < 0) {
            this.l = true;
            c.a.x0.t.c.j("VideoMuxer", "extractor to end, audioEndTimeUs" + this.f26928k);
            sampleTime = 0L;
            readSampleData = 0;
        } else {
            sampleTime = this.f26922e.getSampleTime();
        }
        long j2 = this.f26928k;
        if (j2 > 0 && sampleTime > j2) {
            c.a.x0.t.c.j("VideoMuxer", "extractor audioEndTimeUs:" + this.f26928k + ",presentationTimeUs:" + sampleTime);
            this.l = true;
        }
        boolean z = this.l;
        MediaCodec mediaCodec = this.f26921d;
        if (z) {
            i2 = 0;
            sampleTime = 0;
            sampleFlags = 4;
        } else {
            sampleFlags = this.f26922e.getSampleFlags();
            i2 = readSampleData;
        }
        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i2, sampleTime, sampleFlags);
        if (this.l) {
            return;
        }
        this.f26922e.advance();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r1 != (r2.size - r2.offset)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            ByteBuffer byteBuffer = this.f26925h[i2];
            byte[] bArr = this.f26926i;
            if (bArr != null) {
                int length = bArr.length;
                MediaCodec.BufferInfo bufferInfo = this.f26920c;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.f26920c;
            this.f26926i = new byte[bufferInfo2.size - bufferInfo2.offset];
            MediaCodec.BufferInfo bufferInfo3 = this.f26920c;
            if (bufferInfo3.size > 0) {
                this.f26919b = bufferInfo3.presentationTimeUs;
            }
            byteBuffer.position(this.f26920c.offset);
            byteBuffer.get(this.f26926i);
            byteBuffer.clear();
            this.f26921d.releaseOutputBuffer(i2, false);
        }
    }

    public void k(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jVar) == null) {
            this.m = jVar;
        }
    }

    @Override // c.a.x0.i.a
    public void seek(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) {
            d();
            this.f26922e.seekTo(j2, 2);
            this.f26919b = j2;
            this.f26920c = new MediaCodec.BufferInfo();
            this.f26921d.flush();
        }
    }
}
