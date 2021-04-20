package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes.dex */
public class CyberRTCAudioSamples {

    /* renamed from: a  reason: collision with root package name */
    public final int f5078a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5079b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5080c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f5081d;

    @Keep
    /* loaded from: classes.dex */
    public interface CyberRTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(CyberRTCAudioSamples cyberRTCAudioSamples);
    }

    public CyberRTCAudioSamples(int i, int i2, int i3, byte[] bArr) {
        this.f5078a = i;
        this.f5079b = i2;
        this.f5080c = i3;
        this.f5081d = bArr;
    }

    public int getAudioFormat() {
        return this.f5078a;
    }

    public int getChannelCount() {
        return this.f5079b;
    }

    public byte[] getData() {
        return this.f5081d;
    }

    public int getSampleRate() {
        return this.f5080c;
    }
}
