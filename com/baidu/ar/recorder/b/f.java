package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.record.EncoderParams;
import java.nio.ByteBuffer;
/* loaded from: classes12.dex */
public class f extends b {
    private static final String TAG = f.class.getSimpleName();
    private Surface uk;

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void S(boolean z) {
        super.S(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(EncoderParams encoderParams, d dVar) {
        boolean z = true;
        if (encoderParams != null && dVar != null) {
            this.uc = dVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(encoderParams.getVideoCodec(), encoderParams.getVideoWidth(), encoderParams.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", encoderParams.getVideoBitrate());
            createVideoFormat.setInteger("frame-rate", encoderParams.getVideoFrameRate());
            createVideoFormat.setInteger("i-frame-interval", encoderParams.getVideoIFrameInterval());
            try {
                this.ud = MediaCodec.createEncoderByType(encoderParams.getVideoCodec());
                this.ud.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.uk = this.ud.createInputSurface();
                this.ug = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.uf == null) {
                this.uf.a(z, this.uk);
                return;
            }
            return;
        }
        z = false;
        if (this.uf == null) {
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
    protected void fP() {
        if (this.uh == 0) {
            this.uh = this.ue.presentationTimeUs;
        }
        this.ue.presentationTimeUs -= this.uh;
        com.baidu.ar.g.b.c(TAG, "syncTimestamp mVideoEncoder = " + this.ue.size + "|" + this.ue.presentationTimeUs);
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void fQ() {
        super.fQ();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void fR() {
        super.fR();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void fS() {
        super.fS();
    }
}
