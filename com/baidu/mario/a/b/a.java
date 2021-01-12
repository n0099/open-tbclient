package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.auth.FeatureCodes;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.misc.IMediaFormat;
import java.nio.ByteBuffer;
/* loaded from: classes14.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long cdo = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long YV() {
        return super.YV();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Zv() {
        super.Zv();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Zw() {
        super.Zw();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void Zx() {
        super.Zx();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.b(z, byteBuffer, i, j);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void dR(boolean z) {
        super.dR(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.cdr = eVar;
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
                    this.cdu = true;
                } else {
                    this.cdu = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.cds == null) {
                this.cds.dL(z);
                return;
            }
            return;
        }
        z = false;
        if (this.cds == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void Zu() {
        if (this.cdv == 0) {
            this.cdv = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.cdv;
        if (this.mBufferInfo.presentationTimeUs < this.cdo) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.cdo + 10000;
            this.cdo = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > cdw + 500000) {
            if (cdw > this.cdo) {
                this.mBufferInfo.presentationTimeUs = cdw + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.cdo + 5000;
            }
        }
        if (cdw > this.mBufferInfo.presentationTimeUs + 500000) {
            cdx = FeatureCodes.FACE;
        }
        this.cdo = this.mBufferInfo.presentationTimeUs;
    }
}
