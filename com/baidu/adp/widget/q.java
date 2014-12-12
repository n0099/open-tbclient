package com.baidu.adp.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
public abstract class q implements ListAdapter {
    private final DataSetObservable xV = new DataSetObservable();

    public abstract void a(View view, AdapterView<?> adapterView, int i);

    public abstract int jS();

    public abstract View jT();

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.xV.registerObserver(dataSetObserver);
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.xV.unregisterObserver(dataSetObserver);
    }

    public void notifyDataSetChanged() {
        this.xV.notifyChanged();
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return true;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        return getCount() == 0;
    }
}
