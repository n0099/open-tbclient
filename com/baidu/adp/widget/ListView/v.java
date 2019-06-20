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
public class v extends BaseAdapter implements q<m> {
    private SparseArray<com.baidu.adp.widget.ListView.a<m, a>> Of;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> Og = new SparseArray<>();
    private List<m> Oh = new ArrayList();

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.n
    public int getCount() {
        if (this.Oh != null) {
            return this.Oh.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.n
    public m getItem(int i) {
        if (this.Oh != null) {
            int size = this.Oh.size();
            if (i >= 0 && i < size) {
                return this.Oh.get(i);
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
        com.baidu.adp.widget.ListView.a<m, a> aVar;
        View view2 = null;
        if (this.Of != null && this.Oh != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.Of.get(getItemViewType(i))) != null) {
                m item = getItem(i);
                if (item != null && (item instanceof m)) {
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
        m item;
        BdUniqueId type;
        Integer num;
        if (this.Of == null || this.Of.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.Og.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.Of != null) {
            return this.Of.size();
        }
        return 0;
    }

    public void addAdapter(com.baidu.adp.widget.ListView.a<m, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Of == null) {
                this.Of = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.Of.size();
                this.Of.put(size, aVar);
                this.Og.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends m> list) {
        if (this.Oh == null) {
            this.Oh = new ArrayList();
        } else {
            this.Oh.clear();
        }
        this.Oh.addAll(list);
        notifyDataSetChanged();
    }

    public List<m> getData() {
        return this.Oh;
    }

    public void a(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<m, a> aVar;
        if (this.Of != null) {
            m item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.Of.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<m, a> aVar;
        if (this.Of == null) {
            return false;
        }
        m item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.Of.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.q
    public int s(int i, int i2) {
        int i3;
        if (this.Oh == null || this.Oh.size() == 0) {
            return -1;
        }
        int size = this.Oh.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.Oh.get(i4) == null) {
                i3 = i5;
            } else if (this.Oh.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.Oh.get(i4).getType().getId() ? i5 + 1 : i5;
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
