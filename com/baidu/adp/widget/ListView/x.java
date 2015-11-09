package com.baidu.adp.widget.ListView;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class x extends BaseAdapter {
    private SparseArray<com.baidu.adp.widget.ListView.a<u, a>> Ip;
    private SparseArray<Integer> Iq = new SparseArray<>();
    private List<u> Ir;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Ir != null) {
            return this.Ir.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: aA */
    public u getItem(int i) {
        if (this.Ir != null) {
            int size = this.Ir.size();
            if (i >= 0 && i < size) {
                return this.Ir.get(i);
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
        if (this.Ip != null && this.Ir != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.Ip.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof u)) {
                return aVar.a(i, view, viewGroup, item);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        u item;
        if (this.Ip == null || this.Ip.size() == 0 || (item = getItem(i)) == null || item.getType() == null) {
            return -1;
        }
        return this.Iq.get(item.getType().getId()).intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.Ip != null) {
            return this.Ip.size();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.a<u, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Ip == null) {
                this.Ip = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.a(this);
                int id = aVar.getType().getId();
                int size = this.Ip.size();
                this.Ip.put(size, aVar);
                this.Iq.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<u> list) {
        this.Ir = list;
        notifyDataSetChanged();
    }

    public List<u> getData() {
        return this.Ir;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Ip != null) {
            u item = getItem(i);
            com.baidu.adp.widget.ListView.a<u, a> valueAt = this.Ip.valueAt(getItemViewType(i));
            if (valueAt != null && valueAt.ni() != null) {
                valueAt.ni().a(view, item, valueAt.getType(), adapterView, i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Ip == null) {
            return false;
        }
        u item = getItem(i);
        com.baidu.adp.widget.ListView.a<u, a> valueAt = this.Ip.valueAt(getItemViewType(i));
        if (valueAt == null || valueAt.nj() == null) {
            return false;
        }
        return valueAt.nj().b(view, item, valueAt.getType(), adapterView, i, j);
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
