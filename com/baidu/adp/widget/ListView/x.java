package com.baidu.adp.widget.ListView;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class x extends BaseAdapter {
    private SparseArray<com.baidu.adp.widget.ListView.a<u, a>> Io;
    private SparseArray<Integer> Ip = new SparseArray<>();
    private List<u> Iq;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Iq != null) {
            return this.Iq.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: aA */
    public u getItem(int i) {
        if (this.Iq != null) {
            int size = this.Iq.size();
            if (i >= 0 && i < size) {
                return this.Iq.get(i);
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.adp.widget.ListView.a<u, a> aVar;
        u item;
        if (this.Io != null && this.Iq != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.Io.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof u)) {
                return aVar.a(i, view, viewGroup, item);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        u item;
        if (this.Io == null || this.Io.size() == 0 || (item = getItem(i)) == null || item.getType() == null) {
            return -1;
        }
        return this.Ip.get(item.getType().getId()).intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.Io != null) {
            return this.Io.size();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.a<u, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Io == null) {
                this.Io = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.a(this);
                int id = aVar.getType().getId();
                int size = this.Io.size();
                this.Io.put(size, aVar);
                this.Ip.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<u> list) {
        this.Iq = list;
        notifyDataSetChanged();
    }

    public List<u> getData() {
        return this.Iq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Io != null) {
            u item = getItem(i);
            com.baidu.adp.widget.ListView.a<u, a> valueAt = this.Io.valueAt(getItemViewType(i));
            if (valueAt != null && valueAt.nh() != null) {
                valueAt.nh().a(view, item, valueAt.getType(), adapterView, i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Io == null) {
            return false;
        }
        u item = getItem(i);
        com.baidu.adp.widget.ListView.a<u, a> valueAt = this.Io.valueAt(getItemViewType(i));
        if (valueAt == null || valueAt.ni() == null) {
            return false;
        }
        return valueAt.ni().b(view, item, valueAt.getType(), adapterView, i, j);
    }

    /* loaded from: classes.dex */
    public static class a {
        private View view;

        public a(View view) {
            this.view = null;
            this.view = view;
            if (this.view == null) {
                throw new RuntimeException("view cannt be null");
            }
            this.view.setTag(this);
        }

        public View getView() {
            return this.view;
        }
    }
}
