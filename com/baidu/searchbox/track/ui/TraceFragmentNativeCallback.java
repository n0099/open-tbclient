package com.baidu.searchbox.track.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.util.devices.DeviceUtil;
@TargetApi(26)
/* loaded from: classes3.dex */
public class TraceFragmentNativeCallback extends BaseTraceFragmentCallback {
    public FragmentManager.FragmentLifecycleCallbacks mFragmentCallbacks;

    private FragmentManager.FragmentLifecycleCallbacks getFragmentCallbacks() {
        return new FragmentManager.FragmentLifecycleCallbacks() { // from class: com.baidu.searchbox.track.ui.TraceFragmentNativeCallback.1
            @Override // android.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
                super.onFragmentCreated(fragmentManager, fragment, bundle);
                if (fragment != null) {
                    TraceFragmentNativeCallback.this.doOnFragmentCreated(fragment, fragment.getUserVisibleHint(), fragment.getActivity());
                }
            }

            @Override // android.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
                super.onFragmentResumed(fragmentManager, fragment);
                if (fragment != null) {
                    TraceFragmentNativeCallback.this.doOnFragmentResumed(fragment, fragment.getUserVisibleHint(), fragment.getActivity());
                }
            }
        };
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean register(@NonNull Activity activity) {
        if (DeviceUtil.OSInfo.hasOreo()) {
            if (this.mFragmentCallbacks == null) {
                this.mFragmentCallbacks = getFragmentCallbacks();
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.registerFragmentLifecycleCallbacks(this.mFragmentCallbacks, true);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean unregister(@NonNull Activity activity) {
        FragmentManager fragmentManager;
        if (DeviceUtil.OSInfo.hasOreo()) {
            if (this.mFragmentCallbacks == null || (fragmentManager = activity.getFragmentManager()) == null) {
                return true;
            }
            fragmentManager.unregisterFragmentLifecycleCallbacks(this.mFragmentCallbacks);
            return true;
        }
        return false;
    }
}
