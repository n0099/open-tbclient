package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes2.dex */
public class CyberRTCAudioSamples {

    /* renamed from: a  reason: collision with root package name */
    public final int f4961a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4962b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4963c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f4964d;

    @Keep
    /* loaded from: classes2.dex */
    public interface CyberRTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(CyberRTCAudioSamples cyberRTCAudioSamples);
    }

    public CyberRTCAudioSamples(int i2, int i3, int i4, byte[] bArr) {
        this.f4961a = i2;
        this.f4962b = i3;
        this.f4963c = i4;
        this.f4964d = bArr;
    }

    public int getAudioFormat() {
        return this.f4961a;
    }

    public int getChannelCount() {
        return this.f4962b;
    }

    public byte[] getData() {
        return this.f4964d;
    }

    public int getSampleRate() {
        return this.f4963c;
    }
}
