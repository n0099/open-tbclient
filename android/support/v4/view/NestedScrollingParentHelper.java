package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class NestedScrollingParentHelper {
    private int mNestedScrollAxes;
    private final ViewGroup mViewGroup;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
    }

    public void onNestedScrollAccepted(View view2, View view3, int i) {
        this.mNestedScrollAxes = i;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollAxes;
    }

    public void onStopNestedScroll(View view2) {
        this.mNestedScrollAxes = 0;
    }
}
