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
    private long aKK = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long CK() {
        return super.CK();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Dk() {
        super.Dk();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Dl() {
        super.Dl();
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
            this.aKN = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.Dv());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.Dy());
            mediaFormat.setInteger("channel-count", dVar.Dw());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.Dx());
            mediaFormat.setInteger("max-input-size", dVar.Dz());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.Dv());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.Dp()) {
                    this.aKP = true;
                } else {
                    this.aKP = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aKO == null) {
                this.aKO.bC(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aKO == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void Dj() {
        if (this.aKQ == 0) {
            this.aKQ = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.aKQ;
        if (this.mBufferInfo.presentationTimeUs < this.aKK) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.aKK + 10000;
            this.aKK = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > aKR + 500000) {
            if (aKR > this.aKK) {
                this.mBufferInfo.presentationTimeUs = aKR + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.aKK + 5000;
            }
        }
        if (aKR > this.mBufferInfo.presentationTimeUs + 500000) {
            aKS = 1200;
        }
        this.aKK = this.mBufferInfo.presentationTimeUs;
    }
}
