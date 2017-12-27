package com.baidu.adp.widget.ListView;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes.dex */
public interface n<V extends ViewGroup> {
    void addAdapters(List<a> list);

    List<i> getData();

    j getListAdapter();

    void setData(List<i> list);
}
