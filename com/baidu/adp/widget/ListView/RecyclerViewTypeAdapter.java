package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.a.c.k.e.a;
import d.a.c.k.e.n;
import d.a.c.k.e.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RecyclerViewTypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> implements r<n> {

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<a<n, TypeAdapter.ViewHolder>> f2397e;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<Integer> f2398f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public List<n> f2399g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f2400h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f2401i = -1;

    @Override // d.a.c.k.e.r
    public int a(int i2, int i3) {
        List<n> list = this.f2399g;
        if (list != null && list.size() != 0) {
            int size = this.f2399g.size();
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                if (this.f2399g.get(i5) != null && this.f2399g.get(i5).getType() != null) {
                    if (i3 == this.f2399g.get(i5).getType().getId()) {
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
    public a<n, TypeAdapter.ViewHolder> b(n nVar) {
        BdUniqueId type;
        Integer num;
        if (nVar == null) {
            return null;
        }
        int i2 = -1;
        SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f2397e;
        if (sparseArray != null && sparseArray.size() != 0 && (type = nVar.getType()) != null && (num = this.f2398f.get(type.getId())) != null) {
            i2 = num.intValue();
        }
        if (i2 < 0 || i2 >= this.f2397e.size()) {
            return null;
        }
        return this.f2397e.get(i2);
    }

    public void c(a<n, TypeAdapter.ViewHolder> aVar) {
        if (aVar == null || aVar.H() == null) {
            return;
        }
        if (this.f2397e == null) {
            this.f2397e = new SparseArray<>();
        }
        if (aVar.H() != null) {
            aVar.Z(this);
            int id = aVar.H().getId();
            int size = this.f2397e.size();
            this.f2397e.put(size, aVar);
            this.f2398f.put(id, Integer.valueOf(size));
        }
    }

    @Override // d.a.c.k.e.o
    public int getCount() {
        return getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<n> list = this.f2399g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        n item;
        BdUniqueId type;
        Integer num;
        this.f2401i = i2;
        SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f2397e;
        if (sparseArray == null || sparseArray.size() == 0 || (item = getItem(i2)) == null || (type = item.getType()) == null || (num = this.f2398f.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    public List<n> m() {
        return this.f2399g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.o
    /* renamed from: n */
    public n getItem(int i2) {
        List<n> list = this.f2399g;
        if (list != null) {
            int size = list.size();
            if (i2 < 0 || i2 >= size) {
                return null;
            }
            return this.f2399g.get(i2);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(TypeAdapter.ViewHolder viewHolder, int i2) {
        a<n, TypeAdapter.ViewHolder> aVar;
        n item;
        if (viewHolder == null || this.f2397e == null || this.f2399g == null) {
            return;
        }
        int itemCount = getItemCount();
        if (i2 < 0 || i2 >= itemCount || (aVar = this.f2397e.get(getItemViewType(i2))) == null || (item = getItem(i2)) == null || !(item instanceof n)) {
            return;
        }
        try {
            aVar.Y(i2, this.f2400h, viewHolder, item);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        a<n, TypeAdapter.ViewHolder> aVar;
        if (this.f2400h == null) {
            this.f2400h = (RecyclerView) viewGroup;
        }
        n item = getItem(this.f2401i);
        SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f2397e;
        TypeAdapter.ViewHolder viewHolder = null;
        if (sparseArray != null && (aVar = sparseArray.get(i2)) != null) {
            try {
                viewHolder = aVar.R(viewGroup, item);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (viewHolder == null) {
                Log.e("RecyclerViewTypeAdapter", aVar.getClass().getName());
            }
        }
        return viewHolder;
    }

    public void q(ViewGroup viewGroup, View view, int i2, long j) {
        if (this.f2397e == null) {
            return;
        }
        n item = getItem(i2);
        int itemViewType = getItemViewType(i2);
        a<n, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.f2397e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.A() == null) {
            return;
        }
        valueAt.A().b(view, item, valueAt.H(), viewGroup, i2, j);
    }

    public boolean r(ViewGroup viewGroup, View view, int i2, long j) {
        if (this.f2397e == null) {
            return false;
        }
        n item = getItem(i2);
        int itemViewType = getItemViewType(i2);
        a<n, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.f2397e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.B() == null) {
            return false;
        }
        return valueAt.B().a(view, item, valueAt.H(), viewGroup, i2, j);
    }

    public void s(int i2, int i3) {
        if (i2 < this.f2399g.size()) {
            this.f2399g.remove(i2);
            notifyItemRemoved(i2 + i3);
        }
    }

    public void setData(List<? extends n> list) {
        List<n> list2 = this.f2399g;
        if (list2 == null) {
            this.f2399g = new ArrayList();
        } else {
            list2.clear();
        }
        this.f2399g.addAll(list);
        notifyDataSetChanged();
    }

    public void t(int i2, int i3, int i4) {
        if (i2 >= this.f2399g.size() || i3 >= this.f2399g.size() || i2 > i3) {
            return;
        }
        this.f2399g.subList(i2, i3 + 1).clear();
        notifyItemRangeRemoved(i4 + i2, (i3 - i2) + 1);
    }

    public void u(List<? extends n> list, int i2, int i3) {
        List<n> list2 = this.f2399g;
        if (list2 == null) {
            this.f2399g = new ArrayList();
        } else {
            list2.clear();
        }
        this.f2399g.addAll(list);
        notifyItemRangeChanged(i2, i3);
    }
}
