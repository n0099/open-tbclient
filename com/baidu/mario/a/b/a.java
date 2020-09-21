package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.auth.FeatureCodes;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long bDf = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long SW() {
        return super.SW();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Tw() {
        super.Tw();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Tx() {
        super.Tx();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Ty() {
        super.Ty();
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
    public /* bridge */ /* synthetic */ void cW(boolean z) {
        super.cW(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.bDi = eVar;
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
                    this.bDk = true;
                } else {
                    this.bDk = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bDj == null) {
                this.bDj.cQ(z);
                return;
            }
            return;
        }
        z = false;
        if (this.bDj == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void Tv() {
        if (this.bDl == 0) {
            this.bDl = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.bDl;
        if (this.mBufferInfo.presentationTimeUs < this.bDf) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.bDf + 10000;
            this.bDf = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > bDm + 500000) {
            if (bDm > this.bDf) {
                this.mBufferInfo.presentationTimeUs = bDm + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.bDf + 5000;
            }
        }
        if (bDm > this.mBufferInfo.presentationTimeUs + 500000) {
            bDn = FeatureCodes.FACE;
        }
        this.bDf = this.mBufferInfo.presentationTimeUs;
    }
}
