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
    private SparseArray<com.baidu.adp.widget.ListView.a<i, a>> avM;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> avN = new SparseArray<>();
    private List<i> avO = new ArrayList();

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.j
    public int getCount() {
        if (this.avO != null) {
            return this.avO.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.j
    public i getItem(int i) {
        if (this.avO != null) {
            int size = this.avO.size();
            if (i >= 0 && i < size) {
                return this.avO.get(i);
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
        if (this.avM != null && this.avO != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.avM.get(getItemViewType(i))) != null) {
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
        if (this.avM == null || this.avM.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.avN.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.avM != null) {
            return this.avM.size();
        }
        return 0;
    }

    public void addAdapter(com.baidu.adp.widget.ListView.a<i, a> aVar) {
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
        com.baidu.adp.widget.ListView.a<i, a> aVar;
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
        com.baidu.adp.widget.ListView.a<i, a> aVar;
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
