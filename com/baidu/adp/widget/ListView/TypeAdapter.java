package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.a;
import d.a.c.k.e.n;
import d.a.c.k.e.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TypeAdapter extends BaseAdapter implements r<n> {

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<a<n, ViewHolder>> f2405e;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<Integer> f2406f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public List<n> f2407g = new ArrayList();

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

    @Override // d.a.c.k.e.r
    public int a(int i2, int i3) {
        List<n> list = this.f2407g;
        if (list != null && list.size() != 0) {
            int size = this.f2407g.size();
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                if (this.f2407g.get(i5) != null && this.f2407g.get(i5).getType() != null) {
                    if (i3 == this.f2407g.get(i5).getType().getId()) {
                        i4++;
                    }
                    if (i5 == i2) {
                        return i4;
                    }
                }
            }
        }
        return -1;
    }

    @Override // d.a.c.k.e.r
    public a<n, ViewHolder> b(n nVar) {
        SparseArray<a<n, ViewHolder>> sparseArray;
        BdUniqueId type;
        Integer num;
        if (nVar != null && (sparseArray = this.f2405e) != null) {
            int i2 = -1;
            if (sparseArray.size() != 0 && (type = nVar.getType()) != null && (num = this.f2406f.get(type.getId())) != null) {
                i2 = num.intValue();
            }
            if (i2 >= 0 && i2 < this.f2405e.size()) {
                return this.f2405e.get(i2);
            }
        }
        return null;
    }

    public void c(a<n, ViewHolder> aVar) {
        if (aVar == null || aVar.H() == null) {
            return;
        }
        if (this.f2405e == null) {
            this.f2405e = new SparseArray<>();
        }
        if (aVar.H() != null) {
            aVar.Z(this);
            int id = aVar.H().getId();
            int size = this.f2405e.size();
            this.f2405e.put(size, aVar);
            this.f2406f.put(id, Integer.valueOf(size));
        }
    }

    public List<n> d() {
        return this.f2407g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, d.a.c.k.e.o
    /* renamed from: e */
    public n getItem(int i2) {
        List<n> list = this.f2407g;
        if (list != null) {
            int size = list.size();
            if (i2 < 0 || i2 >= size) {
                return null;
            }
            return this.f2407g.get(i2);
        }
        return null;
    }

    public void f(ViewGroup viewGroup, View view, int i2, long j) {
        if (this.f2405e == null) {
            return;
        }
        n item = getItem(i2);
        int itemViewType = getItemViewType(i2);
        a<n, ViewHolder> valueAt = itemViewType >= 0 ? this.f2405e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.A() == null) {
            return;
        }
        valueAt.A().b(view, item, valueAt.H(), viewGroup, i2, j);
    }

    public boolean g(ViewGroup viewGroup, View view, int i2, long j) {
        if (this.f2405e == null) {
            return false;
        }
        n item = getItem(i2);
        int itemViewType = getItemViewType(i2);
        a<n, ViewHolder> valueAt = itemViewType >= 0 ? this.f2405e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.B() == null) {
            return false;
        }
        return valueAt.B().a(view, item, valueAt.H(), viewGroup, i2, j);
    }

    @Override // android.widget.Adapter, d.a.c.k.e.o
    public int getCount() {
        List<n> list = this.f2407g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        n item;
        BdUniqueId type;
        Integer num;
        SparseArray<a<n, ViewHolder>> sparseArray = this.f2405e;
        if (sparseArray == null || sparseArray.size() == 0 || (item = getItem(i2)) == null || (type = item.getType()) == null || (num = this.f2406f.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a<n, ViewHolder> aVar;
        View view2 = null;
        if (this.f2405e != null && this.f2407g != null) {
            int count = getCount();
            if (i2 >= 0 && i2 < count && (aVar = this.f2405e.get(getItemViewType(i2))) != null) {
                n item = getItem(i2);
                if (item != null && (item instanceof n)) {
                    view2 = aVar.I(i2, view, viewGroup, item);
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
        SparseArray<a<n, ViewHolder>> sparseArray = this.f2405e;
        if (sparseArray != null) {
            return sparseArray.size();
        }
        return 0;
    }

    public void h(List<? extends n> list) {
        List<n> list2 = this.f2407g;
        if (list2 == null) {
            this.f2407g = new ArrayList();
        } else {
            list2.clear();
        }
        this.f2407g.addAll(list);
        notifyDataSetChanged();
    }
}
