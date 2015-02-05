package com.baidu.adp.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
public abstract class q implements ListAdapter {
    private final DataSetObservable xS = new DataSetObservable();

    public abstract void a(View view, AdapterView<?> adapterView, int i);

    public abstract int jL();

    public abstract View jM();

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.xS.registerObserver(dataSetObserver);
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.xS.unregisterObserver(dataSetObserver);
    }

    public void notifyDataSetChanged() {
        this.xS.notifyChanged();
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
