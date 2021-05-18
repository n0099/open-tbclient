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
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6055a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final String f6056b = "video/avc";

    /* renamed from: c  reason: collision with root package name */
    public static final int f6057c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public int f6058d;

    /* renamed from: e  reason: collision with root package name */
    public int f6059e;

    /* renamed from: f  reason: collision with root package name */
    public MediaCodec f6060f;

    /* renamed from: g  reason: collision with root package name */
    public MediaMuxer f6061g;

    /* renamed from: i  reason: collision with root package name */
    public int f6063i;
    public byte[] k;
    public int l;
    public int n;
    public int o;
    public MediaFormat p;
    public boolean q;

    /* renamed from: h  reason: collision with root package name */
    public MediaCodec.BufferInfo f6062h = new MediaCodec.BufferInfo();
    public boolean j = false;
    public int m = 0;

    @SuppressLint({"NewApi"})
    public f(int i2, int i3, int i4, int i5, int i6, MediaMuxer mediaMuxer) {
        this.f6063i = -1;
        this.f6058d = i2;
        this.f6059e = i3;
        this.n = i4;
        this.o = i6;
        this.l = i5;
        this.f6061g = mediaMuxer;
        this.f6063i = -1;
    }

    public void a() {
        int i2 = this.f6058d;
        int i3 = this.f6059e;
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
                this.f6060f = createEncoderByType;
                createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.f6060f.start();
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
            if (this.f6060f != null && this.q) {
                this.q = false;
                this.f6060f.stop();
                this.f6060f.release();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.e(e2.toString());
        }
        try {
            if (this.f6061g != null) {
                try {
                    if (!a.f6050c) {
                        a.f6050c = true;
                        LogUtil.i("VideoMediaEncoderThread", "mMuxer.stop:");
                        this.f6061g.stop();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    LogUtil.e(e3.toString());
                }
                this.f6061g = null;
            }
        } finally {
            this.f6061g.release();
        }
    }

    @TargetApi(18)
    public void a(byte[] bArr, long j) {
        LogUtil.i("encodeFrame()");
        a(bArr, this.k, this.f6058d, this.f6059e, bArr.length);
        ByteBuffer[] inputBuffers = this.f6060f.getInputBuffers();
        ByteBuffer[] outputBuffers = this.f6060f.getOutputBuffers();
        int dequeueInputBuffer = this.f6060f.dequeueInputBuffer(10000L);
        LogUtil.i("inputBufferIndex-->" + dequeueInputBuffer);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.put(this.k);
            this.f6060f.queueInputBuffer(dequeueInputBuffer, 0, this.k.length, j, 0);
        } else {
            LogUtil.d("input buffer not available");
        }
        int dequeueOutputBuffer = this.f6060f.dequeueOutputBuffer(this.f6062h, 10000L);
        LogUtil.i("outputBufferIndex-->" + dequeueOutputBuffer);
        do {
            if (dequeueOutputBuffer == -1) {
                LogUtil.d("no output from encoder available");
            } else if (dequeueOutputBuffer == -3) {
                ByteBuffer[] outputBuffers2 = this.f6060f.getOutputBuffers();
                LogUtil.d("encoder output buffers changed");
                outputBuffers = outputBuffers2;
            } else if (dequeueOutputBuffer == -2) {
                this.p = this.f6060f.getOutputFormat();
                LogUtil.d("encoder output format changed: " + this.p);
            } else if (dequeueOutputBuffer < 0) {
                LogUtil.w("unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                LogUtil.d("perform encoding");
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer2 != null) {
                    if ((this.f6062h.flags & 2) != 0) {
                        LogUtil.d("ignoring BUFFER_FLAG_CODEC_CONFIG");
                        this.f6062h.size = 0;
                    }
                    if (this.f6062h.size != 0) {
                        if (!this.j) {
                            this.f6063i = this.f6061g.addTrack(this.f6060f.getOutputFormat());
                            try {
                                if (!a.f6049b && !a.f6049b) {
                                    a.f6049b = true;
                                    this.f6061g.start();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                LogUtil.e(e2.toString());
                            }
                            this.j = true;
                        }
                        byteBuffer2.position(this.f6062h.offset);
                        MediaCodec.BufferInfo bufferInfo = this.f6062h;
                        byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                        this.f6061g.writeSampleData(this.f6063i, byteBuffer2, this.f6062h);
                        LogUtil.d("sent " + this.f6062h.size + " bytes to muxer");
                    }
                    this.f6060f.releaseOutputBuffer(dequeueOutputBuffer, false);
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
            dequeueOutputBuffer = this.f6060f.dequeueOutputBuffer(this.f6062h, 10000L);
        } while (dequeueOutputBuffer >= 0);
        this.m++;
    }

    private void a(byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        for (int i5 = i2 * i3; i5 < i4; i5 += 2) {
            int i6 = i5 + 1;
            bArr2[i5] = bArr[i6];
            bArr2[i6] = bArr[i5];
        }
    }
}
