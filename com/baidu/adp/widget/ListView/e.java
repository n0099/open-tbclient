package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private Context a;
    private ArrayList c;
    private ArrayList d;
    private boolean e;
    private DataSetObserver h;
    private ListAdapter b = null;
    private boolean f = false;
    private DataSetObserver g = null;

    public e(Context context) {
        boolean z = false;
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.h = null;
        this.a = context;
        this.c = new ArrayList();
        this.d = new ArrayList();
        if (a(this.c) && a(this.d)) {
            z = true;
        }
        this.e = z;
        this.h = new f(this);
    }

    public int a() {
        if (this.b != null) {
            return this.b.getCount();
        }
        return 0;
    }

    public ListAdapter b() {
        return this.b;
    }

    public void a(ListAdapter listAdapter) {
        if (this.b != null) {
            this.f = false;
        }
        this.b = listAdapter;
        if (this.b != null) {
            this.f = this.b instanceof Filterable;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.g = dataSetObserver;
        if (this.b != null) {
            this.b.registerDataSetObserver(this.h);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.g = dataSetObserver;
        if (this.b != null) {
            this.b.unregisterDataSetObserver(this.h);
        }
    }

    public int c() {
        return this.c.size();
    }

    public int d() {
        return this.d.size();
    }

    private boolean a(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((g) it.next()).c) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean a(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.c.size(); i++) {
            if (((g) this.c.get(i)).a == view) {
                this.c.remove(i);
                if (a(this.c) && a(this.d)) {
                    z = true;
                }
                this.e = z;
                notifyDataSetChanged();
                return true;
            }
        }
        return false;
    }

    public boolean b(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (((g) this.d.get(i)).a == view) {
                this.d.remove(i);
                if (a(this.c) && a(this.d)) {
                    z = true;
                }
                this.e = z;
                notifyDataSetChanged();
                return true;
            }
        }
        return false;
    }

    public void a(View view, int i) {
        a(view, null, true, i);
    }

    public void a(View view, Object obj, boolean z, int i) {
        if (view != null) {
            g gVar = new g(this);
            gVar.a = view;
            gVar.b = obj;
            gVar.c = z;
            if (i < 0 || i > this.c.size()) {
                this.c.add(gVar);
            } else {
                this.c.add(i, gVar);
            }
            notifyDataSetChanged();
        }
    }

    public void c(View view) {
        b(view, null, true, -1);
    }

    public void b(View view, Object obj, boolean z, int i) {
        if (view != null) {
            g gVar = new g(this);
            gVar.a = view;
            gVar.b = obj;
            gVar.c = z;
            if (i < 0 || i > this.d.size()) {
                this.d.add(gVar);
            } else {
                this.d.add(i, gVar);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b != null ? d() + c() + this.b.getCount() : d() + c();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int c = c();
        if (i < c) {
            return ((g) this.c.get(i)).b;
        }
        int i2 = i - c;
        int i3 = 0;
        if (this.b != null && i2 < (i3 = this.b.getCount())) {
            return this.b.getItem(i2);
        }
        int i4 = i2 - i3;
        if (i4 >= 0 && i4 < this.d.size()) {
            return ((g) this.d.get(i4)).b;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        int c = c();
        if (this.b == null || i < c || (i2 = i - c) >= this.b.getCount()) {
            return Long.MIN_VALUE;
        }
        return this.b.getItemId(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.b != null ? this.b.hasStableIds() : super.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        if (this.b != null) {
            return this.e && this.b.areAllItemsEnabled();
        }
        return super.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int i2;
        int c = c();
        if (i < c) {
            return ((g) this.c.get(i)).c;
        }
        int i3 = i - c;
        if (this.b != null) {
            i2 = this.b.getCount();
            if (i3 < i2) {
                return this.b.isEnabled(i3);
            }
        } else {
            i2 = 0;
        }
        int i4 = i3 - i2;
        if (i4 < 0 || i4 >= this.d.size()) {
            return false;
        }
        return ((g) this.d.get(i4)).c;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        int c = c();
        if (this.b == null || i < c || (i2 = i - c) >= this.b.getCount()) {
            return -2;
        }
        return this.b.getItemViewType(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.b != null) {
            return this.b.getViewTypeCount() + 1;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.b == null || this.b.isEmpty();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        int c = c();
        if (i < c) {
            View view4 = ((g) this.c.get(i)).a;
            if (view4 == null) {
                return e();
            }
            return view4;
        }
        int i2 = i - c;
        int i3 = 0;
        if (this.b != null && i2 < (i3 = this.b.getCount())) {
            try {
                view3 = this.b.getView(i2, view, viewGroup);
            } catch (Exception e) {
                com.baidu.adp.lib.e.b.a(e.getMessage());
                view3 = null;
            }
            if (view3 == null) {
                return e();
            }
            return view3;
        }
        try {
            view2 = ((g) this.d.get(i2 - i3)).a;
        } catch (Exception e2) {
            com.baidu.adp.lib.e.b.a(e2.getMessage());
            view2 = null;
        }
        if (view2 == null) {
            return e();
        }
        return view2;
    }

    private View e() {
        TextView textView = new TextView(this.a);
        textView.setText("资源加载失败！");
        int a = com.baidu.adp.lib.e.c.a(this.a, 15.0f);
        textView.setPadding(a, a, a, a);
        return textView;
    }
}
