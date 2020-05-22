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
    private long box = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long KQ() {
        return super.KQ();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Lq() {
        super.Lq();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Lr() {
        super.Lr();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Ls() {
        super.Ls();
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
    public /* bridge */ /* synthetic */ void cE(boolean z) {
        super.cE(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.boA = eVar;
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
                    this.boC = true;
                } else {
                    this.boC = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.boB == null) {
                this.boB.cy(z);
                return;
            }
            return;
        }
        z = false;
        if (this.boB == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void Lp() {
        if (this.boD == 0) {
            this.boD = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.boD;
        if (this.mBufferInfo.presentationTimeUs < this.box) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.box + 10000;
            this.box = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > boE + 500000) {
            if (boE > this.box) {
                this.mBufferInfo.presentationTimeUs = boE + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.box + 5000;
            }
        }
        if (boE > this.mBufferInfo.presentationTimeUs + 500000) {
            boF = FeatureCodes.FACE;
        }
        this.box = this.mBufferInfo.presentationTimeUs;
    }
}
