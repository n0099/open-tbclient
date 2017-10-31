package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private SparseArray<com.baidu.adp.widget.ListView.a<f, a>> Hu;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> Hv = new SparseArray<>();
    private List<f> Hw = new ArrayList();

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Hw != null) {
            return this.Hw.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public f getItem(int i) {
        if (this.Hw != null) {
            int size = this.Hw.size();
            if (i >= 0 && i < size) {
                return this.Hw.get(i);
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
        com.baidu.adp.widget.ListView.a<f, a> aVar;
        View view2 = null;
        if (this.Hu != null && this.Hw != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.Hu.get(getItemViewType(i))) != null) {
                f item = getItem(i);
                if (item != null && (item instanceof f)) {
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
        f item;
        BdUniqueId type;
        Integer num;
        if (this.Hu == null || this.Hu.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.Hv.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.Hu != null) {
            return this.Hu.size();
        }
        return 0;
    }

    public void addAdapter(com.baidu.adp.widget.ListView.a<f, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Hu == null) {
                this.Hu = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.Hu.size();
                this.Hu.put(size, aVar);
                this.Hv.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends f> list) {
        if (this.Hw == null) {
            this.Hw = new ArrayList();
        } else {
            this.Hw.clear();
        }
        this.Hw.addAll(list);
        notifyDataSetChanged();
    }

    public List<f> getData() {
        return this.Hw;
    }

    public void a(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<f, a> aVar;
        if (this.Hu != null) {
            f item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.Hu.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<f, a> aVar;
        if (this.Hu == null) {
            return false;
        }
        f item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.Hu.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    public int s(int i, int i2) {
        int i3;
        if (this.Hw == null || this.Hw.size() == 0) {
            return -1;
        }
        int size = this.Hw.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.Hw.get(i4) == null) {
                i3 = i5;
            } else if (this.Hw.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.Hw.get(i4).getType().getId() ? i5 + 1 : i5;
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
