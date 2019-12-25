package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes9.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long aFN = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Ay() {
        super.Ay();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Az() {
        super.Az();
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
    public /* bridge */ /* synthetic */ void bv(boolean z) {
        super.bv(z);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void releaseEncoder() {
        super.releaseEncoder();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long zY() {
        return super.zY();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.aFQ = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.AJ());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.AM());
            mediaFormat.setInteger("channel-count", dVar.AK());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.AL());
            mediaFormat.setInteger("max-input-size", dVar.AN());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.AJ());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.AD()) {
                    this.aFS = true;
                } else {
                    this.aFS = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aFR == null) {
                this.aFR.bp(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aFR == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void Ax() {
        if (this.aFT == 0) {
            this.aFT = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.aFT;
        if (this.mBufferInfo.presentationTimeUs < this.aFN) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.aFN + 10000;
            this.aFN = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > aFU + 500000) {
            if (aFU > this.aFN) {
                this.mBufferInfo.presentationTimeUs = aFU + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.aFN + 5000;
            }
        }
        if (aFU > this.mBufferInfo.presentationTimeUs + 500000) {
            aFV = 1200;
        }
        this.aFN = this.mBufferInfo.presentationTimeUs;
    }
}
