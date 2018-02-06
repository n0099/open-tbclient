package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends RecyclerView.Adapter<r.a> implements m<i> {
    private SparseArray<a<i, r.a>> avH;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> avI = new SparseArray<>();
    private List<i> avJ = new ArrayList();
    private RecyclerView SF = null;
    private int avK = -1;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: b */
    public r.a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a<i, r.a> aVar;
        r.a aVar2 = null;
        if (this.SF == null) {
            this.SF = (RecyclerView) viewGroup;
        }
        i item = getItem(this.avK);
        if (this.avH == null || (aVar = this.avH.get(i)) == null) {
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
    public void onBindViewHolder(r.a aVar, int i) {
        a<i, r.a> aVar2;
        i item;
        if (aVar != null && this.avH != null && this.avJ != null) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount && (aVar2 = this.avH.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof i)) {
                try {
                    aVar2.onFillViewHolder(i, this.SF, aVar, item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        i item;
        BdUniqueId type;
        Integer num;
        this.avK = i;
        if (this.avH == null || this.avH.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.avI.get(type.getId())) == null) {
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
        if (this.avJ != null) {
            return this.avJ.size();
        }
        return 0;
    }

    @Override // com.baidu.adp.widget.ListView.j
    public int getCount() {
        return getItemCount();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.j
    public i getItem(int i) {
        if (this.avJ != null) {
            int size = this.avJ.size();
            if (i >= 0 && i < size) {
                return this.avJ.get(i);
            }
        }
        return null;
    }

    public void addAdapter(a<i, r.a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.avH == null) {
                this.avH = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.avH.size();
                this.avH.put(size, aVar);
                this.avI.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends i> list) {
        if (this.avJ == null) {
            this.avJ = new ArrayList();
        } else {
            this.avJ.clear();
        }
        this.avJ.addAll(list);
        notifyDataSetChanged();
    }

    public List<i> getData() {
        return this.avJ;
    }

    public void a(ViewGroup viewGroup, View view, int i, long j) {
        a<i, r.a> aVar;
        if (this.avH != null) {
            i item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.avH.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view, int i, long j) {
        a<i, r.a> aVar;
        if (this.avH == null) {
            return false;
        }
        i item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.avH.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public int ar(int i, int i2) {
        int i3;
        if (this.avJ == null || this.avJ.size() == 0) {
            return -1;
        }
        int size = this.avJ.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.avJ.get(i4) == null) {
                i3 = i5;
            } else if (this.avJ.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.avJ.get(i4).getType().getId() ? i5 + 1 : i5;
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
