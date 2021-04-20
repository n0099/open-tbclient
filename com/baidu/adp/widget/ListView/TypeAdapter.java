package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.a;
import d.b.c.j.e.n;
import d.b.c.j.e.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TypeAdapter extends BaseAdapter implements r<n> {

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<a<n, ViewHolder>> f2398e;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<Integer> f2399f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public List<n> f2400g = new ArrayList();

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
            this.itemView.setTag(this);
        }

        public View a() {
            return this.itemView;
        }
    }

    @Override // d.b.c.j.e.r
    public int a(int i, int i2) {
        List<n> list = this.f2400g;
        if (list != null && list.size() != 0) {
            int size = this.f2400g.size();
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                if (this.f2400g.get(i4) != null && this.f2400g.get(i4).getType() != null) {
                    if (i2 == this.f2400g.get(i4).getType().getId()) {
                        i3++;
                    }
                    if (i4 == i) {
                        return i3;
                    }
                }
            }
        }
        return -1;
    }

    @Override // d.b.c.j.e.r
    public a<n, ViewHolder> b(n nVar) {
        SparseArray<a<n, ViewHolder>> sparseArray;
        BdUniqueId type;
        Integer num;
        if (nVar != null && (sparseArray = this.f2398e) != null) {
            int i = -1;
            if (sparseArray.size() != 0 && (type = nVar.getType()) != null && (num = this.f2399f.get(type.getId())) != null) {
                i = num.intValue();
            }
            if (i >= 0 && i < this.f2398e.size()) {
                return this.f2398e.get(i);
            }
        }
        return null;
    }

    public void c(a<n, ViewHolder> aVar) {
        if (aVar == null || aVar.G() == null) {
            return;
        }
        if (this.f2398e == null) {
            this.f2398e = new SparseArray<>();
        }
        if (aVar.G() != null) {
            aVar.b0(this);
            int id = aVar.G().getId();
            int size = this.f2398e.size();
            this.f2398e.put(size, aVar);
            this.f2399f.put(id, Integer.valueOf(size));
        }
    }

    public List<n> d() {
        return this.f2400g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, d.b.c.j.e.o
    /* renamed from: e */
    public n getItem(int i) {
        List<n> list = this.f2400g;
        if (list != null) {
            int size = list.size();
            if (i < 0 || i >= size) {
                return null;
            }
            return this.f2400g.get(i);
        }
        return null;
    }

    public void f(ViewGroup viewGroup, View view, int i, long j) {
        if (this.f2398e == null) {
            return;
        }
        n item = getItem(i);
        int itemViewType = getItemViewType(i);
        a<n, ViewHolder> valueAt = itemViewType >= 0 ? this.f2398e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.A() == null) {
            return;
        }
        valueAt.A().f(view, item, valueAt.G(), viewGroup, i, j);
    }

    public boolean g(ViewGroup viewGroup, View view, int i, long j) {
        if (this.f2398e == null) {
            return false;
        }
        n item = getItem(i);
        int itemViewType = getItemViewType(i);
        a<n, ViewHolder> valueAt = itemViewType >= 0 ? this.f2398e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.B() == null) {
            return false;
        }
        return valueAt.B().a(view, item, valueAt.G(), viewGroup, i, j);
    }

    @Override // android.widget.Adapter, d.b.c.j.e.o
    public int getCount() {
        List<n> list = this.f2400g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        n item;
        BdUniqueId type;
        Integer num;
        SparseArray<a<n, ViewHolder>> sparseArray = this.f2398e;
        if (sparseArray == null || sparseArray.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.f2399f.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a<n, ViewHolder> aVar;
        View view2 = null;
        if (this.f2398e != null && this.f2400g != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.f2398e.get(getItemViewType(i))) != null) {
                n item = getItem(i);
                if (item != null && (item instanceof n)) {
                    view2 = aVar.I(i, view, viewGroup, item);
                }
                if (view2 == null) {
                    Log.e("BdTypeListView", aVar.getClass().getName());
                }
            }
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        SparseArray<a<n, ViewHolder>> sparseArray = this.f2398e;
        if (sparseArray != null) {
            return sparseArray.size();
        }
        return 0;
    }

    public void h(List<? extends n> list) {
        List<n> list2 = this.f2400g;
        if (list2 == null) {
            this.f2400g = new ArrayList();
        } else {
            list2.clear();
        }
        this.f2400g.addAll(list);
        notifyDataSetChanged();
    }
}
