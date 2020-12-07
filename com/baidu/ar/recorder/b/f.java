package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.record.EncoderParams;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class f extends b {
    private static final String TAG = f.class.getSimpleName();
    private Surface uX;

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void Q(boolean z) {
        super.Q(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(EncoderParams encoderParams, d dVar) {
        boolean z = true;
        if (encoderParams != null && dVar != null) {
            this.uP = dVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(encoderParams.getVideoCodec(), encoderParams.getVideoWidth(), encoderParams.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", encoderParams.getVideoBitrate());
            createVideoFormat.setInteger("frame-rate", encoderParams.getVideoFrameRate());
            createVideoFormat.setInteger("i-frame-interval", encoderParams.getVideoIFrameInterval());
            try {
                this.uQ = MediaCodec.createEncoderByType(encoderParams.getVideoCodec());
                this.uQ.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.uX = this.uQ.createInputSurface();
                this.uT = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.uS == null) {
                this.uS.a(z, this.uX);
                return;
            }
            return;
        }
        z = false;
        if (this.uS == null) {
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
    protected void fQ() {
        if (this.uU == 0) {
            this.uU = this.uR.presentationTimeUs;
        }
        this.uR.presentationTimeUs -= this.uU;
        com.baidu.ar.h.b.c(TAG, "syncTimestamp mVideoEncoder = " + this.uR.size + "|" + this.uR.presentationTimeUs);
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void fR() {
        super.fR();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void fS() {
        super.fS();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void fT() {
        super.fT();
    }
}
