package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes2.dex */
public class CyberRTCAudioSamples {

    /* renamed from: a  reason: collision with root package name */
    public final int f5042a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5043b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5044c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f5045d;

    @Keep
    /* loaded from: classes2.dex */
    public interface CyberRTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(CyberRTCAudioSamples cyberRTCAudioSamples);
    }

    public CyberRTCAudioSamples(int i, int i2, int i3, byte[] bArr) {
        this.f5042a = i;
        this.f5043b = i2;
        this.f5044c = i3;
        this.f5045d = bArr;
    }

    public int getAudioFormat() {
        return this.f5042a;
    }

    public int getChannelCount() {
        return this.f5043b;
    }

    public byte[] getData() {
        return this.f5045d;
    }

    public int getSampleRate() {
        return this.f5044c;
    }
}
