package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r extends BaseAdapter implements m<i> {
    private SparseArray<com.baidu.adp.widget.ListView.a<i, a>> avJ;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> avK = new SparseArray<>();
    private List<i> avL = new ArrayList();

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.j
    public int getCount() {
        if (this.avL != null) {
            return this.avL.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.j
    public i getItem(int i) {
        if (this.avL != null) {
            int size = this.avL.size();
            if (i >= 0 && i < size) {
                return this.avL.get(i);
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.adp.widget.ListView.a<i, a> aVar;
        View view2 = null;
        if (this.avJ != null && this.avL != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.avJ.get(getItemViewType(i))) != null) {
                i item = getItem(i);
                if (item != null && (item instanceof i)) {
                    view2 = aVar.getView(i, view, viewGroup, item);
                }
                if (view2 == null) {
                    Log.e("BdTypeListView", aVar.getClass().getName());
                }
                return view2;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        i item;
        BdUniqueId type;
        Integer num;
        if (this.avJ == null || this.avJ.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.avK.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.avJ != null) {
            return this.avJ.size();
        }
        return 0;
    }

    public void addAdapter(com.baidu.adp.widget.ListView.a<i, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.avJ == null) {
                this.avJ = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.avJ.size();
                this.avJ.put(size, aVar);
                this.avK.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends i> list) {
        if (this.avL == null) {
            this.avL = new ArrayList();
        } else {
            this.avL.clear();
        }
        this.avL.addAll(list);
        notifyDataSetChanged();
    }

    public List<i> getData() {
        return this.avL;
    }

    public void a(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<i, a> aVar;
        if (this.avJ != null) {
            i item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.avJ.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<i, a> aVar;
        if (this.avJ == null) {
            return false;
        }
        i item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.avJ.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public int ar(int i, int i2) {
        int i3;
        if (this.avL == null || this.avL.size() == 0) {
            return -1;
        }
        int size = this.avL.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.avL.get(i4) == null) {
                i3 = i5;
            } else if (this.avL.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.avL.get(i4).getType().getId() ? i5 + 1 : i5;
                if (i4 == i) {
                    return i3;
                }
            }
            i4++;
            i5 = i3;
        }
        return -1;
    }

    /* loaded from: classes.dex */
    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
            this.itemView.setTag(this);
        }

        public View getView() {
            return this.itemView;
        }
    }
}
