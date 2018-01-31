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
    private SparseArray<a<i, r.a>> avM;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> avN = new SparseArray<>();
    private List<i> avO = new ArrayList();
    private RecyclerView SG = null;
    private int avP = -1;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: b */
    public r.a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a<i, r.a> aVar;
        r.a aVar2 = null;
        if (this.SG == null) {
            this.SG = (RecyclerView) viewGroup;
        }
        i item = getItem(this.avP);
        if (this.avM == null || (aVar = this.avM.get(i)) == null) {
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
        if (aVar != null && this.avM != null && this.avO != null) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount && (aVar2 = this.avM.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof i)) {
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
        this.avP = i;
        if (this.avM == null || this.avM.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.avN.get(type.getId())) == null) {
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
        if (this.avO != null) {
            return this.avO.size();
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
        if (this.avO != null) {
            int size = this.avO.size();
            if (i >= 0 && i < size) {
                return this.avO.get(i);
            }
        }
        return null;
    }

    public void addAdapter(a<i, r.a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.avM == null) {
                this.avM = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.avM.size();
                this.avM.put(size, aVar);
                this.avN.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends i> list) {
        if (this.avO == null) {
            this.avO = new ArrayList();
        } else {
            this.avO.clear();
        }
        this.avO.addAll(list);
        notifyDataSetChanged();
    }

    public List<i> getData() {
        return this.avO;
    }

    public void a(ViewGroup viewGroup, View view, int i, long j) {
        a<i, r.a> aVar;
        if (this.avM != null) {
            i item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.avM.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view, int i, long j) {
        a<i, r.a> aVar;
        if (this.avM == null) {
            return false;
        }
        i item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.avM.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public int ar(int i, int i2) {
        int i3;
        if (this.avO == null || this.avO.size() == 0) {
            return -1;
        }
        int size = this.avO.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.avO.get(i4) == null) {
                i3 = i5;
            } else if (this.avO.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.avO.get(i4).getType().getId() ? i5 + 1 : i5;
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
