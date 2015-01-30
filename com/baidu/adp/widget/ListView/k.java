package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.database.DataSetObserver;
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
public class k extends BaseAdapter {
    private Context mContext;
    private ArrayList<n> wG;
    private ArrayList<n> wH;
    private boolean wI;
    private DataSetObserver wK;
    private ListAdapter mAdapter = null;
    private boolean wJ = false;
    private DataSetObserver mDataSetObserver = null;
    private m wL = null;

    public k(Context context) {
        boolean z = false;
        this.mContext = null;
        this.wG = null;
        this.wH = null;
        this.wI = false;
        this.wK = null;
        this.mContext = context;
        this.wG = new ArrayList<>();
        this.wH = new ArrayList<>();
        if (j(this.wG) && j(this.wH)) {
            z = true;
        }
        this.wI = z;
        this.wK = new l(this);
    }

    public void a(m mVar) {
        this.wL = mVar;
    }

    public int jE() {
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
            this.wJ = false;
        }
        this.mAdapter = listAdapter;
        if (this.mAdapter != null) {
            this.wJ = this.mAdapter instanceof Filterable;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.mDataSetObserver = dataSetObserver;
        if (this.mAdapter != null) {
            this.mAdapter.registerDataSetObserver(this.wK);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.mDataSetObserver = dataSetObserver;
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.wK);
        }
    }

    public int getHeadersCount() {
        return this.wG.size();
    }

    public int getFootersCount() {
        return this.wH.size();
    }

    private boolean j(ArrayList<n> arrayList) {
        if (arrayList != null) {
            Iterator<n> it = arrayList.iterator();
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
        for (int i = 0; i < this.wG.size(); i++) {
            if (this.wG.get(i).view == view) {
                this.wG.remove(i);
                if (j(this.wG) && j(this.wH)) {
                    z = true;
                }
                this.wI = z;
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
        for (int i = 0; i < this.wH.size(); i++) {
            if (this.wH.get(i).view == view) {
                this.wH.remove(i);
                if (j(this.wG) && j(this.wH)) {
                    z = true;
                }
                this.wI = z;
                notifyDataSetChanged();
                return true;
            }
        }
        return false;
    }

    public void d(View view, int i) {
        a(view, null, true, i);
    }

    public void a(View view, Object obj, boolean z, int i) {
        if (view != null) {
            n nVar = new n(this);
            nVar.view = view;
            nVar.data = obj;
            nVar.isSelectable = z;
            if (i < 0 || i > this.wG.size()) {
                this.wG.add(nVar);
            } else {
                this.wG.add(i, nVar);
            }
            notifyDataSetChanged();
        }
    }

    public int getHeaderViewsCount() {
        return this.wG.size();
    }

    public int getFooterViewsCount() {
        return this.wH.size();
    }

    public void addFooterView(View view) {
        b(view, null, true, -1);
    }

    public void b(View view, Object obj, boolean z, int i) {
        if (view != null) {
            n nVar = new n(this);
            nVar.view = view;
            nVar.data = obj;
            nVar.isSelectable = z;
            if (i < 0 || i > this.wH.size()) {
                this.wH.add(nVar);
            } else {
                this.wH.add(i, nVar);
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
            return this.wG.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.mAdapter != null && i2 < (i3 = this.mAdapter.getCount())) {
            return this.mAdapter.getItem(i2);
        }
        int i4 = i2 - i3;
        if (i4 >= 0 && i4 < this.wH.size()) {
            return this.wH.get(i4).data;
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
            return this.wI && this.mAdapter.areAllItemsEnabled();
        }
        return super.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int i2;
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.wG.get(i).isSelectable;
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
        if (i4 < 0 || i4 >= this.wH.size()) {
            return false;
        }
        return this.wH.get(i4).isSelectable;
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
            View view4 = this.wG.get(i).view;
            if (view4 == null) {
                return jF();
            }
            return view4;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.mAdapter != null && i2 < (i3 = this.mAdapter.getCount())) {
            try {
                view3 = this.mAdapter.getView(i2, view, viewGroup);
            } catch (Exception e) {
                BdLog.detailException(e);
                view3 = null;
            } catch (OutOfMemoryError e2) {
                BdBaseApplication.getInst().onAppMemoryLow();
                view3 = this.mAdapter.getView(i2, view, viewGroup);
            }
            if (view3 == null) {
                return jF();
            }
            return view3;
        }
        try {
            view2 = this.wH.get(i2 - i3).view;
        } catch (Exception e3) {
            BdLog.detailException(e3);
            view2 = null;
        }
        if (view2 == null) {
            return jF();
        }
        return view2;
    }

    private View jF() {
        TextView textView = new TextView(this.mContext);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int dip2px = com.baidu.adp.lib.util.l.dip2px(this.mContext, 15.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        return textView;
    }
}
