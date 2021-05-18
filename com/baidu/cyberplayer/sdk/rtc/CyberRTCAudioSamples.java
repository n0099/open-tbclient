package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes2.dex */
public class CyberRTCAudioSamples {

    /* renamed from: a  reason: collision with root package name */
    public final int f5061a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5062b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5063c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f5064d;

    @Keep
    /* loaded from: classes2.dex */
    public interface CyberRTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(CyberRTCAudioSamples cyberRTCAudioSamples);
    }

    public CyberRTCAudioSamples(int i2, int i3, int i4, byte[] bArr) {
        this.f5061a = i2;
        this.f5062b = i3;
        this.f5063c = i4;
        this.f5064d = bArr;
    }

    public int getAudioFormat() {
        return this.f5061a;
    }

    public int getChannelCount() {
        return this.f5062b;
    }

    public byte[] getData() {
        return this.f5064d;
    }

    public int getSampleRate() {
        return this.f5063c;
    }
}
