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
    private SparseArray<com.baidu.adp.widget.ListView.a<h, a>> Ms;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> Mt = new SparseArray<>();
    private List<h> Mu = new ArrayList();

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.i
    public int getCount() {
        if (this.Mu != null) {
            return this.Mu.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.i
    public h getItem(int i) {
        if (this.Mu != null) {
            int size = this.Mu.size();
            if (i >= 0 && i < size) {
                return this.Mu.get(i);
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
        com.baidu.adp.widget.ListView.a<h, a> aVar;
        View view2 = null;
        if (this.Ms != null && this.Mu != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.Ms.get(getItemViewType(i))) != null) {
                h item = getItem(i);
                if (item != null && (item instanceof h)) {
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
        h item;
        BdUniqueId type;
        Integer num;
        if (this.Ms == null || this.Ms.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.Mt.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.Ms != null) {
            return this.Ms.size();
        }
        return 0;
    }

    public void addAdapter(com.baidu.adp.widget.ListView.a<h, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Ms == null) {
                this.Ms = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.Ms.size();
                this.Ms.put(size, aVar);
                this.Mt.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends h> list) {
        if (this.Mu == null) {
            this.Mu = new ArrayList();
        } else {
            this.Mu.clear();
        }
        this.Mu.addAll(list);
        notifyDataSetChanged();
    }

    public List<h> getData() {
        return this.Mu;
    }

    public void a(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<h, a> aVar;
        if (this.Ms != null) {
            h item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.Ms.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<h, a> aVar;
        if (this.Ms == null) {
            return false;
        }
        h item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.Ms.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.l
    public int q(int i, int i2) {
        int i3;
        if (this.Mu == null || this.Mu.size() == 0) {
            return -1;
        }
        int size = this.Mu.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.Mu.get(i4) == null) {
                i3 = i5;
            } else if (this.Mu.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.Mu.get(i4).getType().getId() ? i5 + 1 : i5;
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
