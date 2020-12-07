package com.baidu.swan.menu.viewpager;

import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes14.dex */
public abstract class PagerAdapterImpl extends PagerAdapter {
    private c<View> emm = new c<>(5);
    private SparseArray<View> dii = new SparseArray<>();

    /* loaded from: classes14.dex */
    public interface a {
        void recycle();
    }

    protected abstract View f(ViewGroup viewGroup, int i);

    protected abstract void h(View view, int i);

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        if (view instanceof a) {
            ((a) view).recycle();
        }
        viewGroup.removeView(view);
        this.emm.recycle(view);
        this.dii.remove(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.emm.get();
        if (view == null) {
            view = f(viewGroup, i);
        }
        this.dii.put(i, view);
        viewGroup.addView(view);
        h(view, i);
        return view;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
