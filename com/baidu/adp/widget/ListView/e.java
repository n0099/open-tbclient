package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private Context mContext;
    private ArrayList<b> zj;
    private ArrayList<b> zk;
    private boolean zl;
    private DataSetObserver zn;
    private ListAdapter mAdapter = null;
    private boolean zm = false;
    private DataSetObserver mDataSetObserver = null;
    private a zo = null;

    /* loaded from: classes.dex */
    public interface a {
        void jx();
    }

    public e(Context context) {
        boolean z = false;
        this.mContext = null;
        this.zj = null;
        this.zk = null;
        this.zl = false;
        this.zn = null;
        this.mContext = context;
        this.zj = new ArrayList<>();
        this.zk = new ArrayList<>();
        if (e(this.zj) && e(this.zk)) {
            z = true;
        }
        this.zl = z;
        this.zn = new f(this);
    }

    public void a(a aVar) {
        this.zo = aVar;
    }

    public int jv() {
        if (this.mAdapter != null) {
            return this.mAdapter.getCount();
        }
        return 0;
    }

    public ListAdapter getWrappedAdapter() {
        return this.mAdapter;
    }

    public void a(ListAdapter listAdapter) {
        if (this.mAdapter != null) {
            this.zm = false;
        }
        this.mAdapter = listAdapter;
        if (this.mAdapter != null) {
            this.zm = this.mAdapter instanceof Filterable;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.mDataSetObserver = dataSetObserver;
        if (this.mAdapter != null) {
            this.mAdapter.registerDataSetObserver(this.zn);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.mDataSetObserver = dataSetObserver;
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.zn);
        }
    }

    public int getHeadersCount() {
        return this.zj.size();
    }

    public int getFootersCount() {
        return this.zk.size();
    }

    private boolean e(ArrayList<b> arrayList) {
        if (arrayList != null) {
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().isSelectable) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean removeHeader(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.zj.size(); i++) {
            if (this.zj.get(i).view == view) {
                this.zj.remove(i);
                if (e(this.zj) && e(this.zk)) {
                    z = true;
                }
                this.zl = z;
                notifyDataSetChanged();
                return true;
            }
        }
        return false;
    }

    public boolean removeFooter(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.zk.size(); i++) {
            if (this.zk.get(i).view == view) {
                this.zk.remove(i);
                if (e(this.zj) && e(this.zk)) {
                    z = true;
                }
                this.zl = z;
                notifyDataSetChanged();
                return true;
            }
        }
        return false;
    }

    public void f(View view, int i) {
        a(view, null, true, i);
    }

    public void a(View view, Object obj, boolean z, int i) {
        if (view != null) {
            b bVar = new b();
            bVar.view = view;
            bVar.data = obj;
            bVar.isSelectable = z;
            if (i < 0 || i > this.zj.size()) {
                this.zj.add(bVar);
            } else {
                this.zj.add(i, bVar);
            }
            notifyDataSetChanged();
        }
    }

    public int getHeaderViewsCount() {
        return this.zj.size();
    }

    public int getFooterViewsCount() {
        return this.zk.size();
    }

    public void addFooterView(View view) {
        b(view, null, true, -1);
    }

    public void b(View view, Object obj, boolean z, int i) {
        if (view != null) {
            b bVar = new b();
            bVar.view = view;
            bVar.data = obj;
            bVar.isSelectable = z;
            if (i < 0 || i > this.zk.size()) {
                this.zk.add(bVar);
            } else {
                this.zk.add(i, bVar);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mAdapter != null ? getFootersCount() + getHeadersCount() + this.mAdapter.getCount() : getFootersCount() + getHeadersCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.zj.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.mAdapter != null && i2 < (i3 = this.mAdapter.getCount())) {
            return this.mAdapter.getItem(i2);
        }
        int i4 = i2 - i3;
        if (i4 >= 0 && i4 < this.zk.size()) {
            return this.zk.get(i4).data;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        int headersCount = getHeadersCount();
        if (this.mAdapter == null || i < headersCount || (i2 = i - headersCount) >= this.mAdapter.getCount()) {
            return Long.MIN_VALUE;
        }
        return this.mAdapter.getItemId(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.mAdapter != null ? this.mAdapter.hasStableIds() : super.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        if (this.mAdapter != null) {
            return this.zl && this.mAdapter.areAllItemsEnabled();
        }
        return super.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int i2;
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.zj.get(i).isSelectable;
        }
        int i3 = i - headersCount;
        if (this.mAdapter != null) {
            i2 = this.mAdapter.getCount();
            if (i3 < i2) {
                return this.mAdapter.isEnabled(i3);
            }
        } else {
            i2 = 0;
        }
        int i4 = i3 - i2;
        if (i4 < 0 || i4 >= this.zk.size()) {
            return false;
        }
        return this.zk.get(i4).isSelectable;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        int headersCount = getHeadersCount();
        if (this.mAdapter == null || i < headersCount || (i2 = i - headersCount) >= this.mAdapter.getCount()) {
            return -2;
        }
        return this.mAdapter.getItemViewType(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.mAdapter != null) {
            return this.mAdapter.getViewTypeCount() + 1;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.mAdapter == null || this.mAdapter.isEmpty();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            View view4 = this.zj.get(i).view;
            if (view4 == null) {
                return jw();
            }
            return view4;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.mAdapter != null && i2 < (i3 = this.mAdapter.getCount())) {
            try {
                view3 = this.mAdapter.getView(i2, view, viewGroup);
            } catch (Exception e) {
                if (e == null || e.getMessage() == null) {
                    view3 = null;
                } else {
                    BdLog.detailException(e);
                    Log.e("BdListAdapter", e.getMessage());
                    view3 = null;
                }
            } catch (OutOfMemoryError e2) {
                BdBaseApplication.getInst().onAppMemoryLow();
                view3 = this.mAdapter.getView(i2, view, viewGroup);
            }
            if (view3 == null) {
                return jw();
            }
            return view3;
        }
        try {
            view2 = this.zk.get(i2 - i3).view;
        } catch (Exception e3) {
            BdLog.detailException(e3);
            view2 = null;
        }
        if (view2 == null) {
            return jw();
        }
        return view2;
    }

    private View jw() {
        TextView textView = new TextView(this.mContext);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int dip2px = com.baidu.adp.lib.util.k.dip2px(this.mContext, 15.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        return textView;
    }

    /* loaded from: classes.dex */
    public class b {
        public Object data;
        public boolean isSelectable;
        public View view;

        public b() {
        }
    }
}
