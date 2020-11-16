package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.auth.FeatureCodes;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long bWc = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void YZ() {
        super.YZ();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long Yz() {
        return super.Yz();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Za() {
        super.Za();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Zb() {
        super.Zb();
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
    public /* bridge */ /* synthetic */ void dA(boolean z) {
        super.dA(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.bWf = eVar;
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
                    this.bWh = true;
                } else {
                    this.bWh = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bWg == null) {
                this.bWg.du(z);
                return;
            }
            return;
        }
        z = false;
        if (this.bWg == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void YY() {
        if (this.bWi == 0) {
            this.bWi = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.bWi;
        if (this.mBufferInfo.presentationTimeUs < this.bWc) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.bWc + 10000;
            this.bWc = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > bWj + 500000) {
            if (bWj > this.bWc) {
                this.mBufferInfo.presentationTimeUs = bWj + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.bWc + 5000;
            }
        }
        if (bWj > this.mBufferInfo.presentationTimeUs + 500000) {
            bWk = FeatureCodes.FACE;
        }
        this.bWc = this.mBufferInfo.presentationTimeUs;
    }
}
