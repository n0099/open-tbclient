package com.baidu.live.adp.widget.listview;
/* loaded from: classes11.dex */
public interface IListAdapter<T> {
    int getCount();

    T getItem(int i);

    long getItemId(int i);

    void notifyDataSetChanged();
}
