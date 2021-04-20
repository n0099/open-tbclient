package com.baidu.fsg.face.liveness.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.kwai.video.player.KsMediaMeta;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6034a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final String f6035b = "video/avc";

    /* renamed from: c  reason: collision with root package name */
    public static final int f6036c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public int f6037d;

    /* renamed from: e  reason: collision with root package name */
    public int f6038e;

    /* renamed from: f  reason: collision with root package name */
    public MediaCodec f6039f;

    /* renamed from: g  reason: collision with root package name */
    public MediaMuxer f6040g;
    public int i;
    public byte[] k;
    public int l;
    public int n;
    public int o;
    public MediaFormat p;
    public boolean q;

    /* renamed from: h  reason: collision with root package name */
    public MediaCodec.BufferInfo f6041h = new MediaCodec.BufferInfo();
    public boolean j = false;
    public int m = 0;

    @SuppressLint({"NewApi"})
    public f(int i, int i2, int i3, int i4, int i5, MediaMuxer mediaMuxer) {
        this.i = -1;
        this.f6037d = i;
        this.f6038e = i2;
        this.n = i3;
        this.o = i5;
        this.l = i4;
        this.f6040g = mediaMuxer;
        this.i = -1;
    }

    public void a() {
        int i = this.f6037d;
        int i2 = this.f6038e;
        this.k = new byte[((i * i2) * 3) / 2];
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, this.n);
        createVideoFormat.setInteger("frame-rate", this.l);
        createVideoFormat.setInteger("color-format", 21);
        createVideoFormat.setInteger("i-frame-interval", this.o);
        LogUtil.d("format: " + createVideoFormat);
        try {
            try {
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
                this.f6039f = createEncoderByType;
                createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.f6039f.start();
            } catch (IOException e2) {
                LogUtil.e(e2.toString());
            }
        } finally {
            this.q = true;
        }
    }

    @SuppressLint({"NewApi"})
    public void b() {
        LogUtil.i(IntentConfig.CLOSE);
        try {
            if (this.f6039f != null && this.q) {
                this.q = false;
                this.f6039f.stop();
                this.f6039f.release();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.e(e2.toString());
        }
        try {
            if (this.f6040g != null) {
                try {
                    if (!a.f6029c) {
                        a.f6029c = true;
                        LogUtil.i("VideoMediaEncoderThread", "mMuxer.stop:");
                        this.f6040g.stop();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    LogUtil.e(e3.toString());
                }
                this.f6040g = null;
            }
        } finally {
            this.f6040g.release();
        }
    }

    @TargetApi(18)
    public void a(byte[] bArr, long j) {
        LogUtil.i("encodeFrame()");
        a(bArr, this.k, this.f6037d, this.f6038e, bArr.length);
        ByteBuffer[] inputBuffers = this.f6039f.getInputBuffers();
        ByteBuffer[] outputBuffers = this.f6039f.getOutputBuffers();
        int dequeueInputBuffer = this.f6039f.dequeueInputBuffer(10000L);
        LogUtil.i("inputBufferIndex-->" + dequeueInputBuffer);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.put(this.k);
            this.f6039f.queueInputBuffer(dequeueInputBuffer, 0, this.k.length, j, 0);
        } else {
            LogUtil.d("input buffer not available");
        }
        int dequeueOutputBuffer = this.f6039f.dequeueOutputBuffer(this.f6041h, 10000L);
        LogUtil.i("outputBufferIndex-->" + dequeueOutputBuffer);
        do {
            if (dequeueOutputBuffer == -1) {
                LogUtil.d("no output from encoder available");
            } else if (dequeueOutputBuffer == -3) {
                ByteBuffer[] outputBuffers2 = this.f6039f.getOutputBuffers();
                LogUtil.d("encoder output buffers changed");
                outputBuffers = outputBuffers2;
            } else if (dequeueOutputBuffer == -2) {
                this.p = this.f6039f.getOutputFormat();
                LogUtil.d("encoder output format changed: " + this.p);
            } else if (dequeueOutputBuffer < 0) {
                LogUtil.w("unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                LogUtil.d("perform encoding");
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer2 != null) {
                    if ((this.f6041h.flags & 2) != 0) {
                        LogUtil.d("ignoring BUFFER_FLAG_CODEC_CONFIG");
                        this.f6041h.size = 0;
                    }
                    if (this.f6041h.size != 0) {
                        if (!this.j) {
                            this.i = this.f6040g.addTrack(this.f6039f.getOutputFormat());
                            try {
                                if (!a.f6028b && !a.f6028b) {
                                    a.f6028b = true;
                                    this.f6040g.start();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                LogUtil.e(e2.toString());
                            }
                            this.j = true;
                        }
                        byteBuffer2.position(this.f6041h.offset);
                        MediaCodec.BufferInfo bufferInfo = this.f6041h;
                        byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                        this.f6040g.writeSampleData(this.i, byteBuffer2, this.f6041h);
                        LogUtil.d("sent " + this.f6041h.size + " bytes to muxer");
                    }
                    this.f6039f.releaseOutputBuffer(dequeueOutputBuffer, false);
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
            dequeueOutputBuffer = this.f6039f.dequeueOutputBuffer(this.f6041h, 10000L);
        } while (dequeueOutputBuffer >= 0);
        this.m++;
    }

    private void a(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        for (int i4 = i * i2; i4 < i3; i4 += 2) {
            int i5 = i4 + 1;
            bArr2[i4] = bArr[i5];
            bArr2[i5] = bArr[i4];
        }
    }
}
