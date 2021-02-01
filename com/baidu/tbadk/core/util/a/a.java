package com.baidu.tbadk.core.util.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private final DisplayMetrics fbH;

    public a(DisplayMetrics displayMetrics) {
        this.fbH = displayMetrics;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        if ("ImageViewerActivity".equalsIgnoreCase(activity.getClass().getSimpleName()) && this.fbH != null) {
            b.bsZ().a(activity, this.fbH.density, this.fbH.densityDpi);
        } else {
            b.bsZ().fa(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        if ("ImageViewerActivity".equalsIgnoreCase(activity.getClass().getSimpleName()) && this.fbH != null) {
            b.bsZ().a(activity, this.fbH.density, this.fbH.densityDpi);
        } else {
            b.bsZ().fa(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
    }
}
