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
    private long bgU = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long IY() {
        return super.IY();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void JA() {
        super.JA();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Jy() {
        super.Jy();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Jz() {
        super.Jz();
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
    public /* bridge */ /* synthetic */ void cs(boolean z) {
        super.cs(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.bgX = eVar;
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
                    this.bgZ = true;
                } else {
                    this.bgZ = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bgY == null) {
                this.bgY.cm(z);
                return;
            }
            return;
        }
        z = false;
        if (this.bgY == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void Jx() {
        if (this.bha == 0) {
            this.bha = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.bha;
        if (this.mBufferInfo.presentationTimeUs < this.bgU) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.bgU + 10000;
            this.bgU = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > bhb + 500000) {
            if (bhb > this.bgU) {
                this.mBufferInfo.presentationTimeUs = bhb + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.bgU + 5000;
            }
        }
        if (bhb > this.mBufferInfo.presentationTimeUs + 500000) {
            bhc = FeatureCodes.FACE;
        }
        this.bgU = this.mBufferInfo.presentationTimeUs;
    }
}
