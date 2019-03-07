package com.baidu.adp.widget.ListView;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes.dex */
public interface r<V extends ViewGroup> {
    void addAdapters(List<a> list);

    List<m> getData();

    n getListAdapter();

    V getListView();

    void setData(List<m> list);
}
