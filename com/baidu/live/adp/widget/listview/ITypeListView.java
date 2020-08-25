package com.baidu.live.adp.widget.listview;

import android.view.ViewGroup;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import java.util.List;
/* loaded from: classes7.dex */
public interface ITypeListView<V extends ViewGroup> {
    void addAdapter(AbsDelegateAdapter<IAdapterData, TypeAdapter.ViewHolder> absDelegateAdapter);

    void addAdapters(List<AbsDelegateAdapter> list);

    List<IAdapterData> getData();

    IAdapterData getItem(int i);

    IListAdapter getListAdapter();

    V getListView();

    void setData(List<IAdapterData> list);
}
