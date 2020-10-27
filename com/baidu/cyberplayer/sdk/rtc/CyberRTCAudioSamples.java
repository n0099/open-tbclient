package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes12.dex */
public class CyberRTCAudioSamples {

    /* renamed from: a  reason: collision with root package name */
    private final int f1416a;
    private final int b;
    private final int c;
    private final byte[] d;

    @Keep
    /* loaded from: classes12.dex */
    public interface CyberRTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(CyberRTCAudioSamples cyberRTCAudioSamples);
    }

    public CyberRTCAudioSamples(int i, int i2, int i3, byte[] bArr) {
        this.f1416a = i;
        this.b = i2;
        this.c = i3;
        this.d = bArr;
    }

    public int getAudioFormat() {
        return this.f1416a;
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
