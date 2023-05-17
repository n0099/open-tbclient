package com.baidu.searchbox.track.ui;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes4.dex */
public class TraceFragmentCallbackWrapper implements ITraceFragmentCallback {
    public TraceFragmentNativeCallback mTraceFragmentNativeCallback;
    public TraceFragmentXCallback mTraceFragmentXCallback;

    public TraceFragmentCallbackWrapper() {
        if (DeviceUtil.OSInfo.hasOreo()) {
            this.mTraceFragmentNativeCallback = new TraceFragmentNativeCallback();
        }
        try {
            if (Class.forName("androidx.fragment.app.FragmentActivity") != null) {
                this.mTraceFragmentXCallback = new TraceFragmentXCallback();
            }
        } catch (ClassNotFoundException unused) {
        }
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean register(@Nullable Activity activity) {
        TraceFragmentNativeCallback traceFragmentNativeCallback;
        boolean z = false;
        if (activity == null) {
            return false;
        }
        TraceFragmentXCallback traceFragmentXCallback = this.mTraceFragmentXCallback;
        if (traceFragmentXCallback != null) {
            z = traceFragmentXCallback.register(activity);
        }
        if (!z && (traceFragmentNativeCallback = this.mTraceFragmentNativeCallback) != null) {
            return traceFragmentNativeCallback.register(activity);
        }
        return z;
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean unregister(@Nullable Activity activity) {
        TraceFragmentNativeCallback traceFragmentNativeCallback;
        boolean z = false;
        if (activity == null) {
            return false;
        }
        TraceFragmentXCallback traceFragmentXCallback = this.mTraceFragmentXCallback;
        if (traceFragmentXCallback != null) {
            z = traceFragmentXCallback.unregister(activity);
        }
        if (!z && (traceFragmentNativeCallback = this.mTraceFragmentNativeCallback) != null) {
            return traceFragmentNativeCallback.unregister(activity);
        }
        return z;
    }
}
