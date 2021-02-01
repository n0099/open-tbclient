package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RecyclerViewTypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> implements r<n> {
    private SparseArray<a<n, TypeAdapter.ViewHolder>> mDelegateAdapters;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> mViewTypes = new SparseArray<>();
    private List<n> mLists = new ArrayList();
    private RecyclerView mRecyclerView = null;
    private int Ym = -1;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        a<n, TypeAdapter.ViewHolder> aVar;
        TypeAdapter.ViewHolder viewHolder = null;
        if (this.mRecyclerView == null) {
            this.mRecyclerView = (RecyclerView) viewGroup;
        }
        n item = getItem(this.Ym);
        if (this.mDelegateAdapters == null || (aVar = this.mDelegateAdapters.get(i)) == null) {
            return null;
        }
        try {
            viewHolder = aVar.a(viewGroup, item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (viewHolder == null) {
            Log.e("RecyclerViewTypeAdapter", aVar.getClass().getName());
        }
        return viewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(TypeAdapter.ViewHolder viewHolder, int i) {
        a<n, TypeAdapter.ViewHolder> aVar;
        n item;
        if (viewHolder != null && this.mDelegateAdapters != null && this.mLists != null) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount && (aVar = this.mDelegateAdapters.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof n)) {
                try {
                    aVar.a(i, this.mRecyclerView, viewHolder, item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        n item;
        BdUniqueId type;
        Integer num;
        this.Ym = i;
        if (this.mDelegateAdapters == null || this.mDelegateAdapters.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.mViewTypes.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mLists != null) {
            return this.mLists.size();
        }
        return 0;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public int getCount() {
        return getItemCount();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.o
    public n getItem(int i) {
        if (this.mLists != null) {
            int size = this.mLists.size();
            if (i >= 0 && i < size) {
                return this.mLists.get(i);
            }
        }
        return null;
    }

    public void r(int i, int i2) {
        if (i < this.mLists.size()) {
            this.mLists.remove(i);
            notifyItemRemoved(i + i2);
        }
    }

    public void k(int i, int i2, int i3) {
        if (i < this.mLists.size() && i2 < this.mLists.size() && i <= i2) {
            this.mLists.subList(i, i2 + 1).clear();
            notifyItemRangeRemoved(i + i3, (i2 - i) + 1);
        }
    }

    public void addAdapter(a<n, TypeAdapter.ViewHolder> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.mDelegateAdapters == null) {
                this.mDelegateAdapters = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.a(this);
                int id = aVar.getType().getId();
                int size = this.mDelegateAdapters.size();
                this.mDelegateAdapters.put(size, aVar);
                this.mViewTypes.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends n> list) {
        if (this.mLists == null) {
            this.mLists = new ArrayList();
        } else {
            this.mLists.clear();
        }
        this.mLists.addAll(list);
        notifyDataSetChanged();
    }

    public void a(List<? extends n> list, int i, int i2) {
        if (this.mLists == null) {
            this.mLists = new ArrayList();
        } else {
            this.mLists.clear();
        }
        this.mLists.addAll(list);
        notifyItemRangeChanged(i, i2);
    }

    public List<n> getData() {
        return this.mLists;
    }

    public void onItemClick(ViewGroup viewGroup, View view, int i, long j) {
        a<n, TypeAdapter.ViewHolder> aVar;
        if (this.mDelegateAdapters != null) {
            n item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.mDelegateAdapters.valueAt(itemViewType);
            }
            if (aVar != null && aVar.qp() != null) {
                aVar.qp().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean onItemLongClick(ViewGroup viewGroup, View view, int i, long j) {
        a<n, TypeAdapter.ViewHolder> aVar;
        if (this.mDelegateAdapters == null) {
            return false;
        }
        n item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.mDelegateAdapters.valueAt(itemViewType);
        }
        if (aVar == null || aVar.qq() == null) {
            return false;
        }
        return aVar.qq().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.r
    public int getPositionByType(int i, int i2) {
        int i3;
        if (this.mLists == null || this.mLists.size() == 0) {
            return -1;
        }
        int size = this.mLists.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.mLists.get(i4) == null) {
                i3 = i5;
            } else if (this.mLists.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.mLists.get(i4).getType().getId() ? i5 + 1 : i5;
                if (i4 == i) {
                    return i3;
                }
            }
            i4++;
            i5 = i3;
        }
        return -1;
    }
}
