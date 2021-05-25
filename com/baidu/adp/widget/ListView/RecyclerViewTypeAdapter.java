package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.a.c.j.e.a;
import d.a.c.j.e.n;
import d.a.c.j.e.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RecyclerViewTypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> implements r<n> {

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<a<n, TypeAdapter.ViewHolder>> f2378e;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<Integer> f2379f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public List<n> f2380g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f2381h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f2382i = -1;

    @Override // d.a.c.j.e.r
    public int a(int i2, int i3) {
        List<n> list = this.f2380g;
        if (list != null && list.size() != 0) {
            int size = this.f2380g.size();
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                if (this.f2380g.get(i5) != null && this.f2380g.get(i5).getType() != null) {
                    if (i3 == this.f2380g.get(i5).getType().getId()) {
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

    @Override // d.a.c.j.e.r
    public a<n, TypeAdapter.ViewHolder> b(n nVar) {
        BdUniqueId type;
        Integer num;
        if (nVar == null) {
            return null;
        }
        int i2 = -1;
        SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f2378e;
        if (sparseArray != null && sparseArray.size() != 0 && (type = nVar.getType()) != null && (num = this.f2379f.get(type.getId())) != null) {
            i2 = num.intValue();
        }
        if (i2 < 0 || i2 >= this.f2378e.size()) {
            return null;
        }
        return this.f2378e.get(i2);
    }

    public void c(a<n, TypeAdapter.ViewHolder> aVar) {
        if (aVar == null || aVar.G() == null) {
            return;
        }
        if (this.f2378e == null) {
            this.f2378e = new SparseArray<>();
        }
        if (aVar.G() != null) {
            aVar.Y(this);
            int id = aVar.G().getId();
            int size = this.f2378e.size();
            this.f2378e.put(size, aVar);
            this.f2379f.put(id, Integer.valueOf(size));
        }
    }

    public List<n> d() {
        return this.f2380g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.o
    /* renamed from: e */
    public n getItem(int i2) {
        List<n> list = this.f2380g;
        if (list != null) {
            int size = list.size();
            if (i2 < 0 || i2 >= size) {
                return null;
            }
            return this.f2380g.get(i2);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(TypeAdapter.ViewHolder viewHolder, int i2) {
        a<n, TypeAdapter.ViewHolder> aVar;
        n item;
        if (viewHolder == null || this.f2378e == null || this.f2380g == null) {
            return;
        }
        int itemCount = getItemCount();
        if (i2 < 0 || i2 >= itemCount || (aVar = this.f2378e.get(getItemViewType(i2))) == null || (item = getItem(i2)) == null || !(item instanceof n)) {
            return;
        }
        try {
            aVar.X(i2, this.f2381h, viewHolder, item);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        a<n, TypeAdapter.ViewHolder> aVar;
        if (this.f2381h == null) {
            this.f2381h = (RecyclerView) viewGroup;
        }
        n item = getItem(this.f2382i);
        SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f2378e;
        TypeAdapter.ViewHolder viewHolder = null;
        if (sparseArray != null && (aVar = sparseArray.get(i2)) != null) {
            try {
                viewHolder = aVar.Q(viewGroup, item);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (viewHolder == null) {
                Log.e("RecyclerViewTypeAdapter", aVar.getClass().getName());
            }
        }
        return viewHolder;
    }

    @Override // d.a.c.j.e.o
    public int getCount() {
        return getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<n> list = this.f2380g;
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
        this.f2382i = i2;
        SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f2378e;
        if (sparseArray == null || sparseArray.size() == 0 || (item = getItem(i2)) == null || (type = item.getType()) == null || (num = this.f2379f.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    public void h(ViewGroup viewGroup, View view, int i2, long j) {
        if (this.f2378e == null) {
            return;
        }
        n item = getItem(i2);
        int itemViewType = getItemViewType(i2);
        a<n, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.f2378e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.z() == null) {
            return;
        }
        valueAt.z().b(view, item, valueAt.G(), viewGroup, i2, j);
    }

    public boolean i(ViewGroup viewGroup, View view, int i2, long j) {
        if (this.f2378e == null) {
            return false;
        }
        n item = getItem(i2);
        int itemViewType = getItemViewType(i2);
        a<n, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.f2378e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.A() == null) {
            return false;
        }
        return valueAt.A().a(view, item, valueAt.G(), viewGroup, i2, j);
    }

    public void j(int i2, int i3) {
        if (i2 < this.f2380g.size()) {
            this.f2380g.remove(i2);
            notifyItemRemoved(i2 + i3);
        }
    }

    public void k(int i2, int i3, int i4) {
        if (i2 >= this.f2380g.size() || i3 >= this.f2380g.size() || i2 > i3) {
            return;
        }
        this.f2380g.subList(i2, i3 + 1).clear();
        notifyItemRangeRemoved(i4 + i2, (i3 - i2) + 1);
    }

    public void l(List<? extends n> list, int i2, int i3) {
        List<n> list2 = this.f2380g;
        if (list2 == null) {
            this.f2380g = new ArrayList();
        } else {
            list2.clear();
        }
        this.f2380g.addAll(list);
        notifyItemRangeChanged(i2, i3);
    }

    public void setData(List<? extends n> list) {
        List<n> list2 = this.f2380g;
        if (list2 == null) {
            this.f2380g = new ArrayList();
        } else {
            list2.clear();
        }
        this.f2380g.addAll(list);
        notifyDataSetChanged();
    }
}
