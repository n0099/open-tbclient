package com.baidu.adp.widget.ListView;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class z extends BaseAdapter {
    private SparseArray<com.baidu.adp.widget.ListView.a<v, a>> Io;
    private SparseArray<Integer> Ip = new SparseArray<>();
    private List<v> Iq = new ArrayList();

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Iq != null) {
            return this.Iq.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public v getItem(int i) {
        if (this.Iq != null) {
            int size = this.Iq.size();
            if (i >= 0 && i < size) {
                return this.Iq.get(i);
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
        if (this.Io != null && this.Iq != null) {
            int count = getCount();
            if (i >= 0 && i < count && (aVar = this.Io.get(getItemViewType(i))) != null) {
                v item = getItem(i);
                if (item != null && (item instanceof v)) {
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
        v item;
        BdUniqueId type;
        Integer num;
        if (this.Io == null || this.Io.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.Ip.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.Io != null) {
            return this.Io.size();
        }
        return 0;
    }

    public void addAdapter(com.baidu.adp.widget.ListView.a<v, a> aVar) {
        if (aVar != null && aVar.getType() != null) {
            if (this.Io == null) {
                this.Io = new SparseArray<>();
            }
            if (aVar.getType() != null) {
                aVar.setAdapter(this);
                int id = aVar.getType().getId();
                int size = this.Io.size();
                this.Io.put(size, aVar);
                this.Ip.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends v> list) {
        if (this.Iq == null) {
            this.Iq = new ArrayList();
        } else {
            this.Iq.clear();
        }
        this.Iq.addAll(list);
        notifyDataSetChanged();
    }

    public List<v> getData() {
        return this.Iq;
    }

    public void a(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<v, a> aVar;
        if (this.Io != null) {
            v item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                aVar = null;
            } else {
                aVar = this.Io.valueAt(itemViewType);
            }
            if (aVar != null && aVar.getOnAdapterItemClickListener() != null) {
                aVar.getOnAdapterItemClickListener().a(view, item, aVar.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean b(ViewGroup viewGroup, View view, int i, long j) {
        com.baidu.adp.widget.ListView.a<v, a> aVar;
        if (this.Io == null) {
            return false;
        }
        v item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            aVar = null;
        } else {
            aVar = this.Io.valueAt(itemViewType);
        }
        if (aVar == null || aVar.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return aVar.getOnAdapterItemLongClickListener().b(view, item, aVar.getType(), viewGroup, i, j);
    }

    public int s(int i, int i2) {
        int i3;
        if (this.Iq == null || this.Iq.size() == 0) {
            return -1;
        }
        int size = this.Iq.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.Iq.get(i4) == null) {
                i3 = i5;
            } else if (this.Iq.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.Iq.get(i4).getType().getId() ? i5 + 1 : i5;
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
