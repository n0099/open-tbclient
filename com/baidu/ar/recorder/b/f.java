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
    private Surface tf;

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
            this.sX = dVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(encoderParams.getVideoCodec(), encoderParams.getVideoWidth(), encoderParams.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, encoderParams.getVideoBitrate());
            createVideoFormat.setInteger("frame-rate", encoderParams.getVideoFrameRate());
            createVideoFormat.setInteger("i-frame-interval", encoderParams.getVideoIFrameInterval());
            try {
                this.sY = MediaCodec.createEncoderByType(encoderParams.getVideoCodec());
                this.sY.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.tf = this.sY.createInputSurface();
                this.tb = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.ta == null) {
                this.ta.a(z, this.tf);
                return;
            }
            return;
        }
        z = false;
        if (this.ta == null) {
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
    protected void en() {
        if (this.tc == 0) {
            this.tc = this.sZ.presentationTimeUs;
        }
        this.sZ.presentationTimeUs -= this.tc;
        com.baidu.ar.f.b.c(TAG, "syncTimestamp mVideoEncoder = " + this.sZ.size + "|" + this.sZ.presentationTimeUs);
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void eo() {
        super.eo();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void ep() {
        super.ep();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void eq() {
        super.eq();
    }
}
