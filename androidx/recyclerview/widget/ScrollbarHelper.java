package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class ScrollbarHelper {
    public static int computeScrollExtent(RecyclerView.State state, OrientationHelper orientationHelper, View view2, View view3, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() != 0 && state.getItemCount() != 0 && view2 != null && view3 != null) {
            if (!z) {
                return Math.abs(layoutManager.getPosition(view2) - layoutManager.getPosition(view3)) + 1;
            }
            return Math.min(orientationHelper.getTotalSpace(), orientationHelper.getDecoratedEnd(view3) - orientationHelper.getDecoratedStart(view2));
        }
        return 0;
    }

    public static int computeScrollRange(RecyclerView.State state, OrientationHelper orientationHelper, View view2, View view3, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() != 0 && state.getItemCount() != 0 && view2 != null && view3 != null) {
            if (!z) {
                return state.getItemCount();
            }
            return (int) (((orientationHelper.getDecoratedEnd(view3) - orientationHelper.getDecoratedStart(view2)) / (Math.abs(layoutManager.getPosition(view2) - layoutManager.getPosition(view3)) + 1)) * state.getItemCount());
        }
        return 0;
    }

    public static int computeScrollOffset(RecyclerView.State state, OrientationHelper orientationHelper, View view2, View view3, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
        int max;
        if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view2 == null || view3 == null) {
            return 0;
        }
        int min = Math.min(layoutManager.getPosition(view2), layoutManager.getPosition(view3));
        int max2 = Math.max(layoutManager.getPosition(view2), layoutManager.getPosition(view3));
        if (z2) {
            max = Math.max(0, (state.getItemCount() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z) {
            return max;
        }
        return Math.round((max * (Math.abs(orientationHelper.getDecoratedEnd(view3) - orientationHelper.getDecoratedStart(view2)) / (Math.abs(layoutManager.getPosition(view2) - layoutManager.getPosition(view3)) + 1))) + (orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(view2)));
    }
}
