package android.support.v7.widget;

import android.graphics.Rect;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.GROUP_ID})
/* loaded from: classes2.dex */
public interface FitWindowsViewGroup {

    /* loaded from: classes2.dex */
    public interface OnFitSystemWindowsListener {
        void onFitSystemWindows(Rect rect);
    }

    void setOnFitSystemWindowsListener(OnFitSystemWindowsListener onFitSystemWindowsListener);
}
