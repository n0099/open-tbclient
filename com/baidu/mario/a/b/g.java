package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.kwai.video.player.KsMediaMeta;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class g extends b {
    private static final String TAG = g.class.getSimpleName();
    private Surface mInputSurface;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long acO() {
        return super.acO();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void ado() {
        super.ado();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void adp() {
        super.adp();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void adq() {
        super.adq();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.b(z, byteBuffer, i, j);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void dV(boolean z) {
        super.dV(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.cif = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.getVideoCodec(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, dVar.getVideoBitrate());
            createVideoFormat.setInteger("frame-rate", dVar.getVideoFrameRate());
            createVideoFormat.setInteger("i-frame-interval", dVar.getVideoIFrameInterval());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.getVideoCodec());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.cih = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.cig == null) {
                this.cig.dP(z);
                return;
            }
            return;
        }
        z = false;
        if (this.cig == null) {
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.a.b.b
    protected void adn() {
        if (this.cii == 0) {
            this.cii = this.mBufferInfo.presentationTimeUs;
            cij = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.cii;
        cij = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.a.d.acN().bG(cij / 1000);
    }
}
