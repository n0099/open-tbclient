package com.baidu.ar.recorder.encoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public class a extends b {
    private static final String g = a.class.getSimpleName();
    private long h = 0;

    @Override // com.baidu.ar.recorder.encoder.b
    protected void a() {
        if (this.f == 0) {
            this.f = this.c.presentationTimeUs;
        }
        this.c.presentationTimeUs -= this.f;
        if (this.c.presentationTimeUs < this.h) {
            MediaCodec.BufferInfo bufferInfo = this.c;
            long j = this.h + 10000;
            this.h = j;
            bufferInfo.presentationTimeUs = j;
        }
        this.h = this.c.presentationTimeUs;
        Log.d(g, "syncTimestamp mAudioEncoder = " + this.c.size + "|" + this.c.presentationTimeUs);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(EncoderParams encoderParams, d dVar) {
        boolean z = true;
        if (encoderParams != null && dVar != null) {
            this.a = dVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, encoderParams.l());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", encoderParams.o());
            mediaFormat.setInteger("channel-count", encoderParams.m());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, encoderParams.n());
            mediaFormat.setInteger("max-input-size", encoderParams.p());
            try {
                this.b = MediaCodec.createEncoderByType(encoderParams.l());
                this.b.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (encoderParams.d()) {
                    this.e = false;
                } else {
                    this.e = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (this.d == null) {
                this.d.a(z);
                return;
            }
            return;
        }
        z = false;
        if (this.d == null) {
        }
    }

    @Override // com.baidu.ar.recorder.encoder.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.ar.recorder.encoder.b
    public /* bridge */ /* synthetic */ void a(boolean z) {
        super.a(z);
    }

    @Override // com.baidu.ar.recorder.encoder.b
    public /* bridge */ /* synthetic */ void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.a(z, byteBuffer, i, j);
    }

    @Override // com.baidu.ar.recorder.encoder.b
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.baidu.ar.recorder.encoder.b
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.baidu.ar.recorder.encoder.b
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }
}
