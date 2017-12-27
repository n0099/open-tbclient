package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;
/* loaded from: classes2.dex */
class ListViewCompatGingerbread {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void scrollListBy(ListView listView, int i) {
        View childAt;
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1 && (childAt = listView.getChildAt(0)) != null) {
            listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
        }
    }
}
