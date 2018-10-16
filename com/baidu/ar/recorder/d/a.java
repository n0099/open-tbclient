package com.baidu.ar.recorder.d;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public class a extends b {
    private static final String g = a.class.getSimpleName();
    private long h = 0;

    @Override // com.baidu.ar.recorder.d.b
    protected void a() {
        if (this.f == 0) {
            this.f = this.c.presentationTimeUs;
        }
        this.c.presentationTimeUs -= this.f;
        if (this.c.presentationTimeUs < this.h) {
            MediaCodec.BufferInfo bufferInfo = this.c;
            long j = this.h + ErrDef.Feature.WEIGHT;
            this.h = j;
            bufferInfo.presentationTimeUs = j;
        }
        this.h = this.c.presentationTimeUs;
        Log.d(g, "syncTimestamp mAudioEncoder = " + this.c.size + "|" + this.c.presentationTimeUs);
    }

    @Override // com.baidu.ar.recorder.d.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.a = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.l());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.o());
            mediaFormat.setInteger("channel-count", dVar.m());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.n());
            mediaFormat.setInteger("max-input-size", dVar.p());
            try {
                this.b = MediaCodec.createEncoderByType(dVar.l());
                this.b.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (dVar.d()) {
                    this.e = false;
                } else {
                    this.e = true;
                }
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
}
