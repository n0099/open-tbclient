package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class g extends b {
    private static final String TAG = g.class.getSimpleName();
    private Surface mInputSurface;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void MG() {
        super.MG();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void MH() {
        super.MH();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void MI() {
        super.MI();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long Mg() {
        return super.Mg();
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
    public /* bridge */ /* synthetic */ void cM(boolean z) {
        super.cM(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.btW = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.getVideoCodec(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", dVar.getVideoBitrate());
            createVideoFormat.setInteger("frame-rate", dVar.getVideoFrameRate());
            createVideoFormat.setInteger("i-frame-interval", dVar.getVideoIFrameInterval());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.getVideoCodec());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.btY = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.btX == null) {
                this.btX.cG(z);
                return;
            }
            return;
        }
        z = false;
        if (this.btX == null) {
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.a.b.b
    protected void MF() {
        if (this.btZ == 0) {
            this.btZ = this.mBufferInfo.presentationTimeUs;
            bua = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.btZ;
        bua = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.a.d.Mf().aH(bua / 1000);
    }
}
