package com.baidu.adp.widget.ListView;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class x extends BaseAdapter {
    private SparseArray<com.baidu.adp.widget.ListView.a<u, a>> Jt;
    private SparseArray<Integer> Ju = new SparseArray<>();
    private List<u> Jv;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Jv != null) {
            return this.Jv.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: aF */
    public u getItem(int i) {
        if (this.Jv != null) {
            int size = this.Jv.size();
            if (i >= 0 && i < size) {
                return this.Jv.get(i);
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
        if (this.Jt != null && this.Jv != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.Jt.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof u)) {
                return aVar.a(i, view, viewGroup, item);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        u item;
        BdUniqueId type;
        Integer num;
        if (this.Jt == null || this.Jt.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.Ju.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.Jt != null) {
            return this.Jt.size();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.a<u, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Jt == null) {
                this.Jt = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.a(this);
                int id = aVar.getType().getId();
                int size = this.Jt.size();
                this.Jt.put(size, aVar);
                this.Ju.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<u> list) {
        this.Jv = list;
        notifyDataSetChanged();
    }

    public List<u> getData() {
        return this.Jv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<u, a> aVar;
        if (this.Jt != null) {
            u item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.Jt.valueAt(itemViewType);
            }
            if (aVar != null && aVar.mS() != null) {
                aVar.mS().a(view, item, aVar.getType(), adapterView, i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<u, a> aVar;
        if (this.Jt == null) {
            return false;
        }
        u item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.Jt.valueAt(itemViewType);
        }
        if (aVar == null || aVar.mT() == null) {
            return false;
        }
        return aVar.mT().b(view, item, aVar.getType(), adapterView, i, j);
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
