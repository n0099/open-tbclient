package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View view2, float f, float f2, boolean z);

    boolean onNestedPreFling(@NonNull View view2, float f, float f2);

    void onNestedPreScroll(@NonNull View view2, int i, int i2, @NonNull int[] iArr);

    void onNestedScroll(@NonNull View view2, int i, int i2, int i3, int i4);

    void onNestedScrollAccepted(@NonNull View view2, @NonNull View view3, int i);

    boolean onStartNestedScroll(@NonNull View view2, @NonNull View view3, int i);

    void onStopNestedScroll(@NonNull View view2);
}
