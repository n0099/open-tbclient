package com.baidu.fsg.face.liveness.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f40043a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final String f40044b = "video/avc";

    /* renamed from: c  reason: collision with root package name */
    public static final int f40045c = 10000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f40046d;

    /* renamed from: e  reason: collision with root package name */
    public int f40047e;

    /* renamed from: f  reason: collision with root package name */
    public MediaCodec f40048f;

    /* renamed from: g  reason: collision with root package name */
    public MediaMuxer f40049g;

    /* renamed from: h  reason: collision with root package name */
    public MediaCodec.BufferInfo f40050h;

    /* renamed from: i  reason: collision with root package name */
    public int f40051i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f40052j;
    public byte[] k;
    public int l;
    public int m;
    public int n;
    public int o;
    public MediaFormat p;
    public boolean q;

    @SuppressLint({"NewApi"})
    public f(int i2, int i3, int i4, int i5, int i6, MediaMuxer mediaMuxer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), mediaMuxer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40051i = -1;
        this.f40046d = i2;
        this.f40047e = i3;
        this.n = i4;
        this.o = i6;
        this.l = i5;
        this.f40050h = new MediaCodec.BufferInfo();
        this.f40049g = mediaMuxer;
        this.f40051i = -1;
        this.f40052j = false;
        this.m = 0;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.f40046d;
            int i3 = this.f40047e;
            this.k = new byte[((i2 * i3) * 3) / 2];
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
            createVideoFormat.setInteger("bitrate", this.n);
            createVideoFormat.setInteger("frame-rate", this.l);
            createVideoFormat.setInteger("color-format", 21);
            createVideoFormat.setInteger("i-frame-interval", this.o);
            LogUtil.d("format: " + createVideoFormat);
            try {
                try {
                    MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
                    this.f40048f = createEncoderByType;
                    createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                    this.f40048f.start();
                } catch (IOException e2) {
                    LogUtil.e(e2.toString());
                }
            } finally {
                this.q = true;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogUtil.i(IntentConfig.CLOSE);
            try {
                if (this.f40048f != null && this.q) {
                    this.q = false;
                    this.f40048f.stop();
                    this.f40048f.release();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.e(e2.toString());
            }
            if (this.f40049g != null) {
                try {
                    try {
                        if (!a.f40038c) {
                            a.f40038c = true;
                            LogUtil.i("VideoMediaEncoderThread", "mMuxer.stop:");
                            this.f40049g.stop();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        LogUtil.e(e3.toString());
                    }
                    this.f40049g = null;
                } finally {
                    this.f40049g.release();
                }
            }
        }
    }

    @TargetApi(18)
    public void a(byte[] bArr, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, j2) == null) {
            LogUtil.i("encodeFrame()");
            a(bArr, this.k, this.f40046d, this.f40047e, bArr.length);
            ByteBuffer[] inputBuffers = this.f40048f.getInputBuffers();
            ByteBuffer[] outputBuffers = this.f40048f.getOutputBuffers();
            int dequeueInputBuffer = this.f40048f.dequeueInputBuffer(10000L);
            LogUtil.i("inputBufferIndex-->" + dequeueInputBuffer);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(this.k);
                this.f40048f.queueInputBuffer(dequeueInputBuffer, 0, this.k.length, j2, 0);
            } else {
                LogUtil.d("input buffer not available");
            }
            int dequeueOutputBuffer = this.f40048f.dequeueOutputBuffer(this.f40050h, 10000L);
            LogUtil.i("outputBufferIndex-->" + dequeueOutputBuffer);
            do {
                if (dequeueOutputBuffer == -1) {
                    LogUtil.d("no output from encoder available");
                } else if (dequeueOutputBuffer == -3) {
                    ByteBuffer[] outputBuffers2 = this.f40048f.getOutputBuffers();
                    LogUtil.d("encoder output buffers changed");
                    outputBuffers = outputBuffers2;
                } else if (dequeueOutputBuffer == -2) {
                    this.p = this.f40048f.getOutputFormat();
                    LogUtil.d("encoder output format changed: " + this.p);
                } else if (dequeueOutputBuffer < 0) {
                    LogUtil.w("unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    LogUtil.d("perform encoding");
                    ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer2 != null) {
                        if ((this.f40050h.flags & 2) != 0) {
                            LogUtil.d("ignoring BUFFER_FLAG_CODEC_CONFIG");
                            this.f40050h.size = 0;
                        }
                        if (this.f40050h.size != 0) {
                            if (!this.f40052j) {
                                this.f40051i = this.f40049g.addTrack(this.f40048f.getOutputFormat());
                                try {
                                    if (!a.f40037b && !a.f40037b) {
                                        a.f40037b = true;
                                        this.f40049g.start();
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    LogUtil.e(e2.toString());
                                }
                                this.f40052j = true;
                            }
                            byteBuffer2.position(this.f40050h.offset);
                            MediaCodec.BufferInfo bufferInfo = this.f40050h;
                            byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                            this.f40049g.writeSampleData(this.f40051i, byteBuffer2, this.f40050h);
                            LogUtil.d("sent " + this.f40050h.size + " bytes to muxer");
                        }
                        this.f40048f.releaseOutputBuffer(dequeueOutputBuffer, false);
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                }
                dequeueOutputBuffer = this.f40048f.dequeueOutputBuffer(this.f40050h, 10000L);
            } while (dequeueOutputBuffer >= 0);
            this.m++;
        }
    }

    private void a(byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{bArr, bArr2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            System.arraycopy(bArr, 0, bArr2, 0, i4);
            for (int i5 = i2 * i3; i5 < i4; i5 += 2) {
                int i6 = i5 + 1;
                bArr2[i5] = bArr[i6];
                bArr2[i6] = bArr[i5];
            }
        }
    }
}
