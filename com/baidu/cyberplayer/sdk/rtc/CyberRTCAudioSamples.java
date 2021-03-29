package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes.dex */
public class CyberRTCAudioSamples {

    /* renamed from: a  reason: collision with root package name */
    public final int f5043a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5044b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5045c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f5046d;

    @Keep
    /* loaded from: classes.dex */
    public interface CyberRTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(CyberRTCAudioSamples cyberRTCAudioSamples);
    }

    public CyberRTCAudioSamples(int i, int i2, int i3, byte[] bArr) {
        this.f5043a = i;
        this.f5044b = i2;
        this.f5045c = i3;
        this.f5046d = bArr;
    }

    public int getAudioFormat() {
        return this.f5043a;
    }

    public int getChannelCount() {
        return this.f5044b;
    }

    public byte[] getData() {
        return this.f5046d;
    }

    public int getSampleRate() {
        return this.f5045c;
    }
}
