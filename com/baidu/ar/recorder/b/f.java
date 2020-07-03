package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.record.EncoderParams;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public class f extends b {
    private static final String TAG = f.class.getSimpleName();
    private Surface tF;

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void R(boolean z) {
        super.R(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(EncoderParams encoderParams, d dVar) {
        boolean z = true;
        if (encoderParams != null && dVar != null) {
            this.tx = dVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(encoderParams.getVideoCodec(), encoderParams.getVideoWidth(), encoderParams.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, encoderParams.getVideoBitrate());
            createVideoFormat.setInteger("frame-rate", encoderParams.getVideoFrameRate());
            createVideoFormat.setInteger("i-frame-interval", encoderParams.getVideoIFrameInterval());
            try {
                this.ty = MediaCodec.createEncoderByType(encoderParams.getVideoCodec());
                this.ty.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.tF = this.ty.createInputSurface();
                this.tB = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.tA == null) {
                this.tA.a(z, this.tF);
                return;
            }
            return;
        }
        z = false;
        if (this.tA == null) {
        }
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.a(z, byteBuffer, i, j);
    }

    @Override // com.baidu.ar.recorder.b.b
    protected void eD() {
        if (this.tC == 0) {
            this.tC = this.tz.presentationTimeUs;
        }
        this.tz.presentationTimeUs -= this.tC;
        com.baidu.ar.f.b.c(TAG, "syncTimestamp mVideoEncoder = " + this.tz.size + "|" + this.tz.presentationTimeUs);
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void eE() {
        super.eE();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void eF() {
        super.eF();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void eG() {
        super.eG();
    }
}
