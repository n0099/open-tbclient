package com.baidu.live.adp.widget.listview;
/* loaded from: classes4.dex */
public interface IListAdapter<T> {
    int getCount();

    T getItem(int i);

    long getItemId(int i);

    void notifyDataSetChanged();
}
