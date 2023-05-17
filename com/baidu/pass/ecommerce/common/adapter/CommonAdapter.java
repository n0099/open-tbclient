package com.baidu.pass.ecommerce.common.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class CommonAdapter<T> extends BaseAdapter {
    public List<T> items = new ArrayList();
    public LayoutInflater layoutInflater;

    public abstract ViewHolder createViewHolder(View view2);

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public abstract int getItemLayoutId();

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.items;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<T> getItems() {
        return this.items;
    }

    public void removeAllData() {
        this.items.clear();
        notifyDataSetChanged();
    }

    public void addData(List<T> list) {
        if (list != null) {
            this.items.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        List<T> list = this.items;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    public void removeData(T t) {
        this.items.remove(t);
        notifyDataSetChanged();
    }

    public void setData(List<T> list) {
        this.items.clear();
        if (list != null) {
            this.items.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view2 == null) {
            view2 = LinearLayout.inflate(viewGroup.getContext(), getItemLayoutId(), null);
            viewHolder = createViewHolder(view2);
            view2.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view2.getTag();
        }
        viewHolder.bindView(getItem(i));
        return view2;
    }
}
