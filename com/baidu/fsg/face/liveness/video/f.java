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
/* loaded from: classes10.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final String f35327b = "video/avc";

    /* renamed from: c  reason: collision with root package name */
    public static final int f35328c = 10000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f35329d;

    /* renamed from: e  reason: collision with root package name */
    public int f35330e;

    /* renamed from: f  reason: collision with root package name */
    public MediaCodec f35331f;

    /* renamed from: g  reason: collision with root package name */
    public MediaMuxer f35332g;

    /* renamed from: h  reason: collision with root package name */
    public MediaCodec.BufferInfo f35333h;

    /* renamed from: i  reason: collision with root package name */
    public int f35334i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f35335j;

    /* renamed from: k  reason: collision with root package name */
    public byte[] f35336k;
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
        this.f35334i = -1;
        this.f35329d = i2;
        this.f35330e = i3;
        this.n = i4;
        this.o = i6;
        this.l = i5;
        this.f35333h = new MediaCodec.BufferInfo();
        this.f35332g = mediaMuxer;
        this.f35334i = -1;
        this.f35335j = false;
        this.m = 0;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.f35329d;
            int i3 = this.f35330e;
            this.f35336k = new byte[((i2 * i3) * 3) / 2];
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
            createVideoFormat.setInteger("bitrate", this.n);
            createVideoFormat.setInteger("frame-rate", this.l);
            createVideoFormat.setInteger("color-format", 21);
            createVideoFormat.setInteger("i-frame-interval", this.o);
            LogUtil.d("format: " + createVideoFormat);
            try {
                try {
                    MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
                    this.f35331f = createEncoderByType;
                    createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                    this.f35331f.start();
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
                if (this.f35331f != null && this.q) {
                    this.q = false;
                    this.f35331f.stop();
                    this.f35331f.release();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.e(e2.toString());
            }
            if (this.f35332g != null) {
                try {
                    try {
                        if (!a.f35324c) {
                            a.f35324c = true;
                            LogUtil.i("VideoMediaEncoderThread", "mMuxer.stop:");
                            this.f35332g.stop();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        LogUtil.e(e3.toString());
                    }
                    this.f35332g = null;
                } finally {
                    this.f35332g.release();
                }
            }
        }
    }

    @TargetApi(18)
    public void a(byte[] bArr, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, j2) == null) {
            LogUtil.i("encodeFrame()");
            a(bArr, this.f35336k, this.f35329d, this.f35330e, bArr.length);
            ByteBuffer[] inputBuffers = this.f35331f.getInputBuffers();
            ByteBuffer[] outputBuffers = this.f35331f.getOutputBuffers();
            int dequeueInputBuffer = this.f35331f.dequeueInputBuffer(10000L);
            LogUtil.i("inputBufferIndex-->" + dequeueInputBuffer);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(this.f35336k);
                this.f35331f.queueInputBuffer(dequeueInputBuffer, 0, this.f35336k.length, j2, 0);
            } else {
                LogUtil.d("input buffer not available");
            }
            int dequeueOutputBuffer = this.f35331f.dequeueOutputBuffer(this.f35333h, 10000L);
            LogUtil.i("outputBufferIndex-->" + dequeueOutputBuffer);
            do {
                if (dequeueOutputBuffer == -1) {
                    LogUtil.d("no output from encoder available");
                } else if (dequeueOutputBuffer == -3) {
                    ByteBuffer[] outputBuffers2 = this.f35331f.getOutputBuffers();
                    LogUtil.d("encoder output buffers changed");
                    outputBuffers = outputBuffers2;
                } else if (dequeueOutputBuffer == -2) {
                    this.p = this.f35331f.getOutputFormat();
                    LogUtil.d("encoder output format changed: " + this.p);
                } else if (dequeueOutputBuffer < 0) {
                    LogUtil.w("unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    LogUtil.d("perform encoding");
                    ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer2 != null) {
                        if ((this.f35333h.flags & 2) != 0) {
                            LogUtil.d("ignoring BUFFER_FLAG_CODEC_CONFIG");
                            this.f35333h.size = 0;
                        }
                        if (this.f35333h.size != 0) {
                            if (!this.f35335j) {
                                this.f35334i = this.f35332g.addTrack(this.f35331f.getOutputFormat());
                                try {
                                    if (!a.f35323b && !a.f35323b) {
                                        a.f35323b = true;
                                        this.f35332g.start();
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    LogUtil.e(e2.toString());
                                }
                                this.f35335j = true;
                            }
                            byteBuffer2.position(this.f35333h.offset);
                            MediaCodec.BufferInfo bufferInfo = this.f35333h;
                            byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                            this.f35332g.writeSampleData(this.f35334i, byteBuffer2, this.f35333h);
                            LogUtil.d("sent " + this.f35333h.size + " bytes to muxer");
                        }
                        this.f35331f.releaseOutputBuffer(dequeueOutputBuffer, false);
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                }
                dequeueOutputBuffer = this.f35331f.dequeueOutputBuffer(this.f35333h, 10000L);
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
