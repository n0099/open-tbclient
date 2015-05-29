package com.baidu.adp.widget.ListView;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class al extends BaseAdapter {
    private SparseArray<a<ai, am>> Ik;
    private SparseArray<Integer> Il = new SparseArray<>();
    private List<ai> Im;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Im != null) {
            return this.Im.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ay */
    public ai getItem(int i) {
        if (this.Im != null) {
            int size = this.Im.size();
            if (i >= 0 && i < size) {
                return this.Im.get(i);
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
        if (this.Ik != null && this.Im != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.Ik.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof ai)) {
                return aVar.a(i, view, viewGroup, item);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        ai item;
        if (this.Ik == null || this.Ik.size() == 0 || (item = getItem(i)) == null || item.getType() == null) {
            return -1;
        }
        return this.Il.get(item.getType().getId()).intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.Ik != null) {
            return this.Ik.size();
        }
        return 0;
    }

    public void a(a<ai, am> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Ik == null) {
                this.Ik = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.a(this);
                int id = aVar.getType().getId();
                int size = this.Ik.size();
                this.Ik.put(size, aVar);
                this.Il.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<ai> list) {
        this.Im = list;
        notifyDataSetChanged();
    }

    public List<ai> getData() {
        return this.Im;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Ik != null) {
            ai item = getItem(i);
            a<ai, am> valueAt = this.Ik.valueAt(getItemViewType(i));
            if (valueAt != null && valueAt.mZ() != null) {
                valueAt.mZ().a(view, item, valueAt.getType(), adapterView, i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Ik == null) {
            return false;
        }
        ai item = getItem(i);
        a<ai, am> valueAt = this.Ik.valueAt(getItemViewType(i));
        if (valueAt == null || valueAt.na() == null) {
            return false;
        }
        return valueAt.na().b(view, item, valueAt.getType(), adapterView, i, j);
    }
}
