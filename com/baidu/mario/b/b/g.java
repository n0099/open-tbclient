package com.baidu.mario.b.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class g extends b {
    private static final String TAG = g.class.getSimpleName();
    private Surface mInputSurface;

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

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.aeA = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.tw(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.tx());
            createVideoFormat.setInteger("frame-rate", dVar.ty());
            createVideoFormat.setInteger("i-frame-interval", dVar.tz());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.tw());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.aeC = true;
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

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.b.b.b
    protected void tn() {
        if (this.aeD == 0) {
            this.aeD = this.mBufferInfo.presentationTimeUs;
            aeE = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.aeD;
        aeE = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.b.c.sN().x(aeE / 1000);
        Log.d(TAG, "syncTimestamp mVideoEncoder = " + this.mBufferInfo.size + "|" + this.mBufferInfo.presentationTimeUs);
    }
}
