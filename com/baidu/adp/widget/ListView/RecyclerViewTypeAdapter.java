package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.b.b.j.e.a;
import d.b.b.j.e.n;
import d.b.b.j.e.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RecyclerViewTypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> implements r<n> {

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<a<n, TypeAdapter.ViewHolder>> f2356e;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<Integer> f2357f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public List<n> f2358g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f2359h = null;
    public int i = -1;

    @Override // d.b.b.j.e.r
    public int a(int i, int i2) {
        List<n> list = this.f2358g;
        if (list != null && list.size() != 0) {
            int size = this.f2358g.size();
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                if (this.f2358g.get(i4) != null && this.f2358g.get(i4).getType() != null) {
                    if (i2 == this.f2358g.get(i4).getType().getId()) {
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

    @Override // d.b.b.j.e.r
    public a<n, TypeAdapter.ViewHolder> b(n nVar) {
        BdUniqueId type;
        Integer num;
        if (nVar == null) {
            return null;
        }
        int i = -1;
        SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f2356e;
        if (sparseArray != null && sparseArray.size() != 0 && (type = nVar.getType()) != null && (num = this.f2357f.get(type.getId())) != null) {
            i = num.intValue();
        }
        if (i < 0 || i >= this.f2356e.size()) {
            return null;
        }
        return this.f2356e.get(i);
    }

    public void c(a<n, TypeAdapter.ViewHolder> aVar) {
        if (aVar == null || aVar.G() == null) {
            return;
        }
        if (this.f2356e == null) {
            this.f2356e = new SparseArray<>();
        }
        if (aVar.G() != null) {
            aVar.b0(this);
            int id = aVar.G().getId();
            int size = this.f2356e.size();
            this.f2356e.put(size, aVar);
            this.f2357f.put(id, Integer.valueOf(size));
        }
    }

    @Override // d.b.b.j.e.o
    public int getCount() {
        return getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<n> list = this.f2358g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        n item;
        BdUniqueId type;
        Integer num;
        this.i = i;
        SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f2356e;
        if (sparseArray == null || sparseArray.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.f2357f.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    public List<n> m() {
        return this.f2358g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.o
    /* renamed from: n */
    public n getItem(int i) {
        List<n> list = this.f2358g;
        if (list != null) {
            int size = list.size();
            if (i < 0 || i >= size) {
                return null;
            }
            return this.f2358g.get(i);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(TypeAdapter.ViewHolder viewHolder, int i) {
        a<n, TypeAdapter.ViewHolder> aVar;
        n item;
        if (viewHolder == null || this.f2356e == null || this.f2358g == null) {
            return;
        }
        int itemCount = getItemCount();
        if (i < 0 || i >= itemCount || (aVar = this.f2356e.get(getItemViewType(i))) == null || (item = getItem(i)) == null || !(item instanceof n)) {
            return;
        }
        try {
            aVar.Y(i, this.f2359h, viewHolder, item);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        a<n, TypeAdapter.ViewHolder> aVar;
        if (this.f2359h == null) {
            this.f2359h = (RecyclerView) viewGroup;
        }
        n item = getItem(this.i);
        SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f2356e;
        TypeAdapter.ViewHolder viewHolder = null;
        if (sparseArray != null && (aVar = sparseArray.get(i)) != null) {
            try {
                viewHolder = aVar.S(viewGroup, item);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (viewHolder == null) {
                Log.e("RecyclerViewTypeAdapter", aVar.getClass().getName());
            }
        }
        return viewHolder;
    }

    public void q(ViewGroup viewGroup, View view, int i, long j) {
        if (this.f2356e == null) {
            return;
        }
        n item = getItem(i);
        int itemViewType = getItemViewType(i);
        a<n, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.f2356e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.A() == null) {
            return;
        }
        valueAt.A().f(view, item, valueAt.G(), viewGroup, i, j);
    }

    public boolean r(ViewGroup viewGroup, View view, int i, long j) {
        if (this.f2356e == null) {
            return false;
        }
        n item = getItem(i);
        int itemViewType = getItemViewType(i);
        a<n, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.f2356e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.B() == null) {
            return false;
        }
        return valueAt.B().a(view, item, valueAt.G(), viewGroup, i, j);
    }

    public void s(int i, int i2) {
        if (i < this.f2358g.size()) {
            this.f2358g.remove(i);
            notifyItemRemoved(i + i2);
        }
    }

    public void setData(List<? extends n> list) {
        List<n> list2 = this.f2358g;
        if (list2 == null) {
            this.f2358g = new ArrayList();
        } else {
            list2.clear();
        }
        this.f2358g.addAll(list);
        notifyDataSetChanged();
    }

    public void u(int i, int i2, int i3) {
        if (i >= this.f2358g.size() || i2 >= this.f2358g.size() || i > i2) {
            return;
        }
        this.f2358g.subList(i, i2 + 1).clear();
        notifyItemRangeRemoved(i3 + i, (i2 - i) + 1);
    }

    public void v(List<? extends n> list, int i, int i2) {
        List<n> list2 = this.f2358g;
        if (list2 == null) {
            this.f2358g = new ArrayList();
        } else {
            list2.clear();
        }
        this.f2358g.addAll(list);
        notifyItemRangeChanged(i, i2);
    }
}
