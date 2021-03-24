package com.baidu.tbadk.core.util.dimen;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class TbDimenAdaptActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    public final DisplayMetrics mDefaultMetrics;

    public TbDimenAdaptActivityLifecycle(DisplayMetrics displayMetrics) {
        this.mDefaultMetrics = displayMetrics;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        String simpleName = activity.getClass().getSimpleName();
        if (this.mDefaultMetrics != null) {
            if (!"ImageViewerActivity".equalsIgnoreCase(simpleName) && !"LiveShowActivity".equalsIgnoreCase(simpleName) && !"AlaMasterLiveRoomActivity".equalsIgnoreCase(simpleName) && !"AlaGiftTabActivity".equalsIgnoreCase(simpleName) && !"LiveListActivity".equalsIgnoreCase(simpleName) && !"YuyinLivePlayerActivity".equalsIgnoreCase(simpleName) && !"YuyinAlaCreateLiveRoomActivity".equalsIgnoreCase(simpleName)) {
                TbDimenManager.getInstance().adaptDimen(activity);
                return;
            }
            TbDimenManager tbDimenManager = TbDimenManager.getInstance();
            DisplayMetrics displayMetrics = this.mDefaultMetrics;
            tbDimenManager.adaptDimen(activity, displayMetrics.density, displayMetrics.densityDpi);
            return;
        }
        TbDimenManager.getInstance().adaptDimen(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        String simpleName = activity.getClass().getSimpleName();
        if (this.mDefaultMetrics != null) {
            if (!"ImageViewerActivity".equalsIgnoreCase(simpleName) && !"LiveShowActivity".equalsIgnoreCase(simpleName) && !"AlaMasterLiveRoomActivity".equalsIgnoreCase(simpleName) && !"AlaGiftTabActivity".equalsIgnoreCase(simpleName) && !"LiveListActivity".equalsIgnoreCase(simpleName) && !"YuyinLivePlayerActivity".equalsIgnoreCase(simpleName) && !"YuyinAlaCreateLiveRoomActivity".equalsIgnoreCase(simpleName)) {
                TbDimenManager.getInstance().adaptDimen(activity);
                return;
            }
            TbDimenManager tbDimenManager = TbDimenManager.getInstance();
            DisplayMetrics displayMetrics = this.mDefaultMetrics;
            tbDimenManager.adaptDimen(activity, displayMetrics.density, displayMetrics.densityDpi);
            return;
        }
        TbDimenManager.getInstance().adaptDimen(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
    }
}
