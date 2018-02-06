package com.baidu.ar.recorder.encoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public class f extends b {
    private static final String g = f.class.getSimpleName();
    private Surface h;

    @Override // com.baidu.ar.recorder.encoder.b
    protected void a() {
        if (this.f == 0) {
            this.f = this.c.presentationTimeUs;
        }
        this.c.presentationTimeUs -= this.f;
        Log.d(g, "syncTimestamp mVideoEncoder = " + this.c.size + "|" + this.c.presentationTimeUs);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(EncoderParams encoderParams, d dVar) {
        boolean z = true;
        if (encoderParams != null && dVar != null) {
            this.a = dVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(encoderParams.g(), encoderParams.e(), encoderParams.f());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, encoderParams.h());
            createVideoFormat.setInteger("frame-rate", encoderParams.i());
            createVideoFormat.setInteger("i-frame-interval", encoderParams.j());
            try {
                this.b = MediaCodec.createEncoderByType(encoderParams.g());
                this.b.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.h = this.b.createInputSurface();
                this.e = true;
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

    public Surface e() {
        return this.h;
    }
}
