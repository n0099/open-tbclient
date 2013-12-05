package com.baidu.adp.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
public abstract class u implements ListAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final DataSetObservable f618a = new DataSetObservable();

    public abstract void a(View view, AdapterView adapterView, int i);

    public abstract int b();

    public abstract View c();

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f618a.registerObserver(dataSetObserver);
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f618a.unregisterObserver(dataSetObserver);
    }

    public void a() {
        this.f618a.notifyChanged();
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
