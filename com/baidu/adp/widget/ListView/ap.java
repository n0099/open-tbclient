package com.baidu.adp.widget.ListView;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class ap extends BaseAdapter {
    private SparseArray<a<am>> xE;
    private List<am> xG;
    private final int xD = -1;
    private SparseArray<Integer> xF = new SparseArray<>();

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.xG != null) {
            return this.xG.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: aD */
    public am getItem(int i) {
        if (this.xG != null) {
            int size = this.xG.size();
            if (i >= 0 && i < size) {
                return this.xG.get(i);
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
        if (this.xE != null && this.xG != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.xE.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof am)) {
                return aVar.a(i, view, viewGroup, item);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        am item;
        if (this.xE == null || this.xE.size() == 0 || (item = getItem(i)) == null || item.js() == null) {
            return -1;
        }
        return this.xF.get(item.js().getId()).intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.xE != null) {
            return this.xE.size();
        }
        return 0;
    }

    public void a(a<am> aVar) {
        if (aVar != null && aVar.js() != null) {
            if (this.xE == null) {
                this.xE = new SparseArray<>();
            }
            if (aVar.js() != null) {
                aVar.a(this);
                int id = aVar.js().getId();
                int size = this.xE.size();
                this.xE.put(size, aVar);
                this.xF.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<am> list) {
        this.xG = list;
        notifyDataSetChanged();
    }

    public List<am> getData() {
        return this.xG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.xE != null) {
            am item = getItem(i);
            a<am> valueAt = this.xE.valueAt(getItemViewType(i));
            if (valueAt != null && valueAt.jq() != null) {
                valueAt.jq().a(view, item, valueAt.js(), adapterView, i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.xE != null) {
            am item = getItem(i);
            a<am> valueAt = this.xE.valueAt(getItemViewType(i));
            if (valueAt != null && valueAt.jr() != null) {
                valueAt.jr().b(view, item, valueAt.js(), adapterView, i, j);
            }
        }
        return false;
    }
}
