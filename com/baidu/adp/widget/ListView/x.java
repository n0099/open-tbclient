package com.baidu.adp.widget.ListView;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class x extends BaseAdapter {
    private SparseArray<com.baidu.adp.widget.ListView.a<u, a>> IY;
    private SparseArray<Integer> IZ = new SparseArray<>();
    private List<u> Ja;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Ja != null) {
            return this.Ja.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: au */
    public u getItem(int i) {
        if (this.Ja != null) {
            int size = this.Ja.size();
            if (i >= 0 && i < size) {
                return this.Ja.get(i);
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
        if (this.IY != null && this.Ja != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.IY.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof u)) {
                return aVar.a(i, view, viewGroup, item);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        u item;
        if (this.IY == null || this.IY.size() == 0 || (item = getItem(i)) == null || item.getType() == null) {
            return -1;
        }
        return this.IZ.get(item.getType().getId()).intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.IY != null) {
            return this.IY.size();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.a<u, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.IY == null) {
                this.IY = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.a(this);
                int id = aVar.getType().getId();
                int size = this.IY.size();
                this.IY.put(size, aVar);
                this.IZ.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<u> list) {
        this.Ja = list;
        notifyDataSetChanged();
    }

    public List<u> getData() {
        return this.Ja;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.IY != null) {
            u item = getItem(i);
            com.baidu.adp.widget.ListView.a<u, a> valueAt = this.IY.valueAt(getItemViewType(i));
            if (valueAt != null && valueAt.mM() != null) {
                valueAt.mM().a(view, item, valueAt.getType(), adapterView, i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.IY == null) {
            return false;
        }
        u item = getItem(i);
        com.baidu.adp.widget.ListView.a<u, a> valueAt = this.IY.valueAt(getItemViewType(i));
        if (valueAt == null || valueAt.mN() == null) {
            return false;
        }
        return valueAt.mN().b(view, item, valueAt.getType(), adapterView, i, j);
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
