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
public class q extends BaseAdapter implements l<h> {
    private SparseArray<com.baidu.adp.widget.ListView.a<h, a>> Gi;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> Gj = new SparseArray<>();
    private List<h> Gk = new ArrayList();

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.i
    public int getCount() {
        if (this.Gk != null) {
            return this.Gk.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.i
    public h getItem(int i) {
        if (this.Gk != null) {
            int size = this.Gk.size();
            if (i >= 0 && i < size) {
                return this.Gk.get(i);
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        com.baidu.adp.widget.ListView.a<h, a> aVar;
        View view3 = null;
        if (this.Gi != null && this.Gk != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.Gi.get(getItemViewType(i))) != null) {
                h item = getItem(i);
                if (item != null && (item instanceof h)) {
                    view3 = aVar.getView(i, view2, viewGroup, item);
                }
                if (view3 == null) {
                    Log.e("BdTypeListView", aVar.getClass().getName());
                }
                return view3;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        h item;
        BdUniqueId type;
        Integer num;
        if (this.Gi == null || this.Gi.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.Gj.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.Gi != null) {
            return this.Gi.size();
        }
        return 0;
    }

    public void addAdapter(com.baidu.adp.widget.ListView.a<h, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Gi == null) {
                this.Gi = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.Gi.size();
                this.Gi.put(size, aVar);
                this.Gj.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends h> list) {
        if (this.Gk == null) {
            this.Gk = new ArrayList();
        } else {
            this.Gk.clear();
        }
        this.Gk.addAll(list);
        notifyDataSetChanged();
    }

    public List<h> getData() {
        return this.Gk;
    }

    public void a(ViewGroup viewGroup, View view2, int i, long j) {
        com.baidu.adp.widget.ListView.a<h, a> aVar;
        if (this.Gi != null) {
            h item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.Gi.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view2, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view2, int i, long j) {
        com.baidu.adp.widget.ListView.a<h, a> aVar;
        if (this.Gi == null) {
            return false;
        }
        h item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.Gi.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view2, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.l
    public int q(int i, int i2) {
        int i3;
        if (this.Gk == null || this.Gk.size() == 0) {
            return -1;
        }
        int size = this.Gk.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.Gk.get(i4) == null) {
                i3 = i5;
            } else if (this.Gk.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.Gk.get(i4).getType().getId() ? i5 + 1 : i5;
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
        public a(View view2) {
            super(view2);
            this.itemView.setTag(this);
        }

        public View getView() {
            return this.itemView;
        }
    }
}
