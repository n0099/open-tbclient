package com.baidu.searchbox.track.ui;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class TraceFragmentXCallback extends BaseTraceFragmentCallback {
    private FragmentManager.FragmentLifecycleCallbacks mSupportFragmentCallbacks;

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean register(@NonNull Activity activity) {
        if (activity instanceof FragmentActivity) {
            if (this.mSupportFragmentCallbacks == null) {
                this.mSupportFragmentCallbacks = getSupportFragmentCallbacks();
            }
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            if (supportFragmentManager != null) {
                supportFragmentManager.registerFragmentLifecycleCallbacks(this.mSupportFragmentCallbacks, true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.track.ui.ITraceFragmentCallback
    public boolean unregister(@NonNull Activity activity) {
        FragmentManager supportFragmentManager;
        if (activity instanceof FragmentActivity) {
            if (this.mSupportFragmentCallbacks != null && (supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager()) != null) {
                supportFragmentManager.unregisterFragmentLifecycleCallbacks(this.mSupportFragmentCallbacks);
            }
            return true;
        }
        return false;
    }

    private FragmentManager.FragmentLifecycleCallbacks getSupportFragmentCallbacks() {
        return new FragmentManager.FragmentLifecycleCallbacks() { // from class: com.baidu.searchbox.track.ui.TraceFragmentXCallback.1
            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
                super.onFragmentCreated(fragmentManager, fragment, bundle);
                if (fragment != null) {
                    TraceFragmentXCallback.this.doOnFragmentCreated(fragment, fragment.getUserVisibleHint(), fragment.getActivity());
                }
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
                super.onFragmentResumed(fragmentManager, fragment);
                if (fragment != null) {
                    TraceFragmentXCallback.this.doOnFragmentResumed(fragment, fragment.getUserVisibleHint(), fragment.getActivity());
                }
            }
        };
    }
}
