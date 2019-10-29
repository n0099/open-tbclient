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
    private long ays = 0;

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
    public /* bridge */ /* synthetic */ void yI() {
        super.yI();
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
    public /* bridge */ /* synthetic */ long yg() {
        return super.yg();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.ayv = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.yU());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.yX());
            mediaFormat.setInteger("channel-count", dVar.yV());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.yW());
            mediaFormat.setInteger("max-input-size", dVar.yY());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.yU());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.yO()) {
                    this.ayx = true;
                } else {
                    this.ayx = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.ayw == null) {
                this.ayw.ba(z);
                return;
            }
            return;
        }
        z = false;
        if (this.ayw == null) {
        }
    }

    @Override // com.baidu.mario.b.b.b
    protected void yH() {
        if (this.ayy == 0) {
            this.ayy = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.ayy;
        if (this.mBufferInfo.presentationTimeUs < this.ays) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.ays + 10000;
            this.ays = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > ayz + 500000) {
            if (ayz > this.ays) {
                this.mBufferInfo.presentationTimeUs = ayz + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.ays + 5000;
            }
        }
        this.ays = this.mBufferInfo.presentationTimeUs;
        Log.d(TAG, "syncTimestamp mAudioEncoder = " + this.mBufferInfo.size + "|" + this.mBufferInfo.presentationTimeUs);
    }
}
