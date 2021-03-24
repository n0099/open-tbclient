package com.baidu.searchbox.track.ui;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes3.dex */
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
        if (activity == null) {
            return false;
        }
        TraceFragmentXCallback traceFragmentXCallback = this.mTraceFragmentXCallback;
        boolean register = traceFragmentXCallback != null ? traceFragmentXCallback.register(activity) : false;
        return (register || (traceFragmentNativeCallback = this.mTraceFragmentNativeCallback) == null) ? register : traceFragmentNativeCallback.register(activity);
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean unregister(@Nullable Activity activity) {
        TraceFragmentNativeCallback traceFragmentNativeCallback;
        if (activity == null) {
            return false;
        }
        TraceFragmentXCallback traceFragmentXCallback = this.mTraceFragmentXCallback;
        boolean unregister = traceFragmentXCallback != null ? traceFragmentXCallback.unregister(activity) : false;
        return (unregister || (traceFragmentNativeCallback = this.mTraceFragmentNativeCallback) == null) ? unregister : traceFragmentNativeCallback.unregister(activity);
    }
}
