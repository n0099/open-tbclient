package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class g extends b {
    private static final String TAG = g.class.getSimpleName();
    private Surface mInputSurface;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long UP() {
        return super.UP();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Vp() {
        super.Vp();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Vq() {
        super.Vq();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Vr() {
        super.Vr();
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
    public /* bridge */ /* synthetic */ void dd(boolean z) {
        super.dd(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.bJK = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.getVideoCodec(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", dVar.getVideoBitrate());
            createVideoFormat.setInteger("frame-rate", dVar.getVideoFrameRate());
            createVideoFormat.setInteger("i-frame-interval", dVar.getVideoIFrameInterval());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.getVideoCodec());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.bJM = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bJL == null) {
                this.bJL.cX(z);
                return;
            }
            return;
        }
        z = false;
        if (this.bJL == null) {
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.a.b.b
    protected void Vo() {
        if (this.bJN == 0) {
            this.bJN = this.mBufferInfo.presentationTimeUs;
            bJO = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.bJN;
        bJO = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.a.d.UO().aK(bJO / 1000);
    }
}
