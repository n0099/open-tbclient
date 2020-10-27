package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ad extends RecyclerView.Adapter<af.a> implements u<q> {
    private SparseArray<a<q, af.a>> mDelegateAdapters;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> mViewTypes = new SparseArray<>();
    private List<q> mLists = new ArrayList();
    private RecyclerView mRecyclerView = null;
    private int Xt = -1;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public af.a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a<q, af.a> aVar;
        af.a aVar2 = null;
        if (this.mRecyclerView == null) {
            this.mRecyclerView = (RecyclerView) viewGroup;
        }
        q item = getItem(this.Xt);
        if (this.mDelegateAdapters == null || (aVar = this.mDelegateAdapters.get(i)) == null) {
            return null;
        }
        try {
            aVar2 = aVar.a(viewGroup, item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (aVar2 == null) {
            Log.e("RecyclerViewTypeAdapter", aVar.getClass().getName());
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(af.a aVar, int i) {
        a<q, af.a> aVar2;
        q item;
        if (aVar != null && this.mDelegateAdapters != null && this.mLists != null) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount && (aVar2 = this.mDelegateAdapters.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof q)) {
                try {
                    aVar2.a(i, this.mRecyclerView, aVar, item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        q item;
        BdUniqueId type;
        Integer num;
        this.Xt = i;
        if (this.mDelegateAdapters == null || this.mDelegateAdapters.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.mViewTypes.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mLists != null) {
            return this.mLists.size();
        }
        return 0;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public int getCount() {
        return getItemCount();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.r
    public q getItem(int i) {
        if (this.mLists != null) {
            int size = this.mLists.size();
            if (i >= 0 && i < size) {
                return this.mLists.get(i);
            }
        }
        return null;
    }

    public void q(int i, int i2) {
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

    public void addAdapter(a<q, af.a> aVar) {
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

    public void setData(List<? extends q> list) {
        if (this.mLists == null) {
            this.mLists = new ArrayList();
        } else {
            this.mLists.clear();
        }
        this.mLists.addAll(list);
        notifyDataSetChanged();
    }

    public void a(List<? extends q> list, int i, int i2) {
        if (this.mLists == null) {
            this.mLists = new ArrayList();
        } else {
            this.mLists.clear();
        }
        this.mLists.addAll(list);
        notifyItemRangeChanged(i, i2);
    }

    public List<q> getData() {
        return this.mLists;
    }

    public void onItemClick(ViewGroup viewGroup, View view, int i, long j) {
        a<q, af.a> aVar;
        if (this.mDelegateAdapters != null) {
            q item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.mDelegateAdapters.valueAt(itemViewType);
            }
            if (aVar != null && aVar.qN() != null) {
                aVar.qN().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean onItemLongClick(ViewGroup viewGroup, View view, int i, long j) {
        a<q, af.a> aVar;
        if (this.mDelegateAdapters == null) {
            return false;
        }
        q item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.mDelegateAdapters.valueAt(itemViewType);
        }
        if (aVar == null || aVar.qO() == null) {
            return false;
        }
        return aVar.qO().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.u
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
