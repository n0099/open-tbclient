package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.auth.FeatureCodes;
import java.nio.ByteBuffer;
/* loaded from: classes20.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long bzF = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void SF() {
        super.SF();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void SG() {
        super.SG();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void SH() {
        super.SH();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long Sf() {
        return super.Sf();
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
    public /* bridge */ /* synthetic */ void cU(boolean z) {
        super.cU(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.bzI = eVar;
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
                    this.bzK = true;
                } else {
                    this.bzK = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bzJ == null) {
                this.bzJ.cO(z);
                return;
            }
            return;
        }
        z = false;
        if (this.bzJ == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void SE() {
        if (this.bzL == 0) {
            this.bzL = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.bzL;
        if (this.mBufferInfo.presentationTimeUs < this.bzF) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.bzF + 10000;
            this.bzF = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > bzM + 500000) {
            if (bzM > this.bzF) {
                this.mBufferInfo.presentationTimeUs = bzM + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.bzF + 5000;
            }
        }
        if (bzM > this.mBufferInfo.presentationTimeUs + 500000) {
            bzN = FeatureCodes.FACE;
        }
        this.bzF = this.mBufferInfo.presentationTimeUs;
    }
}
