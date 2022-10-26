package androidx.core.view;

import android.view.View;
/* loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(View view2, float f, float f2, boolean z);

    boolean onNestedPreFling(View view2, float f, float f2);

    void onNestedPreScroll(View view2, int i, int i2, int[] iArr);

    void onNestedScroll(View view2, int i, int i2, int i3, int i4);

    void onNestedScrollAccepted(View view2, View view3, int i);

    boolean onStartNestedScroll(View view2, View view3, int i);

    void onStopNestedScroll(View view2);
}
