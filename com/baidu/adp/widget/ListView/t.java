package com.baidu.adp.widget.ListView;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes.dex */
public interface t<V extends ViewGroup> {
    void addAdapters(List<a> list);

    List<o> getData();

    p getListAdapter();

    V getListView();

    void setData(List<o> list);
}
