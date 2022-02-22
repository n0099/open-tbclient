package c.a.d.o.e;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public interface p<V extends ViewGroup> {
    int getContentViewsCount();

    int getFooterViewsCount();

    int getHeaderViewsCount();

    V getListView();

    boolean removeHeaderView(View view);
}
