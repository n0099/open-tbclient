package com.baidu.searchbox.ng.aiapps.menu.viewpager;

import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public abstract class PagerAdapterImpl extends PagerAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "PagerAdapterImpl";
    private RecyclePool<View> mViewPool = new RecyclePool<>(5);
    private SparseArray<View> mViewList = new SparseArray<>();

    /* loaded from: classes2.dex */
    public interface OnRecycleListener {
        void recycle();
    }

    protected abstract void onConfigItem(View view, int i);

    protected abstract View onInstantiateItem(ViewGroup viewGroup, int i);

    public View getCurrentView(int i) {
        return this.mViewList.get(i);
    }

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
        if (view instanceof OnRecycleListener) {
            ((OnRecycleListener) view).recycle();
        }
        viewGroup.removeView(view);
        this.mViewPool.recycle(view);
        this.mViewList.remove(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.mViewPool.get();
        if (view == null) {
            view = onInstantiateItem(viewGroup, i);
        }
        this.mViewList.put(i, view);
        viewGroup.addView(view);
        onConfigItem(view, i);
        return view;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
