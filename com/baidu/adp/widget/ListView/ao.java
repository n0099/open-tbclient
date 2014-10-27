package com.baidu.adp.widget.ListView;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class ao extends BaseAdapter {
    private SparseArray<a<al>> vB;
    private List<al> vD;
    private final int vA = -1;
    private SparseArray<Integer> vC = new SparseArray<>();

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.vD != null) {
            return this.vD.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ai */
    public al getItem(int i) {
        if (this.vD != null) {
            int size = this.vD.size();
            if (i >= 0 && i < size) {
                return this.vD.get(i);
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
        a<al> aVar;
        al item;
        if (this.vB != null && this.vD != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.vB.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof al)) {
                return aVar.a(i, view, viewGroup, item);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        al item;
        if (this.vB == null || this.vB.size() == 0 || (item = getItem(i)) == null || item.hu() == null) {
            return -1;
        }
        return this.vC.get(item.hu().getId()).intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.vB != null) {
            return this.vB.size();
        }
        return 0;
    }

    public void a(a<al> aVar) {
        if (aVar != null && aVar.hu() != null) {
            if (this.vB == null) {
                this.vB = new SparseArray<>();
            }
            if (aVar.hu() != null) {
                aVar.a(this);
                int id = aVar.hu().getId();
                int size = this.vB.size();
                this.vB.put(size, aVar);
                this.vC.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<al> list) {
        this.vD = list;
        notifyDataSetChanged();
    }

    public List<al> getData() {
        return this.vD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.vB != null) {
            al item = getItem(i);
            a<al> valueAt = this.vB.valueAt(getItemViewType(i));
            if (valueAt != null && valueAt.hs() != null) {
                valueAt.hs().a(view, item, valueAt.hu(), adapterView, i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.vB != null) {
            al item = getItem(i);
            a<al> valueAt = this.vB.valueAt(getItemViewType(i));
            if (valueAt != null && valueAt.ht() != null) {
                valueAt.ht().b(view, item, valueAt.hu(), adapterView, i, j);
            }
        }
        return false;
    }
}
