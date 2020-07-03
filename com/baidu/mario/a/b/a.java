package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.auth.FeatureCodes;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes11.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long btx = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long LZ() {
        return super.LZ();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void MA() {
        super.MA();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void MB() {
        super.MB();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Mz() {
        super.Mz();
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
    public /* bridge */ /* synthetic */ void cK(boolean z) {
        super.cK(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.btA = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.getAudioCodec());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.getAudioSampleRate());
            mediaFormat.setInteger("channel-count", dVar.getAudioChannel());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.getAudioBitrate());
            mediaFormat.setInteger("max-input-size", dVar.getAudioFrameSize());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.getAudioCodec());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.isVideoIncluded()) {
                    this.btC = true;
                } else {
                    this.btC = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.btB == null) {
                this.btB.cE(z);
                return;
            }
            return;
        }
        z = false;
        if (this.btB == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void My() {
        if (this.btD == 0) {
            this.btD = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.btD;
        if (this.mBufferInfo.presentationTimeUs < this.btx) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.btx + 10000;
            this.btx = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > btE + 500000) {
            if (btE > this.btx) {
                this.mBufferInfo.presentationTimeUs = btE + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.btx + 5000;
            }
        }
        if (btE > this.mBufferInfo.presentationTimeUs + 500000) {
            btF = FeatureCodes.FACE;
        }
        this.btx = this.mBufferInfo.presentationTimeUs;
    }
}
