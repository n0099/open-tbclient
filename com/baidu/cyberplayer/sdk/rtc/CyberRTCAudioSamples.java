package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes2.dex */
public class CyberRTCAudioSamples {

    /* renamed from: a  reason: collision with root package name */
    public final int f5207a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5208b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5209c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f5210d;

    @Keep
    /* loaded from: classes2.dex */
    public interface CyberRTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(CyberRTCAudioSamples cyberRTCAudioSamples);
    }

    public CyberRTCAudioSamples(int i2, int i3, int i4, byte[] bArr) {
        this.f5207a = i2;
        this.f5208b = i3;
        this.f5209c = i4;
        this.f5210d = bArr;
    }

    public int getAudioFormat() {
        return this.f5207a;
    }

    public int getChannelCount() {
        return this.f5208b;
    }

    public byte[] getData() {
        return this.f5210d;
    }

    public int getSampleRate() {
        return this.f5209c;
    }
}
