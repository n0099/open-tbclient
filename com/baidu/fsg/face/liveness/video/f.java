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
    public static final boolean f5955a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final String f5956b = "video/avc";

    /* renamed from: c  reason: collision with root package name */
    public static final int f5957c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public int f5958d;

    /* renamed from: e  reason: collision with root package name */
    public int f5959e;

    /* renamed from: f  reason: collision with root package name */
    public MediaCodec f5960f;

    /* renamed from: g  reason: collision with root package name */
    public MediaMuxer f5961g;

    /* renamed from: i  reason: collision with root package name */
    public int f5963i;
    public byte[] k;
    public int l;
    public int n;
    public int o;
    public MediaFormat p;
    public boolean q;

    /* renamed from: h  reason: collision with root package name */
    public MediaCodec.BufferInfo f5962h = new MediaCodec.BufferInfo();
    public boolean j = false;
    public int m = 0;

    @SuppressLint({"NewApi"})
    public f(int i2, int i3, int i4, int i5, int i6, MediaMuxer mediaMuxer) {
        this.f5963i = -1;
        this.f5958d = i2;
        this.f5959e = i3;
        this.n = i4;
        this.o = i6;
        this.l = i5;
        this.f5961g = mediaMuxer;
        this.f5963i = -1;
    }

    public void a() {
        int i2 = this.f5958d;
        int i3 = this.f5959e;
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
                this.f5960f = createEncoderByType;
                createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.f5960f.start();
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
            if (this.f5960f != null && this.q) {
                this.q = false;
                this.f5960f.stop();
                this.f5960f.release();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.e(e2.toString());
        }
        try {
            if (this.f5961g != null) {
                try {
                    if (!a.f5950c) {
                        a.f5950c = true;
                        LogUtil.i("VideoMediaEncoderThread", "mMuxer.stop:");
                        this.f5961g.stop();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    LogUtil.e(e3.toString());
                }
                this.f5961g = null;
            }
        } finally {
            this.f5961g.release();
        }
    }

    @TargetApi(18)
    public void a(byte[] bArr, long j) {
        LogUtil.i("encodeFrame()");
        a(bArr, this.k, this.f5958d, this.f5959e, bArr.length);
        ByteBuffer[] inputBuffers = this.f5960f.getInputBuffers();
        ByteBuffer[] outputBuffers = this.f5960f.getOutputBuffers();
        int dequeueInputBuffer = this.f5960f.dequeueInputBuffer(10000L);
        LogUtil.i("inputBufferIndex-->" + dequeueInputBuffer);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.put(this.k);
            this.f5960f.queueInputBuffer(dequeueInputBuffer, 0, this.k.length, j, 0);
        } else {
            LogUtil.d("input buffer not available");
        }
        int dequeueOutputBuffer = this.f5960f.dequeueOutputBuffer(this.f5962h, 10000L);
        LogUtil.i("outputBufferIndex-->" + dequeueOutputBuffer);
        do {
            if (dequeueOutputBuffer == -1) {
                LogUtil.d("no output from encoder available");
            } else if (dequeueOutputBuffer == -3) {
                ByteBuffer[] outputBuffers2 = this.f5960f.getOutputBuffers();
                LogUtil.d("encoder output buffers changed");
                outputBuffers = outputBuffers2;
            } else if (dequeueOutputBuffer == -2) {
                this.p = this.f5960f.getOutputFormat();
                LogUtil.d("encoder output format changed: " + this.p);
            } else if (dequeueOutputBuffer < 0) {
                LogUtil.w("unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                LogUtil.d("perform encoding");
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer2 != null) {
                    if ((this.f5962h.flags & 2) != 0) {
                        LogUtil.d("ignoring BUFFER_FLAG_CODEC_CONFIG");
                        this.f5962h.size = 0;
                    }
                    if (this.f5962h.size != 0) {
                        if (!this.j) {
                            this.f5963i = this.f5961g.addTrack(this.f5960f.getOutputFormat());
                            try {
                                if (!a.f5949b && !a.f5949b) {
                                    a.f5949b = true;
                                    this.f5961g.start();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                LogUtil.e(e2.toString());
                            }
                            this.j = true;
                        }
                        byteBuffer2.position(this.f5962h.offset);
                        MediaCodec.BufferInfo bufferInfo = this.f5962h;
                        byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                        this.f5961g.writeSampleData(this.f5963i, byteBuffer2, this.f5962h);
                        LogUtil.d("sent " + this.f5962h.size + " bytes to muxer");
                    }
                    this.f5960f.releaseOutputBuffer(dequeueOutputBuffer, false);
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
            dequeueOutputBuffer = this.f5960f.dequeueOutputBuffer(this.f5962h, 10000L);
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
