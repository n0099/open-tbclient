package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.record.EncoderParams;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long uM = 0;

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void Q(boolean z) {
        super.Q(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(EncoderParams encoderParams, d dVar) {
        boolean z = true;
        if (encoderParams != null && dVar != null) {
            this.uP = dVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", encoderParams.getAudioCodec());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", encoderParams.getAudioSampleRate());
            mediaFormat.setInteger("channel-count", encoderParams.getAudioChannel());
            mediaFormat.setInteger("bitrate", encoderParams.getAudioBitrate());
            mediaFormat.setInteger("max-input-size", encoderParams.getAudioFrameSize());
            try {
                this.uQ = MediaCodec.createEncoderByType(encoderParams.getAudioCodec());
                this.uQ.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (encoderParams.isVideoIncluded()) {
                    this.uT = false;
                } else {
                    this.uT = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.uS == null) {
                this.uS.a(z, null);
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
        if (this.uR.presentationTimeUs < this.uM) {
            MediaCodec.BufferInfo bufferInfo = this.uR;
            long j = this.uM + 10000;
            this.uM = j;
            bufferInfo.presentationTimeUs = j;
        }
        this.uM = this.uR.presentationTimeUs;
        com.baidu.ar.h.b.c(TAG, "syncTimestamp mAudioEncoder = " + this.uR.size + "|" + this.uR.presentationTimeUs);
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
