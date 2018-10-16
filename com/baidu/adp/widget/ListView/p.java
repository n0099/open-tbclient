package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends RecyclerView.Adapter<q.a> implements l<h> {
    private SparseArray<a<h, q.a>> Pg;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> Ph = new SparseArray<>();
    private List<h> Pi = new ArrayList();
    private RecyclerView mRecyclerView = null;
    private int Pj = -1;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public q.a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a<h, q.a> aVar;
        q.a aVar2 = null;
        if (this.mRecyclerView == null) {
            this.mRecyclerView = (RecyclerView) viewGroup;
        }
        h item = getItem(this.Pj);
        if (this.Pg == null || (aVar = this.Pg.get(i)) == null) {
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
    public void onBindViewHolder(q.a aVar, int i) {
        a<h, q.a> aVar2;
        h item;
        if (aVar != null && this.Pg != null && this.Pi != null) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount && (aVar2 = this.Pg.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof h)) {
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
        h item;
        BdUniqueId type;
        Integer num;
        this.Pj = i;
        if (this.Pg == null || this.Pg.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.Ph.get(type.getId())) == null) {
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
        if (this.Pi != null) {
            return this.Pi.size();
        }
        return 0;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public int getCount() {
        return getItemCount();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.i
    public h getItem(int i) {
        if (this.Pi != null) {
            int size = this.Pi.size();
            if (i >= 0 && i < size) {
                return this.Pi.get(i);
            }
        }
        return null;
    }

    public void removeItem(int i) {
        if (i < this.Pi.size()) {
            this.Pi.remove(i);
            notifyItemRemoved(i);
        }
    }

    public void addAdapter(a<h, q.a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Pg == null) {
                this.Pg = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.Pg.size();
                this.Pg.put(size, aVar);
                this.Ph.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends h> list) {
        if (this.Pi == null) {
            this.Pi = new ArrayList();
        } else {
            this.Pi.clear();
        }
        this.Pi.addAll(list);
        notifyDataSetChanged();
    }

    public void a(List<? extends h> list, int i, int i2) {
        if (this.Pi == null) {
            this.Pi = new ArrayList();
        } else {
            this.Pi.clear();
        }
        this.Pi.addAll(list);
        notifyItemRangeChanged(i, i2);
    }

    public List<h> getData() {
        return this.Pi;
    }

    public void a(ViewGroup viewGroup, View view, int i, long j) {
        a<h, q.a> aVar;
        if (this.Pg != null) {
            h item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.Pg.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view, int i, long j) {
        a<h, q.a> aVar;
        if (this.Pg == null) {
            return false;
        }
        h item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.Pg.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.l
    public int s(int i, int i2) {
        int i3;
        if (this.Pi == null || this.Pi.size() == 0) {
            return -1;
        }
        int size = this.Pi.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.Pi.get(i4) == null) {
                i3 = i5;
            } else if (this.Pi.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.Pi.get(i4).getType().getId() ? i5 + 1 : i5;
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
