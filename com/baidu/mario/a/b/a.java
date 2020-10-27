package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.auth.FeatureCodes;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long bSc = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long WJ() {
        return super.WJ();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Xj() {
        super.Xj();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Xk() {
        super.Xk();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Xl() {
        super.Xl();
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
    public /* bridge */ /* synthetic */ void dr(boolean z) {
        super.dr(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.bSf = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", dVar.getAudioCodec());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.getAudioSampleRate());
            mediaFormat.setInteger("channel-count", dVar.getAudioChannel());
            mediaFormat.setInteger("bitrate", dVar.getAudioBitrate());
            mediaFormat.setInteger("max-input-size", dVar.getAudioFrameSize());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.getAudioCodec());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.isVideoIncluded()) {
                    this.bSh = true;
                } else {
                    this.bSh = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bSg == null) {
                this.bSg.dl(z);
                return;
            }
            return;
        }
        z = false;
        if (this.bSg == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void Xi() {
        if (this.bSi == 0) {
            this.bSi = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.bSi;
        if (this.mBufferInfo.presentationTimeUs < this.bSc) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.bSc + 10000;
            this.bSc = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > bSj + 500000) {
            if (bSj > this.bSc) {
                this.mBufferInfo.presentationTimeUs = bSj + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.bSc + 5000;
            }
        }
        if (bSj > this.mBufferInfo.presentationTimeUs + 500000) {
            bSk = FeatureCodes.FACE;
        }
        this.bSc = this.mBufferInfo.presentationTimeUs;
    }
}
