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
    private SparseArray<a<i, r.a>> avK;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> avL = new SparseArray<>();
    private List<i> avM = new ArrayList();
    private RecyclerView SG = null;
    private int avN = -1;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: b */
    public r.a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a<i, r.a> aVar;
        r.a aVar2 = null;
        if (this.SG == null) {
            this.SG = (RecyclerView) viewGroup;
        }
        i item = getItem(this.avN);
        if (this.avK == null || (aVar = this.avK.get(i)) == null) {
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
        if (aVar != null && this.avK != null && this.avM != null) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount && (aVar2 = this.avK.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof i)) {
                try {
                    aVar2.onFillViewHolder(i, this.SG, aVar, item);
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
        this.avN = i;
        if (this.avK == null || this.avK.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.avL.get(type.getId())) == null) {
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
        if (this.avM != null) {
            return this.avM.size();
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
        if (this.avM != null) {
            int size = this.avM.size();
            if (i >= 0 && i < size) {
                return this.avM.get(i);
            }
        }
        return null;
    }

    public void addAdapter(a<i, r.a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.avK == null) {
                this.avK = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.avK.size();
                this.avK.put(size, aVar);
                this.avL.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends i> list) {
        if (this.avM == null) {
            this.avM = new ArrayList();
        } else {
            this.avM.clear();
        }
        this.avM.addAll(list);
        notifyDataSetChanged();
    }

    public List<i> getData() {
        return this.avM;
    }

    public void a(ViewGroup viewGroup, View view, int i, long j) {
        a<i, r.a> aVar;
        if (this.avK != null) {
            i item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.avK.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view, int i, long j) {
        a<i, r.a> aVar;
        if (this.avK == null) {
            return false;
        }
        i item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.avK.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public int ar(int i, int i2) {
        int i3;
        if (this.avM == null || this.avM.size() == 0) {
            return -1;
        }
        int size = this.avM.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.avM.get(i4) == null) {
                i3 = i5;
            } else if (this.avM.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.avM.get(i4).getType().getId() ? i5 + 1 : i5;
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
