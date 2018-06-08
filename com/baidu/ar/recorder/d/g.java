package com.baidu.ar.recorder.d;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public class g extends b {
    private static final String g = g.class.getSimpleName();
    private Surface h;

    @Override // com.baidu.ar.recorder.d.b
    protected void a() {
        if (this.f == 0) {
            this.f = this.c.presentationTimeUs;
        }
        this.c.presentationTimeUs -= this.f;
        Log.d(g, "syncTimestamp mVideoEncoder = " + this.c.size + "|" + this.c.presentationTimeUs);
    }

    @Override // com.baidu.ar.recorder.d.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.a = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.g(), dVar.e(), dVar.f());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.h());
            createVideoFormat.setInteger("frame-rate", dVar.i());
            createVideoFormat.setInteger("i-frame-interval", dVar.j());
            try {
                this.b = MediaCodec.createEncoderByType(dVar.g());
                this.b.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.h = this.b.createInputSurface();
                this.e = true;
            } catch (Exception e) {
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

    @Override // com.baidu.ar.recorder.d.b
    public /* bridge */ /* synthetic */ void a(boolean z) {
        super.a(z);
    }

    @Override // com.baidu.ar.recorder.d.b
    public /* bridge */ /* synthetic */ void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.a(z, byteBuffer, i, j);
    }

    @Override // com.baidu.ar.recorder.d.b
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.baidu.ar.recorder.d.b
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.baidu.ar.recorder.d.b
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    public Surface e() {
        return this.h;
    }
}
