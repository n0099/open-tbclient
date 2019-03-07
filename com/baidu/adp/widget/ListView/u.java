package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u extends RecyclerView.Adapter<v.a> implements q<m> {
    private SparseArray<a<m, v.a>> Qx;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> Qy = new SparseArray<>();
    private List<m> Qz = new ArrayList();
    private RecyclerView mRecyclerView = null;
    private int QA = -1;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public v.a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a<m, v.a> aVar;
        v.a aVar2 = null;
        if (this.mRecyclerView == null) {
            this.mRecyclerView = (RecyclerView) viewGroup;
        }
        m item = getItem(this.QA);
        if (this.Qx == null || (aVar = this.Qx.get(i)) == null) {
            return null;
        }
        try {
            aVar2 = aVar.onCreateViewHolder(viewGroup, item);
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
    public void onBindViewHolder(v.a aVar, int i) {
        a<m, v.a> aVar2;
        m item;
        if (aVar != null && this.Qx != null && this.Qz != null) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount && (aVar2 = this.Qx.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof m)) {
                try {
                    aVar2.onFillViewHolder(i, this.mRecyclerView, aVar, item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        m item;
        BdUniqueId type;
        Integer num;
        this.QA = i;
        if (this.Qx == null || this.Qx.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.Qy.get(type.getId())) == null) {
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
        if (this.Qz != null) {
            return this.Qz.size();
        }
        return 0;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public int getCount() {
        return getItemCount();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.n
    public m getItem(int i) {
        if (this.Qz != null) {
            int size = this.Qz.size();
            if (i >= 0 && i < size) {
                return this.Qz.get(i);
            }
        }
        return null;
    }

    public void s(int i, int i2) {
        if (i < this.Qz.size() && i2 < this.Qz.size() && i <= i2) {
            this.Qz.subList(i, i2 + 1).clear();
            notifyItemRangeRemoved(i, (i2 - i) + 1);
        }
    }

    public void addAdapter(a<m, v.a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Qx == null) {
                this.Qx = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.Qx.size();
                this.Qx.put(size, aVar);
                this.Qy.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends m> list) {
        if (this.Qz == null) {
            this.Qz = new ArrayList();
        } else {
            this.Qz.clear();
        }
        this.Qz.addAll(list);
        notifyDataSetChanged();
    }

    public void a(List<? extends m> list, int i, int i2) {
        if (this.Qz == null) {
            this.Qz = new ArrayList();
        } else {
            this.Qz.clear();
        }
        this.Qz.addAll(list);
        notifyItemRangeChanged(i, i2);
    }

    public List<m> getData() {
        return this.Qz;
    }

    public void a(ViewGroup viewGroup, View view, int i, long j) {
        a<m, v.a> aVar;
        if (this.Qx != null) {
            m item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.Qx.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view, int i, long j) {
        a<m, v.a> aVar;
        if (this.Qx == null) {
            return false;
        }
        m item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.Qx.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.q
    public int u(int i, int i2) {
        int i3;
        if (this.Qz == null || this.Qz.size() == 0) {
            return -1;
        }
        int size = this.Qz.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.Qz.get(i4) == null) {
                i3 = i5;
            } else if (this.Qz.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.Qz.get(i4).getType().getId() ? i5 + 1 : i5;
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
