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
    private SparseArray<com.baidu.adp.widget.ListView.a<h, a>> OQ;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> OR = new SparseArray<>();
    private List<h> OT = new ArrayList();

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.i
    public int getCount() {
        if (this.OT != null) {
            return this.OT.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.i
    public h getItem(int i) {
        if (this.OT != null) {
            int size = this.OT.size();
            if (i >= 0 && i < size) {
                return this.OT.get(i);
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
        if (this.OQ != null && this.OT != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.OQ.get(getItemViewType(i))) != null) {
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
        if (this.OQ == null || this.OQ.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.OR.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.OQ != null) {
            return this.OQ.size();
        }
        return 0;
    }

    public void addAdapter(com.baidu.adp.widget.ListView.a<h, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.OQ == null) {
                this.OQ = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.OQ.size();
                this.OQ.put(size, aVar);
                this.OR.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends h> list) {
        if (this.OT == null) {
            this.OT = new ArrayList();
        } else {
            this.OT.clear();
        }
        this.OT.addAll(list);
        notifyDataSetChanged();
    }

    public List<h> getData() {
        return this.OT;
    }

    public void a(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<h, a> aVar;
        if (this.OQ != null) {
            h item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.OQ.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<h, a> aVar;
        if (this.OQ == null) {
            return false;
        }
        h item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.OQ.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.l
    public int s(int i, int i2) {
        int i3;
        if (this.OT == null || this.OT.size() == 0) {
            return -1;
        }
        int size = this.OT.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.OT.get(i4) == null) {
                i3 = i5;
            } else if (this.OT.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.OT.get(i4).getType().getId() ? i5 + 1 : i5;
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
