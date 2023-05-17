package com.baidu.searchbox.ui.viewpager;

import android.database.DataSetObserver;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.searchbox.widget.RecyclePool;
/* loaded from: classes4.dex */
public abstract class PagerAdapterImpl extends PagerAdapter {
    public static final boolean DEBUG = false;
    public static final String TAG = "PagerAdapterImpl";
    public RecyclePool<View> mViewPool = new RecyclePool<>(5);
    public SparseArray<View> mViewList = new SparseArray<>();

    /* loaded from: classes4.dex */
    public interface OnRecycleListener {
        void recycle();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        return view2 == obj;
    }

    public abstract void onConfigItem(View view2, int i);

    public abstract View onInstantiateItem(ViewGroup viewGroup, int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view2 = (View) obj;
        if (view2 instanceof OnRecycleListener) {
            ((OnRecycleListener) view2).recycle();
        }
        viewGroup.removeView(view2);
        this.mViewPool.recycle(view2);
        this.mViewList.remove(i);
    }

    public View getCurrentView(int i) {
        return this.mViewList.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view2 = this.mViewPool.get();
        if (view2 == null) {
            view2 = onInstantiateItem(viewGroup, i);
        }
        this.mViewList.put(i, view2);
        viewGroup.addView(view2);
        onConfigItem(view2, i);
        return view2;
    }
}
