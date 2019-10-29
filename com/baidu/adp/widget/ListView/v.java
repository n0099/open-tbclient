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
    private SparseArray<com.baidu.adp.widget.ListView.a<m, a>> mDelegateAdapters;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> mViewTypes = new SparseArray<>();
    private List<m> mLists = new ArrayList();

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.n
    public int getCount() {
        if (this.mLists != null) {
            return this.mLists.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.n
    public m getItem(int i) {
        if (this.mLists != null) {
            int size = this.mLists.size();
            if (i >= 0 && i < size) {
                return this.mLists.get(i);
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
        if (this.mDelegateAdapters != null && this.mLists != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.mDelegateAdapters.get(getItemViewType(i))) != null) {
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
        if (this.mDelegateAdapters == null || this.mDelegateAdapters.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.mViewTypes.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.mDelegateAdapters != null) {
            return this.mDelegateAdapters.size();
        }
        return 0;
    }

    public void addAdapter(com.baidu.adp.widget.ListView.a<m, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.mDelegateAdapters == null) {
                this.mDelegateAdapters = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.a(this);
                int id = aVar.getType().getId();
                int size = this.mDelegateAdapters.size();
                this.mDelegateAdapters.put(size, aVar);
                this.mViewTypes.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends m> list) {
        if (this.mLists == null) {
            this.mLists = new ArrayList();
        } else {
            this.mLists.clear();
        }
        this.mLists.addAll(list);
        notifyDataSetChanged();
    }

    public List<m> getData() {
        return this.mLists;
    }

    public void onItemClick(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<m, a> aVar;
        if (this.mDelegateAdapters != null) {
            m item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.mDelegateAdapters.valueAt(itemViewType);
            }
            if (aVar != null && aVar.jE() != null) {
                aVar.jE().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean onItemLongClick(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<m, a> aVar;
        if (this.mDelegateAdapters == null) {
            return false;
        }
        m item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.mDelegateAdapters.valueAt(itemViewType);
        }
        if (aVar == null || aVar.jF() == null) {
            return false;
        }
        return aVar.jF().b(view, item, aVar.getType(), viewGroup, i, j);
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
