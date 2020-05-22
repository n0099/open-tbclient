package com.baidu.ala.widget.multicolumn;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.baidu.adp.widget.ListView.e;
import com.baidu.adp.widget.ListView.p;
/* loaded from: classes3.dex */
public class BdSimplePreLoadListAdapter extends BaseAdapter implements p {
    private DataSetObserver mAdapterDataSetObserver;
    private Context mContext;
    private ListAdapter mAdapter = null;
    private boolean mIsFilterable = false;
    private DataSetObserver mDataSetObserver = null;
    private e.a mListPreLoad = null;

    public BdSimplePreLoadListAdapter(Context context) {
        this.mContext = null;
        this.mAdapterDataSetObserver = null;
        this.mContext = context;
        this.mAdapterDataSetObserver = new DataSetObserver() { // from class: com.baidu.ala.widget.multicolumn.BdSimplePreLoadListAdapter.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (BdSimplePreLoadListAdapter.this.mDataSetObserver != null) {
                    BdSimplePreLoadListAdapter.this.mDataSetObserver.onChanged();
                }
                if (BdSimplePreLoadListAdapter.this.mListPreLoad != null) {
                    BdSimplePreLoadListAdapter.this.mListPreLoad.onPreLoad();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                if (BdSimplePreLoadListAdapter.this.mDataSetObserver != null) {
                    BdSimplePreLoadListAdapter.this.mDataSetObserver.onInvalidated();
                }
            }
        };
    }

    public void setListPreLoad(e.a aVar) {
        this.mListPreLoad = aVar;
    }

    public int getWrappedCount() {
        if (this.mAdapter != null) {
            return this.mAdapter.getCount();
        }
        return 0;
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
        try {
            super.unregisterDataSetObserver(dataSetObserver);
            this.mDataSetObserver = dataSetObserver;
            if (this.mAdapter != null) {
                this.mAdapter.unregisterDataSetObserver(this.mAdapterDataSetObserver);
            }
        } catch (IllegalStateException e) {
        }
    }

    public Filter getFilter() {
        if (!this.mIsFilterable || this.mAdapter == null) {
            return null;
        }
        return ((Filterable) this.mAdapter).getFilter();
    }

    public ListAdapter getWrappedAdapter() {
        return this.mAdapter;
    }

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.p
    public int getCount() {
        if (this.mAdapter != null) {
            return this.mAdapter.getCount();
        }
        return 0;
    }

    @Override // android.widget.Adapter, com.baidu.adp.widget.ListView.p
    public Object getItem(int i) {
        if (this.mAdapter != null) {
            return this.mAdapter.getItem(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.mAdapter != null) {
            return this.mAdapter.getItemId(i);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.mAdapter != null) {
            return this.mAdapter.getView(i, view, viewGroup);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.mAdapter != null ? this.mAdapter.hasStableIds() : super.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, com.baidu.adp.widget.ListView.p
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (this.mAdapter instanceof BaseAdapter) {
            ((BaseAdapter) this.mAdapter).notifyDataSetChanged();
        } else if (this.mAdapter instanceof WrapperListAdapter) {
            ListAdapter wrappedAdapter = ((WrapperListAdapter) this.mAdapter).getWrappedAdapter();
            if (wrappedAdapter instanceof BaseAdapter) {
                ((BaseAdapter) wrappedAdapter).notifyDataSetChanged();
            }
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        if (this.mAdapter instanceof BaseAdapter) {
            ((BaseAdapter) this.mAdapter).notifyDataSetInvalidated();
        } else if (this.mAdapter instanceof WrapperListAdapter) {
            ListAdapter wrappedAdapter = ((WrapperListAdapter) this.mAdapter).getWrappedAdapter();
            if (wrappedAdapter instanceof BaseAdapter) {
                ((BaseAdapter) wrappedAdapter).notifyDataSetInvalidated();
            }
        }
    }
}
