package com.baidu.tbadk.core.util.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private final DisplayMetrics feb;

    public a(DisplayMetrics displayMetrics) {
        this.feb = displayMetrics;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        if ("ImageViewerActivity".equalsIgnoreCase(activity.getClass().getSimpleName()) && this.feb != null) {
            b.bwy().a(activity, this.feb.density, this.feb.densityDpi);
        } else {
            b.bwy().fd(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        if ("ImageViewerActivity".equalsIgnoreCase(activity.getClass().getSimpleName()) && this.feb != null) {
            b.bwy().a(activity, this.feb.density, this.feb.densityDpi);
        } else {
            b.bwy().fd(activity);
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
