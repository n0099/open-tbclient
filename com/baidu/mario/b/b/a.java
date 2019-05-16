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
    private long aex = 0;

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void aL(boolean z) {
        super.aL(z);
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.b(z, byteBuffer, i, j);
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ long sO() {
        return super.sO();
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void tp() {
        super.tp();
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void tq() {
        super.tq();
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void tr() {
        super.tr();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.aeA = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.tB());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.getAudioSampleRate());
            mediaFormat.setInteger("channel-count", dVar.tC());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.tD());
            mediaFormat.setInteger("max-input-size", dVar.tE());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.tB());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.tv()) {
                    this.aeC = true;
                } else {
                    this.aeC = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aeB == null) {
                this.aeB.aF(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aeB == null) {
        }
    }

    @Override // com.baidu.mario.b.b.b
    protected void tn() {
        if (this.aeD == 0) {
            this.aeD = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.aeD;
        if (this.mBufferInfo.presentationTimeUs < this.aex) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.aex + 10000;
            this.aex = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > aeE + 500000) {
            if (aeE > this.aex) {
                this.mBufferInfo.presentationTimeUs = aeE + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.aex + 5000;
            }
        }
        this.aex = this.mBufferInfo.presentationTimeUs;
        Log.d(TAG, "syncTimestamp mAudioEncoder = " + this.mBufferInfo.size + "|" + this.mBufferInfo.presentationTimeUs);
    }
}
