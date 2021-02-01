package com.baidu.fsg.face.liveness.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.baidu.fsg.base.utils.LogUtil;
import com.kwai.video.player.KsMediaMeta;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    protected static final boolean f2310a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final String f2311b = "video/avc";
    protected static final int c = 10000;
    protected int d;
    protected int e;
    protected MediaCodec f;
    protected MediaMuxer g;
    protected int i;
    protected byte[] k;
    protected int l;
    protected int n;
    protected int o;
    protected MediaFormat p;
    protected boolean q;
    protected MediaCodec.BufferInfo h = new MediaCodec.BufferInfo();
    protected boolean j = false;
    protected int m = 0;

    @SuppressLint({"NewApi"})
    public f(int i, int i2, int i3, int i4, int i5, MediaMuxer mediaMuxer) {
        this.i = -1;
        this.d = i;
        this.e = i2;
        this.n = i3;
        this.o = i5;
        this.l = i4;
        this.g = mediaMuxer;
        this.i = -1;
    }

    public void a() {
        this.k = new byte[((this.d * this.e) * 3) / 2];
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.d, this.e);
        createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, this.n);
        createVideoFormat.setInteger("frame-rate", this.l);
        createVideoFormat.setInteger("color-format", 21);
        createVideoFormat.setInteger("i-frame-interval", this.o);
        LogUtil.d("format: " + createVideoFormat);
        try {
            this.f = MediaCodec.createEncoderByType("video/avc");
            this.f.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.f.start();
        } catch (IOException e) {
            LogUtil.e(e.toString());
        } finally {
            this.q = true;
        }
    }

    @TargetApi(18)
    public void a(byte[] bArr, long j) {
        LogUtil.i("encodeFrame()");
        a(bArr, this.k, this.d, this.e, bArr.length);
        ByteBuffer[] inputBuffers = this.f.getInputBuffers();
        ByteBuffer[] outputBuffers = this.f.getOutputBuffers();
        int dequeueInputBuffer = this.f.dequeueInputBuffer(10000L);
        LogUtil.i("inputBufferIndex-->" + dequeueInputBuffer);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.put(this.k);
            this.f.queueInputBuffer(dequeueInputBuffer, 0, this.k.length, j, 0);
        } else {
            LogUtil.d("input buffer not available");
        }
        int dequeueOutputBuffer = this.f.dequeueOutputBuffer(this.h, 10000L);
        LogUtil.i("outputBufferIndex-->" + dequeueOutputBuffer);
        int i = dequeueOutputBuffer;
        ByteBuffer[] byteBufferArr = outputBuffers;
        while (true) {
            if (i == -1) {
                LogUtil.d("no output from encoder available");
            } else if (i == -3) {
                byteBufferArr = this.f.getOutputBuffers();
                LogUtil.d("encoder output buffers changed");
            } else if (i == -2) {
                this.p = this.f.getOutputFormat();
                LogUtil.d("encoder output format changed: " + this.p);
            } else if (i < 0) {
                LogUtil.w("unexpected result from encoder.dequeueOutputBuffer: " + i);
            } else {
                LogUtil.d("perform encoding");
                ByteBuffer byteBuffer2 = byteBufferArr[i];
                if (byteBuffer2 == null) {
                    throw new RuntimeException("encoderOutputBuffer " + i + " was null");
                }
                if ((this.h.flags & 2) != 0) {
                    LogUtil.d("ignoring BUFFER_FLAG_CODEC_CONFIG");
                    this.h.size = 0;
                }
                if (this.h.size != 0) {
                    if (!this.j) {
                        this.i = this.g.addTrack(this.f.getOutputFormat());
                        try {
                            if (!a.f2307b && !a.f2307b) {
                                a.f2307b = true;
                                this.g.start();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            LogUtil.e(e.toString());
                        }
                        this.j = true;
                    }
                    byteBuffer2.position(this.h.offset);
                    byteBuffer2.limit(this.h.offset + this.h.size);
                    this.g.writeSampleData(this.i, byteBuffer2, this.h);
                    LogUtil.d("sent " + this.h.size + " bytes to muxer");
                }
                this.f.releaseOutputBuffer(i, false);
            }
            int dequeueOutputBuffer2 = this.f.dequeueOutputBuffer(this.h, 10000L);
            if (dequeueOutputBuffer2 < 0) {
                this.m++;
                return;
            }
            i = dequeueOutputBuffer2;
        }
    }

    @SuppressLint({"NewApi"})
    public void b() {
        LogUtil.i("close");
        try {
            if (this.f != null && this.q) {
                this.q = false;
                this.f.stop();
                this.f.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(e.toString());
        }
        if (this.g != null) {
            try {
                if (!a.c) {
                    a.c = true;
                    LogUtil.i("VideoMediaEncoderThread", "mMuxer.stop:");
                    this.g.stop();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.e(e2.toString());
            } finally {
                this.g.release();
            }
            this.g = null;
        }
    }

    private void a(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        for (int i4 = i * i2; i4 < i3; i4 += 2) {
            bArr2[i4] = bArr[i4 + 1];
            bArr2[i4 + 1] = bArr[i4];
        }
    }
}
