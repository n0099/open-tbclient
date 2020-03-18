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
    private long aLa = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long CT() {
        return super.CT();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Dt() {
        super.Dt();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Du() {
        super.Du();
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
    public /* bridge */ /* synthetic */ void bJ(boolean z) {
        super.bJ(z);
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
            this.aLd = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.DE());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.DH());
            mediaFormat.setInteger("channel-count", dVar.DF());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.DG());
            mediaFormat.setInteger("max-input-size", dVar.DI());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.DE());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.Dy()) {
                    this.aLf = true;
                } else {
                    this.aLf = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aLe == null) {
                this.aLe.bD(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aLe == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void Ds() {
        if (this.aLg == 0) {
            this.aLg = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.aLg;
        if (this.mBufferInfo.presentationTimeUs < this.aLa) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.aLa + 10000;
            this.aLa = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > aLh + 500000) {
            if (aLh > this.aLa) {
                this.mBufferInfo.presentationTimeUs = aLh + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.aLa + 5000;
            }
        }
        if (aLh > this.mBufferInfo.presentationTimeUs + 500000) {
            aLi = 1200;
        }
        this.aLa = this.mBufferInfo.presentationTimeUs;
    }
}
