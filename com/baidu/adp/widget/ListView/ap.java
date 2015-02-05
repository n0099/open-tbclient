package com.baidu.adp.widget.ListView;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class ap extends BaseAdapter {
    private SparseArray<a<am>> xB;
    private List<am> xD;
    private final int xA = -1;
    private SparseArray<Integer> xC = new SparseArray<>();

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.xD != null) {
            return this.xD.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: aD */
    public am getItem(int i) {
        if (this.xD != null) {
            int size = this.xD.size();
            if (i >= 0 && i < size) {
                return this.xD.get(i);
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
        a<am> aVar;
        am item;
        if (this.xB != null && this.xD != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.xB.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof am)) {
                return aVar.a(i, view, viewGroup, item);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        am item;
        if (this.xB == null || this.xB.size() == 0 || (item = getItem(i)) == null || item.jl() == null) {
            return -1;
        }
        return this.xC.get(item.jl().getId()).intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.xB != null) {
            return this.xB.size();
        }
        return 0;
    }

    public void a(a<am> aVar) {
        if (aVar != null && aVar.jl() != null) {
            if (this.xB == null) {
                this.xB = new SparseArray<>();
            }
            if (aVar.jl() != null) {
                aVar.a(this);
                int id = aVar.jl().getId();
                int size = this.xB.size();
                this.xB.put(size, aVar);
                this.xC.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<am> list) {
        this.xD = list;
        notifyDataSetChanged();
    }

    public List<am> getData() {
        return this.xD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.xB != null) {
            am item = getItem(i);
            a<am> valueAt = this.xB.valueAt(getItemViewType(i));
            if (valueAt != null && valueAt.jj() != null) {
                valueAt.jj().a(view, item, valueAt.jl(), adapterView, i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.xB != null) {
            am item = getItem(i);
            a<am> valueAt = this.xB.valueAt(getItemViewType(i));
            if (valueAt != null && valueAt.jk() != null) {
                valueAt.jk().b(view, item, valueAt.jl(), adapterView, i, j);
            }
        }
        return false;
    }
}
