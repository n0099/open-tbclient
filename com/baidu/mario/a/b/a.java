package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.auth.FeatureCodes;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long btT = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void MG() {
        super.MG();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void MH() {
        super.MH();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void MI() {
        super.MI();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long Mg() {
        return super.Mg();
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
    public /* bridge */ /* synthetic */ void cM(boolean z) {
        super.cM(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.btW = eVar;
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
                    this.btY = true;
                } else {
                    this.btY = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.btX == null) {
                this.btX.cG(z);
                return;
            }
            return;
        }
        z = false;
        if (this.btX == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void MF() {
        if (this.btZ == 0) {
            this.btZ = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.btZ;
        if (this.mBufferInfo.presentationTimeUs < this.btT) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.btT + 10000;
            this.btT = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > bua + 500000) {
            if (bua > this.btT) {
                this.mBufferInfo.presentationTimeUs = bua + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.btT + 5000;
            }
        }
        if (bua > this.mBufferInfo.presentationTimeUs + 500000) {
            bub = FeatureCodes.FACE;
        }
        this.btT = this.mBufferInfo.presentationTimeUs;
    }
}
