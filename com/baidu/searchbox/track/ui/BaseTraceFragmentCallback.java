package com.baidu.searchbox.track.ui;

import android.app.Activity;
/* loaded from: classes2.dex */
public abstract class BaseTraceFragmentCallback implements ITraceFragmentCallback {
    public void doOnFragmentCreated(Object obj, boolean z, Activity activity) {
        if (!z) {
            return;
        }
        TraceManager.getInstance().saveTraceInfo(activity, null, obj, "onCreated");
    }

    public void doOnFragmentResumed(Object obj, boolean z, Activity activity) {
        if (!z) {
            return;
        }
        TraceManager.getInstance().saveTraceInfo(activity, null, obj, "onResumed");
    }
}
