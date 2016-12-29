package com.baidu.adp.widget.ListView;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class y extends BaseAdapter {
    private SparseArray<Integer> CA = new SparseArray<>();
    private List<v> CB = new ArrayList();
    private SparseArray<com.baidu.adp.widget.ListView.a<v, a>> Cz;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.CB != null) {
            return this.CB.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: aK */
    public v getItem(int i) {
        if (this.CB != null) {
            int size = this.CB.size();
            if (i >= 0 && i < size) {
                return this.CB.get(i);
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
        com.baidu.adp.widget.ListView.a<v, a> aVar;
        View view2 = null;
        if (this.Cz != null && this.CB != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.Cz.get(getItemViewType(i))) != null) {
                v item = getItem(i);
                if (item != null && (item instanceof v)) {
                    view2 = aVar.a(i, view, viewGroup, item);
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
        v item;
        BdUniqueId type;
        Integer num;
        if (this.Cz == null || this.Cz.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.CA.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.Cz != null) {
            return this.Cz.size();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.a<v, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Cz == null) {
                this.Cz = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.a(this);
                int id = aVar.getType().getId();
                int size = this.Cz.size();
                this.Cz.put(size, aVar);
                this.CA.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<v> list) {
        if (this.CB == null) {
            this.CB = new ArrayList();
        } else {
            this.CB.clear();
        }
        this.CB.addAll(list);
        notifyDataSetChanged();
    }

    public List<v> getData() {
        return this.CB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<v, a> aVar;
        if (this.Cz != null) {
            v item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.Cz.valueAt(itemViewType);
            }
            if (aVar != null && aVar.kd() != null) {
                aVar.kd().a(view, item, aVar.getType(), adapterView, i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<v, a> aVar;
        if (this.Cz == null) {
            return false;
        }
        v item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.Cz.valueAt(itemViewType);
        }
        if (aVar == null || aVar.ke() == null) {
            return false;
        }
        return aVar.ke().b(view, item, aVar.getType(), adapterView, i, j);
    }

    /* loaded from: classes.dex */
    public static class a {
        private View view;

        public a(View view) {
            this.view = null;
            this.view = view;
            if (this.view == null) {
                throw new RuntimeException("view cannt be null");
            }
            this.view.setTag(this);
        }

        public View getView() {
            return this.view;
        }
    }
}
