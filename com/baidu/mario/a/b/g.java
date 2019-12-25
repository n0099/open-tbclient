package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes9.dex */
public class g extends b {
    private static final String TAG = g.class.getSimpleName();
    private Surface mInputSurface;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Ay() {
        super.Ay();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Az() {
        super.Az();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.b(z, byteBuffer, i, j);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void bv(boolean z) {
        super.bv(z);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void releaseEncoder() {
        super.releaseEncoder();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long zY() {
        return super.zY();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.aFQ = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.AE(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.AF());
            createVideoFormat.setInteger("frame-rate", dVar.AG());
            createVideoFormat.setInteger("i-frame-interval", dVar.AH());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.AE());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.aFS = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aFR == null) {
                this.aFR.bp(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aFR == null) {
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.a.b.b
    protected void Ax() {
        if (this.aFT == 0) {
            this.aFT = this.mBufferInfo.presentationTimeUs;
            aFU = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.aFT;
        aFU = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.a.d.zX().Q(aFU / 1000);
    }
}
