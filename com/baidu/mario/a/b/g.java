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
    public /* bridge */ /* synthetic */ long CK() {
        return super.CK();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Dk() {
        super.Dk();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Dl() {
        super.Dl();
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
            this.aKN = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.Dq(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.Dr());
            createVideoFormat.setInteger("frame-rate", dVar.Ds());
            createVideoFormat.setInteger("i-frame-interval", dVar.Dt());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.Dq());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.aKP = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aKO == null) {
                this.aKO.bC(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aKO == null) {
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.a.b.b
    protected void Dj() {
        if (this.aKQ == 0) {
            this.aKQ = this.mBufferInfo.presentationTimeUs;
            aKR = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.aKQ;
        aKR = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.a.d.CJ().X(aKR / 1000);
    }
}
