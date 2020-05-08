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
    private long bgZ = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long IX() {
        return super.IX();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Jx() {
        super.Jx();
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
            this.bhc = eVar;
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
                    this.bhe = true;
                } else {
                    this.bhe = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.bhd == null) {
                this.bhd.cm(z);
                return;
            }
            return;
        }
        z = false;
        if (this.bhd == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void Jw() {
        if (this.bhf == 0) {
            this.bhf = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.bhf;
        if (this.mBufferInfo.presentationTimeUs < this.bgZ) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.bgZ + 10000;
            this.bgZ = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > bhg + 500000) {
            if (bhg > this.bgZ) {
                this.mBufferInfo.presentationTimeUs = bhg + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.bgZ + 5000;
            }
        }
        if (bhg > this.mBufferInfo.presentationTimeUs + 500000) {
            bhh = FeatureCodes.FACE;
        }
        this.bgZ = this.mBufferInfo.presentationTimeUs;
    }
}
