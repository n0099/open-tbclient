package com.baidu.searchbox.track.ui;

import android.app.Activity;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes6.dex */
public class TraceFragmentCallbackWrapper implements ITraceFragmentCallback {
    private TraceFragmentNativeCallback mTraceFragmentNativeCallback;
    private TraceFragmentXCallback mTraceFragmentXCallback;

    public TraceFragmentCallbackWrapper() {
        if (DeviceUtil.OSInfo.hasOreo()) {
            this.mTraceFragmentNativeCallback = new TraceFragmentNativeCallback();
        }
        try {
            if (Class.forName("androidx.fragment.app.FragmentActivity") != null) {
                this.mTraceFragmentXCallback = new TraceFragmentXCallback();
            }
        } catch (ClassNotFoundException e) {
        }
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean register(Activity activity) {
        if (activity == null) {
            return false;
        }
        boolean register = this.mTraceFragmentXCallback != null ? this.mTraceFragmentXCallback.register(activity) : false;
        if (!register && this.mTraceFragmentNativeCallback != null) {
            return this.mTraceFragmentNativeCallback.register(activity);
        }
        return register;
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean unregister(Activity activity) {
        if (activity == null) {
            return false;
        }
        boolean unregister = this.mTraceFragmentXCallback != null ? this.mTraceFragmentXCallback.unregister(activity) : false;
        if (!unregister && this.mTraceFragmentNativeCallback != null) {
            return this.mTraceFragmentNativeCallback.unregister(activity);
        }
        return unregister;
    }
}
