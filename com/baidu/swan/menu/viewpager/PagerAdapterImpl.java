package com.baidu.swan.menu.viewpager;

import android.database.DataSetObserver;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
/* loaded from: classes5.dex */
public abstract class PagerAdapterImpl extends PagerAdapter {
    private c<View> etn = new c<>(5);
    private SparseArray<View> dkB = new SparseArray<>();

    /* loaded from: classes5.dex */
    public interface a {
        void recycle();
    }

    protected abstract View j(ViewGroup viewGroup, int i);

    protected abstract void k(View view, int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        if (view instanceof a) {
            ((a) view).recycle();
        }
        viewGroup.removeView(view);
        this.etn.aj(view);
        this.dkB.remove(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.etn.get();
        if (view == null) {
            view = j(viewGroup, i);
        }
        this.dkB.put(i, view);
        viewGroup.addView(view);
        k(view, i);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
