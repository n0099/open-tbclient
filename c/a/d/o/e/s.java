package c.a.d.o.e;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes.dex */
public interface s<V extends ViewGroup> {
    void addAdapters(List<a> list);

    List<n> getData();

    o getListAdapter();

    V getListView();

    void setData(List<? extends n> list);
}
