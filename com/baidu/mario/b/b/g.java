package com.baidu.mario.b.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class g extends b {
    private static final String TAG = g.class.getSimpleName();
    private Surface mInputSurface;

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void aO(boolean z) {
        super.aO(z);
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.b(z, byteBuffer, i, j);
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void tO() {
        super.tO();
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void tP() {
        super.tP();
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void tQ() {
        super.tQ();
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ long tm() {
        return super.tm();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.aeX = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.tV(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.tW());
            createVideoFormat.setInteger("frame-rate", dVar.tX());
            createVideoFormat.setInteger("i-frame-interval", dVar.tY());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.tV());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.aeZ = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aeY == null) {
                this.aeY.aI(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aeY == null) {
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.b.b.b
    protected void tN() {
        if (this.afa == 0) {
            this.afa = this.mBufferInfo.presentationTimeUs;
            afb = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.afa;
        afb = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.b.c.tl().x(afb / 1000);
        Log.d(TAG, "syncTimestamp mVideoEncoder = " + this.mBufferInfo.size + "|" + this.mBufferInfo.presentationTimeUs);
    }
}
