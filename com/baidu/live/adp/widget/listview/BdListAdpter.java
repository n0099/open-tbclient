package com.baidu.live.adp.widget.listview;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.R;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class BdListAdpter extends BaseAdapter implements IListAdapter {
    private DataSetObserver mAdapterDataSetObserver;
    private boolean mAreAllFixedViewsSelectable;
    private Context mContext;
    private ArrayList<FixedViewInfo> mFooterViewInfos;
    private ArrayList<FixedViewInfo> mHeaderViewInfos;
    private ListAdapter mAdapter = null;
    private boolean mIsFilterable = false;
    private DataSetObserver mDataSetObserver = null;
    private BdListPreLoad mListPreLoad = null;

    /* loaded from: classes3.dex */
    public interface BdListPreLoad {
        void onPreLoad();
    }

    public BdListAdpter(Context context) {
        boolean z = false;
        this.mContext = null;
        this.mHeaderViewInfos = null;
        this.mFooterViewInfos = null;
        this.mAreAllFixedViewsSelectable = false;
        this.mAdapterDataSetObserver = null;
        this.mContext = context;
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
            z = true;
        }
        this.mAreAllFixedViewsSelectable = z;
        this.mAdapterDataSetObserver = new DataSetObserver() { // from class: com.baidu.live.adp.widget.listview.BdListAdpter.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (BdListAdpter.this.mDataSetObserver != null) {
                    BdListAdpter.this.mDataSetObserver.onChanged();
                }
                if (BdListAdpter.this.mListPreLoad != null) {
                    BdListAdpter.this.mListPreLoad.onPreLoad();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                if (BdListAdpter.this.mDataSetObserver != null) {
                    BdListAdpter.this.mDataSetObserver.onInvalidated();
                }
            }
        };
    }

    public void setListPreLoad(BdListPreLoad bdListPreLoad) {
        this.mListPreLoad = bdListPreLoad;
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

    @Override // android.widget.BaseAdapter, com.baidu.live.adp.widget.listview.IListAdapter
    public void notifyDataSetChanged() {
        if (BdUtilHelper.isMainThread()) {
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

    private boolean areAllListInfosSelectable(ArrayList<FixedViewInfo> arrayList) {
        if (arrayList != null) {
            Iterator<FixedViewInfo> it = arrayList.iterator();
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
                if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                    z = true;
                }
                this.mAreAllFixedViewsSelectable = z;
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
                if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                    z = true;
                }
                this.mAreAllFixedViewsSelectable = z;
                notifyDataSetChanged();
                return true;
            }
        }
        return false;
    }

    public Filter getFilter() {
        if (!this.mIsFilterable || this.mAdapter == null) {
            return null;
        }
        return ((Filterable) this.mAdapter).getFilter();
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true, -1);
    }

    public void addHeaderView(View view, int i) {
        addHeaderView(view, null, true, i);
    }

    public void addHeaderView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            FixedViewInfo fixedViewInfo = new FixedViewInfo();
            fixedViewInfo.view = view;
            fixedViewInfo.data = obj;
            fixedViewInfo.isSelectable = z;
            if (i < 0 || i > this.mHeaderViewInfos.size()) {
                this.mHeaderViewInfos.add(fixedViewInfo);
            } else {
                this.mHeaderViewInfos.add(i, fixedViewInfo);
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

    public void addFooterView(View view, int i) {
        addFooterView(view, null, true, i);
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            FixedViewInfo fixedViewInfo = new FixedViewInfo();
            fixedViewInfo.view = view;
            fixedViewInfo.data = obj;
            fixedViewInfo.isSelectable = z;
            if (i < 0 || i > this.mFooterViewInfos.size()) {
                this.mFooterViewInfos.add(fixedViewInfo);
            } else {
                this.mFooterViewInfos.add(i, fixedViewInfo);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter, com.baidu.live.adp.widget.listview.IListAdapter
    public int getCount() {
        return this.mAdapter != null ? getFootersCount() + getHeadersCount() + this.mAdapter.getCount() : getFootersCount() + getHeadersCount();
    }

    @Override // android.widget.Adapter, com.baidu.live.adp.widget.listview.IListAdapter
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

    @Override // android.widget.Adapter, com.baidu.live.adp.widget.listview.IListAdapter
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
            return this.mAreAllFixedViewsSelectable && this.mAdapter.areAllItemsEnabled();
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
                return createErrorView();
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
                return createErrorView();
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
            return createErrorView();
        }
        return view2;
    }

    private View createErrorView() {
        TextView textView = new TextView(this.mContext);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.sdk_load_res_failed));
        int dip2px = BdUtilHelper.dip2px(this.mContext, 15.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        return textView;
    }

    /* loaded from: classes3.dex */
    public class FixedViewInfo {
        public Object data;
        public boolean isSelectable;
        public View view;

        public FixedViewInfo() {
        }
    }
}
