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
    private SparseArray<com.baidu.adp.widget.ListView.a<m, a>> Qy;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> Qz = new SparseArray<>();
    private List<m> QA = new ArrayList();

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.n
    public int getCount() {
        if (this.QA != null) {
            return this.QA.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.n
    public m getItem(int i) {
        if (this.QA != null) {
            int size = this.QA.size();
            if (i >= 0 && i < size) {
                return this.QA.get(i);
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
        if (this.Qy != null && this.QA != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.Qy.get(getItemViewType(i))) != null) {
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
        if (this.Qy == null || this.Qy.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.Qz.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.Qy != null) {
            return this.Qy.size();
        }
        return 0;
    }

    public void addAdapter(com.baidu.adp.widget.ListView.a<m, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Qy == null) {
                this.Qy = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.Qy.size();
                this.Qy.put(size, aVar);
                this.Qz.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends m> list) {
        if (this.QA == null) {
            this.QA = new ArrayList();
        } else {
            this.QA.clear();
        }
        this.QA.addAll(list);
        notifyDataSetChanged();
    }

    public List<m> getData() {
        return this.QA;
    }

    public void a(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<m, a> aVar;
        if (this.Qy != null) {
            m item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.Qy.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<m, a> aVar;
        if (this.Qy == null) {
            return false;
        }
        m item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.Qy.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.adp.widget.ListView.q
    public int u(int i, int i2) {
        int i3;
        if (this.QA == null || this.QA.size() == 0) {
            return -1;
        }
        int size = this.QA.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.QA.get(i4) == null) {
                i3 = i5;
            } else if (this.QA.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.QA.get(i4).getType().getId() ? i5 + 1 : i5;
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
