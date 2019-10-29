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

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.ayv = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.yP(), dVar.getVideoWidth(), dVar.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, dVar.yQ());
            createVideoFormat.setInteger("frame-rate", dVar.yR());
            createVideoFormat.setInteger("i-frame-interval", dVar.yS());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.yP());
                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mInputSurface = this.mEncoder.createInputSurface();
                this.ayx = true;
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

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @Override // com.baidu.mario.b.b.b
    protected void yH() {
        if (this.ayy == 0) {
            this.ayy = this.mBufferInfo.presentationTimeUs;
            ayz = 0L;
        }
        this.mBufferInfo.presentationTimeUs -= this.ayy;
        ayz = this.mBufferInfo.presentationTimeUs;
        com.baidu.mario.b.c.yf().Q(ayz / 1000);
        Log.d(TAG, "syncTimestamp mVideoEncoder = " + this.mBufferInfo.size + "|" + this.mBufferInfo.presentationTimeUs);
    }
}
