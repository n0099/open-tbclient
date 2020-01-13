package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes10.dex */
public class g extends b {
    private static final String TAG = g.class.getSimpleName();
    private Surface mInputSurface;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void AU() {
        super.AU();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void AV() {
        super.AV();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long Au() {
        return super.Au();
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
    public /* bridge */ /* synthetic */ void bA(boolean z) {
        super.bA(z);
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
            this.aGI = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.Ba(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.Bb());
            createVideoFormat.setInteger("frame-rate", dVar.Bc());
            createVideoFormat.setInteger("i-frame-interval", dVar.Bd());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.Ba());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.aGK = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aGJ == null) {
                this.aGJ.bu(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aGJ == null) {
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.a.b.b
    protected void AT() {
        if (this.aGL == 0) {
            this.aGL = this.mBufferInfo.presentationTimeUs;
            aGM = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.aGL;
        aGM = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.a.d.At().T(aGM / 1000);
    }
}
