package com.baidu.rtc;

import android.annotation.SuppressLint;
import com.baidu.rtc.RTCAudioSamples;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RemoteAudioSamplesInterceptor implements RTCAudioSamples.RTCRemoteSamplesReadyCallback {
    @SuppressLint({"UseSparseArrays"})
    public final List<RTCAudioSamples.RTCRemoteSamplesReadyCallback> callbacks = new ArrayList();

    public void attachCallback(RTCAudioSamples.RTCRemoteSamplesReadyCallback rTCRemoteSamplesReadyCallback) {
        this.callbacks.add(rTCRemoteSamplesReadyCallback);
    }

    public void detachCallback() {
        this.callbacks.clear();
    }

    @Override // com.baidu.rtc.RTCAudioSamples.RTCRemoteSamplesReadyCallback
    public void onRtcAudioRemoteSamplesReady(RTCAudioSamples rTCAudioSamples) {
        for (RTCAudioSamples.RTCRemoteSamplesReadyCallback rTCRemoteSamplesReadyCallback : this.callbacks) {
            rTCRemoteSamplesReadyCallback.onRtcAudioRemoteSamplesReady(rTCAudioSamples);
        }
    }
}
