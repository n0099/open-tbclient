package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.auth.FeatureCodes;
import java.nio.ByteBuffer;
/* loaded from: classes14.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long cbr = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void abC() {
        super.abC();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void abD() {
        super.abD();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void abE() {
        super.abE();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long abc() {
        return super.abc();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.b(z, byteBuffer, i, j);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void dO(boolean z) {
        super.dO(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.cbu = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", dVar.getAudioCodec());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.getAudioSampleRate());
            mediaFormat.setInteger("channel-count", dVar.getAudioChannel());
            mediaFormat.setInteger("bitrate", dVar.getAudioBitrate());
            mediaFormat.setInteger("max-input-size", dVar.getAudioFrameSize());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.getAudioCodec());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.isVideoIncluded()) {
                    this.cbw = true;
                } else {
                    this.cbw = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.cbv == null) {
                this.cbv.dI(z);
                return;
            }
            return;
        }
        z = false;
        if (this.cbv == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void abB() {
        if (this.cbx == 0) {
            this.cbx = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.cbx;
        if (this.mBufferInfo.presentationTimeUs < this.cbr) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.cbr + 10000;
            this.cbr = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > cby + 500000) {
            if (cby > this.cbr) {
                this.mBufferInfo.presentationTimeUs = cby + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.cbr + 5000;
            }
        }
        if (cby > this.mBufferInfo.presentationTimeUs + 500000) {
            cbz = FeatureCodes.FACE;
        }
        this.cbr = this.mBufferInfo.presentationTimeUs;
    }
}
