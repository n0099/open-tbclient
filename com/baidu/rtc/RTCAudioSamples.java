package com.baidu.rtc;

import org.webrtc.audio.JavaAudioDeviceModule;
/* loaded from: classes2.dex */
public class RTCAudioSamples extends JavaAudioDeviceModule.AudioSamples {
    public long captureTime;

    /* loaded from: classes2.dex */
    public interface RTCExternalSamplesReadyCallback {
        void onRtcAudioExternalSamplesReady(RTCAudioSamples rTCAudioSamples);
    }

    /* loaded from: classes2.dex */
    public interface RTCMixedSamplesReadyCallback {
        void onRtcAudioMixedSamplesReady(RTCAudioSamples rTCAudioSamples);
    }

    /* loaded from: classes2.dex */
    public interface RTCRemoteSamplesReadyCallback {
        void onRtcAudioRemoteSamplesReady(RTCAudioSamples rTCAudioSamples);
    }

    /* loaded from: classes2.dex */
    public interface RTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(RTCAudioSamples rTCAudioSamples);
    }

    public RTCAudioSamples(int i2, int i3, int i4, byte[] bArr) {
        super(i2, i3, i4, bArr);
        this.captureTime = 0L;
    }

    public RTCAudioSamples(int i2, int i3, int i4, byte[] bArr, long j) {
        super(i2, i3, i4, bArr);
        this.captureTime = 0L;
        this.captureTime = j;
    }

    public long getCaptureTime() {
        return this.captureTime;
    }
}
