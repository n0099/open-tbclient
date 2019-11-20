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
    private long aya = 0;

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.b(z, byteBuffer, i, j);
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void bg(boolean z) {
        super.bg(z);
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void yJ() {
        super.yJ();
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void yK() {
        super.yK();
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ void yL() {
        super.yL();
    }

    @Override // com.baidu.mario.b.b.b
    public /* bridge */ /* synthetic */ long yh() {
        return super.yh();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.ayd = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.yV());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.yY());
            mediaFormat.setInteger("channel-count", dVar.yW());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.yX());
            mediaFormat.setInteger("max-input-size", dVar.yZ());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.yV());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.yP()) {
                    this.ayf = true;
                } else {
                    this.ayf = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.aye == null) {
                this.aye.ba(z);
                return;
            }
            return;
        }
        z = false;
        if (this.aye == null) {
        }
    }

    @Override // com.baidu.mario.b.b.b
    protected void yI() {
        if (this.ayg == 0) {
            this.ayg = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.ayg;
        if (this.mBufferInfo.presentationTimeUs < this.aya) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.aya + 10000;
            this.aya = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > ayh + 500000) {
            if (ayh > this.aya) {
                this.mBufferInfo.presentationTimeUs = ayh + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.aya + 5000;
            }
        }
        this.aya = this.mBufferInfo.presentationTimeUs;
        Log.d(TAG, "syncTimestamp mAudioEncoder = " + this.mBufferInfo.size + "|" + this.mBufferInfo.presentationTimeUs);
    }
}
