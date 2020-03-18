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
    public /* bridge */ /* synthetic */ long CT() {
        return super.CT();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Dt() {
        super.Dt();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Du() {
        super.Du();
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
    public /* bridge */ /* synthetic */ void bJ(boolean z) {
        super.bJ(z);
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
            this.aLd = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.Dz(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.DA());
            createVideoFormat.setInteger("frame-rate", dVar.DB());
            createVideoFormat.setInteger("i-frame-interval", dVar.DC());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.Dz());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.aLf = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aLe == null) {
                this.aLe.bD(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aLe == null) {
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.a.b.b
    protected void Ds() {
        if (this.aLg == 0) {
            this.aLg = this.mBufferInfo.presentationTimeUs;
            aLh = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.aLg;
        aLh = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.a.d.CS().X(aLh / 1000);
    }
}
