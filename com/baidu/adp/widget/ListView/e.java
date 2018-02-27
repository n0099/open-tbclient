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
public class e extends BaseAdapter implements j {
    private boolean auV;
    private DataSetObserver mAdapterDataSetObserver;
    private Context mContext;
    private ArrayList<b> mFooterViewInfos;
    private ArrayList<b> mHeaderViewInfos;
    private ListAdapter mAdapter = null;
    private boolean mIsFilterable = false;
    private DataSetObserver mDataSetObserver = null;
    private a mListPreLoad = null;

    /* loaded from: classes.dex */
    public interface a {
        void onPreLoad();
    }

    public e(Context context) {
        boolean z = false;
        this.mContext = null;
        this.mHeaderViewInfos = null;
        this.mFooterViewInfos = null;
        this.auV = false;
        this.mAdapterDataSetObserver = null;
        this.mContext = context;
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        if (f(this.mHeaderViewInfos) && f(this.mFooterViewInfos)) {
            z = true;
        }
        this.auV = z;
        this.mAdapterDataSetObserver = new DataSetObserver() { // from class: com.baidu.adp.widget.ListView.e.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (e.this.mDataSetObserver != null) {
                    e.this.mDataSetObserver.onChanged();
                }
                if (e.this.mListPreLoad != null) {
                    e.this.mListPreLoad.onPreLoad();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                if (e.this.mDataSetObserver != null) {
                    e.this.mDataSetObserver.onInvalidated();
                }
            }
        };
    }

    public void setListPreLoad(a aVar) {
        this.mListPreLoad = aVar;
    }

    public int getWrappedCount() {
        if (this.mAdapter != null) {
            return this.mAdapter.getCount();
        }
        return 0;
    }

    public ListAdapter getWrappedAdapter() {
        return this.mAdapter;
    }

    public void setAdaper(ListAdapter listAdapter) {
        if (this.mAdapter != null) {
            this.mIsFilterable = false;
        }
        this.mAdapter = listAdapter;
        if (this.mAdapter != null) {
            this.mIsFilterable = this.mAdapter instanceof Filterable;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, com.baidu.adp.widget.ListView.j
    public void notifyDataSetChanged() {
        if (com.baidu.adp.lib.util.l.oZ()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.mDataSetObserver = dataSetObserver;
        if (this.mAdapter != null) {
            this.mAdapter.registerDataSetObserver(this.mAdapterDataSetObserver);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.mDataSetObserver = dataSetObserver;
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mAdapterDataSetObserver);
        }
    }

    public int getHeadersCount() {
        return this.mHeaderViewInfos.size();
    }

    public int getFootersCount() {
        return this.mFooterViewInfos.size();
    }

    private boolean f(ArrayList<b> arrayList) {
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
        for (int i = 0; i < this.mHeaderViewInfos.size(); i++) {
            if (this.mHeaderViewInfos.get(i).view == view) {
                this.mHeaderViewInfos.remove(i);
                if (f(this.mHeaderViewInfos) && f(this.mFooterViewInfos)) {
                    z = true;
                }
                this.auV = z;
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
        for (int i = 0; i < this.mFooterViewInfos.size(); i++) {
            if (this.mFooterViewInfos.get(i).view == view) {
                this.mFooterViewInfos.remove(i);
                if (f(this.mHeaderViewInfos) && f(this.mFooterViewInfos)) {
                    z = true;
                }
                this.auV = z;
                notifyDataSetChanged();
                return true;
            }
        }
        return false;
    }

    public void addHeaderView(View view, int i) {
        addHeaderView(view, null, true, i);
    }

    public void addHeaderView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            b bVar = new b();
            bVar.view = view;
            bVar.data = obj;
            bVar.isSelectable = z;
            if (i < 0 || i > this.mHeaderViewInfos.size()) {
                this.mHeaderViewInfos.add(bVar);
            } else {
                this.mHeaderViewInfos.add(i, bVar);
            }
            notifyDataSetChanged();
        }
    }

    public int getHeaderViewsCount() {
        return this.mHeaderViewInfos.size();
    }

    public int getFooterViewsCount() {
        return this.mFooterViewInfos.size();
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true, -1);
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            b bVar = new b();
            bVar.view = view;
            bVar.data = obj;
            bVar.isSelectable = z;
            if (i < 0 || i > this.mFooterViewInfos.size()) {
                this.mFooterViewInfos.add(bVar);
            } else {
                this.mFooterViewInfos.add(i, bVar);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.j
    public int getCount() {
        return this.mAdapter != null ? getFootersCount() + getHeadersCount() + this.mAdapter.getCount() : getFootersCount() + getHeadersCount();
    }

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.j
    public Object getItem(int i) {
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.mAdapter != null && i2 < (i3 = this.mAdapter.getCount())) {
            return this.mAdapter.getItem(i2);
        }
        int i4 = i2 - i3;
        if (i4 >= 0 && i4 < this.mFooterViewInfos.size()) {
            return this.mFooterViewInfos.get(i4).data;
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
            return this.auV && this.mAdapter.areAllItemsEnabled();
        }
        return super.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int i2;
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.mHeaderViewInfos.get(i).isSelectable;
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
        if (i4 < 0 || i4 >= this.mFooterViewInfos.size()) {
            return false;
        }
        return this.mFooterViewInfos.get(i4).isSelectable;
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
            View view4 = this.mHeaderViewInfos.get(i).view;
            if (view4 == null) {
                return sB();
            }
            return view4;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.mAdapter != null && i2 < (i3 = this.mAdapter.getCount())) {
            try {
                view3 = this.mAdapter.getView(i2, view, viewGroup);
            } catch (Exception e) {
                if (e != null && e.getMessage() != null) {
                    BdLog.detailException(e);
                    Log.e("BdListAdapter", e.getMessage());
                    e.printStackTrace();
                }
                view3 = null;
            } catch (OutOfMemoryError e2) {
                BdBaseApplication.getInst().onAppMemoryLow();
                view3 = this.mAdapter.getView(i2, view, viewGroup);
            }
            if (view3 == null) {
                return sB();
            }
            return view3;
        }
        try {
            view2 = this.mFooterViewInfos.get(i2 - i3).view;
        } catch (Exception e3) {
            BdLog.detailException(e3);
            view2 = null;
        }
        if (view2 == null) {
            return sB();
        }
        return view2;
    }

    private View sB() {
        TextView textView = new TextView(this.mContext);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int dip2px = com.baidu.adp.lib.util.l.dip2px(this.mContext, 15.0f);
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
