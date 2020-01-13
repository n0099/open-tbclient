package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes10.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long aGF = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void AU() {
        super.AU();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void AV() {
        super.AV();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long Au() {
        return super.Au();
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
    public /* bridge */ /* synthetic */ void bA(boolean z) {
        super.bA(z);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void releaseEncoder() {
        super.releaseEncoder();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.aGI = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.Bf());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.Bi());
            mediaFormat.setInteger("channel-count", dVar.Bg());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.Bh());
            mediaFormat.setInteger("max-input-size", dVar.Bj());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.Bf());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.AZ()) {
                    this.aGK = true;
                } else {
                    this.aGK = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aGJ == null) {
                this.aGJ.bu(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aGJ == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void AT() {
        if (this.aGL == 0) {
            this.aGL = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.aGL;
        if (this.mBufferInfo.presentationTimeUs < this.aGF) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.aGF + 10000;
            this.aGF = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > aGM + 500000) {
            if (aGM > this.aGF) {
                this.mBufferInfo.presentationTimeUs = aGM + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.aGF + 5000;
            }
        }
        if (aGM > this.mBufferInfo.presentationTimeUs + 500000) {
            aGN = 1200;
        }
        this.aGF = this.mBufferInfo.presentationTimeUs;
    }
}
