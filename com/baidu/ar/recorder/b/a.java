package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.record.EncoderParams;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long tu = 0;

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void R(boolean z) {
        super.R(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(EncoderParams encoderParams, d dVar) {
        boolean z = true;
        if (encoderParams != null && dVar != null) {
            this.tx = dVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, encoderParams.getAudioCodec());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", encoderParams.getAudioSampleRate());
            mediaFormat.setInteger("channel-count", encoderParams.getAudioChannel());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, encoderParams.getAudioBitrate());
            mediaFormat.setInteger("max-input-size", encoderParams.getAudioFrameSize());
            try {
                this.ty = MediaCodec.createEncoderByType(encoderParams.getAudioCodec());
                this.ty.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (encoderParams.isVideoIncluded()) {
                    this.tB = false;
                } else {
                    this.tB = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.tA == null) {
                this.tA.a(z, null);
                return;
            }
            return;
        }
        z = false;
        if (this.tA == null) {
        }
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.a(z, byteBuffer, i, j);
    }

    @Override // com.baidu.ar.recorder.b.b
    protected void eD() {
        if (this.tC == 0) {
            this.tC = this.tz.presentationTimeUs;
        }
        this.tz.presentationTimeUs -= this.tC;
        if (this.tz.presentationTimeUs < this.tu) {
            MediaCodec.BufferInfo bufferInfo = this.tz;
            long j = this.tu + 10000;
            this.tu = j;
            bufferInfo.presentationTimeUs = j;
        }
        this.tu = this.tz.presentationTimeUs;
        com.baidu.ar.f.b.c(TAG, "syncTimestamp mAudioEncoder = " + this.tz.size + "|" + this.tz.presentationTimeUs);
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void eE() {
        super.eE();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void eF() {
        super.eF();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void eG() {
        super.eG();
    }
}
