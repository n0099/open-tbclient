package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.auth.FeatureCodes;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.misc.IMediaFormat;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class a extends b {
    private static final String TAG = a.class.getSimpleName();
    private long cib = 0;

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ long acN() {
        return super.acN();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void adn() {
        super.adn();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void ado() {
        super.ado();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void adp() {
        super.adp();
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.b(z, byteBuffer, i, j);
    }

    @Override // com.baidu.mario.a.b.b
    public /* bridge */ /* synthetic */ void dV(boolean z) {
        super.dV(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, e eVar) {
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.cif = eVar;
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
                    this.cih = true;
                } else {
                    this.cih = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.cig == null) {
                this.cig.dP(z);
                return;
            }
            return;
        }
        z = false;
        if (this.cig == null) {
        }
    }

    @Override // com.baidu.mario.a.b.b
    protected void adm() {
        if (this.cii == 0) {
            this.cii = this.mBufferInfo.presentationTimeUs;
        }
        this.mBufferInfo.presentationTimeUs -= this.cii;
        if (this.mBufferInfo.presentationTimeUs < this.cib) {
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            long j = this.cib + 10000;
            this.cib = j;
            bufferInfo.presentationTimeUs = j;
        }
        if (this.mBufferInfo.presentationTimeUs > cij + 500000) {
            if (cij > this.cib) {
                this.mBufferInfo.presentationTimeUs = cij + 5000;
            } else {
                this.mBufferInfo.presentationTimeUs = this.cib + 5000;
            }
        }
        if (cij > this.mBufferInfo.presentationTimeUs + 500000) {
            cik = FeatureCodes.FACE;
        }
        this.cib = this.mBufferInfo.presentationTimeUs;
    }
}
