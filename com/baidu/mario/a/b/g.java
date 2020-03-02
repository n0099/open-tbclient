package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes11.dex */
public class g extends b {
    private static final String TAG = g.class.getSimpleName();
    private Surface mInputSurface;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long CM() {
        return super.CM();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Dm() {
        super.Dm();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Dn() {
        super.Dn();
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
    public /* bridge */ /* synthetic */ void bI(boolean z) {
        super.bI(z);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void releaseEncoder() {
        super.releaseEncoder();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.aKO = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.Ds(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.Dt());
            createVideoFormat.setInteger("frame-rate", dVar.Du());
            createVideoFormat.setInteger("i-frame-interval", dVar.Dv());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.Ds());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.aKQ = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aKP == null) {
                this.aKP.bC(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aKP == null) {
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.a.b.b
    protected void Dl() {
        if (this.aKR == 0) {
            this.aKR = this.mBufferInfo.presentationTimeUs;
            aKS = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.aKR;
        aKS = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.a.d.CL().X(aKS / 1000);
    }
}
