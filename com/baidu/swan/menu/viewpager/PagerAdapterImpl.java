package com.baidu.swan.menu.viewpager;

import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes11.dex */
public abstract class PagerAdapterImpl extends PagerAdapter {
    private c<View> czH = new c<>(5);
    private SparseArray<View> mViewList = new SparseArray<>();

    /* loaded from: classes11.dex */
    public interface a {
        void recycle();
    }

    protected abstract void g(View view, int i);

    protected abstract View h(ViewGroup viewGroup, int i);

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
        this.czH.recycle(view);
        this.mViewList.remove(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.czH.get();
        if (view == null) {
            view = h(viewGroup, i);
        }
        this.mViewList.put(i, view);
        viewGroup.addView(view);
        g(view, i);
        return view;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
