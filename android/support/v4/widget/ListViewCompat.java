package android.support.v4.widget;

import android.os.Build;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ListView;
/* loaded from: classes3.dex */
public final class ListViewCompat {
    public static void scrollListBy(@NonNull ListView listView, int i) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1 && (childAt = listView.getChildAt(0)) != null) {
            listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
        }
    }

    public static boolean canScrollList(@NonNull ListView listView, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            return listView.canScrollList(i);
        }
        int childCount = listView.getChildCount();
        if (childCount != 0) {
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            if (i > 0) {
                return childCount + firstVisiblePosition < listView.getCount() || listView.getChildAt(childCount + (-1)).getBottom() > listView.getHeight() - listView.getListPaddingBottom();
            }
            return firstVisiblePosition > 0 || listView.getChildAt(0).getTop() < listView.getListPaddingTop();
        }
        return false;
    }

    private ListViewCompat() {
    }
}
