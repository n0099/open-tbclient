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
    private SparseArray<com.baidu.adp.widget.ListView.a<i, a>> avK;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> avL = new SparseArray<>();
    private List<i> avM = new ArrayList();

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.j
    public int getCount() {
        if (this.avM != null) {
            return this.avM.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.j
    public i getItem(int i) {
        if (this.avM != null) {
            int size = this.avM.size();
            if (i >= 0 && i < size) {
                return this.avM.get(i);
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
        if (this.avK != null && this.avM != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.avK.get(getItemViewType(i))) != null) {
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
        if (this.avK == null || this.avK.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.avL.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.avK != null) {
            return this.avK.size();
        }
        return 0;
    }

    public void addAdapter(com.baidu.adp.widget.ListView.a<i, a> aVar) {
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
        com.baidu.adp.widget.ListView.a<i, a> aVar;
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
        com.baidu.adp.widget.ListView.a<i, a> aVar;
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
