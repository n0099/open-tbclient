package com.baidu.adp.widget.ListView;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class y extends BaseAdapter {
    private SparseArray<com.baidu.adp.widget.ListView.a<v, a>> zJ;
    private SparseArray<Integer> zK = new SparseArray<>();
    private List<v> zL;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.zL != null) {
            return this.zL.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: as */
    public v getItem(int i) {
        if (this.zL != null) {
            int size = this.zL.size();
            if (i >= 0 && i < size) {
                return this.zL.get(i);
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
        v item;
        if (this.zJ != null && this.zL != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.zJ.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof v)) {
                return aVar.a(i, view, viewGroup, item);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        v item;
        BdUniqueId type;
        Integer num;
        if (this.zJ == null || this.zJ.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.zK.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.zJ != null) {
            return this.zJ.size();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.a<v, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.zJ == null) {
                this.zJ = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.a(this);
                int id = aVar.getType().getId();
                int size = this.zJ.size();
                this.zJ.put(size, aVar);
                this.zK.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<v> list) {
        this.zL = list;
        notifyDataSetChanged();
    }

    public List<v> getData() {
        return this.zL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<v, a> aVar;
        if (this.zJ != null) {
            v item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.zJ.valueAt(itemViewType);
            }
            if (aVar != null && aVar.jg() != null) {
                aVar.jg().a(view, item, aVar.getType(), adapterView, i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<v, a> aVar;
        if (this.zJ == null) {
            return false;
        }
        v item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.zJ.valueAt(itemViewType);
        }
        if (aVar == null || aVar.jh() == null) {
            return false;
        }
        return aVar.jh().b(view, item, aVar.getType(), adapterView, i, j);
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
