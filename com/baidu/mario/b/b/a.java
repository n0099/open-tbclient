package com.baidu.mario.b.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long aeU = 0;

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void aO(boolean z) {
        super.aO(z);
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.b(z, byteBuffer, i, j);
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void tO() {
        super.tO();
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void tP() {
        super.tP();
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void tQ() {
        super.tQ();
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ long tm() {
        return super.tm();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.aeX = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.ua());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.ud());
            mediaFormat.setInteger("channel-count", dVar.ub());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.uc());
            mediaFormat.setInteger("max-input-size", dVar.ue());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.ua());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.tU()) {
                    this.aeZ = true;
                } else {
                    this.aeZ = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aeY == null) {
                this.aeY.aI(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aeY == null) {
        }
    }

    @Override // com.baidu.mario.b.b.b
    protected void tN() {
        if (this.afa == 0) {
            this.afa = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.afa;
        if (this.mBufferInfo.presentationTimeUs < this.aeU) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.aeU + 10000;
            this.aeU = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > afb + 500000) {
            if (afb > this.aeU) {
                this.mBufferInfo.presentationTimeUs = afb + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.aeU + 5000;
            }
        }
        this.aeU = this.mBufferInfo.presentationTimeUs;
        Log.d(TAG, "syncTimestamp mAudioEncoder = " + this.mBufferInfo.size + "|" + this.mBufferInfo.presentationTimeUs);
    }
}
