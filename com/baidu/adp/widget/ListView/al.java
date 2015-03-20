package com.baidu.adp.widget.ListView;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class al extends BaseAdapter {
    private SparseArray<a<ai, am>> Is;
    private SparseArray<Integer> It = new SparseArray<>();
    private List<ai> Iu;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Iu != null) {
            return this.Iu.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: aA */
    public ai getItem(int i) {
        if (this.Iu != null) {
            int size = this.Iu.size();
            if (i >= 0 && i < size) {
                return this.Iu.get(i);
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
        a<ai, am> aVar;
        ai item;
        if (this.Is != null && this.Iu != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.Is.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof ai)) {
                return aVar.a(i, view, viewGroup, item);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        ai item;
        if (this.Is == null || this.Is.size() == 0 || (item = getItem(i)) == null || item.getType() == null) {
            return -1;
        }
        return this.It.get(item.getType().getId()).intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.Is != null) {
            return this.Is.size();
        }
        return 0;
    }

    public void a(a<ai, am> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Is == null) {
                this.Is = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.a(this);
                int id = aVar.getType().getId();
                int size = this.Is.size();
                this.Is.put(size, aVar);
                this.It.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<ai> list) {
        this.Iu = list;
        notifyDataSetChanged();
    }

    public List<ai> getData() {
        return this.Iu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Is != null) {
            ai item = getItem(i);
            a<ai, am> valueAt = this.Is.valueAt(getItemViewType(i));
            if (valueAt != null && valueAt.mG() != null) {
                valueAt.mG().a(view, item, valueAt.getType(), adapterView, i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Is != null) {
            ai item = getItem(i);
            a<ai, am> valueAt = this.Is.valueAt(getItemViewType(i));
            if (valueAt != null && valueAt.mH() != null) {
                valueAt.mH().b(view, item, valueAt.getType(), adapterView, i, j);
            }
        }
        return false;
    }
}
