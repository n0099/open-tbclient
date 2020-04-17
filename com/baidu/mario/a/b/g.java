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
    public /* bridge */ /* synthetic */ long IY() {
        return super.IY();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void JA() {
        super.JA();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Jy() {
        super.Jy();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Jz() {
        super.Jz();
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
    public /* bridge */ /* synthetic */ void cs(boolean z) {
        super.cs(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.bgX = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.getVideoCodec(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.getVideoBitrate());
            createVideoFormat.setInteger("frame-rate", dVar.getVideoFrameRate());
            createVideoFormat.setInteger("i-frame-interval", dVar.getVideoIFrameInterval());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.getVideoCodec());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.bgZ = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bgY == null) {
                this.bgY.cm(z);
                return;
            }
            return;
        }
        z = false;
        if (this.bgY == null) {
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.a.b.b
    protected void Jx() {
        if (this.bha == 0) {
            this.bha = this.mBufferInfo.presentationTimeUs;
            bhb = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.bha;
        bhb = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.a.d.IX().aC(bhb / 1000);
    }
}
