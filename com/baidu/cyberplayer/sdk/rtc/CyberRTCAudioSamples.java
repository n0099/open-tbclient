package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes2.dex */
public class CyberRTCAudioSamples {

    /* renamed from: a  reason: collision with root package name */
    public final int f4974a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4975b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4976c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f4977d;

    @Keep
    /* loaded from: classes2.dex */
    public interface CyberRTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(CyberRTCAudioSamples cyberRTCAudioSamples);
    }

    public CyberRTCAudioSamples(int i2, int i3, int i4, byte[] bArr) {
        this.f4974a = i2;
        this.f4975b = i3;
        this.f4976c = i4;
        this.f4977d = bArr;
    }

    public int getAudioFormat() {
        return this.f4974a;
    }

    public int getChannelCount() {
        return this.f4975b;
    }

    public byte[] getData() {
        return this.f4977d;
    }

    public int getSampleRate() {
        return this.f4976c;
    }
}
