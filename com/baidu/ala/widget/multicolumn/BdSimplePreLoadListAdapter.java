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
import d.b.b.j.e.e;
import d.b.b.j.e.o;
/* loaded from: classes2.dex */
public class BdSimplePreLoadListAdapter extends BaseAdapter implements o {
    public DataSetObserver mAdapterDataSetObserver;
    public Context mContext;
    public ListAdapter mAdapter = null;
    public boolean mIsFilterable = false;
    public DataSetObserver mDataSetObserver = null;
    public e.b mListPreLoad = null;

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

    @Override // android.widget.Adapter, d.b.b.j.e.o
    public int getCount() {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return listAdapter.getCount();
        }
        return 0;
    }

    public Filter getFilter() {
        ListAdapter listAdapter;
        if (!this.mIsFilterable || (listAdapter = this.mAdapter) == null) {
            return null;
        }
        return ((Filterable) listAdapter).getFilter();
    }

    @Override // android.widget.Adapter, d.b.b.j.e.o
    public Object getItem(int i) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return listAdapter.getItem(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return listAdapter.getItemId(i);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return listAdapter.getView(i, view, viewGroup);
        }
        return null;
    }

    public ListAdapter getWrappedAdapter() {
        return this.mAdapter;
    }

    public int getWrappedCount() {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return listAdapter.getCount();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return super.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, d.b.b.j.e.o
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter instanceof BaseAdapter) {
            ((BaseAdapter) listAdapter).notifyDataSetChanged();
        } else if (listAdapter instanceof WrapperListAdapter) {
            ListAdapter wrappedAdapter = ((WrapperListAdapter) listAdapter).getWrappedAdapter();
            if (wrappedAdapter instanceof BaseAdapter) {
                ((BaseAdapter) wrappedAdapter).notifyDataSetChanged();
            }
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter instanceof BaseAdapter) {
            ((BaseAdapter) listAdapter).notifyDataSetInvalidated();
        } else if (listAdapter instanceof WrapperListAdapter) {
            ListAdapter wrappedAdapter = ((WrapperListAdapter) listAdapter).getWrappedAdapter();
            if (wrappedAdapter instanceof BaseAdapter) {
                ((BaseAdapter) wrappedAdapter).notifyDataSetInvalidated();
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.mDataSetObserver = dataSetObserver;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mAdapterDataSetObserver);
        }
    }

    public void setAdaper(ListAdapter listAdapter) {
        if (this.mAdapter != null) {
            this.mIsFilterable = false;
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            this.mIsFilterable = listAdapter instanceof Filterable;
        }
        notifyDataSetChanged();
    }

    public void setListPreLoad(e.b bVar) {
        this.mListPreLoad = bVar;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        try {
            super.unregisterDataSetObserver(dataSetObserver);
            this.mDataSetObserver = dataSetObserver;
            if (this.mAdapter != null) {
                this.mAdapter.unregisterDataSetObserver(this.mAdapterDataSetObserver);
            }
        } catch (IllegalStateException unused) {
        }
    }
}
