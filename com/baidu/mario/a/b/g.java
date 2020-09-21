package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class g extends b {
    private static final String TAG = g.class.getSimpleName();
    private Surface mInputSurface;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long SW() {
        return super.SW();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Tw() {
        super.Tw();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Tx() {
        super.Tx();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Ty() {
        super.Ty();
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
    public /* bridge */ /* synthetic */ void cW(boolean z) {
        super.cW(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.bDi = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.getVideoCodec(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", dVar.getVideoBitrate());
            createVideoFormat.setInteger("frame-rate", dVar.getVideoFrameRate());
            createVideoFormat.setInteger("i-frame-interval", dVar.getVideoIFrameInterval());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.getVideoCodec());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.bDk = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bDj == null) {
                this.bDj.cQ(z);
                return;
            }
            return;
        }
        z = false;
        if (this.bDj == null) {
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.a.b.b
    protected void Tv() {
        if (this.bDl == 0) {
            this.bDl = this.mBufferInfo.presentationTimeUs;
            bDm = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.bDl;
        bDm = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.a.d.SV().aI(bDm / 1000);
    }
}
