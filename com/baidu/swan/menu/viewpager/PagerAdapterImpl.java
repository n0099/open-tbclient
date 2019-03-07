package com.baidu.swan.menu.viewpager;

import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public abstract class PagerAdapterImpl extends PagerAdapter {
    private static final boolean DEBUG = com.baidu.swan.menu.a.DEBUG;
    private b<View> blg = new b<>(5);
    private SparseArray<View> blh = new SparseArray<>();

    /* loaded from: classes2.dex */
    public interface a {
        void recycle();
    }

    protected abstract View b(ViewGroup viewGroup, int i);

    protected abstract void f(View view, int i);

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
        if (DEBUG) {
            Log.i("PagerAdapterImpl", "destroyItem    position = " + i + "    recycle a view~~~~~~~");
        }
        View view = (View) obj;
        if (view instanceof a) {
            ((a) view).recycle();
        }
        viewGroup.removeView(view);
        this.blg.T(view);
        this.blh.remove(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.blg.get();
        if (view == null) {
            if (DEBUG) {
                Log.e("PagerAdapterImpl", "instantiateItem    create view!!!");
            }
            view = b(viewGroup, i);
        }
        this.blh.put(i, view);
        viewGroup.addView(view);
        f(view, i);
        return view;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
