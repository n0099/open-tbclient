package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.record.EncoderParams;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long tZ = 0;

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void S(boolean z) {
        super.S(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(EncoderParams encoderParams, d dVar) {
        boolean z = true;
        if (encoderParams != null && dVar != null) {
            this.uc = dVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", encoderParams.getAudioCodec());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", encoderParams.getAudioSampleRate());
            mediaFormat.setInteger("channel-count", encoderParams.getAudioChannel());
            mediaFormat.setInteger("bitrate", encoderParams.getAudioBitrate());
            mediaFormat.setInteger("max-input-size", encoderParams.getAudioFrameSize());
            try {
                this.ud = MediaCodec.createEncoderByType(encoderParams.getAudioCodec());
                this.ud.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (encoderParams.isVideoIncluded()) {
                    this.ug = false;
                } else {
                    this.ug = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.uf == null) {
                this.uf.a(z, null);
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
        if (this.ue.presentationTimeUs < this.tZ) {
            MediaCodec.BufferInfo bufferInfo = this.ue;
            long j = this.tZ + 10000;
            this.tZ = j;
            bufferInfo.presentationTimeUs = j;
        }
        this.tZ = this.ue.presentationTimeUs;
        com.baidu.ar.g.b.c(TAG, "syncTimestamp mAudioEncoder = " + this.ue.size + "|" + this.ue.presentationTimeUs);
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
