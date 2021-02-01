package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.auth.FeatureCodes;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.misc.IMediaFormat;
import java.nio.ByteBuffer;
/* loaded from: classes15.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long chx = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long aaO() {
        return super.aaO();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.b(z, byteBuffer, i, j);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void dZ(boolean z) {
        super.dZ(z);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void releaseEncoder() {
        super.releaseEncoder();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void startEncoder() {
        super.startEncoder();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void stopEncoder() {
        super.stopEncoder();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.chA = eVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, dVar.getAudioCodec());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", dVar.getAudioSampleRate());
            mediaFormat.setInteger("channel-count", dVar.getAudioChannel());
            mediaFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, dVar.getAudioBitrate());
            mediaFormat.setInteger("max-input-size", dVar.getAudioFrameSize());
            try {
                this.mEncoder = MediaCodec.createEncoderByType(dVar.getAudioCodec());
                this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (!dVar.isVideoIncluded()) {
                    this.chC = true;
                } else {
                    this.chC = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.chB == null) {
                this.chB.dT(z);
                return;
            }
            return;
        }
        z = false;
        if (this.chB == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void abm() {
        if (this.chD == 0) {
            this.chD = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.chD;
        if (this.mBufferInfo.presentationTimeUs < this.chx) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.chx + 10000;
            this.chx = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > chE + 500000) {
            if (chE > this.chx) {
                this.mBufferInfo.presentationTimeUs = chE + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.chx + 5000;
            }
        }
        if (chE > this.mBufferInfo.presentationTimeUs + 500000) {
            chF = FeatureCodes.FACE;
        }
        this.chx = this.mBufferInfo.presentationTimeUs;
    }
}
