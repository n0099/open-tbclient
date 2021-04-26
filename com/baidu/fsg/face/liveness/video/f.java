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
    public static final boolean f6201a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final String f6202b = "video/avc";

    /* renamed from: c  reason: collision with root package name */
    public static final int f6203c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public int f6204d;

    /* renamed from: e  reason: collision with root package name */
    public int f6205e;

    /* renamed from: f  reason: collision with root package name */
    public MediaCodec f6206f;

    /* renamed from: g  reason: collision with root package name */
    public MediaMuxer f6207g;

    /* renamed from: i  reason: collision with root package name */
    public int f6209i;
    public byte[] k;
    public int l;
    public int n;
    public int o;
    public MediaFormat p;
    public boolean q;

    /* renamed from: h  reason: collision with root package name */
    public MediaCodec.BufferInfo f6208h = new MediaCodec.BufferInfo();
    public boolean j = false;
    public int m = 0;

    @SuppressLint({"NewApi"})
    public f(int i2, int i3, int i4, int i5, int i6, MediaMuxer mediaMuxer) {
        this.f6209i = -1;
        this.f6204d = i2;
        this.f6205e = i3;
        this.n = i4;
        this.o = i6;
        this.l = i5;
        this.f6207g = mediaMuxer;
        this.f6209i = -1;
    }

    public void a() {
        int i2 = this.f6204d;
        int i3 = this.f6205e;
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
                this.f6206f = createEncoderByType;
                createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.f6206f.start();
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
            if (this.f6206f != null && this.q) {
                this.q = false;
                this.f6206f.stop();
                this.f6206f.release();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.e(e2.toString());
        }
        try {
            if (this.f6207g != null) {
                try {
                    if (!a.f6196c) {
                        a.f6196c = true;
                        LogUtil.i("VideoMediaEncoderThread", "mMuxer.stop:");
                        this.f6207g.stop();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    LogUtil.e(e3.toString());
                }
                this.f6207g = null;
            }
        } finally {
            this.f6207g.release();
        }
    }

    @TargetApi(18)
    public void a(byte[] bArr, long j) {
        LogUtil.i("encodeFrame()");
        a(bArr, this.k, this.f6204d, this.f6205e, bArr.length);
        ByteBuffer[] inputBuffers = this.f6206f.getInputBuffers();
        ByteBuffer[] outputBuffers = this.f6206f.getOutputBuffers();
        int dequeueInputBuffer = this.f6206f.dequeueInputBuffer(10000L);
        LogUtil.i("inputBufferIndex-->" + dequeueInputBuffer);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.put(this.k);
            this.f6206f.queueInputBuffer(dequeueInputBuffer, 0, this.k.length, j, 0);
        } else {
            LogUtil.d("input buffer not available");
        }
        int dequeueOutputBuffer = this.f6206f.dequeueOutputBuffer(this.f6208h, 10000L);
        LogUtil.i("outputBufferIndex-->" + dequeueOutputBuffer);
        do {
            if (dequeueOutputBuffer == -1) {
                LogUtil.d("no output from encoder available");
            } else if (dequeueOutputBuffer == -3) {
                ByteBuffer[] outputBuffers2 = this.f6206f.getOutputBuffers();
                LogUtil.d("encoder output buffers changed");
                outputBuffers = outputBuffers2;
            } else if (dequeueOutputBuffer == -2) {
                this.p = this.f6206f.getOutputFormat();
                LogUtil.d("encoder output format changed: " + this.p);
            } else if (dequeueOutputBuffer < 0) {
                LogUtil.w("unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                LogUtil.d("perform encoding");
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer2 != null) {
                    if ((this.f6208h.flags & 2) != 0) {
                        LogUtil.d("ignoring BUFFER_FLAG_CODEC_CONFIG");
                        this.f6208h.size = 0;
                    }
                    if (this.f6208h.size != 0) {
                        if (!this.j) {
                            this.f6209i = this.f6207g.addTrack(this.f6206f.getOutputFormat());
                            try {
                                if (!a.f6195b && !a.f6195b) {
                                    a.f6195b = true;
                                    this.f6207g.start();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                LogUtil.e(e2.toString());
                            }
                            this.j = true;
                        }
                        byteBuffer2.position(this.f6208h.offset);
                        MediaCodec.BufferInfo bufferInfo = this.f6208h;
                        byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                        this.f6207g.writeSampleData(this.f6209i, byteBuffer2, this.f6208h);
                        LogUtil.d("sent " + this.f6208h.size + " bytes to muxer");
                    }
                    this.f6206f.releaseOutputBuffer(dequeueOutputBuffer, false);
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
            dequeueOutputBuffer = this.f6206f.dequeueOutputBuffer(this.f6208h, 10000L);
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
