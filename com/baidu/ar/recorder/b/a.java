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
    private long sU = 0;

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void Q(boolean z) {
        super.Q(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(EncoderParams encoderParams, d dVar) {
        boolean z = true;
        if (encoderParams != null && dVar != null) {
            this.sX = dVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, encoderParams.getAudioCodec());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", encoderParams.getAudioSampleRate());
            mediaFormat.setInteger("channel-count", encoderParams.getAudioChannel());
            mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, encoderParams.getAudioBitrate());
            mediaFormat.setInteger("max-input-size", encoderParams.getAudioFrameSize());
            try {
                this.sY = MediaCodec.createEncoderByType(encoderParams.getAudioCodec());
                this.sY.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (encoderParams.isVideoIncluded()) {
                    this.tb = false;
                } else {
                    this.tb = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.ta == null) {
                this.ta.a(z, null);
                return;
            }
            return;
        }
        z = false;
        if (this.ta == null) {
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
    protected void en() {
        if (this.tc == 0) {
            this.tc = this.sZ.presentationTimeUs;
        }
        this.sZ.presentationTimeUs -= this.tc;
        if (this.sZ.presentationTimeUs < this.sU) {
            MediaCodec.BufferInfo bufferInfo = this.sZ;
            long j = this.sU + 10000;
            this.sU = j;
            bufferInfo.presentationTimeUs = j;
        }
        this.sU = this.sZ.presentationTimeUs;
        com.baidu.ar.f.b.c(TAG, "syncTimestamp mAudioEncoder = " + this.sZ.size + "|" + this.sZ.presentationTimeUs);
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void eo() {
        super.eo();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void ep() {
        super.ep();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void eq() {
        super.eq();
    }
}
