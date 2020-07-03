package com.baidu.adp.widget.ListView;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes.dex */
public interface v<V extends ViewGroup> {
    void addAdapters(List<a> list);

    List<q> getData();

    r getListAdapter();

    V getListView();

    void setData(List<? extends q> list);
}
