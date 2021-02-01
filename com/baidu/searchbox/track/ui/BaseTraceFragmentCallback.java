package com.baidu.searchbox.track.ui;

import android.app.Activity;
/* loaded from: classes3.dex */
public abstract class BaseTraceFragmentCallback implements ITraceFragmentCallback {
    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnFragmentCreated(Object obj, boolean z, Activity activity) {
        if (z) {
            TraceManager.getInstance().saveTraceInfo(activity, null, obj, "onCreated");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnFragmentResumed(Object obj, boolean z, Activity activity) {
        if (z) {
            TraceManager.getInstance().saveTraceInfo(activity, null, obj, "onResumed");
        }
    }
}
