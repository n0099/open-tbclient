package androidx.core.view;

import android.view.View;
/* loaded from: classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(View view2, int i, int i2, int[] iArr, int i3);

    void onNestedScroll(View view2, int i, int i2, int i3, int i4, int i5);

    void onNestedScrollAccepted(View view2, View view3, int i, int i2);

    boolean onStartNestedScroll(View view2, View view3, int i, int i2);

    void onStopNestedScroll(View view2, int i);
}
