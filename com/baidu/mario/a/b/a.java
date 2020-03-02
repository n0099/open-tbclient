package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes11.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long aKL = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long CM() {
        return super.CM();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Dm() {
        super.Dm();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Dn() {
        super.Dn();
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
    public /* bridge */ /* synthetic */ void bI(boolean z) {
        super.bI(z);
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
            this.aKO = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.Dx());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.DA());
            mediaFormat.setInteger("channel-count", dVar.Dy());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.Dz());
            mediaFormat.setInteger("max-input-size", dVar.DB());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.Dx());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.Dr()) {
                    this.aKQ = true;
                } else {
                    this.aKQ = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aKP == null) {
                this.aKP.bC(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aKP == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void Dl() {
        if (this.aKR == 0) {
            this.aKR = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.aKR;
        if (this.mBufferInfo.presentationTimeUs < this.aKL) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.aKL + 10000;
            this.aKL = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > aKS + 500000) {
            if (aKS > this.aKL) {
                this.mBufferInfo.presentationTimeUs = aKS + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.aKL + 5000;
            }
        }
        if (aKS > this.mBufferInfo.presentationTimeUs + 500000) {
            aKT = 1200;
        }
        this.aKL = this.mBufferInfo.presentationTimeUs;
    }
}
