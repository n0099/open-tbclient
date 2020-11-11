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
    private long bXM = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void ZI() {
        super.ZI();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void ZJ() {
        super.ZJ();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void ZK() {
        super.ZK();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long Zi() {
        return super.Zi();
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
    public /* bridge */ /* synthetic */ void dy(boolean z) {
        super.dy(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.bXP = eVar;
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
                    this.bXR = true;
                } else {
                    this.bXR = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bXQ == null) {
                this.bXQ.ds(z);
                return;
            }
            return;
        }
        z = false;
        if (this.bXQ == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void ZH() {
        if (this.bXS == 0) {
            this.bXS = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.bXS;
        if (this.mBufferInfo.presentationTimeUs < this.bXM) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.bXM + 10000;
            this.bXM = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > bXT + 500000) {
            if (bXT > this.bXM) {
                this.mBufferInfo.presentationTimeUs = bXT + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.bXM + 5000;
            }
        }
        if (bXT > this.mBufferInfo.presentationTimeUs + 500000) {
            bXU = FeatureCodes.FACE;
        }
        this.bXM = this.mBufferInfo.presentationTimeUs;
    }
}
