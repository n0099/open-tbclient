package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes6.dex */
public class CyberRTCAudioSamples {

    /* renamed from: a  reason: collision with root package name */
    private final int f1866a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1867b;
    private final int c;
    private final byte[] d;

    @Keep
    /* loaded from: classes6.dex */
    public interface CyberRTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(CyberRTCAudioSamples cyberRTCAudioSamples);
    }

    public CyberRTCAudioSamples(int i, int i2, int i3, byte[] bArr) {
        this.f1866a = i;
        this.f1867b = i2;
        this.c = i3;
        this.d = bArr;
    }

    public int getAudioFormat() {
        return this.f1866a;
    }

    public int getChannelCount() {
        return this.f1867b;
    }

    public byte[] getData() {
        return this.d;
    }

    public int getSampleRate() {
        return this.c;
    }
}
