package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes17.dex */
public class CyberRTCAudioSamples {

    /* renamed from: a  reason: collision with root package name */
    private final int f1420a;
    private final int b;
    private final int c;
    private final byte[] d;

    @Keep
    /* loaded from: classes17.dex */
    public interface CyberRTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(CyberRTCAudioSamples cyberRTCAudioSamples);
    }

    public CyberRTCAudioSamples(int i, int i2, int i3, byte[] bArr) {
        this.f1420a = i;
        this.b = i2;
        this.c = i3;
        this.d = bArr;
    }

    public int getAudioFormat() {
        return this.f1420a;
    }

    public int getChannelCount() {
        return this.b;
    }

    public byte[] getData() {
        return this.d;
    }

    public int getSampleRate() {
        return this.c;
    }
}
